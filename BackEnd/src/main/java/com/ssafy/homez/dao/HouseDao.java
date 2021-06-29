package com.ssafy.homez.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homez.dto.HouseDto;
import com.ssafy.homez.dto.HouseParamDto;

@Mapper
public interface HouseDao {
	public List<HouseDto> searchByDong(HouseParamDto houseParamDto);
	public List<HouseDto> searchByAptName(HouseParamDto houseParamDto);
	public List<Map<String, String>> getGugunList();
	public List<Map<String, String>> getDongList(String gugunCode);
}
