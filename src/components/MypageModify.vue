<template>
  <!-- Start Content -->
    <div class="container">
      <h2 class="text-center my-5">정보수정</h2>
      <div class="table-div pb-3" style="min-height: 600px;">
        <div class="text-center">
            <img style="border-radius: 50%;width: 300px;" src="../assets/img/noProfile.png" alt="프로필 사진">
        </div>  
        <div class="row pt-4">
            <div class="col"></div>
            <div class="col">                
                <div class="row mb-4 form-group">
                    <label class="mb-2 fw-bold">프로필 사진</label>
                    <input type="file" class="form-control" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3 fw-bold">아이디 </label>
                    <input type="text" class="form-control col" readonly v-model="$store.state.login.memberId">
                </div>
                <div  class="row mb-4 form-group">
                  <label class="mb-2 col-3 fw-bold">비밀번호 </label>
                  <input v-model="memberPwd" type="password" class="form-control" placeholder="비밀번호 : 최소 8자 이상">
                  <input v-model="memberPwdMore" type="password" class="form-control" placeholder="비밀번호 확인 : 위와 동일하게 입력">
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3 fw-bold">이름 </label>
                    <input type="text" class="form-control col" v-model="$store.state.login.memberName">
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">성별 <span style="color:red;">*</span></label>
                    <div class="col m-2 form-check form-check-inline" v-for="(code, index) in GenderList" :key="index">
                        <input class="form-check-input" type="radio" :value="code.code" v-model="$store.state.login.memberGender">
                        <label class="form-check-label">{{code.codeName}}</label>
                    </div>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">연령대 <span style="color:red;">*</span></label>
                    <div class="col-4 form-check form-check-inline" v-for="(code, index) in Agelist" :key="index">
                        <input class="form-check-input" type="radio" :value="code.code" v-model="$store.state.login.memberAge">
                        <label class="form-check-label">{{code.codeName}}</label>
                    </div>  
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3 fw-bold">이메일 </label>
                    <input type="text" class="form-control col"  v-model="$store.state.login.memberEmail">
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3 fw-bold">관심지역 </label>
                    <div class="col">
                        <select class="form-select">
                            <option selected>구</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                    <div class="col">
                        <select class="form-select">
                            <option selected>동</option>
                            <option value="1">One</option>
                            <option value="2">Two</option>
                            <option value="3">Three</option>
                        </select>
                    </div>
                </div>
                <div class="mb-3 pagination justify-content-center">
                    <button type="button" class="btn btn-success"><a href="#" style="text-decoration: none; color:white">업데이트</a></button>
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
  data: function(){
      return {
          memberPwd:'',
          memberPwdMore:'',
          // 공통 코드 리스트
          GenderList: [],
          Agelist: [],
      }
  },created:function(){
        http.get("/codes",{params:{groupCode:"002"}})
        .then(({data})=>{
            this.GenderList = data;
            console.log(this.GenderList);
        });

        http.get("/codes",{params:{groupCode:"003"}})
        .then(({data})=>{
            this.Agelist = data;
            console.log(this.Agelist);
        });
    }
}
</script>

<style>

</style>