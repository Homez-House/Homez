<template>
    <!-- Find -->
    <div class="container pb-5">
        <div style="height: 100px;"></div>
        <div class="row mb-3 pr-0 text-center">
                <h2>정보찾기</h2>
                <br><br><br>
                <img class="mx-auto d-block" style="width:300px;"  src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJDYXBhXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB2aWV3Qm94PSIwIDAgNTEyIDUxMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNTEyIDUxMjsiIHhtbDpzcGFjZT0icHJlc2VydmUiPg0KPHBhdGggc3R5bGU9ImZpbGw6IzVBNTRFMDsiIGQ9Ik0zNjEuNzY4LDMyMS4zNDdMNDkzLjY0LDQ1My4yMmMxMS4wNDIsMTEuMDQyLDEwLjk1NCwyOS4xOTgtMC4xOTQsNDAuMzQ2bDAsMA0KCWMtMTEuMTQ5LDExLjE0OS0yOS4zMDUsMTEuMjM2LTQwLjM0NiwwLjE5NEwzMjEuMjI2LDM2MS44ODhMMzYxLjc2OCwzMjEuMzQ3eiIvPg0KPHJlY3QgeD0iMzI4Ljk2MiIgeT0iMzM0Ljk0NSIgdHJhbnNmb3JtPSJtYXRyaXgoMC43MDcxIC0wLjcwNzEgMC43MDcxIDAuNzA3MSAtMTQ4LjIxOTcgMzU3LjY2MjgpIiBzdHlsZT0iZmlsbDojRkZGRkZGOyIgd2lkdGg9IjU3LjMzIiBoZWlnaHQ9IjQ1LjYwNyIvPg0KPHBhdGggc3R5bGU9ImZpbGw6IzcyRDhGRjsiIGQ9Ik0zOTMuOTYxLDIwMS45NTZjMC0xMDYuMDI1LTg1Ljk0NC0xOTEuOTY5LTE5MS45NjktMTkxLjk2OVMxMC4wMjQsOTUuOTMxLDEwLjAyNCwyMDEuOTU2DQoJczg1Ljk0NCwxOTEuOTY5LDE5MS45NjksMTkxLjk2OVMzOTMuOTYxLDMwNy45OCwzOTMuOTYxLDIwMS45NTZ6Ii8+DQo8Y2lyY2xlIHN0eWxlPSJmaWxsOiNGRkZGRkY7IiBjeD0iMjAxLjk5NyIgY3k9IjIwMS45NTciIHI9IjE0My45NzYiLz4NCjxwYXRoIHN0eWxlPSJmaWxsOiNGRjVENUQ7IiBkPSJNMjI3LjI4OSwxOTcuNzU2aC01MC41OTFjLTMyLjQxNCwwLTU4LjY5LDI2LjI3Ny01OC42OSw1OC42OXY1LjE2NkgyODUuOTh2LTUuMTY2DQoJQzI4NS45NzksMjI0LjAzMiwyNTkuNzAyLDE5Ny43NTYsMjI3LjI4OSwxOTcuNzU2eiIvPg0KPHBhdGggc3R5bGU9ImZpbGw6I0ZDQzY5RDsiIGQ9Ik0yMDEuOTkzLDEwOC42NzJMMjAxLjk5MywxMDguNjcyYy0yMC45ODQsMC0zNy45OTQsMTcuMDEtMzcuOTk0LDM3Ljk5NHYxMy4wOTYNCgljMCwyMC45ODQsMTcuMDEsMzcuOTk0LDM3Ljk5NCwzNy45OTRsMCwwYzIwLjk4NCwwLDM3Ljk5NC0xNy4wMSwzNy45OTQtMzcuOTk0di0xMy4wOTYNCglDMjM5Ljk4NywxMjUuNjgyLDIyMi45NzcsMTA4LjY3MiwyMDEuOTkzLDEwOC42NzJ6Ii8+DQo8cGF0aCBkPSJNNTAwLjcxLDQ0Ni4xNDlsLTkyLjctOTIuN2MyLjU0OC0zLjg3OSwyLjExOC05LjE0Mi0xLjI5My0xMi41NTJjLTMuNDEtMy40MS04LjY3NC0zLjg0MS0xMi41NTItMS4yOTNsLTI0LjczNy0yNC43MzcNCgljMTguNDg5LTI3LjQ0NywzMC4xMjgtNTkuMjM4LDMzLjQ5NS05Mi4zOTVjNC42MTEtNDUuNDEyLTYuMzctOTEuNDQ1LTMwLjkyLTEyOS42MjJjLTIuOTg4LTQuNjQ1LTkuMTc0LTUuOTg4LTEzLjgxOC0zLjAwMg0KCWMtNC42NDQsMi45ODctNS45ODgsOS4xNzQtMy4wMDIsMTMuODE4YzQ1LjkxMSw3MS4zOTIsMzUuNiwxNjYuODQ0LTI0LjUxNywyMjYuOTYxYy03MC45NSw3MC45NS0xODYuMzk0LDcwLjk1LTI1Ny4zNDUsMA0KCWMtNzAuOTUtNzAuOTQ5LTcwLjk1LTE4Ni4zOTMsMC0yNTcuMzQ0YzYwLjE4MS02MC4xODEsMTUyLjU5NC03MC44NDIsMjI0LjczLTI1LjkzMWM0LjY4NiwyLjkxOCwxMC44NTMsMS40ODUsMTMuNzcyLTMuMjAzDQoJYzIuOTE5LTQuNjg3LDEuNDg0LTEwLjg1My0zLjIwMy0xMy43NzJDMjcwLjU1Miw2LjY3NywyMjQuOTAxLTMuNjkzLDE4MC4wNjgsMS4xNzRDMTM0LjU1MSw2LjExNyw5MS42MiwyNi43MDUsNTkuMTgsNTkuMTQzDQoJYy03OC43NDYsNzguNzQ3LTc4Ljc0NiwyMDYuODc4LDAsMjg1LjYyNGMzOS4zNzQsMzkuMzc0LDkxLjA5Myw1OS4wNiwxNDIuODEzLDU5LjA2YzM5LjQwMywwLDc4Ljc5OC0xMS40NCwxMTIuNzQxLTM0LjI5Mg0KCWwyNC42MTMsMjQuNjEzYy0zLjY5OCwzLjkxOC0zLjYzOSwxMC4wODksMC4xOTUsMTMuOTI0YzEuOTUzLDEuOTUzLDQuNTExLDIuOTI4LDcuMDcsMi45MjhjMi40NjgsMCw0LjkzLTAuOTE3LDYuODU0LTIuNzMzDQoJbDkyLjU2Myw5Mi41NjNjNy40NSw3LjQ1LDE3LjI0NCwxMS4xNjksMjcuMDY1LDExLjE2OWM5LjkxMSwwLDE5Ljg1LTMuNzkxLDI3LjQyMy0xMS4zNjQNCglDNTE1LjU5MSw0ODUuNTYsNTE1LjY3OSw0NjEuMTE3LDUwMC43MSw0NDYuMTQ5eiBNMzYxLjc2OCwzMzUuNDg3bDE4LjExLDE4LjExbC0yNi40MDIsMjYuNDAybC0xOC4xMS0xOC4xMUwzNjEuNzY4LDMzNS40ODd6DQoJIE00ODYuMzc2LDQ4Ni40OTZjLTcuMjgsNy4yNzktMTkuMDM2LDcuMzY3LTI2LjIwNywwLjE5NGwtOTIuNTUzLTkyLjU1M2wyNi40MDItMjYuNDAybDkyLjU1Miw5Mi41NTMNCglDNDkzLjc0Miw0NjcuNDYxLDQ5My42NTUsNDc5LjIxNyw0ODYuMzc2LDQ4Ni40OTZ6Ii8+DQo8cGF0aCBkPSJNMzMwLjkwNCw3My41MjJjMS45NTMsMS45NTMsNC41MTEsMi45MjksNy4wNywyLjkyOWMyLjU1OSwwLDUuMTE4LTAuOTc2LDcuMDctMi45MjljMy45MDQtMy45MDQsMy45MDQtMTAuMjM1LDAtMTQuMTQxDQoJbC0wLjIxNy0wLjIxN2MtMy44OTItMy45MTYtMTAuMjIzLTMuOTM1LTE0LjE0LTAuMDQzcy0zLjkzNiwxMC4yMjMtMC4wNDMsMTQuMTRMMzMwLjkwNCw3My41MjJ6Ii8+DQo8cGF0aCBkPSJNMjAxLjk5Myw0Ny45ODFjLTg0LjkwMiwwLTE1My45NzUsNjkuMDczLTE1My45NzUsMTUzLjk3NXM2OS4wNzMsMTUzLjk3NSwxNTMuOTc1LDE1My45NzVzMTUzLjk3NS02OS4wNzMsMTUzLjk3NS0xNTMuOTc1DQoJUzI4Ni44OTUsNDcuOTgxLDIwMS45OTMsNDcuOTgxeiBNMjAxLjk5MywzMzUuOTM0Yy03My44NzYsMC0xMzMuOTc4LTYwLjEwMi0xMzMuOTc4LTEzMy45NzhTMTI4LjExNyw2Ny45NzgsMjAxLjk5Myw2Ny45NzgNCglzMTMzLjk3OCw2MC4xMDIsMTMzLjk3OCwxMzMuOTc4UzI3NS44NjksMzM1LjkzNCwyMDEuOTkzLDMzNS45MzR6Ii8+DQo8cGF0aCBkPSJNMjQwLjA0MSwxODguOTYzYzYuMjI4LTguMDk2LDkuOTQ0LTE4LjIyLDkuOTQ0LTI5LjIwMXYtMTMuMDk2YzAtMjYuNDYzLTIxLjUyOS00Ny45OTItNDcuOTkyLTQ3Ljk5Mg0KCXMtNDcuOTkyLDIxLjUyOS00Ny45OTIsNDcuOTkydjEzLjA5NmMwLDEwLjk4MSwzLjcxNSwyMS4xMDYsOS45NDQsMjkuMjAxYy0zMS44LDUuOTk3LTU1LjkzNywzMy45NjYtNTUuOTM3LDY3LjQ4NHY1LjE2Ng0KCWMwLDUuNTIyLDQuNDc2LDkuOTk4LDkuOTk4LDkuOTk4aDE2Ny45NzJjNS41MjIsMCw5Ljk5OC00LjQ3Niw5Ljk5OC05Ljk5OHYtNS4xNjZDMjk1Ljk3OCwyMjIuOTMsMjcxLjg0MSwxOTQuOTYxLDI0MC4wNDEsMTg4Ljk2M3oNCgkgTTE3My45OTgsMTQ2LjY2NmMwLTE1LjQzNiwxMi41NTktMjcuOTk1LDI3Ljk5NS0yNy45OTVzMjcuOTk1LDEyLjU1OSwyNy45OTUsMjcuOTk1djEzLjA5NmMwLDE1LjQzNi0xMi41NTksMjcuOTk1LTI3Ljk5NSwyNy45OTUNCglzLTI3Ljk5NS0xMi41NTktMjcuOTk1LTI3Ljk5NVYxNDYuNjY2eiBNMTI4LjI0MywyNTEuNjE0YzIuNDM0LTI0LjU4OSwyMy4yMzYtNDMuODYsNDguNDU1LTQzLjg2aDUwLjU5MQ0KCWMyNS4yMTksMCw0Ni4wMjEsMTkuMjcxLDQ4LjQ1NSw0My44NkgxMjguMjQzeiIvPg0KPHBhdGggZD0iTTQ0Mi4zMDUsNDQuNDEyYzUuNTIyLDAsOS45OTgtNC40NzYsOS45OTgtOS45OThWMjEuOTg1YzAtNS41MjItNC40NzYtOS45OTgtOS45OTgtOS45OThjLTUuNTIyLDAtOS45OTgsNC40NzYtOS45OTgsOS45OTgNCgl2MTIuNDI4QzQzMi4zMDYsMzkuOTM1LDQzNi43ODIsNDQuNDEyLDQ0Mi4zMDUsNDQuNDEyeiIvPg0KPHBhdGggZD0iTTQ0Mi4zMDUsMTAzLjk3MmM1LjUyMiwwLDkuOTk4LTQuNDc2LDkuOTk4LTkuOTk4VjgxLjU0NmMwLTUuNTIyLTQuNDc2LTkuOTk4LTkuOTk4LTkuOTk4DQoJYy01LjUyMiwwLTkuOTk4LDQuNDc2LTkuOTk4LDkuOTk4djEyLjQyOEM0MzIuMzA2LDk5LjQ5Niw0MzYuNzgyLDEwMy45NzIsNDQyLjMwNSwxMDMuOTcyeiIvPg0KPHBhdGggZD0iTTQ2NS44NzEsNjcuOTc4aDEyLjQyOGM1LjUyMiwwLDkuOTk4LTQuNDc2LDkuOTk4LTkuOTk4cy00LjQ3Ni05Ljk5OC05Ljk5OC05Ljk5OGgtMTIuNDI4DQoJYy01LjUyMiwwLTkuOTk4LDQuNDc2LTkuOTk4LDkuOTk4UzQ2MC4zNDksNjcuOTc4LDQ2NS44NzEsNjcuOTc4eiIvPg0KPHBhdGggZD0iTTQwNi4zMSw2Ny45NzhoMTIuNDI4YzUuNTIyLDAsOS45OTgtNC40NzYsOS45OTgtOS45OThzLTQuNDc2LTkuOTk4LTkuOTk4LTkuOTk4SDQwNi4zMWMtNS41MjIsMC05Ljk5OCw0LjQ3Ni05Ljk5OCw5Ljk5OA0KCVM0MDAuNzg4LDY3Ljk3OCw0MDYuMzEsNjcuOTc4eiIvPg0KPHBhdGggZD0iTTYxLjkzNyw0MTIuMDA4Yy01LjUyMiwwLTkuOTk4LDQuNDc2LTkuOTk4LDkuOTk4djEyLjQyOGMwLDUuNTIyLDQuNDc2LDkuOTk4LDkuOTk4LDkuOTk4czkuOTk4LTQuNDc2LDkuOTk4LTkuOTk4di0xMi40MjgNCglDNzEuOTM1LDQxNi40ODQsNjcuNDU5LDQxMi4wMDgsNjEuOTM3LDQxMi4wMDh6Ii8+DQo8cGF0aCBkPSJNNjEuOTM3LDQ3MS41NjhjLTUuNTIyLDAtOS45OTgsNC40NzYtOS45OTgsOS45OTh2MTIuNDI4YzAsNS41MjIsNC40NzYsOS45OTgsOS45OTgsOS45OThzOS45OTgtNC40NzYsOS45OTgtOS45OTh2LTEyLjQyOA0KCUM3MS45MzUsNDc2LjA0NCw2Ny40NTksNDcxLjU2OCw2MS45MzcsNDcxLjU2OHoiLz4NCjxwYXRoIGQ9Ik05Ny45MzEsNDQ4LjAwMkg4NS41MDNjLTUuNTIyLDAtOS45OTgsNC40NzYtOS45OTgsOS45OThzNC40NzYsOS45OTgsOS45OTgsOS45OThoMTIuNDI4YzUuNTIyLDAsOS45OTgtNC40NzYsOS45OTgtOS45OTgNCglTMTAzLjQ1Myw0NDguMDAyLDk3LjkzMSw0NDguMDAyeiIvPg0KPHBhdGggZD0iTTM4LjM3MSw0NDguMDAySDI1Ljk0M2MtNS41MjIsMC05Ljk5OCw0LjQ3Ni05Ljk5OCw5Ljk5OHM0LjQ3Niw5Ljk5OCw5Ljk5OCw5Ljk5OGgxMi40MjhjNS41MjIsMCw5Ljk5OC00LjQ3Niw5Ljk5OC05Ljk5OA0KCVM0My44OTMsNDQ4LjAwMiwzOC4zNzEsNDQ4LjAwMnoiLz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjwvc3ZnPg0K" />
                <br><br><br>
        </div>
        <br>
        <hr>
        <br>
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <!-- 검색 확인 : 라디오 버튼 -->
                <div class="row mt-3 mb-4 form-group">
                    <div class="col">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio">
                            <label class="form-check-label"> 아이디 찾기 </label>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio">
                            <label class="form-check-label" >비밀번호 찾기</label>
                        </div>
                    </div>
                </div>
                <!-- 아이디 검색 div -->
                <div class="row p-3"> 
                    <div class="row mb-3">
                        회원가입했을 때의 정보를 입력하세요.
                    </div>
                    <div class="row">
                        <div class="col"></div>
                        <div class="col">
                            <input type="text" placeholder="이름">
                            <br>
                            <input type="text" placeholder="이메일">
                        </div>
                        <div class="col"></div>
                    </div>
                    <div class="row pt-3">
                        <div class="mb-4 pagination justify-content-center">
                            <button type="button" class="btn btn-success mr-3">아이디 검색</button>
                        </div>
                    </div>
                </div>
                <!-- 비밀번호 검색 div -->
                <div class="row p-3">
                    <div class="row mb-3">
                        본인의 정보를 정확히 입력해주세요.
                    </div>
                    <div class="row">
                        <div class="col"></div>
                        <div class="col">
                            <input type="text" placeholder="아이디">
                            <br>
                            <input type="text" placeholder="이메일">
                        </div>
                        <div class="col"></div>
                    </div>
                    <div class="row pt-3">
                        <div class="mb-4 pagination justify-content-center">
                            <button type="button" class="btn btn-success mr-3">비밀번호 검색</button>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>
        

    </div>
    <!-- Close Find -->
</template>

<script>
export default {
    name: 'MemberFind',
}
</script>

<style>
    
</style>