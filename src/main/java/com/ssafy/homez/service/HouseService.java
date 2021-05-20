package com.ssafy.homez.service;

import java.util.List;

import com.ssafy.homez.dto.HouseDto;


public interface HouseService {
	public List<HouseDto> searchByDong(String dongCode);
	public List<HouseDto> searchByName(String aptName);
}
