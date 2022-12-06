package com.finance.demo.domain.transaction;

public enum Movement {

    INTEREST_EQUITY("Juros Sobre Capital Próprio"),
    DIVIDEND("Dividendo"),
    TRANSFER_SETTLEMENT("Transferência - Liquidação"),
    TRANSFER("Transferência"),
    LOAN("Empréstimo"),
    PERFORMANCE("Rendimento"),
    BONUS_ASSETS("Bonificação em Ativos"),
    EXPIRATION("VENCIMENTO"),
    PURCHASE_SALE("COMPRA / VENDA");

    private String name;

    Movement(String s) {
    }
}
