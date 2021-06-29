package com.ssafy.homez.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeParamDto;
import com.ssafy.homez.dto.NoticeResultDto;

public interface NoticeService {
	
	public NoticeResultDto noticeDetail(NoticeParamDto noticeParamDto);
	
	public NoticeResultDto noticeDelete(int noticeNo);
	
	public NoticeResultDto noticeUpdate(NoticeDto noticeDto, MultipartHttpServletRequest request);
	
	public NoticeResultDto noticeInsert(NoticeDto noticeDto, MultipartHttpServletRequest request);

	public NoticeResultDto noticeList(NoticeParamDto noticeParamDto);
	
	public NoticeResultDto noticeListSearchWord(NoticeParamDto noticeParamDto);
	
}
