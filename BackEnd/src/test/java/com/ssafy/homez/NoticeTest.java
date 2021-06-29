package com.ssafy.homez;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.plaf.multi.MultiOptionPaneUI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.service.NoticeService;

@SpringBootTest
public class NoticeTest {

	@Autowired
	NoticeService noticeService;

//	@Test
//	@Transactional
//	@Rollback(false)
//	public void testInsertNotice() {
//		noticeDto.setNoticeTitle("test5");
//		noticeDto.setNoticeContent("test5");
//		assertEquals(noticeService.noticeInsert(noticeDto, request), 1);
//	}
//	
	@Test
	@Transactional
	@Rollback(false)
	public void testInsertNotice() {
		// 자료를 저장한다.
		NoticeDto noticeDto = new NoticeDto();
		noticeDto.setNoticeNo(10);
		noticeDto.setNoticeAuthor("test5");
		noticeDto.setNoticeTitle("test5");
		noticeDto.setNoticeContent("test5");
		noticeDto.setNoticeRegdate("2021-05-23 22:13:49");
		noticeDto.setNoticeReadCnt(0);
		
//		assertEquals(noticeService.noticeInsert(noticeDto, request), 1);
	}
	
//	@Test
//	@Transactional
//	@Rollback(false)
//	public void testDetailNotice() {
//		// 자료를 저장한다.
//		NoticeParamDto noticeParamDto = new NoticeParamDto();
//		
//		noticeParamDto.setNoticeNo(6);
//		noticeParamDto.setNoticeAuthor("test1");
//		
//		assertEquals(noticeService.noticeDetail(noticeParamDto), 1);
//	}
}


// 자료를 저장한다.
//StudentDto dto = new StudentDto();
//dto.setStudentNm("홍길동");
//dto.setMajorCd("m0001");
//dto.setEmail("hong@hong.com");
//dto.setPhone("010-1111-2222");
//dto.setEnterDt("2020-10-01");
//assertEquals(service.studentInsert(dto), 1);
