package com.ssafy.homez.dto;

import java.util.List;

public class NoticeResultDto {
	private int noticeResult;
	private NoticeDto noticeDto;
	private List<NoticeDto> noticelist;
	private int noticeCount;

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

	public List<NoticeDto> getNoticelist() {
		return noticelist;
	}

	public void setNoticelist(List<NoticeDto> noticelist) {
		this.noticelist = noticelist;
	}

	public int getNoticeCount() {
		return noticeCount;
	}

	public void setNoticeCount(int noticeCount) {
		this.noticeCount = noticeCount;
	}

	@Override
	public String toString() {
		return "NoticeResultDto [noticeResult=" + noticeResult + ", noticeDto=" + noticeDto + ", noticelist="
				+ noticelist + ", noticeCount=" + noticeCount + "]";
	}

}
