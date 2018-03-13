package com.org.controller;

import com.org.service.OrderService;

public class OrderController {

	public static void main(String[] args) throws Exception {
		try{
			OrderService orderService = new OrderService(); 
			orderService.formatOrderData("C:\\Users\\dnarahar\\Desktop\\Java_code_Challenge.txt");
			System.out.println("done");
		} catch(Exception e){
			// exception logic
			e.printStackTrace();
		}
	}

}
