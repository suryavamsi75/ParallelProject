package com.cg.account.dao;

import java.util.HashMap;

import com.cg.accountDb.AccountDb;
import com.cg.bean.Account;
import com.cg.exception.AccountException;

public class AccountDaoImpl implements AccountDao {
static HashMap<String, Account> accMap= AccountDb.getAccountDb();
	@Override
	public String createAccount(Account acc) throws AccountException {
		accMap.put(acc.getPhone(),acc);
		return acc.getPhone();
	}
	@Override
	public double AccountBalance(String phone) throws AccountException {
		Account acc= accMap.get(phone);
	if(acc==null){
		throw new AccountException("phone does not exist");
	}
	return acc.getBalance();
	}
	@Override
	public Account deposit(String phone) throws AccountException {
		Account acc=accMap.get(phone);
		if(acc==null){
			throw new AccountException("phone does not exist");
		}
		return acc;
	}
	@Override
	public Account withdraw(String phone) throws AccountException {
		Account acc=accMap.get(phone);
		if(acc==null){
			throw new AccountException("phone does not exist");
		}
		return acc;
	}
	@Override
	public Account TransactionDetails(String phone) throws AccountException {
		Account acc=accMap.get(phone);
		if(acc==null){
			throw new AccountException("phone does not exist");
		}
		return acc;
	}

}
