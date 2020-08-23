package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STOCK")
public class Stock {

	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String stockName;
	private String stockNumber;
	private Double stockPurchaseprice;
	private Double stockSellingprice;
	private Date purchasingDate;
	private Long quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	
	public Date getPurchasingDate() {
		return purchasingDate;
	}

	public void setPurchasingDate(Date purchasingDate) {
		this.purchasingDate = purchasingDate;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	
	

	public Double getStockPurchaseprice() {
		return stockPurchaseprice;
	}

	public void setStockPurchaseprice(Double stockPurchaseprice) {
		this.stockPurchaseprice = stockPurchaseprice;
	}

	public Double getStockSellingprice() {
		return stockSellingprice;
	}

	public void setStockSellingprice(Double stockSellingprice) {
		this.stockSellingprice = stockSellingprice;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public Stock() {

	}

	public Stock(String stockName, String stockNumber, Double stockPurchaseprice, Double stockSellingprice,
			Date purchasingDate, Long quantity) {
		super();
		this.stockName = stockName;
		this.stockNumber = stockNumber;
		this.stockPurchaseprice = stockPurchaseprice;
		this.stockSellingprice = stockSellingprice;
		this.purchasingDate = purchasingDate;
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((purchasingDate == null) ? 0 : purchasingDate.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + ((stockNumber == null) ? 0 : stockNumber.hashCode());
		result = prime * result + ((stockPurchaseprice == null) ? 0 : stockPurchaseprice.hashCode());
		result = prime * result + ((stockSellingprice == null) ? 0 : stockSellingprice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (purchasingDate == null) {
			if (other.purchasingDate != null)
				return false;
		} else if (!purchasingDate.equals(other.purchasingDate))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (stockName == null) {
			if (other.stockName != null)
				return false;
		} else if (!stockName.equals(other.stockName))
			return false;
		if (stockNumber == null) {
			if (other.stockNumber != null)
				return false;
		} else if (!stockNumber.equals(other.stockNumber))
			return false;
		if (stockPurchaseprice == null) {
			if (other.stockPurchaseprice != null)
				return false;
		} else if (!stockPurchaseprice.equals(other.stockPurchaseprice))
			return false;
		if (stockSellingprice == null) {
			if (other.stockSellingprice != null)
				return false;
		} else if (!stockSellingprice.equals(other.stockSellingprice))
			return false;
		return true;
	}
	
	

}
