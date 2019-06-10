package com.paqui.openBankRestAPI.json.deserializer;

import com.paqui.openBankRestAPI.domain.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TransactionDeserializerTest {

    @Test
    public void testJsonDeserializer () throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Transaction.class, new TransactionDeserializer());
        objectMapper.registerModule(simpleModule);

        Transaction transaction = objectMapper.readValue(JSON_NODE, Transaction.class);

        Assert.assertEquals(transaction.getId(), "897706c1-dcc6-4e70-9d85-8a537c7cbf3e");
        Assert.assertEquals(transaction.getAccountId(), "savings-kids-john");

    }

    private static  final  String JSON_NODE = " {\n" +
            "            \"id\": \"897706c1-dcc6-4e70-9d85-8a537c7cbf3e\",\n" +
            "            \"this_account\": {\n" +
            "                \"id\": \"savings-kids-john\",\n" +
            "                \"holders\": [\n" +
            "                    {\n" +
            "                        \"name\": \"Savings - Kids John\",\n" +
            "                        \"is_alias\": false\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"number\": \"832425-00304050\",\n" +
            "                \"kind\": \"savings\",\n" +
            "                \"IBAN\": null,\n" +
            "                \"swift_bic\": null,\n" +
            "                \"bank\": {\n" +
            "                    \"national_identifier\": \"rbs\",\n" +
            "                    \"name\": \"The Royal Bank of Scotland\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"other_account\": {\n" +
            "                \"id\": \"E806HT1hp-IfBH0DP1rCFrPAftEtpCAwU-XlMo_9bzM\",\n" +
            "                \"holder\": {\n" +
            "                    \"name\": \"ALIAS_49532E\",\n" +
            "                    \"is_alias\": true\n" +
            "                },\n" +
            "                \"number\": \"savings-kids-john\",\n" +
            "                \"kind\": null,\n" +
            "                \"IBAN\": null,\n" +
            "                \"swift_bic\": null,\n" +
            "                \"bank\": {\n" +
            "                    \"national_identifier\": \"rbs\",\n" +
            "                    \"name\": \"rbs\"\n" +
            "                },\n" +
            "                \"metadata\": {\n" +
            "                    \"public_alias\": null,\n" +
            "                    \"private_alias\": null,\n" +
            "                    \"more_info\": null,\n" +
            "                    \"URL\": null,\n" +
            "                    \"image_URL\": null,\n" +
            "                    \"open_corporates_URL\": null,\n" +
            "                    \"corporate_location\": null,\n" +
            "                    \"physical_location\": null\n" +
            "                }\n" +
            "            },\n" +
            "            \"details\": {\n" +
            "                \"type\": \"SANDBOX_TAN\",\n" +
            "                \"description\": \"Gift\",\n" +
            "                \"posted\": \"2017-10-15T14:22:28Z\",\n" +
            "                \"completed\": \"2017-10-15T14:22:28Z\",\n" +
            "                \"new_balance\": {\n" +
            "                    \"currency\": \"GBP\",\n" +
            "                    \"amount\": null\n" +
            "                },\n" +
            "                \"value\": {\n" +
            "                    \"currency\": \"GBP\",\n" +
            "                    \"amount\": \"-90.00\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"metadata\": {\n" +
            "                \"narrative\": null,\n" +
            "                \"comments\": [],\n" +
            "                \"tags\": [],\n" +
            "                \"images\": [],\n" +
            "                \"where\": null\n" +
            "            }\n" +
            "        }";
}
