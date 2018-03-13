package com.org.order.domain;

import java.util.Comparator;

public class OrderDomainOutput implements Comparator<OrderDomain>{


	public int compare(OrderDomain o1, OrderDomain o2) {
		return o1.getOrderTime().compareTo(o2.getOrderTime());
	}

}
