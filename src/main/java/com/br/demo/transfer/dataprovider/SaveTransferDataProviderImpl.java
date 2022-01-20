package com.br.demo.transfer.dataprovider;

import com.br.demo.transfer.dataprovider.mapper.TransferMapper;
import com.br.demo.transfer.dataprovider.repository.TransferRepository;
import com.br.demo.transfer.domain.dataprovider.CalculateFeeDataProvider;
import com.br.demo.transfer.domain.dataprovider.DefineTransferTypeDataProvider;
import com.br.demo.transfer.domain.dataprovider.SaveTransferDataProvider;
import com.br.demo.transfer.domain.dataprovider.dto.TransferDTO;
import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SaveTransferDataProviderImpl implements SaveTransferDataProvider {

    private final DefineTransferTypeDataProvider defineTransferTypeDataProvider;
    private final CalculateFeeDataProvider calculateFeeDataProvider;
    private final TransferRepository transferRepository;
    private final TransferMapper mapper;

    @Override
    @Transactional
    public TransferResponse save(TransferDTO dto) {
        var transfer = mapper.convertDTOToModel(dto);
        transfer.setType(defineTransferTypeDataProvider.define(transfer.getTransferAt()));
        transfer.setFeeAmount(calculateFeeDataProvider.execute(transfer));

        var saved = transferRepository.save(transfer);
        return mapper.convertModelToDTO(saved);
    }
}
