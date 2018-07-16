package com.cg.account.service;

import java.time.LocalDateTime;

import com.cg.account.dao.AccountDao;
import com.cg.account.dao.AccountDaoImpl;
import com.cg.bean.Account;
import com.cg.exception.AccountException;

public class AccountServiceImpl implements AccountService {
AccountDao dao=new  AccountDaoImpl();



	@Override
	public String createAccount(Account acc) throws AccountException {
		
		
		if(!acc.getEmail().matches("[A-Za-z0-9]+@+[a-z]+\\.com")){
			throw new AccountException("Enter a valid email");
		}
		if(acc.getName().isEmpty()){
			throw new AccountException("Name cannot be null");
		}
		if(!acc.getPhone().matches("\\d{10}")){
			throw new AccountException("Phone number should contain 10 digits");
		}
		if(!acc.getName().matches("[A-Z][A-Za-z]")){
			throw new AccountException("Name should start with a capital letter");
		}
		
		if(acc.getBalance()<0){
			throw new AccountException("Balance should be greater than 0");
		}
		return dao.createAccount(acc);
	}

	@Override
	public double AccountBalance(String phone) throws AccountException {
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Phone number should contain 10 digits");
		}
		return dao.AccountBalance(phone);
	}

	@Override
	public Account deposit(String phone, double deposit)
			throws AccountException {
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Phone number should contain 10 digits");
		}
		Account acc= dao.withdraw(phone);
		if(deposit>acc.getBalance() || deposit<=0){
			throw new AccountException("Deposit amount should be greater than 0");
		}
		acc.setBalance(acc.getBalance()+deposit);
		acc.setDate(LocalDateTime.now());
		return acc;
	}

	@Override
	public Account withdraw(String phone, double withdraw)
			throws AccountException {
		if(!phone.matches("\\d{10}")){
			throw new AccountException("Phone number should contain 10 digits");
		}
		Account acc= dao.withdraw(phone);
		if(withdraw>acc.getBalance() || withdraw<=0){
			throw new AccountException("Withdraw amount is more than current balance");
		}
		acc.setBalance(acc.getBalance()-withdraw);
		acc.setDate(LocalDateTime.now());
		return acc;
	}

	@Override
	public Account TransactionDetails(String phone) throws AccountException {
	
		return dao.TransactionDetails(phone);
	}

	@Override
	public boolean fundTransfer(String sourcePhone, String destPhone,
			double transferAmt) throws AccountException {
		if(!sourcePhone.matches("\\d{10}")){
			throw new AccountException("Phone number should contain 10 digits");
		}
		if(!destPhone.matches("\\d{10}")){
			throw new AccountException("Phone number should contain 10 digits");
		}

		return true;
	}

}
