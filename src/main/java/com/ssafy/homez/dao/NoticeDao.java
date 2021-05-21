package com.ssafy.homez.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeFileDto;
import com.ssafy.homez.dto.NoticeParamDto;

@Mapper
public interface NoticeDao {
	
	public NoticeDto NoticeDetail(NoticeParamDto NoticeParamDto);
	public List<NoticeFileDto> NoticeDetailFileList(int noticeNo);
	
	// map - Dto
	public int NoticeMemberReadCount(NoticeParamDto NoticeParamDto); 
	
	// map - @param
	public int NoticeMemberReadInsert(
			@Param("noticeNo") int noticeNo, 
			@Param("noticeAuthor") int noticeAuthor ); 
	
	public int NoticeReadCountUpdate(int noticeNo);
	
	
	public int NoticeDelete(int noticeNo);	
	public int NoticeFileDelete(int noticeNo);
	public List<String> NoticeFileUrlDeleteList(int noticeNo);
	public int NoticeReadCountDelete(int noticeNo);
	
	public int NoticeInsert(NoticeDto noticeDto);
	public int NoticeFileInsert(NoticeFileDto noticeFileDto);
	
	public List<NoticeDto> NoticeList(NoticeParamDto noticeParamDto);
	public int NoticeListTotalCount();
	
	public List<NoticeDto> NoticeListSearchWord(NoticeParamDto noticeParamDto);
	public int NoticeListSearchWordTotalCount(NoticeParamDto noticeParamDto);
	

	public int NoticeUpdate(NoticeDto noticeDto);
	
}
