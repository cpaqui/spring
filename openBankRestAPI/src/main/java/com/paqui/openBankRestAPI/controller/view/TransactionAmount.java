package com.paqui.openBankRestAPI.controller.view;

import java.math.BigDecimal;

public class TransactionAmount {

    private BigDecimal amount;

    public TransactionAmount() {
    }

    public TransactionAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
