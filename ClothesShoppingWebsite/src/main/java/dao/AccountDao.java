package dao;

import persistence.Account;

public interface AccountDao {
	Account getAccountByEmail(String email);
	
	Account getAccountByEmailAndPassword(String email, String password);
	
	void createNewAccount(Account t);
}
