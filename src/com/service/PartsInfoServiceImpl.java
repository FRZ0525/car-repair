package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.PartsInfoDao;
import com.entity.PartsInfo;
import com.util.Result;

@Service
public class PartsInfoServiceImpl implements PartsInfoService{
	@Resource
	PartsInfoDao dao;

	@Override
	public Result buyParts(String id) {
		// TODO Auto-generated method stub
		dao.buyParts(id);
		return new Result("0", "零件购买成功", null);
	}

	@Override
	public Result findAllParts() {
		// TODO Auto-generated method stub
		List<PartsInfo> list=dao.findAllParts();
		return new Result("0", "零件信息加载成功", list);
	}

	@Override
	public Result useParts(String id) {
		// TODO Auto-generated method stub
		dao.useParts(id);
		return new Result("0", "零件已使用", null);
	}
	
	@Override
	public Result searchPartsInfo(String type, String keywords) {
		// TODO Auto-generated method stub
		Map<String,Object> params=new HashMap<String,Object>();
		if(!type.equals("") && keywords.equals("")){
			return new Result("1", "请输入关键字", null);
		}else if(type.equals("") && !keywords.equals("")){
			return new Result("1", "请选择分类", null);
		}else if(type.equals("1")){
			params.put("name", "%"+keywords+"%");
		}else if(type.equals("2")){
			params.put("type", "%"+keywords+"%");
		}else if(type.equals("3")){
			params.put("price", "%"+keywords+"%");
		}
		List<PartsInfo> list=dao.searchPartsInfo(params);
		return new Result("0", "配件信息加载成功", list);
	}
	
	@Override
	public Result partTotal(){
		List<Map<String, String>> list =dao.partTotalInfo();
		return new Result("0", "配件统计", list);
	}
}
