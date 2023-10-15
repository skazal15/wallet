package com.example.wallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wallet.exception.LoginException;
import com.example.wallet.model.CurrentUserSession;
import com.example.wallet.model.Customer;
import com.example.wallet.model.UserLogin;
import com.example.wallet.repository.CurrentSessionRepos;
import com.example.wallet.repository.CustomerRepos;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImplement implements LoginService{

	@Autowired
	private CustomerRepos customerRepo;
	
	@Autowired
	private CurrentSessionRepos currentSessionRepo;

	
	/*-------------------------------------------   Login   --------------------------------------------------*/

	@Override
	public String login(UserLogin userLogin) throws LoginException {
		
        List<Customer> customer= customerRepo.findCustomerByMobile(userLogin.getMobileNumber());
		
		Customer existingCustomer = customer.get(0);
		
		if(existingCustomer == null) {
			throw new LoginException("Invalid MobileNumber!");
		}
		
		
		
		Optional<CurrentUserSession> optional =  currentSessionRepo.findByUserId(existingCustomer.getCustomerId());
		
		if(optional.isPresent()) {
			
			throw new LoginException("User Already Exists in the System.");
			
		}
		
		if(existingCustomer.getPassword().equals(userLogin.getPassword())) {
			
			String key= RandomString.make(6);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(key,existingCustomer.getCustomerId(),LocalDateTime.now());
			
			currentSessionRepo.save(currentUserSession);

			return currentUserSession.toString();
		}

		throw new LoginException("Wrong password");
		
	}

	
	/*-------------------------------------   Logout   ----------------------------------------*/

	@Override
	public String logout(String key) throws LoginException {
		
        CurrentUserSession currentUserSession = currentSessionRepo.findByUuid(key);
		
		if(currentUserSession == null) {
			throw new LoginException("Invalid Unique userId (Session Key).");
			
		}
		
		currentSessionRepo.delete(currentUserSession);
		
		return "Logged Out Successfully!";
	}

}