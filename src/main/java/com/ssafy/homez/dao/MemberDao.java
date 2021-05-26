package com.ssafy.homez.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dto.MemberDto;

@Mapper
public interface MemberDao {
	
	public MemberDto login(String memberId);
	
	public List<MemberDto> list();
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(String memberId);
	public MemberDto detail(String memberId);
	
}
