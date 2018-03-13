package com.org.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.org.order.domain.OrderDomain;
import com.org.util.OrderUtility;

public class OrderDAO {
	OrderUtility orderUtility = new OrderUtility();
	public List<OrderDomain> readData(String filePath) throws Exception{
		BufferedReader reader;
		List<OrderDomain> orders = new ArrayList<OrderDomain>();
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String currentLine = reader.readLine();
			while (currentLine != null && !"".equals(currentLine))
			{
				String[] orderdetails = currentLine.split("\\s+");
				String name = orderdetails[0];
				Long orderTime = null;
				try{
					orderTime = Long.valueOf(orderdetails[1]);
				}catch(Exception e){
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
		} catch (FileNotFoundException e1) {
			throw new Exception("Problem occoured while reading the file");
		} catch (Exception e) {
			throw e;
		}
		return orders;
	}

	public void writeDataToFile(String newfileLocation, List<OrderDomain> orders) throws Exception {
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(newfileLocation));
			writer.write("Order");
			writer.write("      time");
			writer.newLine();
			for (OrderDomain order : orders) 
			{
				writer.write(order.getItemName());
				writer.write("      "+orderUtility.convertDate(order.getOrderTime()));
				writer.newLine();
			}
			writer.close();
		} catch (FileNotFoundException e1) {
			throw new Exception("Problem occoured while reading the file");
		}
	}
}
