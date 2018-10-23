package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CarInfoService;
import com.service.OrderInfoService;
import com.sun.crypto.provider.RSACipher;
import com.util.Result;

@Controller
@RequestMapping("/orderinfo")
public class OrderInfoController {
	@Resource
	private OrderInfoService os;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public Result addOrderInfo(String user_id, String user_name, String plate, String trouble_code,String trouble_name, String contact,
			String contact_way) {
		System.out.println("进入OrderInfoController/add.do");
		Result rs=os.addOrderInfo(user_id, user_name, plate, trouble_code,trouble_name, contact, contact_way);
		System.out.println(rs);
		return rs;		
	}
	
	@RequestMapping("/showAll.do")
	@ResponseBody
	public Result findAllOrder() {
		System.out.println("进入OrderInfoController/showAll.do");
		Result rs=os.findAllOrder();
		System.out.println(rs);
		return rs;	
	}
	
	@RequestMapping("/delete.do")
	@ResponseBody
	public Result delOrderInfo(String id) {
		System.out.println("进入OrderInfoController/delete.do");
		Result rs=os.delOrderInfo(id);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/changecost.do")
	@ResponseBody
	public Result changeCost(String id,String order_cost) {
		System.out.println("进入OrderInfoController/changecost.do");
		System.out.println(order_cost);
		Result rs=os.changeCost(id,order_cost);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/change.do")
	@ResponseBody
	public Result changStatus(String id) {
		System.out.println("进入OrderInfoController/change.do");
		Result rs=os.changStatus(id);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/show.do")
	@ResponseBody
	public Result findOrder(String user_id) {
		System.out.println("进入OrderInfoController/show.do");
		Result rs=os.findOrder(user_id);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/sort.do")
	@ResponseBody
	public Result findBySort(String flag) {
		System.out.println("进入OrderInfoController/sort.do");
		int flag_sort=Integer.parseInt(flag);
		System.out.println(flag_sort);
		Result rs=null;
		if(flag_sort%2!=0){
			rs=os.findBySort();
		}else{
			rs=os.findBySortDesc();
		}
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/deal.do")
	@ResponseBody
	public Result findDealOrder(String flag){
		System.out.println("进入OrderInfoController/deal.do");
		int flag_deal=Integer.parseInt(flag);
		System.out.println(flag_deal);
		Result rs=null;
		if(flag_deal%2!=0){
			rs=os.findDealOrder();
		}else{
			rs=os.findUndealOrder();
		}
		System.out.println(rs);
		return rs;
	}
		
	
	@RequestMapping("/searchorder.do")
	@ResponseBody
	public Result searchOrderInfo(String type, String keywords) {
		System.out.println("进入OrderInfoController/search.do");
		Result rs=os.searchOrderInfo(type, keywords);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/countorderprice.do")
	@ResponseBody
	public Result countOrderPrice(){
		System.out.println("进入OrderinfoController/countOrderPrice.do");
		Result rs=os.countOrderPrice();
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/total_project.do")
	@ResponseBody
	public Result totalProject(){   //项目使用的统计情况
		System.out.println("进入OrderinfoController/total_project.do");
		Result rs=os.totalProject();
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/month_income.do")
	@ResponseBody
	public Result monthIncome(){
		System.out.println("进入OrderinfoController/month_income.do");
		Result rs=os.monthIncome();
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/userpay_total.do")
	@ResponseBody
	public Result userPayTotal(){   //
		System.out.println("进入OrderinfoController/userpay_total.do");
		Result rs=os.userPayTotalResult();
		System.out.println(rs);
		return rs;
	}
	
}
