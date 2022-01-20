package com.br.demo.transfer.domain.usecase;

import com.br.demo.transfer.domain.dataprovider.GetTransferDataProvider;
import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTransferUseCase {

    private final GetTransferDataProvider provider;

    public Page<TransferResponse> execute(Pageable pageable){
        return provider.get(pageable);
    }
}
