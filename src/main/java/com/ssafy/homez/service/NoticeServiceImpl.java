package com.ssafy.homez.service;

import java.util.List;

import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeFileDto;
import com.ssafy.homez.dto.NoticeParamDto;

public class NoticeServiceImpl implements NoticeService {

	@Override
	public NoticeDto NoticeDetail(NoticeParamDto NoticeParamDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NoticeFileDto> NoticeDetailFileList(int NoticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int NoticeUserReadCount(NoticeParamDto NoticeParamDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeUserReadInsert(int NoticeId, int userSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeReadCountUpdate(int NoticeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeDelete(int NoticeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeFileDelete(int NoticeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> NoticeFileUrlDeleteList(int NoticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int NoticeReadCountDelete(int NoticeId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeInsert(NoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeFileInsert(NoticeFileDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoticeDto> NoticeList(NoticeParamDto NoticeParamDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int NoticeListTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoticeDto> NoticeListSearchWord(NoticeParamDto NoticeParamDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int NoticeListSearchWordTotalCount(NoticeParamDto NoticeParamDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int NoticeUpdate(NoticeDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
