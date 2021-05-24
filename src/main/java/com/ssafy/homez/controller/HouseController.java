package com.ssafy.homez.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homez.dto.HouseDto;
import com.ssafy.homez.dto.HouseParamDto;
import com.ssafy.homez.service.HouseService;

@RestController
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping(value="gugun")
	public ResponseEntity<List<Map>> getGugunList(){
		List<Map<String, String>> list = null;
		
		list = houseService.getGugunList();
		
		for(int i=0,size=list.size(); i<size; i++ ) {
			Map<String,String> map = list.get(i);
			for(String key: map.keySet()) {
				System.out.print( key + " " + map.get(key) );
			}
			System.out.println();
		}
		return new ResponseEntity<List<Map>>(HttpStatus.OK);
	}
	
	@GetMapping(value="gugun/{gugunCode}")
	public ResponseEntity<List<Map>> getDongList(@PathVariable String gugunCode){
		List<Map<String, String>> list = null;
		
		list = houseService.getDongList(gugunCode);
		
		for(int i=0,size=list.size(); i<size; i++ ) {
			Map<String,String> map = list.get(i);
			for(String key: map.keySet()) {
				System.out.print( key + " " + map.get(key) );
			}
			System.out.println();
		}
		
		return new ResponseEntity<List<Map>>(HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/houses")
	public ResponseEntity<List<HouseDto>> searchByDong(HouseParamDto houseParamDto) {
		
		List<HouseDto> list = null;
		
		if (houseParamDto.getHouseSearchType().equals("dongName")) {
			list = houseService.searchByDong(houseParamDto);
		} else if (houseParamDto.getHouseSearchType().equals("aptName")) {
			list = houseService.searchByAptName(houseParamDto);
		}
		
		for(HouseDto house : list) {
			System.out.println(house);
		}
		
		return new ResponseEntity<List<HouseDto>>(list, HttpStatus.OK);
	}
}
