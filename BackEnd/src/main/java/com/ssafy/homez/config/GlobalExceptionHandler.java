package com.ssafy.homez.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


//개별 Controller Exception 이 처리하지 않는 Exception 일괄 처리
//일반 요청 및 ajax 요청 모두를 처리하려면 ajax 요청을 구분할 수 있는 reqeuest header 등을 활용해서 처리를 구분해야 함.
@ControllerAdvice
public class GlobalExceptionHandler {
	
	// 브라우저 요청
//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", req.getRequestURL());
//		mav.setViewName("globalError");
//		return mav;
//	}
	
	// ajax 요청에 대한 exception 처리
	// Transaction 테스트 경우 ajax 요청 -> NullPointer 오류가 위 method 가 실행되면 error page html 이 넘어옴. 아래의 것으로 변경
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleErrorResponseEntity(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("ajax_global_exception", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
