package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders>{
	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;
	Long orderID = null;
	
	public OrderController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Orders create() {
	
		LOGGER.info("Please enter a ID");
		orderID = utils.getLong();

		Orders order = ordersDAO.create(new Orders(orderID));
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Orders update() {
		Orders order = null;

		LOGGER.info("Please enter the id of the Order you would like to update");
		Long id = utils.getLong();
		
		LOGGER.info("Would you like to add a item yes or no");
		
		String str = utils.getString();
		
		 switch(str) 
	        { 
	            case "yes": 
	        		LOGGER.info("What item do you want added please enter the ID:");
	        		orderID = utils.getLong();
	        		order = new Orders(id, orderID);
	        		ordersDAO.addItem(order);
	                break; 
	            case "no": 
	            	
	    			order = new Orders(id);
	    			ordersDAO.deleteItem(order);
	    			
	                break; 
	   
	            default: 	    				
	        }
		 LOGGER.info("Order Updated");
		 return order;
			
	


	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Order you would like to delete");
		Long id = utils.getLong();
		return ordersDAO.delete(id);
	}
}
