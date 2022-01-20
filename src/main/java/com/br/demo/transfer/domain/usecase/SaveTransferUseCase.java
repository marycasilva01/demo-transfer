package com.br.demo.transfer.domain.usecase;

import com.br.demo.transfer.domain.dataprovider.SaveTransferDataProvider;
import com.br.demo.transfer.domain.dataprovider.dto.TransferDTO;
import com.br.demo.transfer.common.exceptions.InvalidTransferException;
import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTransferUseCase {

    private final SaveTransferDataProvider provider;

    public TransferResponse save(TransferDTO transfer) {
        checkIfOriginDifferentFromDestination(transfer);

        return provider.save(transfer);
    }

    private void checkIfOriginDifferentFromDestination(TransferDTO transfer){
        if(transfer.getAccountOrigin().equals(transfer.getAccountDestination())) {
            throw new InvalidTransferException("Account origin and destination cannot be the same");
        }
    }

}
