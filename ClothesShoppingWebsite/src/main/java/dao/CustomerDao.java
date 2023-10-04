package dao;

import persistence.Account;
import persistence.Customer;

public interface CustomerDao {
	void createNewCustomer(Customer c, Account ac);
}
