package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.controller;

public class StockUpdateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public  StockUpdateException(String stockName,Long Quantity) {
		// TODO Auto-generated constructor stub
		super("Unable to purchase stock : "+stockName+" for given quantity : "+Quantity);
	}

}
