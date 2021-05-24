package com.ssafy.homez.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.homez.dto.MemberDto;
import com.ssafy.homez.service.MemberService;

//@CrossOrign 추가 <-- vue cli mode 개발 대응
@CrossOrigin(
		origins = "http://localhost:5500", 
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.OPTIONS}
)
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
			System.out.println("|| insert : " + memberDto);
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		} else
			return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping(value = "/member/{memberId}")
	public ResponseEntity<Integer> update(@PathVariable String memberId, @RequestBody MemberDto memberDto) {
		MemberDto dto = memberService.detail(memberId);

		if (dto != null) {
			memberService.update(memberDto);
			System.out.println("|| update : " + memberDto);
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		} else
			return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value="/member/{memberId}")
	public ResponseEntity<Integer> delete(@PathVariable String memberId) {
		MemberDto dto = memberService.detail(memberId);
		if(dto != null) {
			memberService.delete(memberId);
			System.out.println("|| delete : " + memberId);
			return new ResponseEntity<Integer>(SUCCESS, HttpStatus.OK);
		}else
			return new ResponseEntity<Integer>(FAIL, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
