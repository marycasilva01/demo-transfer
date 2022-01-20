package com.br.demo.transfer.dataprovider;

import com.br.demo.transfer.dataprovider.mapper.TransferMapper;
import com.br.demo.transfer.dataprovider.repository.TransferRepository;
import com.br.demo.transfer.domain.dataprovider.GetTransferByIdDataProvider;
import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetTransferByIdDataProviderImpl implements GetTransferByIdDataProvider {

    private final TransferRepository transferRepository;
    private final TransferMapper mapper;

    @Override
    public Optional<TransferResponse> get(Long id) {
        var transfer = transferRepository.getById(id);
        if(Objects.isNull(transfer)){
            return Optional.empty();
        }
        return Optional.of(mapper.convertModelToDTO(transfer));
    }
}
