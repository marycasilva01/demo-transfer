package com.br.demo.transfer.domain.dataprovider;

import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;

import java.util.Optional;

public interface GetTransferByIdDataProvider {

   Optional<TransferResponse> get(Long id);
}
