package com.ssafy.homez.dto;

public class MemberDto {
	private String memberId;
	private String memberName;
	private String memberPwd;
	private String memberEmail;
	private String memberInterestArea;
	private String memberJoindate;
	private String memberProfile;
	private String memberGender; // 성별 구분
	private String memberAge; // 연령대 구분

	// 회원 구분
	private String memberType;
	private String memberTypeName;

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
		if (memberProfile == null || "null".equals(memberProfile) || "".equals(memberProfile)) 
			this.memberProfile = "/img/noProfile.png";
		return this.memberProfile;
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

	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", memberName=" + memberName + ", memberPwd=" + memberPwd
				+ ", memberEmail=" + memberEmail + ", memberInterestArea=" + memberInterestArea + ", memberJoindate="
				+ memberJoindate + ", memberProfile=" + memberProfile + ", memberGender=" + memberGender
				+ ", memberAge=" + memberAge + ", memberType=" + memberType + ", memberTypeName=" + memberTypeName
				+ "]";
	}

}
