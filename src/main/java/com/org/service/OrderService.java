package com.org.service;

import java.util.Collections;
import java.util.List;

import com.org.dao.OrderDAO;
import com.org.order.domain.OrderDomain;
import com.org.util.OrderSortByTime;

public class OrderService {
	OrderDAO orderDAO= new OrderDAO();	
	public String formatOrderData(String filePath, String newfileLocation) throws Exception {
		List<OrderDomain> orders = orderDAO.readData(filePath);
		Collections.sort(orders, new OrderSortByTime());
		orderDAO.writeDataToFile(newfileLocation, orders);
		return newfileLocation;
	}
}
