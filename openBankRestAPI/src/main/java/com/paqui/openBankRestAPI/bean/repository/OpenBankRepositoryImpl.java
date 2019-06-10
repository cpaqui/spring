package com.paqui.openBankRestAPI.bean.repository;

import com.paqui.openBankRestAPI.domain.Transaction;
import com.paqui.openBankRestAPI.json.deserializer.TransactionDeserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenBankRepositoryImpl implements OpenBankRepository {

    private static final String TRANSACTION_ENDPOINT =
            "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";

    private final RestTemplate restTemplate;

    @Autowired
    public OpenBankRepositoryImpl(RestTemplate restTemplate) {

        this.restTemplate = restTemplate;
    }

    @Override
    public List<Transaction> transactions() throws IOException {
        Iterator<JsonNode> jsonNodeIterator = jsonParser();

        ObjectMapper objectMapper = jsonDeserializer();

        List<Transaction> transactions = new ArrayList<>();

        while (jsonNodeIterator.hasNext()) {
            transactions.add(objectMapper.treeToValue(jsonNodeIterator.next(), Transaction.class));
        }

        return transactions;
    }

    @Override
    public BigDecimal transactionsAmountByType(String type) throws IOException {
        return transactionsByType(type)
                .stream()
                .map(Transaction::getTransactionAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public List<Transaction> transactionsByType(String type) throws IOException {
        Iterator<JsonNode> jsonNodeIterator = jsonParser();

        ObjectMapper objectMapper = jsonDeserializer();

        List<Transaction> transactions = new ArrayList<>();

        while (jsonNodeIterator.hasNext()) {

            JsonNode jsonNode = jsonNodeIterator.next();

            if (type.equalsIgnoreCase(jsonNode.get("details").get("type").asText())) {
                transactions.add(objectMapper.treeToValue(jsonNode, Transaction.class));
            }
        }

        return transactions;
    }

    private Iterator<JsonNode> jsonParser () throws IOException {
        RestTemplate restTemplate = this.restTemplate;
        String payload = restTemplate.getForObject(TRANSACTION_ENDPOINT, String.class);

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode jsonNode = objectMapper.readValue(payload, JsonNode.class);

        return jsonNode.get("transactions").iterator();
    }

    private ObjectMapper jsonDeserializer () {
        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Transaction.class, new TransactionDeserializer());
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);

        return objectMapper;
    }
}
