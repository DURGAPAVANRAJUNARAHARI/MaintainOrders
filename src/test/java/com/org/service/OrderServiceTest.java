package com.org.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.org.dao.OrderDAO;
@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {
	@Mock
	OrderDAO orderDAO;
	@InjectMocks
	OrderService orderService=new OrderService();
	@Test
	public void testFormatOrderData() throws Exception {
		String newfileLocation="Output.txt";
		String fileLocation = "Java_code_Challenge.txt";
		Assert.assertNotNull(orderService.formatOrderData(fileLocation,newfileLocation));
	}
}
