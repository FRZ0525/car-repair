package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.entity.OrderInfo;
import com.entity.TroubleInfo;

public interface TroubleInfoDao {
	public void addTroubleInfo(TroubleInfo ti);
	public List<TroubleInfo> troubleList();
	public void changStatus(@Param("id")String id,@Param("status")Integer status);
	public TroubleInfo findTrouble(String id);
	public List<TroubleInfo> priceSortDescInfo();
	public List<TroubleInfo> priceSortAscInfo();
	public List<TroubleInfo> searchTroubleInfo(Map<String,Object> params);
	public List<TroubleInfo> searchTroubleByRemarkInfo(String remark);
}
