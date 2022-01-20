package com.br.demo.transfer.domain.dataprovider;

import com.br.demo.transfer.domain.dataprovider.dto.TransferDTO;
import com.br.demo.transfer.entrypoint.rest.model.TransferResponse;

public interface SaveTransferDataProvider {

   TransferResponse save(TransferDTO transfer);

}
