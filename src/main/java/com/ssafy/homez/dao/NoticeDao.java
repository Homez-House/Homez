package com.ssafy.homez.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeFileDto;
import com.ssafy.homez.dto.NoticeParamDto;

@Mapper
public interface NoticeDao {
	
	public NoticeDto noticeDetail(NoticeParamDto noticeParamDto);
	public List<NoticeFileDto> noticeDetailFileList(int noticeNo);
	
	// map - Dto
	public int noticeMemberReadCount(NoticeParamDto noticeParamDto); 
	
	// map - @param
	public int noticeMemberReadInsert(
			@Param("noticeNo") int noticeNo, 
			@Param("noticeAuthor") String noticeAuthor ); 
	
	public int noticeReadCountUpdate(int noticeNo);
	
	
	public int noticeDelete(int noticeNo);	
	public int noticeFileDelete(int noticeNo);
	public List<String> noticeFileUrlDeleteList(int noticeNo);
	public int noticeReadCountDelete(int noticeNo);
	
	public int noticeInsert(NoticeDto noticeDto);
	public int noticeFileInsert(NoticeFileDto noticeFileDto);
	
	public List<NoticeDto> noticeList(NoticeParamDto noticeParamDto);
	public int noticeListTotalCount();
	
	public List<NoticeDto> noticeListSearchWord(NoticeParamDto noticeParamDto);
	public int noticeListSearchWordTotalCount(NoticeParamDto noticeParamDto);
	

	public int noticeUpdate(NoticeDto noticeDto);
	
}
