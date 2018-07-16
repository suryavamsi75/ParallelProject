package com.cg.account.dao;

import com.cg.bean.Account;
import com.cg.exception.AccountException;


public interface AccountDao {
	public String createAccount(Account acc) throws AccountException;
	public double AccountBalance(String phone) throws AccountException;
	public Account deposit(String phone) throws AccountException;
	public Account withdraw(String phone) throws AccountException;
	public Account TransactionDetails(String phone) throws AccountException;
	}
