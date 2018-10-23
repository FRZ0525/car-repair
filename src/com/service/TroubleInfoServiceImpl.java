package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TroubleInfoDao;
import com.entity.OrderInfo;
import com.entity.TroubleInfo;
import com.util.IDUtil;
import com.util.Result;
@Service
public class TroubleInfoServiceImpl implements TroubleInfoService{

	@Resource
	TroubleInfoDao dao;
	
	@Override
	public Result addTroubleInfo(String trouble_code, String trouble_name, String trouble_remark,String trouble_price) {
		// TODO Auto-generated method stub
		
		Result nr=null;
		if(trouble_code.equals("")){
			nr=new Result("1", "请输入项目编号", null);
		}else if(trouble_name.equals("")){
			nr=new Result("1", "请输入项目名称", null);
		}else{
			String id=IDUtil.createId();
			TroubleInfo ti=new TroubleInfo();
			ti.setId(id);
			ti.setTrouble_code(trouble_code);
			ti.setTrouble_name(trouble_name);
			ti.setTrouble_remark(trouble_remark);
			ti.setTrouble_price(trouble_price);			
			ti.setStatus(0);
			dao.addTroubleInfo(ti);
			nr=new Result("0", "项目信息添加成功", null);
		}		
		return nr;
	}

	@Override
	public Result troubleList() {
		// TODO Auto-generated method stub
		List<TroubleInfo> list=dao.troubleList();
		return new Result("0", "项目信息加载成功", list);
	}

	@Override
	public Result changStatus(String id) {
		// TODO Auto-generated method stub
		TroubleInfo ti=dao.findTrouble(id);
		Integer status=ti.getStatus();
		if(status==0){
			dao.changStatus(id, 1);
		}else{
			dao.changStatus(id, 0);
		}
		return new Result("0", "故障状态更改成功", null);
	}

	@Override
	public Result priceSortDescList(){   //按照价格降序排序
		List<TroubleInfo> list=dao.priceSortDescInfo();
		return new Result("0", "时间降序排序查询成功", list);
	}
	
	@Override
	public Result priceSortAscList(){    //按照价格升序排序
		List<TroubleInfo> list=dao.priceSortAscInfo();
		return new Result("0", "时间升序排序查询成功", list);
	}
	
	public Result searchTroubleInfo(String type, String keywords ){ //按照关键字模糊查询项目
		// TODO Auto-generated method stub
				Map<String,Object> params=new HashMap<String,Object>();
				if(!type.equals("") && keywords.equals("")){
					return new Result("1", "请输入关键字", null);
				}else if(type.equals("") && !keywords.equals("")){
					return new Result("1", "请选择分类", null);
				}else if(type.equals("1")){
					params.put("trouble_code", "%"+keywords+"%");
				}else if(type.equals("2")){
					params.put("trouble_name", "%"+keywords+"%");
				}else if(type.equals("3")){
					params.put("trouble_remark", "%"+keywords+"%");
				}
				List<TroubleInfo> list=dao.searchTroubleInfo(params);
				return new Result("0", "按照关键字订单信息加载成功", list);
	}
	
	public Result searchTroubleByRemarkInfo(String remark){
		if(remark.equals("0")){
			return new Result("1", "请选择分类", null);
		}else{
		List<TroubleInfo> list =dao.searchTroubleByRemarkInfo(remark);
		return new Result("0", "按照订单类型信息加载成功", list);
		}
	}
}
