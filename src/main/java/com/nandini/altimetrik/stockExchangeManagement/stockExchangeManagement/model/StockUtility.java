package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class StockUtility {


	@Autowired
	private  EntityManager em;
 
    
 
    public List<Stock> findStockByStockName(String stockName) {
      System.out.println("****** findStockByStockName111 *****");
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Stock> cq = cb.createQuery(Stock.class);
     
            Root<Stock> stock = cq.from(Stock.class);
            Predicate stockNamePredicate = cb.equal(stock.get("stockName"), stockName);
            //Predicate titlePredicate = cb.like(stock.get("title"), "%" + title + "%");
            cq.where( stockNamePredicate);
     
            TypedQuery<Stock> query = em.createQuery(cq);
            return query.getResultList();
        }
    
}
