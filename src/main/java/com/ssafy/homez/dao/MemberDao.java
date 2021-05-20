package com.ssafy.homez.dao;

import java.util.List;

import com.ssafy.homez.dto.MemberDto;


public interface MemberDao {
	
	public MemberDto login(String userEmail);
	
	public List<MemberDto> list();
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(int id);
	public MemberDto detail(int id);
	
}
