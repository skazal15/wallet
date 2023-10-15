package com.example.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import com.example.wallet.model.Customer;

@Repository
public interface CustomerRepos extends JpaRepository<Customer, Integer> {

	@Query("FROM Customer c WHERE c.mobileNumber=?1")
	public List<Customer> findCustomerByMobile(String mobileNumber); 

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Customer (customer_id,customer_name, mobile_number, password) VALUES (?1, ?2, ?3,?4)", nativeQuery = true)
    void addCustomer(int customerId,String customerName, String mobileNumber, String password);
}