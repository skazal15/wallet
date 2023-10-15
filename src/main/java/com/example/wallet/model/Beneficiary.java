package com.example.wallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {

   @Id
   @NotNull
   @Size(min = 10, max = 10 ,message = "Invalid Mobile Number [ 10 Digit Only ] ")
   private String beneficiaryMobileNumber;
   
   @NotNull
   @Size(min = 3, message = "Invalid Beneficiary name [ contains at least 3 characters ]")
   private String beneficiaryName;


   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "walletId" ,referencedColumnName = "walletId")
   private Wallet wallet;

   public Beneficiary(String beneficiaryMobileNumber, String beneficiaryName) {
      this.beneficiaryMobileNumber = beneficiaryMobileNumber;
      this.beneficiaryName = beneficiaryName;
   }

   public Beneficiary() {
    // Konstruktor tanpa argumen
}
    /**
     * @return String return the beneficiaryMobileNumber
     */
    public String getBeneficiaryMobileNumber() {
        return beneficiaryMobileNumber;
    }

    /**
     * @param beneficiaryMobileNumber the beneficiaryMobileNumber to set
     */
    public void setBeneficiaryMobileNumber(String beneficiaryMobileNumber) {
        this.beneficiaryMobileNumber = beneficiaryMobileNumber;
    }

    /**
     * @return String return the beneficiaryName
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * @param beneficiaryName the beneficiaryName to set
     */
    public void setBeneficiaryName(String beneficiaryName) {
        this.beneficiaryName = beneficiaryName;
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