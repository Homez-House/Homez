package com.ssafy.homez.dto;

public class MemberDto {
	private String memberId;
	private String memberName;
	private String memberPwd;
	private String memberEmail;
	private String memberInterestArea;
	private String memberJoindate;
	private String memberProfile;
	private String memberGender;
	private String memberAge;
	private String memberType;

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

	public String getMemberGender() {
		return memberGender;
	}

	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	public String getMemberAge() {
		return memberAge;
	}

	public void setMemberAge(String memberAge) {
		this.memberAge = memberAge;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd
				+ ", memberEmail=" + memberEmail + ", memberInterestArea=" + memberInterestArea + ", memberJoindate="
				+ memberJoindate + ", memberProfile=" + memberProfile + ", memberGender=" + memberGender
				+ ", memberAge=" + memberAge + ", memberType=" + memberType + "]";
	}

}
