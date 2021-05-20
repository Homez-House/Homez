package com.ssafy.homez.dao;

import java.util.List;

import com.ssafy.homez.dto.HouseDto;

public interface HouseDao {
	public List<HouseDto> searchByDong(String dongCode);
	public List<HouseDto> searchByName(String aptName);

}
