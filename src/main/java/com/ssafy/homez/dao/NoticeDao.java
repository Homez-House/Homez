package com.ssafy.homez.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeFileDto;
import com.ssafy.homez.dto.NoticeParamDto;


public interface NoticeDao {
	
	public NoticeDto NoticeDetail(NoticeParamDto NoticeParamDto);
	public List<NoticeFileDto> NoticeDetailFileList(int NoticeId);
	
	// map - Dto
	public int NoticeUserReadCount(NoticeParamDto NoticeParamDto); 
	
	// map - @param
	public int NoticeUserReadInsert(
			@Param("NoticeId") int NoticeId, 
			@Param("userSeq") int userSeq ); 
	
	public int NoticeReadCountUpdate(int NoticeId);
	
	
	public int NoticeDelete(int NoticeId);	
	public int NoticeFileDelete(int NoticeId);
	public List<String> NoticeFileUrlDeleteList(int NoticeId);
	public int NoticeReadCountDelete(int NoticeId);
	
	public int NoticeInsert(NoticeDto dto);
	public int NoticeFileInsert(NoticeFileDto dto);
	
	public List<NoticeDto> NoticeList(NoticeParamDto NoticeParamDto);
	public int NoticeListTotalCount();
	
	public List<NoticeDto> NoticeListSearchWord(NoticeParamDto NoticeParamDto);
	public int NoticeListSearchWordTotalCount(NoticeParamDto NoticeParamDto);
	

	public int NoticeUpdate(NoticeDto dto);
	
}
