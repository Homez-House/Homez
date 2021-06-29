package com.ssafy.homez;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.homez.dto.HouseDto;
import com.ssafy.homez.dto.HouseParamDto;
import com.ssafy.homez.service.HouseService;

@SpringBootTest
public class HouseTest {

	@Autowired
	HouseService houseService;
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDetailNotice() {
		// 자료를 저장한다.
		HouseParamDto houseParamDto = new HouseParamDto(5,5,"아현동", "dongName");
		
		List<HouseDto> list = houseService.searchByDong(houseParamDto);
		
		for(HouseDto house: list) {
			System.out.println(house);
		}
	}
}


// 자료를 저장한다.
//StudentDto dto = new StudentDto();
//dto.setStudentNm("홍길동");
//dto.setMajorCd("m0001");
//dto.setEmail("hong@hong.com");
//dto.setPhone("010-1111-2222");
//dto.setEnterDt("2020-10-01");
//assertEquals(service.studentInsert(dto), 1);
