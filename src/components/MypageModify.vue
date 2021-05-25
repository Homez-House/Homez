<template>
  <!-- Start Content -->
  <div class="container">
    <h2 class="text-center my-5">정보수정</h2>
    <div class="table-div pb-3" style="min-height: 600px">
      <div class="text-center">
        <img style="border-radius: 50%; width: 300px" :src="memberProfile" alt="프로필 사진"/>
      </div>
      <div class="row pt-4">
        <div class="col"></div>
        <div class="col">
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">프로필 사진</label>
            <input type="file" class="form-control" aria-describedby="inputGroupFileAddon04" aria-label="Upload"/>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3 fw-bold">아이디 </label>
            <input type="text" class="form-control col" readonly v-model="memberId" />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">비밀번호 <span style="color: red">*</span></label>
            <input v-model="memberPwd" type="password" class="form-control" placeholder="비밀번호 : 최소 8자 이상" />
            <input v-model="memberPwdMore" type="password" class="form-control" placeholder="비밀번호 확인 : 위와 동일하게 입력" />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3 fw-bold">이름 </label>
            <input type="text" class="form-control col" v-model="memberName" />
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">성별</label>
            <div class="col m-2 form-check form-check-inline" v-for="(code, index) in GenderList" :key="index" >
              <input class="form-check-input" type="radio" :value="code.code" v-model="memberGender" />
              <label class="form-check-label">{{ code.codeName }}</label>
            </div>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">연령대</label>
            <div class="col-4 form-check form-check-inline" v-for="(code, index) in Agelist" :key="index" >
              <input class="form-check-input" type="radio" :value="code.code" v-model="memberAge" />
              <label class="form-check-label">{{ code.codeName }}</label>
            </div>
          </div>
          <div class="row mb-4 form-group">
            <label class="mb-2 col-3 fw-bold">이메일 </label>
            <input type="text" class="form-control col" v-model="memberEmail" />
          </div>
        <div class="row mb-4 form-group">
            <label class="mb-2 fw-bold">관심지역 <span style="color:red;">*</span></label>
            <div class="col">
                <select class="form-select" v-model="selectGugun" @change="selectGugunData($event)">
                    <option selected :value="0" hidden>구</option>
                    <option v-for="(Gugun, index) in GugunList" :key="index" :value="Gugun.GUGUN_CODE">{{Gugun.GUGUN_NAME}}</option>
                </select>
            </div>
            <div class="col">
                <select class="form-select" v-model="memberInterestArea">
                    <option selected :value="0" hidden>동</option>
                    <option v-for="(Dong, index) in DongList" :key="index" :value="Dong.DONG_CODE">{{Dong.DONG_NAME}}</option>
                </select>
            </div>
        </div>
          <div class="mb-3 pagination justify-content-center">
            <button type="button" class="btn btn-success">
              <a href="#" style="text-decoration: none; color: white" @click="updateMember">업데이트</a >
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
      memberId: this.$store.state.login.memberId,
      memberPwd: "",
      memberPwdMore: "",
      memberProfile: this.$store.state.login.memberProfile,
      memberName: this.$store.state.login.memberName,
      memberGender: this.$store.state.login.memberGender,
      memberAge: this.$store.state.login.memberAge,
      memberEmail: this.$store.state.login.memberEmail,
      memberInterestArea: this.$store.state.login.memberInterestArea,

      // 공통 코드 리스트
      GenderList: [],
      Agelist: [],

      // 구군 리스트
      GugunList: [],
      DongList: [],
      selectGugun: '',
    }
  }, methods: {
      selectGugunData(event){
        this.memberInterestArea = 0;
        console.log(event.target.value);
        http.get("/gugun/"+this.selectGugun)
        .then(({data})=>{
            this.DongList = data;
            console.log(data);
        })
      }, updateMember(){
        if(this.memberPwd.length < 8 || this.memberPwd !== this.memberPwdMore){
          this.$alertify.alert('업데이트 불가', '비밀번호를 확인해주세요!');
          return;
        }else if(this.memberInterestArea == 0){
          this.$alertify.alert('업데이트 불가', '관심 지역을 선택해주세요!');
          return;
        }
        
        http.put("/member/"+this.memberId, {
          memberId:this.memberId, 
          memberPwd:this.memberPwd,
          memberProfile:this.memberProfile,
          memberName:this.memberName,
          memberGender:this.memberGender,
          memberAge:this.memberAge,
          memberEmail:this.memberEmail,
          memberInterestArea:this.memberInterestArea,
          memberType:this.memberType
        }).then(({data})=>{
          console.log("Member Update : " + data);
          this.$store.commit('SET_UPDATE', {
              memberName: data.memberName, 
              memberPwd: data.memberPwd,
              memberEmail: data.memberEmail,
              memberInterestArea: data.memberInterestArea,
              memberProfile: data.memberProfile,
              memberGender: data.memberGender,
              memberAge: data.memberAge
          });
          let $this = this;
          this.$alertify.alert(
              '정상적으로 업데이트 되었습니다!',
              function() {
                  $this.$router.push("/mypage");
              }
          );       
        }).catch(error=>{
          console.log("Error : "+error);
          this.$alertify.error('문제가 발생했습니다.');          
        });
      }
  }, created: function () {
    http.get("/codes", { params: { groupCode: "002" } })
    .then(({ data }) => {
      this.GenderList = data;
      console.log(this.GenderList);
    });

    http.get("/codes", { params: { groupCode: "003" } })
    .then(({ data }) => {
      this.Agelist = data;
      console.log(this.Agelist);
    });

    http.get("/gugun").then(({ data }) => {
      let str = this.$store.state.login.memberInterestArea;
      console.log(data);
      this.GugunList = data;
      this.selectGugun = str.substring(0,5);

      http.get("/gugun/"+this.selectGugun)
        .then(({data})=>{
            this.DongList = data;
        })
    });
  },
};
</script>

<style>
</style>