package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;



public class ItemController implements CrudController<Items>{

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemsDAO;
	private Utils utils;
	String itemName = "";
	Long itemValue = null;
	public ItemController(ItemsDAO itemDAO, Utils utils) {
		super();
		this.itemsDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter a name");
		itemName = utils.getString();
		LOGGER.info("Please enter a value");
		itemValue = utils.getLong();
		Items item = itemsDAO.create(new Items(itemName, itemValue));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the Item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a name");
		itemName = utils.getString();
		LOGGER.info("Please enter a Value");
		itemValue = utils.getLong();
		Items item = itemsDAO.update(new Items(id, itemName, itemValue));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}
