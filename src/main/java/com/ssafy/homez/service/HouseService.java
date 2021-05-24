package com.ssafy.homez.service;

import java.util.List;
import java.util.Map;

import com.ssafy.homez.dto.HouseDto;
import com.ssafy.homez.dto.HouseParamDto;


public interface HouseService {
	public List<HouseDto> searchByDong(HouseParamDto houseParamDto);
	public List<HouseDto> searchByAptName(HouseParamDto houseParamDto);
	public List<Map<String, String>> getGugunList();
	public List<Map<String, String>> getDongList(String gugunCode);
}