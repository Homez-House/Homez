<template>
  <!-- Start Content -->
  <div class="container">
    <h2 class="text-center my-5">정보수정</h2>
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
            <div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper">
              <!-- vue way img 를 만들어서 append 하지 않고, v-for 로 처리 -->
              <img v-bind:src="fileUrl" />
            </div>
            <label class="mb-2 fw-bold">프로필 사진</label>
            <input
              type="file"
              class="form-control"
              aria-describedby="inputGroupFileAddon04"
              aria-label="Upload"
              id="inputFileUploadInsert"
              @change="insertFile"
            />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3 fw-bold">아이디 </label>
            <input
              type="text"
              class="form-control col"
              readonly
              v-model="memberId"
            />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold"
              >비밀번호 <span style="color: red">*</span></label
            >
            <input
              v-model="memberPwd"
              type="password"
              class="form-control"
              placeholder="비밀번호 : 최소 8자 이상"
            />
            <input
              v-model="memberPwdMore"
              type="password"
              class="form-control"
              placeholder="비밀번호 확인 : 위와 동일하게 입력"
            />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3 fw-bold">이름 </label>
            <input type="text" class="form-control col" v-model="memberName" />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">성별</label>
            <div
              class="col m-2 form-check form-check-inline"
              v-for="(code, index) in GenderList"
              :key="index"
            >
              <input
                class="form-check-input"
                type="radio"
                :value="code.code"
                v-model="memberGender"
              />
              <label class="form-check-label">{{ code.codeName }}</label>
            </div>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">연령대</label>
            <div
              class="col-4 form-check form-check-inline"
              v-for="(code, index) in Agelist"
              :key="index"
            >
              <input
                class="form-check-input"
                type="radio"
                :value="code.code"
                v-model="memberAge"
              />
              <label class="form-check-label">{{ code.codeName }}</label>
            </div>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3 fw-bold">이메일 </label>
            <input type="text" class="form-control col" v-model="memberEmail" />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold"
              >관심지역 <span style="color: red">*</span></label
            >
            <div class="col">
              <select
                class="form-select"
                v-model="selectGugun"
                @change="selectGugunData($event)"
              >
                <option selected :value="0" hidden>구</option>
                <option
                  v-for="(Gugun, index) in GugunList"
                  :key="index"
                  :value="Gugun.GUGUN_CODE"
                >
                  {{ Gugun.GUGUN_NAME }}
                </option>
              </select>
            </div>
            <div class="col">
              <select class="form-select" v-model="memberInterestArea">
                <option selected :value="0" hidden>동</option>
                <option
                  v-for="(Dong, index) in DongList"
                  :key="index"
                  :value="Dong.DONG_CODE"
                >
                  {{ Dong.DONG_NAME }}
                </option>
              </select>
            </div>
          </div>
          <div class="mb-3 pagination justify-content-center">
            <button type="button" class="btn btn-success">
              <a
                href="#"
                style="text-decoration: none; color: white"
                @click="updateMember"
                >업데이트</a
              >
            </button>
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
  name: "MypageModify",
  data: function () {
    return {
      // store 값으로 세팅
      memberId: this.$store.state.login.memberId,
      memberPwd: "",
      memberPwdMore: "",
      memberProfile: this.$store.state.login.memberProfile,
      memberName: this.$store.state.login.memberName,
      memberGender: this.$store.state.login.memberGender,
      memberAge: this.$store.state.login.memberAge,
      memberEmail: this.$store.state.login.memberEmail,
      memberInterestArea: this.$store.state.login.memberInterestArea,

      // file url
      fileUrl: "",
      // 공통 코드 리스트
      GenderList: [],
      Agelist: [],

      // 구군 리스트
      GugunList: [],
      DongList: [],
      selectGugun: "",
    };
  },
  methods: {
    insertFile(fileEvent) {
      // 프로필 이미지 파일을 URL Object로 만들어준다.
      if (fileEvent.target.files && fileEvent.target.files.length > 0) {
        for (var i = 0; i < fileEvent.target.files.length; i++) {
          const file = fileEvent.target.files[i];
          this.fileUrl = URL.createObjectURL(file);
        }
      }
    },
    selectGugunData(event) {
      // 구/군 리스트를 가져온다.
      this.memberInterestArea = 0;
      console.log(event.target.value);
      http.get("/gugun/" + this.selectGugun).then(({ data }) => {
        this.DongList = data;
      });
    },
    updateMember() {
      // 회원 수정 버튼을 눌렀을 때
      if (this.memberPwd.length < 8 || this.memberPwd !== this.memberPwdMore) {
        this.$alertify.alert("업데이트 불가", "비밀번호를 확인해주세요!");
        return;
      } else if (this.memberInterestArea == 0) {
        this.$alertify.alert("업데이트 불가", "관심 지역을 선택해주세요!");
        return;
      }

      var formData = new FormData();
      var attachFiles = document.querySelector("#inputFileUploadInsert");

      formData.append("memberId", this.memberId);
      formData.append("memberPwd", this.memberPwd);
      formData.append("memberName", this.memberName);
      formData.append("memberGender", this.memberGender);
      formData.append("memberAge", this.memberAge);
      formData.append("memberEmail", this.memberEmail);
      formData.append("memberInterestArea", this.memberInterestArea);
      formData.append("memberType", this.memberType);
      formData.append("file", attachFiles.files[0]);
      http
        .put("/member/" + this.memberId, formData, {
          headers: {
            "Content-Type": "multipart/form-data;",
          },
        })
        .then(({ data }) => {
          this.$store.commit("SET_UPDATE", {
            memberName: data.memberName,
            memberPwd: data.memberPwd,
            memberEmail: data.memberEmail,
            memberInterestArea: data.memberInterestArea,
            memberProfile: data.memberProfile,
            memberGender: data.memberGender,
            memberAge: data.memberAge,
          });
          let $this = this;
          this.$alertify.alert("정상적으로 업데이트 되었습니다!", function () {
            $this.$router.push("/mypage");
          });
        })
        .catch((error) => {
          console.log("Error : " + error);
          this.$alertify.error("문제가 발생했습니다.");
        });
    },
  },
  created: function () {
    // 성별 리스트 중 회원의 정보와 동일한 값으로 설정
    http.get("/codes", { params: { groupCode: "002" } }).then(({ data }) => {
      this.GenderList = data;
    });

    // 연령대 리스트 중 회원의 정보와 동일한 값으로 설정
    http.get("/codes", { params: { groupCode: "003" } }).then(({ data }) => {
      this.Agelist = data;
    });

    http.get("/gugun").then(({ data }) => {
      // 현재 유저가 관심있는 지역의 앞 4글자가 구/군 코드임을 활용
      let str = this.$store.state.login.memberInterestArea;
      this.GugunList = data;// 구/군 리스트 업데이트
      this.selectGugun = str.substring(0, 5);

      // 구해진 구/군 코드를 활용해 동 리스트 업데이트
      http.get("/gugun/" + this.selectGugun).then(({ data }) => {
        this.DongList = data;
      });
    });
  },
};
</script>

<style></style>
