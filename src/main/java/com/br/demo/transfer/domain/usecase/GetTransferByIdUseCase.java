package com.br.demo.transfer.domain.usecase;

import com.br.demo.transfer.domain.dataprovider.GetTransferByIdDataProvider;
import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetTransferByIdUseCase {

    private final GetTransferByIdDataProvider provider;

    public Optional<TransferResponse> execute(Long id){
        return provider.get(id);
    }
}
