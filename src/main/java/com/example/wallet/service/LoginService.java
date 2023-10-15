package com.example.wallet.service;

import com.example.wallet.exception.LoginException;
import com.example.wallet.model.UserLogin;

public interface LoginService {
    public String login (UserLogin userLogin) throws LoginException;
	
	public String logout (String Key) throws LoginException;
}