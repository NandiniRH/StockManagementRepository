package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.controller;

public class StockNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  StockNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public  StockNotFoundException(String stockName) {
		// TODO Auto-generated constructor stub
		super("Stock : "+stockName+" not found");
	}
	
}
