package com.paqui.openBankRestAPI.controller;

import com.paqui.openBankRestAPI.bean.repository.OpenBankRepositoryImpl;
import com.paqui.openBankRestAPI.domain.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OpenBankRepositoryTest {


    @Test
    public void returnAllTransaction_ok() throws IOException {

        RestTemplate restTemplate = mock(RestTemplate.class);
        OpenBankRepositoryImpl openBankRepository = spy(new OpenBankRepositoryImpl(restTemplate));

        when(restTemplate.getForObject(anyString(), any())).thenReturn(TRANSACTIONS_JSON);

        List<Transaction> transactions = openBankRepository.transactions();

        Assert.assertEquals(transactions.size(), 3);
    }

    @Test
    public void returnAllTransactionByTypeCash_ok() throws IOException {

        RestTemplate restTemplate = mock(RestTemplate.class);
        OpenBankRepositoryImpl openBankRepository = spy(new OpenBankRepositoryImpl(restTemplate));

        when(restTemplate.getForObject(anyString(), any())).thenReturn(TRANSACTIONS_JSON);

        List<Transaction> transactions = openBankRepository.transactionsByType("cash");

        Assert.assertEquals(transactions.size(), 2);
    }

    @Test
    public void returnAllTransactionAmountByTypeCash_ok() throws IOException {

        RestTemplate restTemplate = mock(RestTemplate.class);
        OpenBankRepositoryImpl openBankRepository = spy(new OpenBankRepositoryImpl(restTemplate));

        when(restTemplate.getForObject(anyString(), any())).thenReturn(TRANSACTIONS_JSON);

        BigDecimal amountByType = openBankRepository.transactionsAmountByType("cash");

        Assert.assertEquals(amountByType, new BigDecimal("10.00"));
    }

    private static final String TRANSACTIONS_JSON = "{\n" +
            "\t\"transactions\": [{\n" +
            "\t\t\t\"id\": \"The bank's id for the transaction\",\n" +
            "\t\t\t\"this_account\": {\n" +
            "\t\t\t\t\"id\": \"ACCOUNT_ID\",\n" +
            "\t\t\t\t\"holders\": [{\n" +
            "\t\t\t\t\t\"name\": \"MUSIC PICTURES LIMITED\",\n" +
            "\t\t\t\t\t\"is_alias\": \"true/false\"\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"number\": \"\",\n" +
            "\t\t\t\t\"kind\": \"\",\n" +
            "\t\t\t\t\"IBAN\": \"\",\n" +
            "\t\t\t\t\"swift_bic\": \"\",\n" +
            "\t\t\t\t\"bank\": {\n" +
            "\t\t\t\t\t\"national_identifier\": \"\",\n" +
            "\t\t\t\t\t\"name\": \"\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"other_account\": {\n" +
            "\t\t\t\t\"id\": \"123213\",\n" +
            "\t\t\t\t\"holder\": {\n" +
            "\t\t\t\t\t\"name\": \"DEUTSCHE POST AG, SSC ACC S\",\n" +
            "\t\t\t\t\t\"is_alias\": \"true/false\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"number\": \"\",\n" +
            "\t\t\t\t\"kind\": \"\",\n" +
            "\t\t\t\t\"IBAN\": \"\",\n" +
            "\t\t\t\t\"swift_bic\": \"\",\n" +
            "\t\t\t\t\"bank\": {\n" +
            "\t\t\t\t\t\"national_identifier\": \"\",\n" +
            "\t\t\t\t\t\"name\": \"\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"metadata\": {\n" +
            "\t\t\t\t\t\"public_alias\": \"the public alias of the other account holder\",\n" +
            "\t\t\t\t\t\"private_alias\": \"the private alias of the other account holder\",\n" +
            "\t\t\t\t\t\"more_info\": \"short text explaining who the other party of the transaction is\",\n" +
            "\t\t\t\t\t\"URL\": \"a URL related to the other party e.g. the website of the company\",\n" +
            "\t\t\t\t\t\"image_URL\": \"an image URL related to the other party e.g. company logo\",\n" +
            "\t\t\t\t\t\"open_corporates_URL\": \"the company corporate URL in the http://opencorporates.com/ web service\",\n" +
            "\t\t\t\t\t\"corporate_location\": {\n" +
            "\t\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\t\"date\": \"date of posting the geo tag\",\n" +
            "\t\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"physical_location\": {\n" +
            "\t\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\t\"date\": \"date of posting the geo tag\",\n" +
            "\t\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"details\": {\n" +
            "\t\t\t\t\"type\": \"cash\",\n" +
            "\t\t\t\t\"description\": \"transaction description\",\n" +
            "\t\t\t\t\"posted\": \"2012-03-07T00:00:00.001Z\",\n" +
            "\t\t\t\t\"completed\": \"2012-03-07T00:00:00.001Z\",\n" +
            "\t\t\t\t\"new_balance\": {\n" +
            "\t\t\t\t\t\"currency\": \"EUR\",\n" +
            "\t\t\t\t\t\"amount\": \"+ (depending on the view, this might show the balance or only +/-)\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"value\": {\n" +
            "\t\t\t\t\t\"currency\": \"EUR\",\n" +
            "\t\t\t\t\t\"amount\": \"-1.45\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"metadata\": {\n" +
            "\t\t\t\t\"narrative\": \"text explaining the purpose of the transaction\",\n" +
            "\t\t\t\t\"comments\": [{\n" +
            "\t\t\t\t\t\"id\": \"id of the comment\",\n" +
            "\t\t\t\t\t\"date\": \"date of posting the comment\",\n" +
            "\t\t\t\t\t\"value\": \"the comment\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"tags\": [{\n" +
            "\t\t\t\t\t\"id\": \"id of the tag\",\n" +
            "\t\t\t\t\t\"value\": \"thetag\",\n" +
            "\t\t\t\t\t\"date\": \"date of posting the tag\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"images\": [{\n" +
            "\t\t\t\t\t\"id\": \"1239qsxezad0123\",\n" +
            "\t\t\t\t\t\"label\": \"cool image\",\n" +
            "\t\t\t\t\t\"URL\": \"http://www.mysuperimage.com\"\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"where\": {\n" +
            "\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\"date\": \"date of posting the tag\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"id\": \"The bank's id for the transaction\",\n" +
            "\t\t\t\"this_account\": {\n" +
            "\t\t\t\t\"id\": \"ACCOUNT_ID\",\n" +
            "\t\t\t\t\"holders\": [{\n" +
            "\t\t\t\t\t\"name\": \"MUSIC PICTURES LIMITED\",\n" +
            "\t\t\t\t\t\"is_alias\": \"true/false\"\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"number\": \"\",\n" +
            "\t\t\t\t\"kind\": \"\",\n" +
            "\t\t\t\t\"IBAN\": \"\",\n" +
            "\t\t\t\t\"swift_bic\": \"\",\n" +
            "\t\t\t\t\"bank\": {\n" +
            "\t\t\t\t\t\"national_identifier\": \"\",\n" +
            "\t\t\t\t\t\"name\": \"\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"other_account\": {\n" +
            "\t\t\t\t\"id\": \"123213\",\n" +
            "\t\t\t\t\"holder\": {\n" +
            "\t\t\t\t\t\"name\": \"DEUTSCHE POST AG, SSC ACC S\",\n" +
            "\t\t\t\t\t\"is_alias\": \"true/false\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"number\": \"\",\n" +
            "\t\t\t\t\"kind\": \"\",\n" +
            "\t\t\t\t\"IBAN\": \"\",\n" +
            "\t\t\t\t\"swift_bic\": \"\",\n" +
            "\t\t\t\t\"bank\": {\n" +
            "\t\t\t\t\t\"national_identifier\": \"\",\n" +
            "\t\t\t\t\t\"name\": \"\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"metadata\": {\n" +
            "\t\t\t\t\t\"public_alias\": \"the public alias of the other account holder\",\n" +
            "\t\t\t\t\t\"private_alias\": \"the private alias of the other account holder\",\n" +
            "\t\t\t\t\t\"more_info\": \"short text explaining who the other party of the transaction is\",\n" +
            "\t\t\t\t\t\"URL\": \"a URL related to the other party e.g. the website of the company\",\n" +
            "\t\t\t\t\t\"image_URL\": \"an image URL related to the other party e.g. company logo\",\n" +
            "\t\t\t\t\t\"open_corporates_URL\": \"the company corporate URL in the http://opencorporates.com/ web service\",\n" +
            "\t\t\t\t\t\"corporate_location\": {\n" +
            "\t\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\t\"date\": \"date of posting the geo tag\",\n" +
            "\t\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"physical_location\": {\n" +
            "\t\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\t\"date\": \"date of posting the geo tag\",\n" +
            "\t\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"details\": {\n" +
            "\t\t\t\t\"type\": \"cash\",\n" +
            "\t\t\t\t\"description\": \"transaction description\",\n" +
            "\t\t\t\t\"posted\": \"2012-03-07T00:00:00.001Z\",\n" +
            "\t\t\t\t\"completed\": \"2012-03-07T00:00:00.001Z\",\n" +
            "\t\t\t\t\"new_balance\": {\n" +
            "\t\t\t\t\t\"currency\": \"EUR\",\n" +
            "\t\t\t\t\t\"amount\": \"+ (depending on the view, this might show the balance or only +/-)\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"value\": {\n" +
            "\t\t\t\t\t\"currency\": \"EUR\",\n" +
            "\t\t\t\t\t\"amount\": \"11.45\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"metadata\": {\n" +
            "\t\t\t\t\"narrative\": \"text explaining the purpose of the transaction\",\n" +
            "\t\t\t\t\"comments\": [{\n" +
            "\t\t\t\t\t\"id\": \"id of the comment\",\n" +
            "\t\t\t\t\t\"date\": \"date of posting the comment\",\n" +
            "\t\t\t\t\t\"value\": \"the comment\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"tags\": [{\n" +
            "\t\t\t\t\t\"id\": \"id of the tag\",\n" +
            "\t\t\t\t\t\"value\": \"thetag\",\n" +
            "\t\t\t\t\t\"date\": \"date of posting the tag\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"images\": [{\n" +
            "\t\t\t\t\t\"id\": \"1239qsxezad0123\",\n" +
            "\t\t\t\t\t\"label\": \"cool image\",\n" +
            "\t\t\t\t\t\"URL\": \"http://www.mysuperimage.com\"\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"where\": {\n" +
            "\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\"date\": \"date of posting the tag\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t},\t\t\t \n" +
            "\t\t{\n" +
            "\t\t\t\"id\": \"The bank's id for the transaction\",\n" +
            "\t\t\t\"this_account\": {\n" +
            "\t\t\t\t\"id\": \"ACCOUNT_ID\",\n" +
            "\t\t\t\t\"holders\": [{\n" +
            "\t\t\t\t\t\"name\": \"MUSIC PICTURES LIMITED\",\n" +
            "\t\t\t\t\t\"is_alias\": \"true/false\"\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"number\": \"\",\n" +
            "\t\t\t\t\"kind\": \"\",\n" +
            "\t\t\t\t\"IBAN\": \"\",\n" +
            "\t\t\t\t\"swift_bic\": \"\",\n" +
            "\t\t\t\t\"bank\": {\n" +
            "\t\t\t\t\t\"national_identifier\": \"\",\n" +
            "\t\t\t\t\t\"name\": \"\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"other_account\": {\n" +
            "\t\t\t\t\"id\": \"123213\",\n" +
            "\t\t\t\t\"holder\": {\n" +
            "\t\t\t\t\t\"name\": \"DEUTSCHE POST AG, SSC ACC S\",\n" +
            "\t\t\t\t\t\"is_alias\": \"true/false\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"number\": \"\",\n" +
            "\t\t\t\t\"kind\": \"\",\n" +
            "\t\t\t\t\"IBAN\": \"\",\n" +
            "\t\t\t\t\"swift_bic\": \"\",\n" +
            "\t\t\t\t\"bank\": {\n" +
            "\t\t\t\t\t\"national_identifier\": \"\",\n" +
            "\t\t\t\t\t\"name\": \"\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"metadata\": {\n" +
            "\t\t\t\t\t\"public_alias\": \"the public alias of the other account holder\",\n" +
            "\t\t\t\t\t\"private_alias\": \"the private alias of the other account holder\",\n" +
            "\t\t\t\t\t\"more_info\": \"short text explaining who the other party of the transaction is\",\n" +
            "\t\t\t\t\t\"URL\": \"a URL related to the other party e.g. the website of the company\",\n" +
            "\t\t\t\t\t\"image_URL\": \"an image URL related to the other party e.g. company logo\",\n" +
            "\t\t\t\t\t\"open_corporates_URL\": \"the company corporate URL in the http://opencorporates.com/ web service\",\n" +
            "\t\t\t\t\t\"corporate_location\": {\n" +
            "\t\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\t\"date\": \"date of posting the geo tag\",\n" +
            "\t\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t},\n" +
            "\t\t\t\t\t\"physical_location\": {\n" +
            "\t\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\t\"date\": \"date of posting the geo tag\",\n" +
            "\t\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t\t}\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"details\": {\n" +
            "\t\t\t\t\"type\": \"check\",\n" +
            "\t\t\t\t\"description\": \"transaction description\",\n" +
            "\t\t\t\t\"posted\": \"2012-03-07T00:00:00.001Z\",\n" +
            "\t\t\t\t\"completed\": \"2012-03-07T00:00:00.001Z\",\n" +
            "\t\t\t\t\"new_balance\": {\n" +
            "\t\t\t\t\t\"currency\": \"EUR\",\n" +
            "\t\t\t\t\t\"amount\": \"+ (depending on the view, this might show the balance or only +/-)\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"value\": {\n" +
            "\t\t\t\t\t\"currency\": \"EUR\",\n" +
            "\t\t\t\t\t\"amount\": \"-1.45\"\n" +
            "\t\t\t\t}\n" +
            "\t\t\t},\n" +
            "\t\t\t\"metadata\": {\n" +
            "\t\t\t\t\"narrative\": \"text explaining the purpose of the transaction\",\n" +
            "\t\t\t\t\"comments\": [{\n" +
            "\t\t\t\t\t\"id\": \"id of the comment\",\n" +
            "\t\t\t\t\t\"date\": \"date of posting the comment\",\n" +
            "\t\t\t\t\t\"value\": \"the comment\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"tags\": [{\n" +
            "\t\t\t\t\t\"id\": \"id of the tag\",\n" +
            "\t\t\t\t\t\"value\": \"thetag\",\n" +
            "\t\t\t\t\t\"date\": \"date of posting the tag\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"images\": [{\n" +
            "\t\t\t\t\t\"id\": \"1239qsxezad0123\",\n" +
            "\t\t\t\t\t\"label\": \"cool image\",\n" +
            "\t\t\t\t\t\"URL\": \"http://www.mysuperimage.com\"\n" +
            "\t\t\t\t}],\n" +
            "\t\t\t\t\"where\": {\n" +
            "\t\t\t\t\t\"latitude\": 37.423021,\n" +
            "\t\t\t\t\t\"longitude\": -122.083739,\n" +
            "\t\t\t\t\t\"date\": \"date of posting the tag\",\n" +
            "\t\t\t\t\t\"user\": {\n" +
            "\t\t\t\t\t\t\"provider\": \"name of party that authorized the user e.g. bank_name/facebook/twitter\",\n" +
            "\t\t\t\t\t\t\"id\": \"ID (given by the user's provider) of the user making the comment\",\n" +
            "\t\t\t\t\t\t\"display_name\": \"display name of user\"\n" +
            "\t\t\t\t\t}\n" +
            "\t\t\t\t}\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t]\n" +
            "}";
}