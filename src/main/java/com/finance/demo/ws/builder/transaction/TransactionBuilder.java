package com.finance.demo.ws.builder.transaction;

import com.finance.demo.domain.asset.Asset;
import com.finance.demo.domain.institution.Institution;
import com.finance.demo.domain.transaction.Movement;
import com.finance.demo.domain.transaction.Transaction;
import com.finance.demo.domain.transaction.TypeTransaction;
import com.finance.demo.ws.transaction.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionBuilder {

    @Autowired
    private InstitutionRepository institutionRepository;

    public Transaction builder(TransactionDataBuilder data){
        final Institution institution = institutionRepository.findBy(data.institution());
        return Transaction.builder()
                .date(data.date())
                .type(TypeTransaction.valueOf(data.type()))
                .product(
                        new Asset(
                                data.product(),
                                data.quantity(),
                                institution
                        )
                )
                .institution(institution)
                .princeUnitary(data.princeUnitary())
                .quantity(data.quantity())
                .movement(Movement.valueOf(data.moviment()))
                .valueOperation(data.valueOperation())
                .build();
    }

}
