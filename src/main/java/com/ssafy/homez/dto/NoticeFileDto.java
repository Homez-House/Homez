package com.ssafy.homez.dto;

public class NoticeFileDto {
	private int fileId;
	private int noticeNo;
	private String fileName;
	private int fileSize;
	private String fileContentType;
	private String fileUrl;
	private String regDate;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "NoticeFileDto [fileId=" + fileId + ", noticeNo=" + noticeNo + ", fileName=" + fileName + ", fileSize="
				+ fileSize + ", fileContentType=" + fileContentType + ", fileUrl=" + fileUrl + ", regDate=" + regDate
				+ "]";
	}

}
