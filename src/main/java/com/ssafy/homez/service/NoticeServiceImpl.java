package com.ssafy.homez.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ssafy.homez.dao.NoticeDao;
import com.ssafy.homez.dto.NoticeDto;
import com.ssafy.homez.dto.NoticeFileDto;
import com.ssafy.homez.dto.NoticeParamDto;
import com.ssafy.homez.dto.NoticeResultDto;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDao noticeDao;
	String uploadFolder = "upload";
	
	/* for eclipse development code */
	// 파일을 업로드할 경로 지정
//	C:/Users/ahnda/git/final-project/src/main
	
	
//	String uploadPath = "C:" + File.separator + "Users" + File.separator + "ahnda" + File.separator
//			+ "git" + File.separator + "final-project" + File.separator + "src" + File.separator + "main" 
//			+ File.separator + "resources" + File.separator + "static";
	
	String uploadPath = "C:" + File.separator + "Users" + File.separator + "dang0" + File.separator
			+ "git" + File.separator + "final-project" + File.separator + "src" + File.separator + "main" 
			+ File.separator + "resources" + File.separator + "static";
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	@Override
	@Transactional
	public NoticeResultDto noticeDetail(NoticeParamDto noticeParamDto) {
		
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			int memberReadCnt = noticeDao.noticeMemberReadCount(noticeParamDto);
			
			if(memberReadCnt == 0) {
				noticeDao.noticeMemberReadInsert(noticeParamDto.getNoticeNo(), noticeParamDto.getNoticeAuthor());
				noticeDao.noticeReadCountUpdate(noticeParamDto.getNoticeNo());
			}
			
			NoticeDto dto = noticeDao.noticeDetail(noticeParamDto);
			List<NoticeFileDto> fileList = noticeDao.noticeDetailFileList(dto.getNoticeNo());
			
			dto.setFileList(fileList);
			noticeResultDto.setNoticeDto(dto);
			
			noticeResultDto.setNoticeResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setNoticeResult(FAIL);
		}
		
		return noticeResultDto;
	}
	
	@Override
	@Transactional
	public NoticeResultDto noticeDelete(int noticeNo) {
		
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			// 물리적 파일 삭제
			List<String> fileUrlList = noticeDao.noticeFileUrlDeleteList(noticeNo);
			for(String fileUrl: fileUrlList) {
				File file = new File(uploadPath + File.pathSeparator, fileUrl);
				if(file.exists()) {
					file.delete();
				}
			}
			
			noticeDao.noticeFileDelete(noticeNo);
			noticeDao.noticeReadCountDelete(noticeNo);
			noticeDao.noticeDelete(noticeNo);
			noticeResultDto.setNoticeResult(SUCCESS);
			
		} catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setNoticeResult(FAIL);
		}
		
		return noticeResultDto;
	}
	
	@Override
	@Transactional
	public NoticeResultDto noticeUpdate(NoticeDto noticeDto, MultipartHttpServletRequest request) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			noticeDao.noticeUpdate(noticeDto);
			
			List<MultipartFile> fileList = request.getFiles("file");
			
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			if(!uploadDir.exists()) uploadDir.mkdir();
			
			// 물리파일 삭제, 첨부파일 여러개 고려
			List<String> fileUrlList = noticeDao.noticeFileUrlDeleteList(noticeDto.getNoticeNo());
			for(String fileUrl: fileUrlList) {
				File file = new File(uploadPath + File.separator, fileUrl);
				if(file.exists()) {
					file.delete();
				}
			}
			
			// 모든파일삭제
			noticeDao.noticeFileDelete(noticeDto.getNoticeNo());
			
			// 파일 삭제후 다시 insert 
			for(MultipartFile part: fileList) {
				int noticeNo = noticeDto.getNoticeNo();
				
				String fileName = part.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				
				String extension = FilenameUtils.getExtension(fileName);
				String savingFileName = uuid + "." + extension;
				
				File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				part.transferTo(destFile);
				
				NoticeFileDto noticeFileDto = new NoticeFileDto();
				noticeFileDto.setNoticeNo(noticeNo);
				noticeFileDto.setFileName(fileName);
				noticeFileDto.setFileSize(part.getSize());
				noticeFileDto.setFileContentType(part.getContentType());
				String noticeFileUrl = uploadFolder + "/" + savingFileName;
				noticeFileDto.setFileUrl(noticeFileUrl);
				
				noticeDao.noticeFileInsert(noticeFileDto);
			}

			noticeResultDto.setNoticeResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setNoticeResult(FAIL);
		}
		
		return noticeResultDto;
	}
	
	@Override
	@Transactional
	public NoticeResultDto noticeInsert(NoticeDto noticeDto, MultipartHttpServletRequest request) {
		
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			noticeDao.noticeInsert(noticeDto);
			
			List<MultipartFile> fileList = request.getFiles("file");
			
			File uploadDir = new File(uploadPath + File.pathSeparator + uploadFolder);
			if(!uploadDir.exists()) uploadDir.mkdir();
			
			for(MultipartFile part: fileList) {
				
				int noticeNo = noticeDto.getNoticeNo();
				String fileName = part.getOriginalFilename();
				
				// Random File Id
				UUID uuid = UUID.randomUUID();
				
				// file extension
				String extension = FilenameUtils.getExtension(fileName);
				String savingFileName = uuid + "." + extension;
				
				File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				
				part.transferTo(destFile);
				
				// table insert
				
				NoticeFileDto noticeFileDto = new NoticeFileDto();
				noticeFileDto.setNoticeNo(noticeNo);
				noticeFileDto.setFileName(fileName);
				noticeFileDto.setFileSize(part.getSize());
				noticeFileDto.setFileContentType(part.getContentType());
				
				String noticeFileUrl = uploadFolder + "/" + savingFileName;
				noticeFileDto.setFileUrl(noticeFileUrl);
				
				noticeDao.noticeFileInsert(noticeFileDto);
			}
			noticeResultDto.setNoticeResult(SUCCESS);
			
		} catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setNoticeResult(FAIL);
		}
		
		
		return noticeResultDto;
	}
	
	@Override
	@Transactional
	public NoticeResultDto noticeList(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			List<NoticeDto> noticeList = noticeDao.noticeList(noticeParamDto);
			int noticeCount = noticeDao.noticeListTotalCount();
			noticeResultDto.setNoticeList(noticeList);
			noticeResultDto.setNoticeCount(noticeCount);
			noticeResultDto.setNoticeResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setNoticeResult(FAIL);
		}
		
		return noticeResultDto;
	}
	
	@Override
	@Transactional
	public NoticeResultDto noticeListSearchWord(NoticeParamDto noticeParamDto) {
		NoticeResultDto noticeResultDto = new NoticeResultDto();
		
		try {
			List<NoticeDto> noticeList = noticeDao.noticeListSearchWord(noticeParamDto);
			int noticeCount = noticeDao.noticeListSearchWordTotalCount(noticeParamDto);
			noticeResultDto.setNoticeList(noticeList);
			noticeResultDto.setNoticeCount(noticeCount);
			noticeResultDto.setNoticeResult(SUCCESS);
		}
		catch(Exception e) {
			e.printStackTrace();
			noticeResultDto.setNoticeResult(FAIL);
		}
		
		return noticeResultDto;
	}


}
