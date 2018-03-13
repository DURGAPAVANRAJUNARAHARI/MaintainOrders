package com.org.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import com.org.order.domain.OrderDomain;
import com.org.order.domain.OrderDomainOutput;
import com.org.util.OrderUtility;

public class OrderService {
	OrderUtility orderUtility = new OrderUtility();
	public String formatOrderData(String filePath) throws Exception {
		String newfileLocation="C:\\Users\\dnarahar\\Desktop\\Output.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		ArrayList<OrderDomain> orders = new ArrayList<OrderDomain>();
		String nameOut=null;
		String formattedTime=null;
		String currentLine = reader.readLine();
		while (currentLine != null && !"".equals(currentLine))
		{
			String[] orderdetails = currentLine.split("\\s+");
			String name = orderdetails[0];
			Long orderTime = null;
			try{
				orderTime = Long.valueOf(orderdetails[1]);
			}catch(Exception e){
				nameOut = name;
				formattedTime = orderdetails[1];
				currentLine = reader.readLine();
				continue;
			}
			OrderDomain  orderDomain = new OrderDomain();
			orderDomain.setItemName(name);
			orderDomain.setOrderTime(orderTime);
			orders.add(orderDomain);
			currentLine = reader.readLine();
		}
		reader.close();
		Collections.sort(orders, new OrderDomainOutput());
		BufferedWriter writer = new BufferedWriter(new FileWriter(newfileLocation));
		writer.write(nameOut);
		writer.write("      "+formattedTime);
		writer.newLine();
		for (OrderDomain order : orders) 
		{
			writer.write(order.getItemName());
			writer.write("      "+orderUtility.convertDate(order.getOrderTime()));
			writer.newLine();
		}
		writer.close();
		return "";
	}
}
