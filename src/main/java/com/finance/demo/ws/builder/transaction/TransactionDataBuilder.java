package com.finance.demo.ws.builder.transaction;

import com.finance.demo.domain.transaction.Transaction;
import com.finance.demo.ws.builder.DataBuilder;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TransactionDataBuilder (
        String type,
        LocalDate date,
        String moviment,
        String product,
        String institution,
        Long quantity,
        Double princeUnitary,
        Double valueOperation
) implements DataBuilder<Transaction> {

    public Transaction getResult() {
        return new TransactionBuilder().builder(this);
    }

}
