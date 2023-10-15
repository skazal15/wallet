package com.example.wallet.controller;

import javax.validation.Valid;

import com.example.wallet.exception.BankAccountException;
import com.example.wallet.exception.TransactionException;
import com.example.wallet.exception.WalletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.wallet.exception.CustomerException;
import com.example.wallet.model.Customer;
import com.example.wallet.service.WalletService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/wallet")
public class WalletController {
    
	@Autowired
	public WalletService walletService;

	/*--------------------------------------------   Create Account  ------------------------------------------------*/
	@PostMapping("/createaccount")
	public ResponseEntity<Customer> createAccount(@Valid @RequestBody Customer customer) throws CustomerException{

		return new ResponseEntity<Customer>(walletService.createCustomerAccount(customer), HttpStatus.CREATED);
	}


	/*--------------------------------------------  view Balance  ------------------------------------------------*/
	@GetMapping("/balance")
	public ResponseEntity<BigDecimal> showBalance(@RequestParam String key, @RequestParam String mobileNumber) throws CustomerException{

		return new ResponseEntity<BigDecimal>(walletService.showBalance(mobileNumber, key), HttpStatus.ACCEPTED);
	}


	/*--------------------------------------------   Update Account  ------------------------------------------------*/
	@PostMapping("/updateaccount")
	public ResponseEntity<Customer> updateCustomerDetails(@Valid @RequestBody Customer customer, @RequestParam String key) throws CustomerException{

		return new ResponseEntity<Customer>(walletService.updateAccount(customer,key), HttpStatus.ACCEPTED);
	}


	/*--------------------------------------------   Deposit Money to Wallet  ------------------------------------------------*/
	@PostMapping("/deposit/wallet")
	public ResponseEntity<String> depositToWallet(@RequestParam Integer accountNo, @RequestParam BigDecimal amount, @RequestParam String key) throws BankAccountException, CustomerException, TransactionException, WalletException {

		return new ResponseEntity<String>(walletService.depositAmount(amount, accountNo,  key), HttpStatus.OK);
	}


	/*--------------------------------------------   Fund Transfer  ------------------------------------------------*/
	@PostMapping("/transfer/mobile")
	public ResponseEntity<String> fundTransfer(@RequestParam String mobile, @RequestParam String name, @RequestParam BigDecimal amount, @RequestParam String key) throws WalletException, CustomerException, TransactionException{

		return new ResponseEntity<String>(walletService.fundTransfer(mobile, name, amount, key), HttpStatus.OK);
	}


}