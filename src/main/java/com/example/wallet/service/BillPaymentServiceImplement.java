package com.example.wallet.service;

import com.example.wallet.exception.BillPaymentException;
import com.example.wallet.model.BillPayment;
import com.example.wallet.repository.BillPaymentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillPaymentServiceImplement implements BillPaymentService{

	
	@Autowired
	private BillPaymentRepos billPaymentRepo;


	/*--------------------------------------------   Add Bill Payment -------------------------------------------------*/
	@Override
	public String addBillPayment(String targetMobile, String Name, double amount, String billType, LocalDate paymentDate, Integer walletId, String key) throws BillPaymentException  {


		BillPayment billPayment = new BillPayment(amount, billType, LocalDate.now());

		billPaymentRepo.save(billPayment);

		return "add Bill Success";

	}
    
}