package com.ssafy.homez.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homez.dao.HouseDao;
import com.ssafy.homez.dto.HouseDto;
import com.ssafy.homez.dto.HouseParamDto;


@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	HouseDao houseDao;
	
	@Override
	public List<HouseDto> searchByDong(HouseParamDto houseParamDto) {
		return houseDao.searchByDong(houseParamDto);
	}

	@Override
	public List<HouseDto> searchByAptName(HouseParamDto houseParamDto) {
		return houseDao.searchByAptName(houseParamDto);
	}

	@Override
	public List<Map<String, String>> getGugunList() {
		return houseDao.getGugunList();
	}

	@Override
	public List<Map<String, String>> getDongList(String gugunCode) {
		return houseDao.getDongList(gugunCode);
	}

}
