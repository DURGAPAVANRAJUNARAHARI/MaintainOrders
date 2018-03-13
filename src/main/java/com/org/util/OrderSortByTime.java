package com.org.util;

import java.util.Comparator;

import com.org.order.domain.OrderDomain;

public class OrderSortByTime implements Comparator<OrderDomain>{

	@Override
	public int compare(OrderDomain o1, OrderDomain o2) {
		return o1.getOrderTime().compareTo(o2.getOrderTime());
	}

}
