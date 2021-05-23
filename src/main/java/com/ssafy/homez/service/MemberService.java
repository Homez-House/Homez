package com.ssafy.homez.service;

import java.util.List;

import com.ssafy.homez.dto.MemberDto;

public interface MemberService {

	
	public MemberDto login(String memberId);
	
	public List<MemberDto> list();
	public int insert(MemberDto dto);
	public int update(MemberDto dto);
	public int delete(String memberId);
	public MemberDto detail(String memberId);
}
