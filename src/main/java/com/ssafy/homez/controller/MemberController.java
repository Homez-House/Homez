package com.ssafy.homez.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homez.dto.MemberDto;
import com.ssafy.homez.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService memberService;

	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	@PostMapping(value = "/login")
	public ResponseEntity<Integer> login(@RequestBody Map<String, String> map) {
		String memberId = map.get("id");
		String memberPwd = map.get("pwd");
		System.out.println("id : " + memberId + " pwd : " + memberPwd);

		MemberDto dto = memberService.detail(memberId);
		System.out.println(dto);

		if (dto != null && dto.getMemberPwd().equals(memberPwd))
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/member")
	public ResponseEntity<List<MemberDto>> list() {
		return new ResponseEntity<List<MemberDto>>(memberService.list(), HttpStatus.OK);
	}

	@PostMapping(value = "/member/{memberId}")
	public ResponseEntity<Integer> insert(MemberDto memberDto) {
		MemberDto dto = memberService.detail(memberDto.getMemberId());

		if (dto == null) {
			memberService.insert(memberDto);
			System.out.println(memberDto);
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		}else
			return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
