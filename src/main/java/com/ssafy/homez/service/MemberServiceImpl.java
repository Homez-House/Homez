package com.ssafy.homez.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dao.MemberDao;
import com.ssafy.homez.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	String uploadFolder = "upload";
	
	/* for eclipse development code */
	// 파일을 업로드할 경로 지정
//	C:\Users\ahnda\git\final-project\src\main\resources
	String uploadPath = "C:" + File.separator + "Users" + File.separator + "ahnda" + File.separator
			+ "git" + File.separator + "final-project" + File.separator + "src" + File.separator + "main" 
			+ File.separator + "resources" + File.separator + "static";
	
//	String uploadPath = "C:" + File.separator + "Users" + File.separator + "dang0" + File.separator
//			+ "git" + File.separator + "final-project" + File.separator + "src" + File.separator + "main" 
//			+ File.separator + "resources" + File.separator + "static";
	
	@Override
	public MemberDto login(String userId) {
		return memberDao.login(userId);
	}

	@Override
	public List<MemberDto> list() {
		return memberDao.list();
	}

	@Override
	public int insert(MemberDto dto, MultipartHttpServletRequest request) {
		try {
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			if(!uploadDir.exists()) uploadDir.mkdir();
			
			
			MultipartFile part = request.getFiles("file").get(0);
			String fileName = part.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String extension = FilenameUtils.getExtension(fileName);
			String savingFileName = uuid + "." + extension;
			File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
			System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
			part.transferTo(destFile);
			String fileUrl = uploadFolder + "/" + savingFileName;
			dto.setMemberProfile(fileUrl);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return memberDao.insert(dto);
	}

	@Override
	public int update(MemberDto dto, MultipartHttpServletRequest request) {
		try {
			String deleteFileUrl = memberDao.detail(dto.getMemberId()).getMemberProfile();
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			if(!uploadDir.exists()) uploadDir.mkdir();
			
			
			File file = null;
	        if(deleteFileUrl != null) {
	           file = new File(uploadPath + File.separator, deleteFileUrl);
	        
	           System.out.println("2-2. update!!!!! ----------------- "+dto);
	           if(file.exists()) {
	              file.delete();
	           }
	        }
			
			// 수정
			MultipartFile part = request.getFiles("file").get(0);
			String fileName = part.getOriginalFilename();
			UUID uuid = UUID.randomUUID();
			String extension = FilenameUtils.getExtension(fileName);
			String savingFileName = uuid + "." + extension;
			File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
			System.out.println(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
			part.transferTo(destFile);
			String fileUrl = uploadFolder + "/" + savingFileName;
			dto.setMemberProfile(fileUrl);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
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
