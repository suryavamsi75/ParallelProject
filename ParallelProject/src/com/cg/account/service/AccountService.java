package com.cg.account.service;

import com.cg.bean.Account;
import com.cg.exception.AccountException;

public interface AccountService {
	public String createAccount(Account acc) throws AccountException;
	public double AccountBalance(String phone) throws AccountException;
	public Account deposit(String phone, double deposit) throws AccountException;
	public Account withdraw(String phone, double withdraw) throws AccountException;
	public Account TransactionDetails(String phone) throws AccountException;
	public boolean fundTransfer(String sourcePhone, String destPhone, double transferAmt) throws AccountException;
}
