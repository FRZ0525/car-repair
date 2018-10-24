package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.OrderInfo;
import com.entity.PartsInfo;

public interface PartsInfoDao {
	public void buyParts(String id);
	public void useParts(String id);
	
	public List<PartsInfo> findAllParts();
	public List<PartsInfo> searchPartsInfo(Map<String,Object> params);
	
	public List<Map<String, String>> partTotalInfo();
}
