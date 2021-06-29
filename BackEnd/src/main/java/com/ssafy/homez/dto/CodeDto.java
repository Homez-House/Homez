package com.ssafy.homez.dto;

public class CodeDto {
	private String code;
	private String codeName;
	
	public CodeDto(String code, String codeName) {
		super();
		this.code = code;
		this.codeName = codeName;
	}
	public CodeDto() {}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	@Override
	public String toString() {
		return "CodeDto [code=" + code + ", codeName=" + codeName + "]";
	}
	
	
	
}
