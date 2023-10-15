package com.example.wallet.service;

import com.example.wallet.exception.BillPaymentException;
import com.example.wallet.exception.CustomerException;
import com.example.wallet.exception.TransactionException;
import com.example.wallet.exception.WalletException;

import java.time.LocalDate;

public interface BillPaymentService {
    public String addBillPayment(String targetMobile, String Name, double amount, String BillType, LocalDate paymentDate, Integer walletId, String key) throws BillPaymentException,WalletException,CustomerException,TransactionException;
}