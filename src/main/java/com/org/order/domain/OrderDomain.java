package com.org.order.domain;

public class OrderDomain {
private String itemName;
private Long orderTime;

public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}

public Long getOrderTime() {
	return orderTime;
}
public void setOrderTime(Long orderTime) {
	this.orderTime = orderTime;
}
}
