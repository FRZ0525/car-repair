package com.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.PartsInfoService;
import com.util.Result;

@Controller
@RequestMapping("/partsinfo")
public class PartsInfoController {
	@Resource
	private PartsInfoService ps;
	
	@RequestMapping("/buy.do")
	@ResponseBody
	public Result buyParts(String id) {
		System.out.println("进入PartsInfoController/buy.do");
		Result rs=ps.buyParts(id);
		System.out.println(rs);
		return rs;		
	}
	
	@RequestMapping("/use.do")
	@ResponseBody
	public Result useParts(String id) {
		System.out.println("进入PartsInfoController/use.do");
		Result rs=ps.useParts(id);
		System.out.println(rs);
		return rs;		
	}
	
	@RequestMapping("/show.do")
	@ResponseBody
	public Result findAllParts() {
		System.out.println("进入PartsInfoController/show.do");
		Result rs=ps.findAllParts();
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/searchparts.do")
	@ResponseBody
	public Result searchOrderInfo(String type, String keywords) {
		System.out.println("进入PartsInfoController/searchparts.do"+"Type"+type+",keywords"+keywords);		
		Result rs=ps.searchPartsInfo(type, keywords);
		System.out.println(rs);
		return rs;
	}
	
	@RequestMapping("/parttotal.do")
	@ResponseBody
	public Result partTotal(){
		System.out.println("进入partsinfoController/parttotal.do");
		Result rs=ps.partTotal();
		System.out.println(rs);
		return rs;
	}
	
	
}
