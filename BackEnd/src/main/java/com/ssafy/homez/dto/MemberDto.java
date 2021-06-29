package com.ssafy.homez.dto;

public class MemberDto {
	private String memberId;
	private String memberName;
	private String memberPwd;
	private String memberEmail;
	private String memberInterestArea;
	private String memberJoindate;
	private String memberProfile;

	// 회원 구분
	private String memberType;
	private String memberTypeName;

	// 성별 구분
	private String memberGender;
	private String memberGenderName;

	// 연령대 구분
	private String memberAge;
	private String memberAgeName;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberInterestArea() {
		return memberInterestArea;
	}

	public void setMemberInterestArea(String memberInterestArea) {
		this.memberInterestArea = memberInterestArea;
	}

	public String getMemberJoindate() {
		return memberJoindate;
	}

	public void setMemberJoindate(String memberJoindate) {
		this.memberJoindate = memberJoindate;
	}

	public String getMemberProfile() {
		return memberProfile;
	}

	public void setMemberProfile(String memberProfile) {
		this.memberProfile = memberProfile;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberTypeName() {
		return memberTypeName;
	}

	public void setMemberTypeName(String memberTypeName) {
		this.memberTypeName = memberTypeName;
	}

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberGenderName() {
		return memberGenderName;
	}

	public void setMemberGenderName(String memberGenderName) {
		this.memberGenderName = memberGenderName;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberAgeName() {
		return memberAgeName;
	}

	public void setMemberAgeName(String memberAgeName) {
		this.memberAgeName = memberAgeName;
	}

	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd
				+ ", memberEmail=" + memberEmail + ", memberInterestArea=" + memberInterestArea + ", memberJoindate="
				+ memberJoindate + ", memberProfile=" + memberProfile + ", memberType=" + memberType
				+ ", memberTypeName=" + memberTypeName + ", memberGender=" + memberGender + ", memberGenderName="
				+ memberGenderName + ", memberAge=" + memberAge + ", memberAgeName=" + memberAgeName + "]";
	}

}
