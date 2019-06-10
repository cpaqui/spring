package com.paqui.openBankRestAPI.bean.repository;

import com.paqui.openBankRestAPI.domain.Transaction;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface OpenBankRepository {

    List<Transaction> transactions() throws IOException;

    List<Transaction> transactionsByType(String type) throws IOException;

    BigDecimal transactionsAmountByType(String type) throws IOException;
}
