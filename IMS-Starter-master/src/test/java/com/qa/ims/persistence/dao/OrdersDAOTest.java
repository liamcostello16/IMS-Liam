package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAOTest {
	
	private final OrdersDAO DAO = new OrdersDAO(new ItemsDAO());
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema3.sql", "src/test/resources/sql-data2.sql");
	}
	
	@Test
	public void testCreate() {
		Long value = (long) 2L;
		List<Items> expected = new ArrayList<>();
		expected.clear();
		final Orders created = new Orders(2L, value, expected);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Orders> expected = new ArrayList<>();
		List<Items> test = new ArrayList<>();
		test.clear();
		expected.add(new Orders(1L, 1L, test));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		Long value = (long) 1;
		List<Items> test = new ArrayList<>();
		test.clear();
		assertEquals(new Orders(1L, value, test), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		List<Items> test = new ArrayList<>();
		test.clear();
		assertEquals(new Orders(ID, ID, test), DAO.read(ID));
	}
	
	@Test
	public void testAddItem() {
		
		List<Items> test = new ArrayList<>();
		test.add(new Items(1L, "baseball", 20L));
		final Orders updated = new Orders(1L, 1L, test);
		
		final Orders testObject = new Orders(1L, 1L, 1L);
		
		assertEquals(updated, DAO.addItem(testObject));
	}
	
	@Test
	public void testRemoveItem() {
		
		List<Items> test = new ArrayList<>();
		test.clear();
		final Orders updated = new Orders(1L, 1L, test);
		
		final Orders testObject = new Orders(1L, 1L, 1L);
		assertEquals(updated, DAO.deleteItem(testObject));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}


}
