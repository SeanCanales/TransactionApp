package com.example.demo;

import java.util.List;

public interface TransactionDAO {
	
	public void create(Transaction transaction);
	public List<Transaction> retrieveAll();
	public void update(Transaction transaction);
	public void delete(Transaction transaction);
}
