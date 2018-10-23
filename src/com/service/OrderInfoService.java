package com.service;

import java.util.List;

import com.entity.OrderInfo;
import com.util.Result;

public interface OrderInfoService {
	public Result addOrderInfo(String user_id,String user_name,
			String plate,String trouble_code,String trouble_name,
			String contact,String contact_way
			);
	
	public Result findAllOrder();
	
	public  String getRemarkBycode(String trouble_code);
	
	public Result delOrderInfo(String id);
	
	public Result changStatus(String id);
	
	public Result changeCost(String id,String order_cost);
	
	public Result findOrder(String user_id);
	
	public Result searchOrderInfo(String type,String keywords);
	
	public Result findDealOrder();
	public Result findUndealOrder();
	
	public Result findBySort();
	
	public Result findBySortDesc();
	
	public String getPrice(String trouble_code);
	
	public  String getPriceById(String id);
	
	public Result countOrderPrice();
	
	public Result totalProject();
	
	public Result monthIncome();
	public Result userPayTotalResult();
}
