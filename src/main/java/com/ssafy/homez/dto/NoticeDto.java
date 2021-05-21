package com.ssafy.homez.dto;

import java.util.List;

public class NoticeDto {
	private int noticeNo;
	private String noticeAuthor;
	private String noticeTitle;
	private String noticeContent;
	private String noticeRegdate;
	private int noticeReadCnt;
	
	private List<NoticeFileDto> fileList;
	
	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeAuthor() {
		return noticeAuthor;
	}

	public void setNoticeAuthor(String noticeAuthor) {
		this.noticeAuthor = noticeAuthor;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeRegdate() {
		return noticeRegdate;
	}

	public void setNoticeRegdate(String noticeRegdate) {
		this.noticeRegdate = noticeRegdate;
	}

	public int getNoticeReadCnt() {
		return noticeReadCnt;
	}

	public void setNoticeReadCnt(int noticeReadCnt) {
		this.noticeReadCnt = noticeReadCnt;
	}
	
	public List<NoticeFileDto> getFileList() {
		return fileList;
	}
	
	public void setFileList(List<NoticeFileDto> fileList) {
		this.fileList = fileList;
	}
	
	@Override
	public String toString() {
		return "NoticeDto [noticeNo=" + noticeNo + ", noticeAuthor=" + noticeAuthor + ", noticeTitle=" + noticeTitle
				+ ", noticeContent=" + noticeContent + ", noticeRegdate=" + noticeRegdate + ", noticeReadCnt="
				+ noticeReadCnt + "]";
	}

}
