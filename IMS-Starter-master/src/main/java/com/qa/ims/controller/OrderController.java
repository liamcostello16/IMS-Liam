package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemsDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.OrderItems;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Orders>{
	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private OrderItemsDAO orderDAO;
	private Utils utils;

	public OrderController(OrdersDAO ordersDAO, Utils utils, OrderItemsDAO orderI) {
		super();
		this.ordersDAO = ordersDAO;
		this.orderDAO = orderI;
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
		Orders order = new Orders();
		LOGGER.info("Please enter a ID");
		Long Value = utils.getLong();
		order.setCustomerID(Value);
		order = ordersDAO.create(order);
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
	        		Long Item = utils.getLong();
	        		order = new Orders(id, Item);
	        		ordersDAO.update(order);
	                break; 
	            case "no": 
	            	
	    			order = new Orders(id);
	    			ordersDAO.DeleteItem(order);
	    			
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
