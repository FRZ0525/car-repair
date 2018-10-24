package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.entity.OrderInfo;

public interface OrderInfoDao {
	public void addOrderInfo(OrderInfo oi);
	public List<OrderInfo> findAllOrder();
	public void delOrderInfo(String id);
	public void changStatus(@Param("id")String id,@Param("status")Integer status);
	public String getTrouble_priceById(@Param("id")String id);
	public void changeCost(@Param("id") String id,@Param("trouble_price") String trouble_price,@Param("order_cost")String order_cost);
	public List<OrderInfo> findOrder(String user_id);
	public List<OrderInfo> searchOrderInfo(Map<String,Object> params);
	public List<OrderInfo> findByStatus(Integer status);
	public List<OrderInfo> findBySort();
	public List<OrderInfo> findBySortDesc();
	public String getTrouble_price(String trouble_code);
	public String getTrouble_remark(String trouble_code);
	public List<Map<String, String>> countOrderPrice();
	public List<Map<String, String>> totalProject();
	public List<Map<String, String>> monthIncomeInfo();
	public List<Map<String, String>> userPayTotalInfo();
}
