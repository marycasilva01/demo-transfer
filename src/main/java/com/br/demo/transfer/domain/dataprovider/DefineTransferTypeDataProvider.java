package com.br.demo.transfer.domain.dataprovider;

import com.br.demo.transfer.dataprovider.model.enums.TransferType;

import java.time.LocalDate;

public interface DefineTransferTypeDataProvider {

     TransferType define(LocalDate transferDate);
}
