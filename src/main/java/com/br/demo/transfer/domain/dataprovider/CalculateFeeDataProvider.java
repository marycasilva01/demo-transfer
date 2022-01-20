package com.br.demo.transfer.domain.dataprovider;

import com.br.demo.transfer.dataprovider.model.Transfer;

import java.math.BigDecimal;

public interface CalculateFeeDataProvider {

    BigDecimal execute(Transfer transfer);
}
