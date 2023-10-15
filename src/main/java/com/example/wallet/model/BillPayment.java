package com.example.wallet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer billId;
	
	private Double amount;
	
	private String billType;
	
	private LocalDate billPaymentDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Wallet wallet;


	public BillPayment(Double amount, String billType, LocalDate billPaymentDate) {
		this.amount = amount;
		this.billType = billType;
		this.billPaymentDate = billPaymentDate;
	}

    public BillPayment(){
        
    }

    /**
     * @return Integer return the billId
     */
    public Integer getBillId() {
        return billId;
    }

    /**
     * @param billId the billId to set
     */
    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    /**
     * @return Double return the amount
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * @return String return the billType
     */
    public String getBillType() {
        return billType;
    }

    /**
     * @param billType the billType to set
     */
    public void setBillType(String billType) {
        this.billType = billType;
    }

    /**
     * @return LocalDate return the billPaymentDate
     */
    public LocalDate getBillPaymentDate() {
        return billPaymentDate;
    }

    /**
     * @param billPaymentDate the billPaymentDate to set
     */
    public void setBillPaymentDate(LocalDate billPaymentDate) {
        this.billPaymentDate = billPaymentDate;
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