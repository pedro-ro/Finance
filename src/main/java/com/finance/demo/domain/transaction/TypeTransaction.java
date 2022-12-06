package com.finance.demo.domain.transaction;

import lombok.Getter;

@Getter
public enum TypeTransaction {
    CREDIT("Credito"),
    DEBIT("Debito");

    private final String name;

    TypeTransaction(String type) {
        name = type;
    }

}
