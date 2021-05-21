package com.ssafy.homez.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.homez.dao.NoticeDao;
import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeFileDto;
import com.ssafy.homez.dto.NoticeParamDto;

@Service
public class NoticeServiceImpl implements NoticeService {

	NoticeDao noticeDao;
	String uploadFolder = "upload";
	
	/* for eclipse development code */
	// 파일을 업로드할 경로 지정
	String uploadPath = "C:" + File.separator + "SSAFY" + File.separator + "SpringBoot" + File.separator
			+ "BoardFileUploadSpringMVCMyBatis" + File.separator + "src" + File.separator + "main" + File.separator
			+ "webapp" + File.separator + "resources" + File.separator + "static";
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
