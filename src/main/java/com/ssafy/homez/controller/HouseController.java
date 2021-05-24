package com.ssafy.homez.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homez.dto.HouseDto;
import com.ssafy.homez.dto.HouseParamDto;
import com.ssafy.homez.service.HouseService;

// VUE cli mode 개발 대응
@CrossOrigin(origins ="http://localhost:5500", allowCredentials="true", allowedHeaders="*",
		methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS}
)
@RestController
public class HouseController {
	
	@Autowired
	HouseService houseService;
	
	@GetMapping(value="/gugun")
	public ResponseEntity<List<Map<String, String>>> getGugunList(){
		System.out.println("|| gugun 리스트 확인하기");
		List<Map<String, String>> list = null;
		
		list = houseService.getGugunList();
		
		for(int i=0,size=list.size(); i<size; i++ ) {
			Map<String,String> map = list.get(i);
			for(String key: map.keySet()) {
				System.out.print( key + " " + map.get(key) );
			}
			System.out.println();
		}
		return new ResponseEntity<List<Map<String, String>>>(list, HttpStatus.OK);
	}
	
	@GetMapping(value="/gugun/{gugunCode}")
	public ResponseEntity<List<Map<String, String>>> getDongList(@PathVariable String gugunCode){
		System.out.println("|| gugunCode를 기반으로 dong 리스트 확인하기 : " + gugunCode);
		List<Map<String, String>> list = null;
		
		list = houseService.getDongList(gugunCode);
		
		for(int i=0,size=list.size(); i<size; i++ ) {
			Map<String,String> map = list.get(i);
			for(String key: map.keySet()) {
				System.out.print( key + " " + map.get(key) );
			}
			System.out.println();
		}
		
		return new ResponseEntity<List<Map<String, String>>>(list, HttpStatus.OK);
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
