package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.CarInfoService;
import com.service.TroubleInfoService;
import com.util.Result;

@Controller
@RequestMapping("/troubleinfo")
public class TroubleInfoController {
	@Resource
	private TroubleInfoService ts;
		
	@RequestMapping("/add.do")
	@ResponseBody
	public Result addTroubleInfo(String trouble_code, String trouble_name, String trouble_remark,String trouble_price) {
		System.out.println("进入TroubleInfoController/add.do");
		Result rs= ts.addTroubleInfo(trouble_code, trouble_name, trouble_remark,trouble_price);
		System.out.println(rs.toString());
		return rs;
	}
	
	
	@RequestMapping("/show.do")
	@ResponseBody
	public Result troubleList() {
		System.out.println("进入TroubleInfoController/show.do");
		Result rs=ts.troubleList();
		System.out.println(rs.toString());
		return rs;
	}

	@RequestMapping("/change.do")
	@ResponseBody
	public Result changStatus(String id) {
		System.out.println("进入TroubleInfoController/change.do");
		Result rs=ts.changStatus(id);
		System.out.println(rs.toString());
		return rs;
	}
	
	@RequestMapping("/pricesort.do")
	@ResponseBody
	public Result priceSort(String flag){	  //价格排序的controller	
		System.out.println("进入troubleinfoController/pricesort.do");
		int flag_sort=Integer.parseInt(flag);
		System.out.println(flag_sort);
		Result rs=null;
		if(flag_sort%2!=0){
			rs=ts.priceSortAscList();
		}else{
			rs=ts.priceSortDescList();
		}
		System.out.println(rs.toString());
		return rs;
	}
	
	@RequestMapping("/searchtrouble.do")
	@ResponseBody
	public Result searchTroubleInfo(String type, String keywords) {
		System.out.println("进入troubleInfoController/searchtrouble.do");
		Result rs=ts.searchTroubleInfo(type, keywords);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/searchtroubleByRemark.do")
	@ResponseBody
	public Result searchTroubleByRemark(String remark) {
		System.out.println("进入troubleInfoController/searchTroubleByRemark.do");
		System.out.println(remark);
		Result rs=ts.searchTroubleByRemarkInfo(remark);
		System.out.println(rs);
		return rs;
	}
}
