<template>
  <!-- Start Content -->
  <div class="container">
    <h2 class="text-center my-5">마이페이지</h2>
    <div class="table-div pb-3" style="min-height: 600px">
      <div class="text-center">
        <img
          style="border-radius: 20px; width: 300px"
          :src="'http://localhost:8080/' + $store.state.login.memberProfile"
          alt="프로필 사진"
        />
      </div>
      <div class="row pt-4">
        <div class="col"></div>
        <div class="col">
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3">아이디 </label>
            <label class="col">{{ $store.state.login.memberId }}</label>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3">이름 </label>
            <label class="col">{{ $store.state.login.memberName }}</label>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3">성별 </label>
            <label class="col">{{ memberGenderName }}</label>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3">연령대 </label>
            <label class="col">{{ memberAgeName }}</label>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3">이메일 </label>
            <label class="col">{{ $store.state.login.memberEmail }}</label>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3">관심지역 </label>
            <label class="col"
              >{{ memberInterestAreaGugunName }}
              {{ memberInterestAreaDongName }}</label
            >
          </div>
          <div class="row mb-3 pagination justify-content-center">
            <div class="col text-end">
              <button type="button" class="btn btn-success">
                <router-link
                  to="/modify"
                  style="text-decoration: none; color: white"
                  >수정</router-link
                ></button
              >&nbsp;
            </div>
            <div class="col">
              <button
                type="button"
                class="btn btn-secondary"
                @click="DeleteUser"
              >
                탈퇴
              </button>
            </div>
          </div>
        </div>
        <div class="col"></div>
      </div>
    </div>
  </div>
  <!-- End Content -->
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: "Mypage",
  data() {
    return {
      memberGenderName: "",
      memberAgeName: "",
      memberInterestAreaGugunName: "",
      memberInterestAreaDongName: "",
      memberId: "",
    };
  },
  methods: {
    DeleteUser() {
      let $this = this;
      this.$alertify.confirm("정말 탈퇴하시겠습니까?", function () {
        http
          .delete("/member/" + $this.$store.state.login.memberId)
          .then(({ data }) => {
            console.log(data);
            alert("성공적으로 탈퇴되었습니다!");
            $this.$router.push("/");
          });
      });
    },
  },
  created: function () {
    // 성별 리스트 중 회원의 정보와 동일한 값으로 설정
    http.get("/codes", { params: { groupCode: "002" } }).then(({ data }) => {
      data.forEach((element) => {
        if (this.$store.state.login.memberGender === element.code)
          this.memberGenderName = element.codeName;
      });
    });

    // 연령대 리스트 중 회원의 정보와 동일한 값으로 설정
    http.get("/codes", { params: { groupCode: "003" } }).then(({ data }) => {
      data.forEach((element) => {
        if (this.$store.state.login.memberAge === element.code)
          this.memberAgeName = element.codeName;
      });
    });

    // 현재 유저가 관심있는 지역의 앞 4글자가 구/군 코드임을 활용
    let str = this.$store.state.login.memberInterestArea;
    let gugunCode = str.substring(0, 5);

    // 구한 구/군 코드를 기준으로 구/군 이름 업데이트
    http.get("/gugun").then(({ data }) => {
      data.forEach((element) => {
        if (gugunCode === element.GUGUN_CODE)
          this.memberInterestAreaGugunName = element.GUGUN_NAME;
      });
    });

    // 구해진 동 코드를 활용해 동 이름 업데이트
    http.get("/gugun/" + gugunCode).then(({ data }) => {
      data.forEach((element) => {
        if (this.$store.state.login.memberInterestArea === element.DONG_CODE)
          this.memberInterestAreaDongName = element.DONG_NAME;
      });
    });
  },
};
</script>

<style></style>
