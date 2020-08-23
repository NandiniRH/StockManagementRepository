package com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.controller;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.model.Stock;
import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.model.StockUtility;
import com.nandini.altimetrik.stockExchangeManagement.stockExchangeManagement.repository.StockRepository;

import javassist.NotFoundException;

@RestController("/stocks")
@Path("stocks")
public class StockController {

	private final StockRepository repository;

	@Autowired
	private StockUtility stockUtility;

	public StockController(StockRepository repository) {
		this.repository = repository;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Stock> getAllStocks() {
		System.out.println("*** Inside getAllStocks *********");
		List<Stock> stockLst = (List<Stock>) repository.findAll();
		System.out.println("List Size : --- > : " + stockLst.size());
		return stockLst;

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addStock(Stock stock, @Context UriInfo uriInfo) throws URISyntaxException {
		Stock newStock = repository.save(stock);
		System.out.println("*********** inside save : " + uriInfo.getAbsolutePath());
		Response response = Response
				.created(new URI(String.format("%s/%s", uriInfo.getAbsolutePath().toString(), newStock.getId())))
				.build();
		System.out.println("**** Inserted new Stock : " + newStock.getId());
		return response;
	}

	@PUT
	@Path("/{stockName}/{quantity}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response purchasStockQuantity(@PathParam("stockName") String stockName, @PathParam("quantity") Long quantity,
			Stock requestStock) throws NotFoundException {
		System.out.println("********** purchasStockQuantity  ---- " + stockName + " quantity : " + quantity);
		List<Stock> stockLst = stockUtility.findStockByStockName(stockName);
		Stock stock = null;
		if (stockLst != null && stockLst.size() == 1) {
			stock = stockLst.get(0);
			System.out.println("Current Quantity : " + stock.getQuantity());
			Long updateQuantity = stock.getQuantity() - quantity;
			if (updateQuantity >= 0) {
				stock.setQuantity(updateQuantity);
				repository.save(stock);
				if(stock.getQuantity()==0)
				{
					System.out.println("Stock quantity is zero and cannot do purchasing ");
					repository.delete(stock);
				}
			}
			else
			{
				throw new StockUpdateException(stockName, quantity);
			}

		} else {
			throw new StockNotFoundException(stockName);
		}

		return Response.ok(stock).build();
	}
	
	private Sort.Direction getSortDirection(String direction) {
	    if (direction.equals("asc")) {
	      return Sort.Direction.ASC;
	    } else if (direction.equals("desc")) {
	      return Sort.Direction.DESC;
	    }

	    return Sort.Direction.ASC;
	  }

	  @GET
	  @Path("/sortedStocks")
	  @Produces(MediaType.APPLICATION_JSON)
	  public ResponseEntity<List<Stock>> getAllSortedStocks(@QueryParam("sortLst") List<String> sort) {
		  System.out.println("***** custom sort********* "+sort);
	    try {
	      List<Order> orders = new ArrayList<Order>();

	      if (sort.get(0).contains(",")) {
	        // will sort more than 2 columns
	        for (String sortOrder : sort) {
	          // sortOrder="column, direction"
	          String[] _sort = sortOrder.split(",");
	          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
	        }
	      } else {
	        // sort=[column, direction]
	        orders.add(new Order(getSortDirection(sort.get(1)), sort.get(0)));
	      }

	      List<Stock> stocks = repository.findAll(Sort.by(orders));
	      System.out.println("stock sorted list : "+stocks);

	      if (stocks.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(stocks, HttpStatus.OK);
	    } catch (Exception e) {
	    	//e.printStackTrace();
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	
}
