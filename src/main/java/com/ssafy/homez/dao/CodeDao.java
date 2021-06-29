package com.ssafy.homez.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.homez.dto.CodeDto;

@Mapper
public interface CodeDao {
	public List<CodeDto> codeList(String groupCode);
}
