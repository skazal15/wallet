package com.example.wallet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer customerId;	
	
	@NotNull
	@Size(min = 3, message = "Invalid Customer name [ cotains at least 3 characters ]")
	private String customerName;
	
	@NotNull
	@Size(min = 10, max = 12 ,message = "Invalid Mobile Number [ 10 Digit Only ] ")
	private String mobileNumber;
	
	@NotNull
	@Size(min = 6, max = 12, message = "Invalid Password [ must be 6 to 8 characters ]")
	private String password;		

	

    /**
     * @return Integer return the customerId
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * @return String return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return String return the mobileNumber
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber the mobileNumber to set
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}