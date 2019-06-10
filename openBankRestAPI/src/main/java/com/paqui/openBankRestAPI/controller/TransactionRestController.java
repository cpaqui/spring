package com.paqui.openBankRestAPI.controller;

import com.paqui.openBankRestAPI.bean.repository.OpenBankRepository;
import com.paqui.openBankRestAPI.controller.view.TransactionAmount;
import com.paqui.openBankRestAPI.domain.Transaction;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Api(value="/secure/v1/transactions",produces ="application/json")
@RequestMapping("/secure/v1/transactions")
public class TransactionRestController {

	@Autowired
	private OpenBankRepository openBankRepository;

	@ApiOperation(value="get all transactions", response=Transaction.class, responseContainer = "List")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Transactions Details Retrieved", response=Transaction.class, responseContainer = "List"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="Transactions not found")
	})
	@RequestMapping(
			method = RequestMethod.GET,
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Transaction> transactions() throws IOException {

		return openBankRepository.transactions();
	}

	@ApiOperation(value="get transactions by type", response=Transaction.class, responseContainer = "List")
	@ApiResponses(value={
			@ApiResponse(code=200,message="Transactions Details Retrieved", response=Transaction.class, responseContainer = "List"),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="Transactions not found")
	})
	@RequestMapping(
			value = "/{type}",
			method = RequestMethod.GET,
			produces = "application/json")
	public List<Transaction> message(@ApiParam(value = "Transaction type", required = true) @PathVariable String type) throws IOException {

		return openBankRepository.transactionsByType(type);
	}

	@ApiOperation(value="get transactions amount by type", response= TransactionAmount.class)
	@ApiResponses(value={
			@ApiResponse(code=200,message="Transactions amount Retrieved", response=TransactionAmount.class),
			@ApiResponse(code=500,message="Internal Server Error"),
			@ApiResponse(code=404,message="Transactions not found")
	})
	@RequestMapping(
			value = "/{type}/amount",
			method = RequestMethod.GET,
			produces = "application/json")
	public TransactionAmount amount(@ApiParam(value = "Transaction type", required = true)@PathVariable String type) throws IOException {//REST Endpoint.

		BigDecimal amount = openBankRepository.transactionsAmountByType(type);

		return new TransactionAmount(amount);
	}


}
