package com.example.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankAccount {

	@Id
	@NotNull
	private Integer accountNo;

	@Size(min = 5, max = 10,message = "Invalid IFSC Code [ 5-10 Characters only ]")
	private String IFSCCode;
	
	@NotNull
	@Size(min = 3, max = 15,message = "Invalid Bank Name [ 3-15 characters only ]")
	private String bankName;
	
	@NotNull
	private Double balance;
	
	
	@ManyToOne(cascade= CascadeType.PERSIST)
	private Wallet wallet;


	public BankAccount(@NotNull Integer accountNo, String IFSCCode,
                       @NotNull @Size(min = 4, max = 10, message = "Bank name not valid") String bankName,
                       @NotNull Double balance) {
		super();
		this.accountNo = accountNo;
		this.IFSCCode = IFSCCode;
		this.bankName = bankName;
		this.balance = balance;
	}


    public BankAccount() {
        // Konstruktor tanpa argumen
    }
    /**
     * @return Integer return the accountNo
     */
    public Integer getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo the accountNo to set
     */
    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return String return the IFSCCode
     */
    public String getIFSCCode() {
        return IFSCCode;
    }

    /**
     * @param IFSCCode the IFSCCode to set
     */
    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    /**
     * @return String return the bankName
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName the bankName to set
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return Double return the balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * @return Wallet return the wallet
     */
    public Wallet getWallet() {
        return wallet;
    }

    /**
     * @param wallet the wallet to set
     */
    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

}