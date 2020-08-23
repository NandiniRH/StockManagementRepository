package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.bootStrap;

import java.util.Date;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.model.Stock;
import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.repository.StockRepository;

@Component
public class InitialDataLoad implements ApplicationListener<ContextRefreshedEvent>{

	private final StockRepository repository;

	public InitialDataLoad(StockRepository repository) {
		this.repository = repository;
	}
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		System.out.println("*********** Saving the data *********");
		Stock stock1 = new Stock();
		stock1.setStockName("AAAA");
		stock1.setStockNumber("AAAA11");
		stock1.setPurchasingDate(new Date());
		stock1.setStockPurchaseprice(100.00);
		stock1.setStockSellingprice(150.00);
		stock1.setQuantity(100l);
		repository.save(stock1);
		
		Stock stock2 = new Stock();
		stock2.setStockName("BBBB");
		stock2.setStockNumber("BBBB22");
		stock2.setPurchasingDate(new Date());
		stock2.setStockPurchaseprice(110.00);
		stock2.setStockSellingprice(120.00);
		stock2.setQuantity(100l);
		repository.save(stock2);
		
		Stock stock3 = new Stock();
		stock3.setStockName("CCCC");
		stock3.setStockNumber("CCCC33");
		stock3.setPurchasingDate(new Date());
		stock3.setStockPurchaseprice(130.00);
		stock3.setStockSellingprice(150.00);
		stock3.setQuantity(100l);
		repository.save(stock3);
		
		Stock stock4 = new Stock();
		stock4.setStockName("DDDD");
		stock4.setStockNumber("DDDD44");
		stock4.setPurchasingDate(new Date());
		stock4.setStockPurchaseprice(160.00);
		stock4.setStockSellingprice(180.00);
		stock4.setQuantity(100l);
		repository.save(stock4);
		
		Stock stock5 = new Stock();
		stock5.setStockName("EEEE");
		stock5.setStockNumber("EEEE55");
		stock5.setPurchasingDate(new Date());
		stock5.setStockPurchaseprice(180.00);
		stock5.setStockSellingprice(200.00);
		stock5.setQuantity(100l);
		repository.save(stock5);
		
		
	}

}
