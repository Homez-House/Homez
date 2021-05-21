package com.ssafy.homez.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dto.MemberDto;
import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeParamDto;
import com.ssafy.homez.dto.NoticeResultDto;
import com.ssafy.homez.service.NoticeService;

// VUE cli mode 개발 대응
@CrossOrigin(origins ="http://localhost:5500", allowCredentials="true", allowedHeaders="*",
		methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS}
)

@RestController
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	private static final int SUCCESS = 1;
	
	// notice 리스트
	@GetMapping(value="/notice")
	public ResponseEntity<NoticeResultDto> noticeList(NoticeParamDto noticeParamDto){
		
		NoticeResultDto noticeResultDto;
		
		if(noticeParamDto.getNoticeSearchWord().isEmpty()) {
			noticeResultDto = noticeService.noticeList(noticeParamDto);
		} else {
			noticeResultDto = noticeService.noticeListSearchWord(noticeParamDto);
		}
		
		System.out.println("----------------List :" + " " + noticeResultDto);
		
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// notice detail
	@GetMapping(value="/notice/{noticeNo}")
	public ResponseEntity<NoticeResultDto> noticeDetail(@PathVariable(value="noticeNo") int noticeNo, HttpSession session){
		
		NoticeParamDto noticeParamDto = new NoticeParamDto();
		noticeParamDto.setNoticeNo(noticeNo);
		
		NoticeResultDto noticeResultDto = noticeService.noticeDetail(noticeParamDto);
		
		if( ((MemberDto) session.getAttribute("memberDto")).getMemberId() == noticeResultDto.getNoticeDto().getNoticeAuthor() ) {
			noticeResultDto.setIsOwner(true);
		}
		
		System.out.println("----------------Detail :" + " " + noticeResultDto);
		
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// notice insert
	@PostMapping(value="/notice")
	public ResponseEntity<NoticeResultDto> noticeInsert(NoticeDto noticeDto, MultipartHttpServletRequest request){
		
		noticeDto.setNoticeAuthor( ((MemberDto) request.getSession().getAttribute("memberDto")).getMemberId() );
		NoticeResultDto noticeResultDto = noticeService.noticeInsert(noticeDto, request);
		
		System.out.println("----------------Insert :" + " " + noticeResultDto);
		
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// notice update
	@PostMapping(value="/notice/{noticeNo}")
	public ResponseEntity<NoticeResultDto> noticeUpdate(NoticeDto noticeDto, MultipartHttpServletRequest request){
		NoticeResultDto noticeResultDto = noticeService.noticeUpdate(noticeDto, request);
		noticeDto.setNoticeAuthor( ((MemberDto) request.getSession().getAttribute("memberDto")).getMemberId() );
		
		System.out.println("----------------Update :" + " " + noticeResultDto);
		
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(value="/notice/{noticeNo}")
	public ResponseEntity<NoticeResultDto> noticeDelete(@PathVariable(value="noticeNo") int noticeNo){
		NoticeResultDto noticeResultDto = noticeService.noticeDelete(noticeNo);
		
		System.out.println("----------------Delete :" + " " + noticeResultDto);
		
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
