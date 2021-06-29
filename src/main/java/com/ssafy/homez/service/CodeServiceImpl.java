package com.ssafy.homez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homez.dao.CodeDao;
import com.ssafy.homez.dto.CodeDto;


@Service
public class CodeServiceImpl implements CodeService{
	
	@Autowired
	CodeDao codeDao;
	
	@Override
	public List<CodeDto> codeList(String groupCode) {
		
		return codeDao.codeList(groupCode);
	}
}