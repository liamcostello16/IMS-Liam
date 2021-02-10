package com.qa.ims.controllers;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class OrderControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private OrdersDAO dao;

	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		
		final Long ID = 1L, CustomerID = 1L;
		final Orders created = new Orders(CustomerID);
		created.setCustomerID(CustomerID);
		
		Mockito.when(utils.getLong()).thenReturn(CustomerID);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Orders> item = new ArrayList<>();
		
		Long id = 1L;
		
		Long total = (long) 1;
		item.add(new Orders(id, total, total));

		Mockito.when(dao.readAll()).thenReturn(item);

		assertEquals(item, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

//	@Test
//	public void testUpdate() {
//		
//		
//		Long id = 1L;
//	
//		Long total = (long) 1;
//		
//		Orders updated = new Orders(id, total, total);
//
//		Mockito.when(this.utils.getLong()).thenReturn(updated.getId(), updated.getItemId());
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(2)).getLong();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}

	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
