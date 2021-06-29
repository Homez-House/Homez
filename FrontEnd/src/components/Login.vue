<template>
    <!-- Login -->
    <div class="container pb-5">
        <div class="row m-5 pr-0 text-center">
                <h2>로그인</h2>
                <br><br><br>
                <img class="mx-auto d-block" style="width:300px;" src="data:image/svg+xml;base64,PHN2ZyBpZD0iY29sb3JfbGluZSIgaGVpZ2h0PSI1MTIiIHZpZXdCb3g9IjAgMCA3NCA3NCIgd2lkdGg9IjUxMiIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiBkYXRhLW5hbWU9ImNvbG9yIGxpbmUiPjxwYXRoIGQ9Im03MSA0Ni4zMXY5LjA0YTMuOTA5IDMuOTA5IDAgMCAxIC0zLjkxIDMuOTFoLTYwLjE4YTMuOTA5IDMuOTA5IDAgMCAxIC0zLjkxLTMuOTF2LTkuMDR6IiBmaWxsPSIjZWVlZmVlIi8+PHBhdGggZD0ibTcwLjY2NyA0Ni4zMXY5LjA0YTMuOTA5IDMuOTA5IDAgMCAxIC0zLjkxIDMuOTFoLTNhMy45MDkgMy45MDkgMCAwIDAgMy45MS0zLjkxdi05LjA0eiIgZmlsbD0iI2UxZTZlOSIvPjxwYXRoIGQ9Im03MSAxMC4wNnYzNi4yNWgtNjh2LTM2LjI1YTMuOTA5IDMuOTA5IDAgMCAxIDMuOTEtMy45MWg2MC4xOGEzLjkwOSAzLjkwOSAwIDAgMSAzLjkxIDMuOTF6IiBmaWxsPSIjODljNWNkIi8+PHBhdGggZD0ibTcwLjY2NyAxMC4zMXYzNi4yNWgtMy4yM3YtMzMuNDJhMy45MDkgMy45MDkgMCAwIDAgLTMuOTEtMy45MWgtNjAuMThhMy4wNzkgMy4wNzkgMCAwIDAgLS41My4wNCAzLjg4OCAzLjg4OCAwIDAgMSAzLjc2LTIuODdoNjAuMThhMy45MDkgMy45MDkgMCAwIDEgMy45MSAzLjkxeiIgZmlsbD0iIzZlYWFhZCIvPjxwYXRoIGQ9Im00OC41NDQgNjguOTc3LTIuMzU5LTkuNzEyaC0xOC4zN2wtMi4zNTkgOS43MTJ6IiBmaWxsPSIjZDVkNmRiIi8+PHBhdGggZD0ibTQ4LjU0NSA2OS40NzdoLTIzLjA4OWEuNS41IDAgMCAxIC0uNDg2LS42MThsMi4zNTktOS43MTJhLjUuNSAwIDAgMSAuNDg2LS4zODJoMTguMzdhLjUuNSAwIDAgMSAuNDg2LjM4MmwyLjM2IDkuNzEyYS41LjUgMCAwIDEgLS40ODYuNjE4em0tMjIuNDUzLTFoMjEuODE3bC0yLjExNy04LjcxMmgtMTcuNTgzeiIgZmlsbD0iIzMyM2M2YiIvPjxwYXRoIGQ9Im01Mi4xODQgNjkuNDc3aC0zMC4zNjhhLjUuNSAwIDAgMSAwLTFoMzAuMzY4YS41LjUgMCAwIDEgMCAxeiIgZmlsbD0iIzMyM2M2YiIvPjxjaXJjbGUgY3g9IjM3IiBjeT0iNTIuNTUzIiBmaWxsPSIjODQ4NzljIiByPSIxLjkxNyIvPjxwYXRoIGQ9Im0zNyA1NC45N2EyLjQxNyAyLjQxNyAwIDEgMSAyLjQxNy0yLjQxNyAyLjQxOSAyLjQxOSAwIDAgMSAtMi40MTcgMi40MTd6bTAtMy44MzNhMS40MTcgMS40MTcgMCAxIDAgMS40MTcgMS40MTcgMS40MTkgMS40MTkgMCAwIDAgLTEuNDE3LTEuNDE4eiIgZmlsbD0iIzMyM2M2YiIvPjxjaXJjbGUgY3g9IjM3LjI5MyIgY3k9IjE2LjQxOSIgZmlsbD0iI2ZjZDQ2MiIgcj0iNC44MTMiIHRyYW5zZm9ybT0ibWF0cml4KDEgLS4wMDYgLjAwNiAxIC0uMDk4IC4yMjMpIi8+PHBhdGggZD0ibTQ2LjczOCAzMS40NTFoLTE4Ljg5MmMuNTcxLTUuOTc0IDIuOTg1LTcuMTM4IDYuOS04LjIyMmE0LjMxMyA0LjMxMyAwIDAgMCA1LjEgMGMzLjkwNiAxLjA4NCA2LjMyIDIuMjQ4IDYuODkyIDguMjIyeiIgZmlsbD0iI2ZjZDQ2MiIvPjxwYXRoIGQ9Im00MS44ODIgMTYuNDM5YTQuODIxIDQuODIxIDAgMCAxIC0zLjgyIDQuNzQgNC44MTYgNC44MTYgMCAwIDAgLTMuMTUtOC40OCA1LjA0IDUuMDQgMCAwIDAgLS45Ni4xIDQuNzMyIDQuNzMyIDAgMCAxIDMuMDgtMS4xNCA0LjgxNCA0LjgxNCAwIDAgMSA0Ljg1IDQuNzh6IiBmaWxsPSIjZjdiZTU2Ii8+PHBhdGggZD0ibTM5LjM5MyAyMy4yM2E0LjE3OSA0LjE3OSAwIDAgMSAtMS45MjMuNzgxYzMuNTU1IDEgNS44MzcgMi40NjEgNi41NjMgNy40MzloMi4yNmMtLjU3LTUuOTctMi45OTMtNy4xNC02LjktOC4yMnoiIGZpbGw9IiNmN2JlNTYiLz48cGF0aCBkPSJtMjQuMjA4IDM0LjQxN2gyNS41ODN2Ny45NzFoLTI1LjU4M3oiIGZpbGw9IiNlMWU2ZTkiLz48ZyBmaWxsPSIjMzIzYzZiIj48cGF0aCBkPSJtNDkuNzkyIDQyLjg4OGgtMjUuNTg0YS41LjUgMCAwIDEgLS41LS41di03Ljk3MWEuNS41IDAgMCAxIC41LS41aDI1LjU4NGEuNS41IDAgMCAxIC41LjV2Ny45NzFhLjUuNSAwIDAgMSAtLjUuNXptLTI1LjA4NC0xaDI0LjU4NHYtNi45NzFoLTI0LjU4NHoiLz48cGF0aCBkPSJtNDMuNTUzIDQwLjUyOWEuNS41IDAgMCAxIC0uNS0uNXYtMy4yNTRhLjUuNSAwIDAgMSAxIDB2My4yNTRhLjUuNSAwIDAgMSAtLjUuNXoiLz48cGF0aCBkPSJtMzAuNDQ3IDQwLjUyOWEuNS41IDAgMCAxIC0uNS0uNXYtMy4yNTRhLjUuNSAwIDAgMSAxIDB2My4yNTRhLjUuNSAwIDAgMSAtLjUuNXoiLz48cGF0aCBkPSJtMjkuMDcxIDM5LjY1OWEuNS41IDAgMCAxIC0uMjUtLjkzM2wyLjgxOS0xLjYyNmEuNS41IDAgMCAxIC41Ljg2NmwtMi44MTggMS42MjZhLjUuNSAwIDAgMSAtLjI1MS4wNjd6Ii8+PHBhdGggZD0ibTMxLjgyNCAzOS42NTlhLjUuNSAwIDAgMSAtLjI1LS4wNjdsLTIuODE4LTEuNjI2YS41LjUgMCAwIDEgLjUtLjg2NmwyLjgxOCAxLjYyNmEuNS41IDAgMCAxIC0uMjUuOTMzeiIvPjxwYXRoIGQ9Im0zNyA0MC41MjlhLjUuNSAwIDAgMSAtLjUtLjV2LTMuMjU0YS41LjUgMCAwIDEgMSAwdjMuMjU0YS41LjUgMCAwIDEgLS41LjV6Ii8+PHBhdGggZD0ibTM1LjYyNCAzOS42NTlhLjUuNSAwIDAgMSAtLjI1LS45MzNsMi44MTctMS42MjZhLjUuNSAwIDAgMSAuNS44NjZsLTIuODE3IDEuNjI2YS41LjUgMCAwIDEgLS4yNS4wNjd6Ii8+PHBhdGggZD0ibTM4LjM3NiAzOS42NTlhLjUuNSAwIDAgMSAtLjI1LS4wNjdsLTIuODE3LTEuNjI2YS41LjUgMCAwIDEgLjUtLjg2NmwyLjgxNyAxLjYyNmEuNS41IDAgMCAxIC0uMjUuOTMzeiIvPjxwYXRoIGQ9Im00Mi4xNzYgMzkuNjU5YS41LjUgMCAwIDEgLS4yNS0uOTMzbDIuODE4LTEuNjI2YS41LjUgMCAwIDEgLjUuODY2bC0yLjgxOCAxLjYyNmEuNS41IDAgMCAxIC0uMjUuMDY3eiIvPjxwYXRoIGQ9Im00NC45MjkgMzkuNjU5YS41LjUgMCAwIDEgLS4yNS0uMDY3bC0yLjgxOS0xLjYyN2EuNS41IDAgMCAxIC41LS44NjZsMi44MTggMS42MjZhLjUuNSAwIDAgMSAtLjI1LjkzM3oiLz48cGF0aCBkPSJtNjYuMzEzIDYyLjc2NWgtOS44NzVhLjUuNSAwIDAgMSAwLTFoOS44NzVhLjUuNSAwIDAgMSAwIDF6Ii8+PHBhdGggZD0ibTU0LjE1NiA2Mi43NjVoLTEuMTg3YS41LjUgMCAwIDEgMC0xaDEuMTg4YS41LjUgMCAwIDEgMCAxeiIvPjxwYXRoIGQ9Im0uNTIxIDcuOTM4YS41LjUgMCAwIDEgLS4xOTEtLjAzOC41LjUgMCAwIDEgLS4yNzEtLjY1MyA3LjM5MyA3LjM5MyAwIDAgMSA2Ljg1NC00LjZoMi4zMzdhLjUuNSAwIDAgMSAwIDFoLTIuMzM4YTYuNCA2LjQgMCAwIDAgLTUuOTMgMy45ODEuNS41IDAgMCAxIC0uNDYxLjMxeiIvPjxwYXRoIGQ9Im0xMi44NzUgMy42NWgtMS4xMjVhLjUuNSAwIDAgMSAwLTFoMS4xMjVhLjUuNSAwIDAgMSAwIDF6Ii8+PHBhdGggZD0ibTcxIDQ2LjgxaC02OGEuNS41IDAgMCAxIC0uNS0uNXYtMzYuMjVhNC40MTUgNC40MTUgMCAwIDEgNC40MS00LjQxaDYwLjE4YTQuNDE1IDQuNDE1IDAgMCAxIDQuNDEgNC40MXYzNi4yNWEuNS41IDAgMCAxIC0uNS41em0tNjcuNS0xaDY3di0zNS43NWEzLjQxNCAzLjQxNCAwIDAgMCAtMy40MS0zLjQxaC02MC4xOGEzLjQxNCAzLjQxNCAwIDAgMCAtMy40MSAzLjQxeiIvPjxwYXRoIGQ9Im02Ny4wOSA1OS43NmgtNjAuMThhNC40MTUgNC40MTUgMCAwIDEgLTQuNDEtNC40MXYtOS4wNGEuNS41IDAgMCAxIC41LS41aDY4YS41LjUgMCAwIDEgLjUuNXY5LjA0YTQuNDE1IDQuNDE1IDAgMCAxIC00LjQxIDQuNDF6bS02My41OS0xMi45NXY4LjU0YTMuNDE0IDMuNDE0IDAgMCAwIDMuNDEgMy40MWg2MC4xOGEzLjQxNCAzLjQxNCAwIDAgMCAzLjQxLTMuNDF2LTguNTR6Ii8+PHBhdGggZD0ibTM3LjI5MSAyMS43MzFhNS4zMTMgNS4zMTMgMCAwIDEgLS4wMy0xMC42MjVoLjAzMWE1LjMxMyA1LjMxMyAwIDAgMSAuMDMyIDEwLjYyNXptLS4wMjQtOS42MjVhNC4zMTMgNC4zMTMgMCAwIDAgLjAyNCA4LjYyNWguMDI3YTQuMzEzIDQuMzEzIDAgMCAwIC0uMDI2LTguNjI1eiIvPjxwYXRoIGQ9Im00Ni43MzcgMzEuOTUxaC0xOC44OTFhLjUuNSAwIDAgMSAtLjUtLjU0N2MuNjA2LTYuMzM1IDMuMzk0LTcuNTg0IDcuMjY1LTguNjU3YS41LjUgMCAwIDEgLjQzMS4wOCAzLjg3NCAzLjg3NCAwIDAgMCA0LjUgMCAuNS41IDAgMCAxIC40MzEtLjA4YzMuODY3IDEuMDczIDYuNjUgMi4zMjMgNy4yNTcgOC42NTdhLjUuNSAwIDAgMSAtLjUuNTQ3em0tMTguMzM1LTFoMTcuNzc5Yy0uNjI2LTUuMTM0LTIuOC02LjItNi4yNDMtNy4xNzdhNC44ODYgNC44ODYgMCAwIDEgLTUuMjg0IDBjLTMuNDU0Ljk3My01LjYyNiAyLjA0LTYuMjU0IDcuMTc3eiIvPjwvZz48cGF0aCBkPSJtMTMuMiA0Mi42NWgtNi4xYS43NDkuNzQ5IDAgMCAxIC0uNzUtLjc0OXYtNC40NjhhLjc1Ljc1IDAgMCAxIDEuNSAwdjMuNzE5aDUuMzVhLjc0OS43NDkgMCAxIDEgMCAxLjV6IiBmaWxsPSIjZmZmIi8+PHBhdGggZD0ibTcuMSAzNC44MzNhLjc0OS43NDkgMCAwIDEgLS43NS0uNzQ5di0xLjAyMmEuNzUuNzUgMCAwIDEgMS41IDB2MS4wMjJhLjc0OS43NDkgMCAwIDEgLS43NS43NDl6IiBmaWxsPSIjZmZmIi8+PC9zdmc+" />
        </div>
        <hr>
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <div class="row mt-3 mb-4 form-group">
                    <div class="col-3 text-end"><label>아이디</label></div>
                    <div class="col"><input type="text" class="form-control" v-model="loginId"></div>
                </div>
                <div class="row mb-4 form-group">
                    <div class="col-3 text-end"><label>비밀번호</label></div>
                    <div class="col"><input type="password" class="form-control" v-model="loginPwd"></div>
                </div>
                <div class="pagination justify-content-center">
                    <button type="button" class="btn btn-success mr-3"  @click="login">로그인</button>
                </div>
                <div class="row mt-3 mb-4 form-group">
                    <div class="col text-end">
                        <router-link to="/find" class="text-secondary" style="text-decoration: none;">아이디/비밀번호 찾기</router-link>
                    </div>|
                    <div class="col">
                        <router-link to="/signup" class="text-secondary" style="text-decoration: none;">회원가입</router-link>
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
        

    </div>
    <!-- Close Login -->
</template>

<script>
import http from "@/common/axios.js";

export default {
    name: 'Login',
    data:function(){
        return{
            loginId:'',
            loginPwd:''
        }
    },
    methods:{
        login(){
            http.post("/login", {
                memberId: this.loginId,
                memberPwd: this.loginPwd
            }).then(({data})=>{
                console.log("Login data : "+data);
                this.$store.commit('SET_LOGIN', {
                    isLogin: true, 
                    memberId: data.memberId,
                    memberName: data.memberName, 
                    memberPwd: data.memberPwd,
                    memberEmail: data.memberEmail,
                    memberInterestArea: data.memberInterestArea,
                    memberJoindate: data.memberJoindate,
                    memberProfile: data.memberProfile,
                    memberGender: data.memberGender,
                    memberAge: data.memberAge,
                    memberType: data.memberType
                });

                this.$router.push("/");
            }).catch(error =>{
                if( error.response.status == '404'){
                    this.$alertify.error('이메일 또는 비밀번호를 확인하세요.');
                }else{
                    this.$alertify.error('Opps!! 서버에 문제가 발생했습니다.');
                }
            });
        }
    }
}
</script>

<style>
    
</style>