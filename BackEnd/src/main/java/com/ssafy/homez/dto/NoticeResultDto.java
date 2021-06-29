package com.ssafy.homez.dto;

import java.util.List;

public class NoticeResultDto {
	private int noticeResult;
	private NoticeDto noticeDto;
	private List<NoticeDto> noticeList;
	private int noticeCount;

	private boolean isOwner;
	
	public boolean getIsOwner() {
		return isOwner;
	}
	
	public void setIsOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}
	
	public int getNoticeResult() {
		return noticeResult;
	}

	public void setNoticeResult(int noticeResult) {
		this.noticeResult = noticeResult;
	}

	public NoticeDto getNoticeDto() {
		return noticeDto;
	}

	public void setNoticeDto(NoticeDto noticeDto) {
		this.noticeDto = noticeDto;
	}

	public List<NoticeDto> getNoticeList() {
		return noticeList;
	}

	public void setNoticeList(List<NoticeDto> noticeList) {
		this.noticeList = noticeList;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	@Override
	public String toString() {
		return "NoticeResultDto [noticeResult=" + noticeResult + ", noticeDto=" + noticeDto + ", noticeList="
				+ noticeList + ", noticeCount=" + noticeCount + "]";
	}

}
