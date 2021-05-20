package com.ssafy.homez.dto;

public class NoticeParamDto {
	private int noticeLimit;
	private int noticeOffset;
	private String noticeSearchWord;
	private int noticeNo;
	private String noticeAuthor;

	public int getNoticeLimit() {
		return noticeLimit;
	}

	public void setNoticeLimit(int noticeLimit) {
		this.noticeLimit = noticeLimit;
	}

	public int getNoticeOffset() {
		return noticeOffset;
	}

	public void setNoticeOffset(int noticeOffset) {
		this.noticeOffset = noticeOffset;
	}

	public String getNoticeSearchWord() {
		return noticeSearchWord;
	}

	public void setNoticeSearchWord(String noticeSearchWord) {
		this.noticeSearchWord = noticeSearchWord;
	}

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

	@Override
	public String toString() {
		return "NoticeParamDto [noticeLimit=" + noticeLimit + ", noticeOffset=" + noticeOffset + ", noticeSearchWord="
				+ noticeSearchWord + ", noticeNo=" + noticeNo + ", noticeAuthor=" + noticeAuthor + "]";
	}

}
