<template>
    <!-- Start Content -->
    <div class="container">
      <h2 class="text-center my-5">마이페이지</h2>
      <div class="table-div pb-3" style="min-height: 600px;">
        <div class="text-center">
            <img style="border-radius: 50%;width: 300px;" :src="$store.state.login.memberProfile" alt="프로필 사진">
        </div>  
        <div class="row pt-4">
            <div class="col"></div>
            <div class="col">
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">아이디 </label>
                    <label class="col">{{$store.state.login.memberId}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">이름 </label>
                    <label class="col">{{$store.state.login.memberName}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">성별 </label>
                    <label class="col">{{memberGenderName}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">연령대 </label>
                    <label class="col">{{memberAgeName}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">이메일 </label>
                    <label class="col">{{$store.state.login.memberEmail}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">관심지역 </label>
                    <label class="col">{{memberInterestAreaGugunName}} {{memberInterestAreaDongName}}</label>
                </div>
                <div class="row mb-3 pagination justify-content-center">
                    <div class="col text-end">
                        <button type="button" class="btn btn-success"><router-link to="/modify" style="text-decoration: none; color:white">수정</router-link></button>&nbsp;
                    </div>
                    <div class="col">
                        <button type="button" class="btn btn-secondary" @click="DeleteUser">탈퇴</button>
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
    name: 'Mypage',
    data(){
        return {
            //v-model
            memberGenderName: '',
            memberAgeName: '',
            memberInterestAreaGugunName: '',
            memberInterestAreaDongName: '',
            memberId: '',
        }
    }, methods:{
        DeleteUser(){
          let $this = this;
          this.$alertify.confirm(
              '정말 탈퇴하시겠습니까?',
              function(){
                  console.log("진짜 탈퇴한데");
                  console.log($this.$store.state.login.memberId);
                  
                  http.delete("/member/"+$this.$store.state.login.memberId)
                  .then(({data})=>{
                    console.log(data);
                    alert("성공적으로 탈퇴되었습니다!");
                    $this.$router.push("/");
                })
              }
          );
            
        }, 
    },created:function(){
        console.log(this.$store.state.login.memberPwd);

        http.get("/codes", { params: { groupCode: "002" } })
        .then(({ data }) => {
            //console.log("Login Member Gender code : " + this.$store.state.login.memberGender);
            data.forEach(element => {
                if(this.$store.state.login.memberGender === element.code)
                    //console.log(element.codeName);
                    this.memberGenderName = element.codeName;
            });
        });

        http.get("/codes", { params: { groupCode: "003" } })
        .then(({ data }) => {
            //console.log("Login Member Age code : " + this.$store.state.login.memberAge);
            data.forEach(element => {
                if(this.$store.state.login.memberAge === element.code)
                    //console.log(element.codeName);
                    this.memberAgeName = element.codeName;
            });
        });

        let str = this.$store.state.login.memberInterestArea;
        let gugunCode = str.substring(0,5);

        http.get("/gugun").then(({data})=>{
            data.forEach(element => {
                if(gugunCode === element.GUGUN_CODE)
                    this.memberInterestAreaGugunName = element.GUGUN_NAME;
            })
        })

        http.get("/gugun/"+gugunCode)
        .then(({data})=>{
            data.forEach(element => {
                if(this.$store.state.login.memberInterestArea === element.DONG_CODE)
                    this.memberInterestAreaDongName = element.DONG_NAME;
            })
        })

    }
}
</script>

<style>
    
</style>