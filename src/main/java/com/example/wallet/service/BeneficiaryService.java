package com.example.wallet.service;

import com.example.wallet.exception.BeneficiaryException;
import com.example.wallet.exception.CustomerException;
import com.example.wallet.exception.WalletException;
import com.example.wallet.model.Beneficiary;
import com.example.wallet.model.dto.BeneficiaryDTO;
import java.util.List;

public interface BeneficiaryService {
    public Beneficiary addBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException, CustomerException, WalletException;

	public List<Beneficiary> findAllByWallet(Integer walletId) throws BeneficiaryException;

	public Beneficiary viewBeneficiary(String beneficiaryName, String key) throws BeneficiaryException, CustomerException;

	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException;

	public Beneficiary deleteBeneficiary(String key, BeneficiaryDTO beneficiaryDTO) throws BeneficiaryException, CustomerException;

}