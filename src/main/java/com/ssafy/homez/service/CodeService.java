package com.ssafy.homez.service;

import java.util.List;

import com.ssafy.homez.dto.CodeDto;


public interface CodeService {
	public List<CodeDto> codeList(String groupCode);
}
