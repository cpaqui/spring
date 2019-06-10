package com.paqui.openBankRestAPI.domain;

import java.math.BigDecimal;

public class Transaction {

    private String id;
    private String accountId;
    private String counterPartyAccount;
    private String counterPartyName;
    private String counterPartyLogoPath;
    private BigDecimal instructedAmount;
    private String instructedCurrency;
    private BigDecimal transactionAmount;
    private String transactionCurrency;
    private String transactionType;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCounterPartyAccount() {
        return counterPartyAccount;
    }

    public void setCounterPartyAccount(String counterPartyAccount) {
        this.counterPartyAccount = counterPartyAccount;
    }

    public String getCounterPartyName() {
        return counterPartyName;
    }

    public void setCounterPartyName(String counterPartyName) {
        this.counterPartyName = counterPartyName;
    }

    public String getCounterPartyLogoPath() {
        return counterPartyLogoPath;
    }

    public void setCounterPartyLogoPath(String counterPartyLogoPath) {
        this.counterPartyLogoPath = counterPartyLogoPath;
    }

    public BigDecimal getInstructedAmount() {
        return instructedAmount;
    }

    public void setInstructedAmount(String instructedAmount) {
        this.instructedAmount = new BigDecimal(instructedAmount);
    }

    public String getInstructedCurrency() {
        return instructedCurrency;
    }

    public void setInstructedCurrency(String instructedCurrency) {
        this.instructedCurrency = instructedCurrency;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = new BigDecimal(transactionAmount);
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
