package com.br.demo.transfer.domain.dataprovider;

import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GetTransferDataProvider {

    Page<TransferResponse> get(Pageable pageable);
}
