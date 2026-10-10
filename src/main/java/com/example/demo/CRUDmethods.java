package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CRUDmethods implements TransactionDAO{
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@Override
	public void create(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> retrieveAll() {
		Iterable<Transaction> transactions = transactionRepository.findAll();
		List<Transaction> transactionList = new ArrayList<>();
		transactions.forEach(transactionList::add);
		return transactionList;
	}

	@Override
	public void update(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	@Override
	public void delete(Transaction transaction) {
		transactionRepository.delete(transaction);
	}
	
	
}
