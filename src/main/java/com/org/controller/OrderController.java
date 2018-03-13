package com.org.controller;

import com.org.dao.OrderDAO;
import com.org.service.OrderService;


public class OrderController {
	static OrderService orderService = new OrderService(); 
	public static void main(String[] args) throws Exception {
		try{
			orderService.formatOrderData("Java_code_Challenge.txt","Output.txt");
		} catch(Exception e){
			// Implement the exception handling logic
			e.printStackTrace();
		}
	}

}
