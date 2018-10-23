package com.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.OrderInfoDao;
import com.dao.TroubleInfoDao;
import com.entity.OrderInfo;
import com.entity.TroubleInfo;
import com.util.IDUtil;
import com.util.Result;
@Service
public class OrderInfoServiceImpl implements OrderInfoService{

	@Resource
	OrderInfoDao dao;
	
	@Override
	public Result addOrderInfo(String user_id, String user_name, String plate, String trouble_code,String trouble_name, String contact,
			String contact_way) {
		// TODO Auto-generated method stub
		OrderInfo oi=new OrderInfo();
		String id=IDUtil.createId();
		String order_cost="0";
		String remark=getRemarkBycode(trouble_code);
		String trouble_price=this.getPrice(trouble_code);
		System.out.println(trouble_price);
		oi.setId(id);
		oi.setUser_id(user_id);
		oi.setUser_name(user_name);
		oi.setPlate(plate);
		oi.setTrouble_code(trouble_code);
		oi.setTrouble_name(trouble_name);
		oi.setContact(contact);
		oi.setContact_way(contact_way);
		oi.setRemark(remark);
		oi.setCreart_time(getTime());
		oi.setLong_time(System.currentTimeMillis());
		oi.setStatus(0);
		oi.setTrouble_price(trouble_price);
		oi.setOrder_cost(order_cost);
		dao.addOrderInfo(oi);
		return new Result("0", "订单信息添加成功", null);
	}

	@Override
	public  String getRemarkBycode(String trouble_code){   //根据trouble_code获取trouble_remark
		String trouble_remark=dao.getTrouble_remark(trouble_code);
		System.out.println(trouble_remark);
		return trouble_remark;
	}
	
	@Override
	public  String getPrice(String trouble_code){   //获取对应trouble_code的价格
		String trouble_price=dao.getTrouble_price(trouble_code);
		System.out.println(trouble_price);
		return trouble_price;
	}
	
	public Result countOrderPrice(){  //获取各个订单的金额
		//List<Map<String, String>> list =null;
		//System.out.println(list);
		List<Map<String, String>> list =dao.countOrderPrice();
		return new Result("0", "统计结果处理完成", list);
	}
	private static String getTime(){
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");       
		Date curDate=new Date(System.currentTimeMillis());//获取当前时间     
		String str=formatter.format(curDate); 
		return str;
	}


	@Override
	public Result findAllOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> list=dao.findAllOrder();
		return new Result("0", "订单信息加载成功", list);
	}

	@Override
	public Result delOrderInfo(String id) {
		// TODO Auto-generated method stub
		dao.delOrderInfo(id);
		return new Result("0", "订单信息删除成功", null);
	}

	@Override
	public Result changStatus(String id) {
		// TODO Auto-generated method stub
		dao.changStatus(id, 1);
		return new Result("0", "订单状态更改成功", null);
	}

	@Override
	public  String getPriceById(String id){   //获取对应id的价格
		String trouble_price=dao.getTrouble_priceById(id);
		System.out.println(trouble_price);
		return trouble_price;
	}
	
	public Result changeCost(String id,String order_cost){
		System.out.println(Integer.parseInt(getPriceById(id)));
		System.out.println(Integer.parseInt(order_cost));
		int trouble_price = Integer.parseInt(getPriceById(id))+Integer.parseInt(order_cost);
		System.out.println(trouble_price);
		dao.changeCost(id,Integer.toString(trouble_price),order_cost);
		return new Result("0", "订单的成本价格更改成功", null);
	}
	
	@Override
	public Result findOrder(String user_id) {
		// TODO Auto-generated method stub
		List<OrderInfo> list=dao.findOrder(user_id);
		return new Result("0", "订单信息加载成功", list);
	}

	@Override
	public Result searchOrderInfo(String type, String keywords) {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		if(!type.equals("") && keywords.equals("")){
			return new Result("1", "请输入关键字", null);
		}else if(type.equals("") && !keywords.equals("")){
			return new Result("1", "请选择分类", null);
		}else if(type.equals("1")){
			params.put("plate", "%"+keywords+"%");
		}else if(type.equals("2")){
			params.put("trouble_name", "%"+keywords+"%");
		}else if(type.equals("3")){
			params.put("user_name", "%"+keywords+"%");
		}else if(type.equals("4")){
			params.put("contact", "%"+keywords+"%");
		}
		List<OrderInfo> list=dao.searchOrderInfo(params);
		return new Result("0", "订单信息加载成功", list);
	}

	@Override
	public Result findDealOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> list=dao.findByStatus(1);
		return new Result("0", "订单信息加载成功", list);
	}

	@Override
	public Result  findUndealOrder() {
		// TODO Auto-generated method stub
		List<OrderInfo> list=dao.findByStatus(0);
		return new Result("0", "订单信息加载成功", list);
	}

	@Override
	public Result findBySort() {
		// TODO Auto-generated method stub
		List<OrderInfo> list=dao.findBySort();
		return new Result("0", "订单信息升序排序加载成功", list);
	}

	@Override
	public Result findBySortDesc() {
		// TODO Auto-generated method stub
		List<OrderInfo> list=dao.findBySortDesc();
		return new Result("0", "订单信息降序排序加载成功", list);
	}

	@Override
	public Result totalProject() {   //统计项目的客户消费情况
		List<Map<String, String>> list =dao.totalProject();
		return new Result("0", "统计结果处理完成", list);		
	}
	
	@Override
	public Result monthIncome(){    //月收入统计
		List<Map<String, String>> list =dao.monthIncomeInfo();
		return new Result("0", "月收入统计结果处理完成", list);
	}
	
	
	@Override
	public Result userPayTotalResult(){    //月收入统计
		List<Map<String, String>> list =dao.userPayTotalInfo();
		return new Result("0", "月人均收入统计结果处理完成", list);
	}
}
