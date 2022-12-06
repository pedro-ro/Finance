package com.finance.demo.domain.transaction;

import com.finance.demo.domain.asset.Asset;
import com.finance.demo.domain.institution.Institution;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class Transaction {

    private final String id = UUID.randomUUID().toString();
    @Enumerated(EnumType.ORDINAL)
    private final TypeTransaction type;
    private final LocalDate date;
    @Enumerated(EnumType.ORDINAL)
    private final Movement movement;
    private final Asset product;
    private final Institution institution;
    private final Long quantity;
    private final Double princeUnitary;
    private final Double valueOperation;

}
