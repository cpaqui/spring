package com.paqui.openBankRestAPI.json.deserializer;

import com.paqui.openBankRestAPI.domain.Transaction;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class TransactionDeserializer extends JsonDeserializer<Transaction> {

    @Override
    public Transaction deserialize(JsonParser jsonParser,
                                   DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

        JsonNode jsonNode = jsonParser.getCodec().readTree(jsonParser);

        Transaction transaction = new Transaction();
        transaction.setId(jsonNode.get("id").asText());
        transaction.setAccountId(jsonNode.get("this_account").get("id").asText());
        transaction.setCounterPartyAccount(jsonNode.get("other_account").get("number").asText());
        transaction.setCounterPartyName(jsonNode.get("other_account").get("holder").get("name").asText());
        transaction.setCounterPartyLogoPath(jsonNode.get("other_account").get("metadata").get("image_URL").asText());
        transaction.setInstructedAmount(jsonNode.get("details").get("value").get("amount").asText());
        transaction.setInstructedCurrency(jsonNode.get("details").get("value").get("currency").asText());
        transaction.setTransactionAmount(jsonNode.get("details").get("value").get("amount").asText());
        transaction.setTransactionCurrency(jsonNode.get("details").get("value").get("currency").asText());
        transaction.setTransactionType(jsonNode.get("details").get("type").asText());
        transaction.setDescription(jsonNode.get("details").get("description").asText());

        return transaction;
    }
}
