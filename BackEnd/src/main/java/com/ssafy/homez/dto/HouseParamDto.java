package com.ssafy.homez.dto;

public class HouseParamDto {
	
	private int houseOffset;
	private int houseLimit;
	private String houseSearchWord;
	private String houseSearchType;
	
	public HouseParamDto() {};
	
	public HouseParamDto(int houseOffset, int houseLimit, String houseSearchWord, String houseSearchType) {
		super();
		this.houseOffset = houseOffset;
		this.houseLimit = houseLimit;
		this.houseSearchWord = houseSearchWord;
		this.houseSearchType = houseSearchType;
	}
	
	public int getHouseOffset() {
		return houseOffset;
	}
	public void setHouseOffset(int houseOffset) {
		this.houseOffset = houseOffset;
	}
	public int getHouseLimit() {
		return houseLimit;
	}
	public void setHouseLimit(int houseLimit) {
		this.houseLimit = houseLimit;
	}
	public String getHouseSearchWord() {
		return houseSearchWord;
	}
	public void setHouseSearchWord(String houseSearchWord) {
		this.houseSearchWord = houseSearchWord;
	}
	public String getHouseSearchType() {
		return houseSearchType;
	}
	public void setHouseSearchType(String houseSearchType) {
		this.houseSearchType = houseSearchType;
	}
	
	@Override
	public String toString() {
		return "HouseParamDto [houseOffset=" + houseOffset + ", houseLimit=" + houseLimit + ", houseSearchWord="
				+ houseSearchWord + ", houseSearchType=" + houseSearchType + "]";
	}
	
	
	
}
