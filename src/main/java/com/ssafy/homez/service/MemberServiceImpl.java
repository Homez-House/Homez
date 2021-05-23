package com.ssafy.homez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.homez.dao.MemberDao;
import com.ssafy.homez.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;

	@Override
	public MemberDto login(String userId) {
		return memberDao.login(userId);
	}

	@Override
	public List<MemberDto> list() {
		return memberDao.list();
	}

	@Override
	public int insert(MemberDto dto) {
		return memberDao.insert(dto);
	}

	@Override
	public int update(MemberDto dto) {
		return memberDao.update(dto);
	}

	@Override
	public int delete(String memberId) {
		return memberDao.delete(memberId);
	}

	@Override
	public MemberDto detail(String memberId) {
		return memberDao.detail(memberId);
	}

}
