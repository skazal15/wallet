package com.example.wallet.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BankAccountDTO {

	@NotNull
	private Integer accountNo;

	@NotNull
	@Size(min = 5, max = 10,message = "Invalid IFSC Code [ 5-10 Characters only ]")
	private String IFSCCode;

	@NotNull
	@Size(min = 3, max = 15,message = "Invalid Bank Name [ 3-15 characters only ]")
	private String bankName;

	@NotNull
	private Double balance;

    public BankAccountDTO(@NotNull Integer accountNo, String IFSCCode,
                       @NotNull @Size(min = 4, max = 10, message = "Bank name not valid") String bankName,
                       @NotNull Double balance) {
		super();
		this.accountNo = accountNo;
		this.IFSCCode = IFSCCode;
		this.bankName = bankName;
		this.balance = balance;
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

}