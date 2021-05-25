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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dto.MemberDto;
import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeParamDto;
import com.ssafy.homez.dto.NoticeResultDto;
import com.ssafy.homez.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

// VUE cli mode 개발 대응
@CrossOrigin(origins ="http://localhost:5500", allowCredentials="true", allowedHeaders="*",
		methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.HEAD, RequestMethod.OPTIONS}
)

//@RequestMapping("/notice")
@Api("공지사항 Controller API V1")
@RestController
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	private static final int SUCCESS = 1;
	
	// notice 리스트
	@ApiOperation(value = "공지사항 목록", notes = "공지사항의 <big>전체목록</big>을 반환해줍니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록OK"), @ApiResponse(code = 404, message = "페이지없음"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping(value="/notice")
	public ResponseEntity<NoticeResultDto> noticeList(NoticeParamDto noticeParamDto){
		NoticeResultDto noticeResultDto;
		
		if(noticeParamDto.getNoticeSearchWord() == null) {
			noticeResultDto = noticeService.noticeList(noticeParamDto);
		} else {
			noticeResultDto = noticeService.noticeListSearchWord(noticeParamDto);
		}
		
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// notice detail
	@ApiOperation(value = "공지사항 확인", notes = "해당 공지사항글을 확인합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록OK"), @ApiResponse(code = 404, message = "페이지없음"),
			@ApiResponse(code = 500, message = "서버에러!!") })
	@GetMapping(value="/notice/{noticeNo}")
	public ResponseEntity<NoticeResultDto> noticeDetail(@PathVariable(value="noticeNo") int noticeNo, 
			@RequestParam(value="noticeAuthor") String noticeAuthor,HttpSession session){
		
		NoticeParamDto noticeParamDto = new NoticeParamDto();
		noticeParamDto.setNoticeNo(noticeNo);
		noticeParamDto.setNoticeAuthor(noticeAuthor);
		System.out.println(noticeParamDto);
		
		NoticeResultDto noticeResultDto = noticeService.noticeDetail(noticeParamDto);
		
//		if( ((MemberDto) session.getAttribute("memberDto")).getMemberId() == noticeResultDto.getNoticeDto().getNoticeAuthor() ) {
//			noticeResultDto.setIsOwner(true);
//		}
				
		if(noticeResultDto.getNoticeResult() == SUCCESS) {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<NoticeResultDto>(noticeResultDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// notice insert
	@ApiOperation(value = "공지사항 등록", notes = "해당 공지사항글을 등록합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록OK"), @ApiResponse(code = 404, message = "페이지없음"),
			@ApiResponse(code = 500, message = "서버에러!!") })
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
	@ApiOperation(value = "공지사항 수정", notes = "해당 공지사항글을 삭제합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록OK"), @ApiResponse(code = 404, message = "페이지없음"),
			@ApiResponse(code = 500, message = "서버에러!!") })
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
	
	// 회원삭제
	@DeleteMapping(value="/notice/{noticeNo}")
	@ApiOperation(value = "공지사항 삭제", notes = "해당 공지사항글을 삭제합니다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "회원목록OK"), @ApiResponse(code = 404, message = "페이지없음"),
			@ApiResponse(code = 500, message = "서버에러!!") })
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
