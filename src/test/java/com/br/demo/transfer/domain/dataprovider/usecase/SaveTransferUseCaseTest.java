package com.br.demo.transfer.domain.dataprovider.usecase;

import com.br.demo.transfer.common.exceptions.InvalidTransferException;
import com.br.demo.transfer.domain.dataprovider.SaveTransferDataProvider;
import com.br.demo.transfer.domain.dataprovider.model.TransferFactory;
import com.br.demo.transfer.domain.usecase.SaveTransferUseCase;
import com.br.demo.transfer.dataprovider.model.enums.TransferType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
class SaveTransferUseCaseTest {

    @Mock
    private SaveTransferDataProvider saveTransferDataProvider;

    @InjectMocks
    private SaveTransferUseCase saveTransferUseCase;

    @Test
    public void saveTransferTestInvalidOrigins() {
        var dto = TransferFactory.createTransferSameOriginAndDestination();
        Assertions.assertThrows(InvalidTransferException.class, () -> saveTransferUseCase.save(dto));
    }

    @Test
    public void saveSuccessTransfer() {
        var currentDate = LocalDate.now();
        var dto = TransferFactory.createTransferDTODate(currentDate,0);
        var transfer = TransferFactory.createTransferResponse();

        Mockito.when(saveTransferDataProvider.save(dto)).thenReturn(transfer);

        var persistedTransfer = saveTransferUseCase.save(dto);
        Assertions.assertEquals(TransferType.A, persistedTransfer.getType());
    }
}
