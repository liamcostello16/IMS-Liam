package com.qa.ims.persistence.dao;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;


public class ItemsDAOTest {
	private final ItemsDAO DAO = new ItemsDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema2.sql", "src/test/resources/sql-data2.sql");
	}

	@Test
	public void testCreate() {
		Long value = (long) 20;
		final Items created = new Items(2L, "Baseball", value);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Items> expected = new ArrayList<>();
		expected.add(new Items(1L, "baseball", (long) 20));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		Long value = (long) 20;
		assertEquals(new Items(1L, "baseball", (long) 20), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Items(ID, "baseball", (long) 20), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Items updated = new Items(1L, "Baseball", (long) 20);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
