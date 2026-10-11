package com.example.demo;

import org.springframework.data.annotation.Id;

public class Transaction {
	
	@Id
	int transaction_id;
	int account_id;
	String category;
	String merchant;
	String description;
	double price;
	
	public Transaction() {
		super();
	}
	public Transaction(int transaction_id) {
		super();
		this.transaction_id = transaction_id;
	}
	public Transaction(int account_id, String category, String merchant, String description, double price) {
		super();
		this.account_id = account_id;
		this.category = category;
		this.merchant = merchant;
		this.description = description;
		this.price = price;
	}
	public Transaction(int transaction_id, int account_id, String category, String merchant, String description,
			double price) {
		super();
		this.transaction_id = transaction_id;
		this.account_id = account_id;
		this.category = category;
		this.merchant = merchant;
		this.description = description;
		this.price = price;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", account_id=" + account_id + ", category=" + category
				+ ", merchant=" + merchant + ", description=" + description + ", price=" + price + "]";
	}
	
	
}
