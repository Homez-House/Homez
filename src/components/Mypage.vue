<template>
    <!-- Start Content -->
    <div class="container">
      <h2 class="text-center my-5">마이페이지</h2>
      <div class="table-div pb-3" style="min-height: 600px;">
        <div class="text-center">
            <img style="border-radius: 50%;width: 300px;" src="../assets/img/noProfile.png" alt="프로필 사진">
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
                    <label class="col">{{$store.state.login.memberGender}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">연령대 </label>
                    <label class="col">{{$store.state.login.memberAge}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">이메일 </label>
                    <label class="col">{{$store.state.login.memberEmail}}</label>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2 col-3">관심지역 </label>
                    <label class="col">강남구 역삼동</label>
                </div>
                <div class="row mb-3 pagination justify-content-center">
                    <div class="col text-end">
                        <button type="button" class="btn btn-success"><router-link to="/modify" style="text-decoration: none; color:white">수정</router-link></button>&nbsp;
                    </div>
                    <div class="col">
                        <button type="button" class="btn btn-secondary">탈퇴</button>
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
export default {
    name: 'Mypage'
}
</script>

<style>
    
</style>