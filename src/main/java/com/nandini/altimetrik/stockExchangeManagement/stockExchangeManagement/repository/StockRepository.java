package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long> {

	List<Stock> findAll(Sort sort);
}
