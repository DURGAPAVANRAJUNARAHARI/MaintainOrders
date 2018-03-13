package com.org.dao;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.org.order.domain.OrderDomain;

public class OrderDAOTest {

	OrderDAO orderDAO = new OrderDAO();

	@Test
	public void testReadData() throws Exception {
		List<OrderDomain> orders = orderDAO.readData("Java_code_Challenge.txt");
		Assert.assertTrue(!orders.isEmpty());
	}

	@Test
	public void testWriteDataToFile() throws Exception {
		List<OrderDomain> orders = new ArrayList<OrderDomain>();
		OrderDomain orderDomain = new OrderDomain();
		orderDomain.setItemName("order");
		orderDomain.setOrderTime(Long.valueOf("12345678"));
		orders.add(orderDomain);
		orderDAO.writeDataToFile("Outputfile.txt", orders);
		FileReader file=new FileReader("Outputfile.txt");
		Assert.assertTrue(file.ready());
	}

}
