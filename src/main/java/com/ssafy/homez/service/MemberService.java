package com.ssafy.homez.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dto.MemberDto;

public interface MemberService {

	
	public MemberDto login(String memberId);
	
	public List<MemberDto> list();
	public int insert(MemberDto dto, MultipartHttpServletRequest request);
	public int update(MemberDto dto, MultipartHttpServletRequest request);
	public int delete(String memberId);
	public MemberDto detail(String memberId);
}
