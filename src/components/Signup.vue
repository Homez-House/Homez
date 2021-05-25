<template>
    <!-- Sing-up -->
    <div class="container pb-5">
        <div style="height: 100px;"></div>
        <div class="row mb-3 pr-0 text-center">
                <h2>회원 가입</h2>
                <br><br><br>
                <img class="mx-auto d-block" style="width:300px;" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iaXNvLTg4NTktMSI/Pg0KPCEtLSBHZW5lcmF0b3I6IEFkb2JlIElsbHVzdHJhdG9yIDE5LjAuMCwgU1ZHIEV4cG9ydCBQbHVnLUluIC4gU1ZHIFZlcnNpb246IDYuMDAgQnVpbGQgMCkgIC0tPg0KPHN2ZyB2ZXJzaW9uPSIxLjEiIGlkPSJDYXBhXzEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4Ig0KCSB2aWV3Qm94PSIwIDAgNTEyIDUxMiIgc3R5bGU9ImVuYWJsZS1iYWNrZ3JvdW5kOm5ldyAwIDAgNTEyIDUxMjsiIHhtbDpzcGFjZT0icHJlc2VydmUiPg0KPHBhdGggc3R5bGU9ImZpbGw6IzQ3NTA5NjsiIGQ9Ik01MTIsMjU2YzAsMjQuNTg2LTMuNDY5LDQ4LjM1OC05LjkzNyw3MC44NjVjLTMuNTExLDEyLjE4NC03Ljg3OSwyMy45OTEtMTMuMDcyLDM1LjM1OQ0KCWMtNC4wMTIsOC43ODgtOC41MTYsMTcuMzE0LTEzLjQ1OCwyNS41MjdjLTIuOTQ3LDQuOTExLTYuMDYsOS43MDctOS4zMzEsMTQuMzk5QzQxOS45NjUsNDY4LjU0MywzNDMuMDUsNTEyLDI1Niw1MTINCglTOTIuMDM1LDQ2OC41NDMsNDUuNzk4LDQwMi4xNWMtMy4yNzEtNC42ODEtNi4zNzQtOS40NzctOS4zMzEtMTQuMzg4Yy00Ljk0Mi04LjIyMy05LjQ0Ni0xNi43Ni0xMy40NjktMjUuNTU4DQoJYy01LjE4My0xMS4zNjgtOS41NjEtMjMuMTY1LTEzLjA2MS0zNS4zMzhDMy40NjksMzA0LjM1OCwwLDI4MC41ODYsMCwyNTZzMy40NjktNDguMzU4LDkuOTM3LTcwLjg2NQ0KCWMzLjUtMTIuMTczLDcuODc5LTIzLjk4LDEzLjA2MS0zNS4zMjhjNC4xOC05LjE2NCw4Ljg4Mi0xOC4wMjQsMTQuMDc1LTI2LjU2MWMyLjkzNi00LjgzOCw2LjAyOS05LjU2MSw5LjI2OC0xNC4xNzkNCglDOTIuNjUxLDQzLjExMiwxNjkuMjg0LDAsMjU2LDBzMTYzLjM0OSw0My4xMTIsMjA5LjY1OSwxMDkuMDY2YzMuMjM5LDQuNjE4LDYuMzMyLDkuMzQxLDkuMjY4LDE0LjE3OQ0KCWM1LjE5Myw4LjUyNiw5Ljg4NSwxNy4zODcsMTQuMDY0LDI2LjU0YzUuMTkzLDExLjM1OCw5LjU3MSwyMy4xNjUsMTMuMDcyLDM1LjM0OUM1MDguNTMxLDIwNy42NDIsNTEyLDIzMS40MTQsNTEyLDI1NnoiLz4NCjxwYXRoIHN0eWxlPSJmaWxsOiM2OTc4QzY7IiBkPSJNNDU5LjU4NSwyMDMuNTg2YzAsNDYuOTU4LTE1Ljg5Niw5MC4yMDEtNDIuNjA0LDEyNC42NDRjLTM3LjI0Myw0OC4wMy05NS41MDMsNzguOTQxLTE2MC45ODIsNzguOTQxDQoJUzEzMi4yNjEsMzc2LjI1OSw5NS4wMTcsMzI4LjIzYy0yNi43MDctMzQuNDQzLTQyLjYwNC03Ny42ODYtNDIuNjA0LTEyNC42NDRDNTIuNDE1LDkxLjE0OSwxNDMuNTYzLDAuMDAxLDI1NiwwLjAwMQ0KCVM0NTkuNTg1LDkxLjE0OSw0NTkuNTg1LDIwMy41ODZ6Ii8+DQo8cGF0aCBzdHlsZT0iZmlsbDojRjc0QzgzOyIgZD0iTTM4NS43MDIsMTY3LjQyMUwyNTUuOTk3LDIzLjQ4TDEyNi4yOTEsMTY3LjQyMWwtNy43NjMtNi45OTVMMjUyLjExNiwxMi4xNzgNCgljMC45OTEtMS4wOTksMi40MDEtMS43MjcsMy44ODEtMS43MjdjMS40OCwwLDIuODksMC42MjgsMy44ODEsMS43MjdsMTMzLjU4NywxNDguMjQ4TDM4NS43MDIsMTY3LjQyMXoiLz4NCjxwYXRoIHN0eWxlPSJmaWxsOiNGRkQyNTU7IiBkPSJNNTAyLjA2MywxNDIuOXYxODMuOTY1Yy03LjgyNiwyNy4yMy0yMC4wNTIsNTIuNi0zNS44NjEsNzUuMjg1SDQ1Ljc5OA0KCWMtMTUuODA5LTIyLjY4NS0yOC4wMzUtNDguMDU1LTM1Ljg2MS03NS4yODVWMTQyLjljMC0xOC42ODMsMTUuMTUxLTMzLjgzNCwzMy44MzQtMzMuODM0aDQyNC40NDgNCglDNDg2LjkxMiwxMDkuMDY2LDUwMi4wNjMsMTI0LjIxNyw1MDIuMDYzLDE0Mi45eiIvPg0KPHBhdGggc3R5bGU9ImZpbGw6I0YyOTczRDsiIGQ9Ik00NzQuOTI3LDEyMy4yNDZjLTIuMS0wLjczMS00LjM2OC0xLjExOC02LjcwOC0xLjExOEg0My43NzFjLTIuMzQxLDAtNC41OTgsMC4zODctNi42OTgsMS4xMTgNCgljLTguMTgyLDIuNzktMTQuMDc1LDEwLjU0My0xNC4wNzUsMTkuNjU1djIxOS4zMDNjNC4wMjMsOC43OTgsOC41MjYsMTcuMzM1LDEzLjQ2OSwyNS41NThjMi4yNzgsMC44NTcsNC43MzMsMS4zMjcsNy4zMDQsMS4zMjcNCgloNDI0LjQ0OGMyLjU3LDAsNS4wMzYtMC40Nyw3LjMxNC0xLjMzN2M0Ljk0Mi04LjIxMyw5LjQ0Ni0xNi43MzksMTMuNDU4LTI1LjUyN1YxNDIuOQ0KCUM0ODguOTkxLDEzMy43ODksNDgzLjEwOSwxMjYuMDM2LDQ3NC45MjcsMTIzLjI0NnogTTQ3My4zMTgsMzY4LjMxNmMwLDIuODExLTIuMjc4LDUuMDk5LTUuMDk5LDUuMDk5SDQzLjc3MQ0KCWMtMi44MTEsMC01LjA5OS0yLjI4OC01LjA5OS01LjA5OVYxNDIuOWMwLTIuODExLDIuMjg4LTUuMDk5LDUuMDk5LTUuMDk5aDQyNC40NDhjMi44MjEsMCw1LjA5OSwyLjI4OCw1LjA5OSw1LjA5OVYzNjguMzE2eiIvPg0KPHBhdGggc3R5bGU9ImZpbGw6I0Y3RUZDNjsiIGQ9Ik00MTQuNDM4LDE3MS45NzNoLTQ0Ljk2OWgtNDQuOTY5SDI3OS41M2gtNDQuOTY5aC00NC45NjloLTQ0Ljk2OWgtNDQuOTdINzUuNzMNCgljLTExLjYyMywwLTIxLjA0Niw5LjQyMy0yMS4wNDYsMjEuMDQ2djEwMi43NTRjMCwxMi40MTgsMTAuMDY3LDIyLjQ4NCwyMi40ODQsMjIuNDg0bDAsMGMxMi40MTgsMCwyMi40ODQtMTAuMDY3LDIyLjQ4NC0yMi40ODQNCgl2LTE0LjI0MmMwLTEyLjQxOCwxMC4wNjctMjIuNDg0LDIyLjQ4NC0yMi40ODRsMCwwYzEyLjQxOCwwLDIyLjQ4NCwxMC4wNjcsMjIuNDg0LDIyLjQ4NHYyLjRjMCwxMi40MTgsMTAuMDY3LDIyLjQ4NCwyMi40ODQsMjIuNDg0DQoJbDAsMGMxMi40MTgsMCwyMi40ODQsMTAuMDY3LDIyLjQ4NCwyMi40ODR2Ny42MjVjMCwxMi40MTgsMTAuMDY3LDIyLjQ4NCwyMi40ODQsMjIuNDg0bDAsMGMxMi40MTgsMCwyMi40ODQtMTAuMDY3LDIyLjQ4NC0yMi40ODQNCgl2LTQ4LjAyOGMwLTEyLjQxOCwxMC4wNjctMjIuNDg0LDIyLjQ4NC0yMi40ODRsMCwwYzEyLjQxOCwwLDIyLjQ4NCwxMC4wNjcsMjIuNDg0LDIyLjQ4NFYzMTEuMQ0KCWMwLDEyLjQxOCwxMC4wNjcsMjIuNDg0LDIyLjQ4NCwyMi40ODRsMCwwYzEyLjQxOCwwLDIyLjQ4NC0xMC4wNjcsMjIuNDg0LTIyLjQ4NHYtMi40MDFjMC0xMi40MTgsMTAuMDY3LTIyLjQ4NCwyMi40ODQtMjIuNDg0bDAsMA0KCWMxMi40MTgsMCwyMi40ODQsMTAuMDY3LDIyLjQ4NCwyMi40ODR2MjEuNDgzYzAsMTIuNDE4LDEwLjA2NywyMi40ODQsMjIuNDg0LDIyLjQ4NGwwLDBjMTIuNDE4LDAsMjIuNDg0LTEwLjA2NywyMi40ODQtMjIuNDg0DQoJdi0yMy41NzNjMC0xMi40MTgsMTAuMDY3LTIyLjQ4NCwyMi40ODQtMjIuNDg0bDAsMGMxMi40MTgsMCwyMi40ODQtMTAuMDY3LDIyLjQ4NC0yMi40ODR2LTY4LjYyMg0KCWMwLTExLjYyMy05LjQyMy0yMS4wNDYtMjEuMDQ2LTIxLjA0NmgtMjMuOTE0VjE3MS45NzN6Ii8+DQo8Zz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojRkZGRkZGOyIgZD0iTTEzNC43ODMsMjQxLjc4M2MtMS4wMSwyLjk0Ny00Ljc5OSw0LjM3OC04LjY3Miw0LjM3OGMtMy43ODksMC03LjgzLTEuNDMyLTguNTAzLTQuMzc4DQoJCWwtNC4zNzgtMTkuOTU0bC00LjM3OCwxOS45NTRjLTAuNjc0LDIuOTQ3LTQuNzE1LDQuMzc4LTguNTA0LDQuMzc4Yy0zLjg3MywwLTcuNzQ2LTEuNDMyLTguNjcyLTQuMzc4bC0xNi43NTUtNTEuMzU4DQoJCWMtMC4wODQtMC4yNTMtMC4xNjgtMC42NzQtMC4xNjgtMS4wOTVjMC0yLjg2Myw0LjcxNS01LjIyLDguNTAzLTUuMjJjMi4wMjEsMCwzLjcwNSwwLjY3NCw0LjIxLDIuNDQybDEyLjc5OCw0My4xOTJsNi42NTEtMjguNDU4DQoJCWMwLjUwNi0yLjI3NCwzLjQ1Mi0zLjQ1Miw2LjMxNC0zLjQ1MmMyLjg2MywwLDUuODEsMS4xNzksNi4zMTQsMy40NTJsNi42NTIsMjguNDU4bDEyLjc5Ny00My4xOTINCgkJYzAuNTA2LTEuNzY4LDIuMTg5LTIuNDQyLDQuMjEtMi40NDJjMy43ODksMCw4LjUwMywyLjM1Nyw4LjUwMyw1LjIyYzAsMC40MjEtMC4wODQsMC44NDItMC4xNjgsMS4wOTVMMTM0Ljc4MywyNDEuNzgzeiIvPg0KCTxwYXRoIHN0eWxlPSJmaWxsOiNGRkZGRkY7IiBkPSJNMTY5LjY0NiwyMDkuNzg5aDEyLjYyOWMyLjUyNywwLDMuOTU3LDIuNDQyLDMuOTU3LDUuMTM2YzAsMi4yNzQtMS4xNzksNC45NjctMy45NTcsNC45NjdoLTEyLjYyOQ0KCQl2MTQuMzEzaDIyLjU2NGMyLjUyNywwLDMuOTU3LDIuNjk0LDMuOTU3LDUuODFjMCwyLjY5NC0xLjE3OSw1LjY0MS0zLjk1Nyw1LjY0MWgtMjkuOTczYy0yLjg2MiwwLTUuNzI1LTEuMzQ3LTUuNzI1LTQuMDQydi01My40NjMNCgkJYzAtMi42OTQsMi44NjMtNC4wNDIsNS43MjUtNC4wNDJoMjkuOTczYzIuNzc4LDAsMy45NTcsMi45NDcsMy45NTcsNS42NDFjMCwzLjExNi0xLjQzMiw1LjgxLTMuOTU3LDUuODFoLTIyLjU2NFYyMDkuNzg5eiIvPg0KCTxwYXRoIHN0eWxlPSJmaWxsOiNGRkZGRkY7IiBkPSJNMjA3LjYyLDI0NS42NTdjLTIuODYyLDAtNS43MjUtMS4zNDctNS43MjUtNC4wNDJ2LTUzLjU0N2MwLTIuNzc4LDMuMjg0LTMuOTU3LDYuNTY3LTMuOTU3DQoJCWMzLjI4MywwLDYuNTY3LDEuMTc5LDYuNTY3LDMuOTU3djQ2LjEzOWgxOS4xOTZjMi41MjcsMCwzLjc4OSwyLjg2MiwzLjc4OSw1LjcyNWMwLDIuODYyLTEuMjYzLDUuNzI1LTMuNzg5LDUuNzI1TDIwNy42MiwyNDUuNjU3DQoJCUwyMDcuNjIsMjQ1LjY1N3oiLz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojRkZGRkZGOyIgZD0iTTI2My4zNTksMTk1LjU2MWMtNC43OTksMC03LjU3OCwyLjY5NC03LjU3OCw4LjQydjIyLjMxMmMwLDUuNzI1LDIuNzc4LDguNDIsNy42NjEsOC40Mg0KCQljNi43MzUsMCw3LjE1Ni01LjEzNiw3LjQwOS04LjQyYzAuMjUzLTMuMTE1LDMuMTE2LTMuOTU3LDYuNDg0LTMuOTU3YzQuNTQ2LDAsNi42NTEsMS4xNzksNi42NTEsNi4yMzENCgkJYzAsMTEuMTk4LTkuMDkzLDE3LjU5Ny0yMS4xMzMsMTcuNTk3Yy0xMS4wMjksMC0yMC4yMDYtNS4zODktMjAuMjA2LTE5Ljg3di0yMi4zMTJjMC0xNC40ODEsOS4xNzctMTkuODcsMjAuMjA2LTE5Ljg3DQoJCWMxMi4wNCwwLDIxLjEzMyw2LjA2MywyMS4xMzMsMTYuNzU1YzAsNS4wNTItMi4xMDQsNi4yMzEtNi41NjcsNi4yMzFjLTMuNTM2LDAtNi4zOTktMC45MjYtNi41NjctMy45NTcNCgkJQzI3MC43NjksMjAwLjk1LDI3MC41MTYsMTk1LjU2MSwyNjMuMzU5LDE5NS41NjF6Ii8+DQoJPHBhdGggc3R5bGU9ImZpbGw6I0ZGRkZGRjsiIGQ9Ik0yODkuOTY4LDIyNi4yOTFWMjAzLjk4YzAtMTQuNDgxLDkuMDA5LTE5Ljg3LDIwLjYyNy0xOS44N2MxMS42MTgsMCwyMC43MTIsNS4zODksMjAuNzEyLDE5Ljg3DQoJCXYyMi4zMTJjMCwxNC40ODEtOS4wOTMsMTkuODctMjAuNzEyLDE5Ljg3UzI4OS45NjgsMjQwLjc3NCwyODkuOTY4LDIyNi4yOTF6IE0zMTguMTcyLDIwMy45ODFjMC01LjgxLTIuODYyLTguNDItNy41NzgtOC40Mg0KCQljLTQuNzE2LDAtNy40OTMsMi42MS03LjQ5Myw4LjQydjIyLjMxMmMwLDUuODEsMi43NzgsOC40Miw3LjQ5Myw4LjQyczcuNTc4LTIuNjEsNy41NzgtOC40MlYyMDMuOTgxeiIvPg0KCTxwYXRoIHN0eWxlPSJmaWxsOiNGRkZGRkY7IiBkPSJNMzY5LjM2NiwyMjMuODUxYy0xLjA5NCwxLjg1My0yLjc3OCwyLjQ0Mi00LjM3OCwyLjQ0MmMtMS41MTUsMC0zLjExNi0wLjUwNS00LjEyNS0yLjQ0Mg0KCQlsLTcuOTk5LTE0LjY0OXYzMi40MTVjMCwyLjY5NS0zLjI4NCw0LjA0Mi02LjU2Nyw0LjA0MmMtMy4yODMsMC02LjU2Ny0xLjM0Ny02LjU2Ny00LjA0MnYtNTAuOTM4YzAtNC43OTksMy4yODQtNi41NjcsNi41NjctNi41NjcNCgkJYzQuNzE1LDAsNi43MzUsMC41MDYsMTAuMTg4LDYuNTY3bDguNjcyLDE1LjE1NWw4LjY3Mi0xNS4xNTVjMy40NTItNi4wNjEsNS40NzItNi41NjcsMTAuMTg4LTYuNTY3DQoJCWMzLjM2OCwwLDYuNTY3LDEuNzY4LDYuNTY3LDYuNTY3djUwLjkzOGMwLDIuNjk1LTMuMjgzLDQuMDQyLTYuNTY3LDQuMDQycy02LjU2Ny0xLjM0Ny02LjU2Ny00LjA0MnYtMzEuNTczTDM2OS4zNjYsMjIzLjg1MXoiLz4NCgk8cGF0aCBzdHlsZT0iZmlsbDojRkZGRkZGOyIgZD0iTTQxMi44MTUsMjA5Ljc4OWgxMi42MjljMi41MjcsMCwzLjk1NywyLjQ0MiwzLjk1Nyw1LjEzNmMwLDIuMjc0LTEuMTc5LDQuOTY3LTMuOTU3LDQuOTY3aC0xMi42MjkNCgkJdjE0LjMxM2gyMi41NjRjMi41MjcsMCwzLjk1NywyLjY5NCwzLjk1Nyw1LjgxYzAsMi42OTQtMS4xNzksNS42NDEtMy45NTcsNS42NDFoLTI5Ljk3M2MtMi44NjIsMC01LjcyNS0xLjM0Ny01LjcyNS00LjA0MnYtNTMuNDYzDQoJCWMwLTIuNjk0LDIuODYzLTQuMDQyLDUuNzI1LTQuMDQyaDI5Ljk3M2MyLjc3OCwwLDMuOTU3LDIuOTQ3LDMuOTU3LDUuNjQxYzAsMy4xMTYtMS40MzIsNS44MS0zLjk1Nyw1LjgxaC0yMi41NjRWMjA5Ljc4OXoiLz4NCjwvZz4NCjxjaXJjbGUgc3R5bGU9ImZpbGw6I0ZGRDI1NTsiIGN4PSIyNTYiIGN5PSIyNi4xMjIiIHI9IjE1LjIyNCIvPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPGc+DQo8L2c+DQo8Zz4NCjwvZz4NCjxnPg0KPC9nPg0KPC9zdmc+DQo=" />
                <br><br><br>
        </div>
        <br>
        <hr>
        <br>
        <div class="row">
            <div class="col"></div>
            <div class="col-5">
                <div class="row mt-4 mb-4 form-group">
                    <label class="mb-2">로그인 정보 <span style="color:red;">*</span></label>
                    <!-- ID 정보 -->
                    <div>
                        <input v-model="memberId" type="text" class="form-control" placeholder="아이디 : 최소 4글자 이상"
                                :class="{'is-valid':isIDFocusAndValid, 'is-invalid':isIDFocuseAndInvalid }"
                                @input="validateID" @focus="isIDFocus=true"/>
                        <div class="invalid-feedback">올바른 아이디를 입력해 주세요.</div>
                    </div>
                    <div>
                        <input v-model="memberPwd" type="password" class="form-control" placeholder="비밀번호 : 최소 8자 이상"
                                :class="{'is-valid':isPwdFocusAndValid, 'is-invalid':isPwdFocuseAndInvalid }"
                                @input="validatePwd" @focus="isPwdFocus=true"/>
                        <div class="invalid-feedback">올바른 비밀번호를 입력해 주세요.</div>
                    </div>
                    <div>
                        <input v-model="memberPwdMore" type="password" class="form-control" placeholder="비밀번호 확인 : 위와 동일하게 입력"
                                :class="{'is-valid':isPwdMoreFocusAndValid, 'is-invalid':isPwdMoreFocuseAndInvalid }"
                                @input="validatePwdMore" @focus="isPwdMoreFocus=true"/>
                        <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
                    </div>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">프로필 사진</label>
                    <input @change="insertFile" type="file" class="form-control" aria-describedby="inputGroupFileAddon04" aria-label="Upload">
                </div>
                <div class="row mb-4 form-group">
                    <label>이름 <span style="color:red;">*</span></label>
                    <input v-model="memberName" type="text" class="form-control" placeholder="김싸피"
                                :class="{'is-valid':isNameFocusAndValid, 'is-invalid':isNameFocuseAndInvalid }"
                                @input="validateName" @focus="isNameFocus=true"/>
                    <div class="invalid-feedback">이름을 입력하세요.</div>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">성별 <span style="color:red;">*</span></label>
                    <div class="col m-2 form-check form-check-inline" v-for="(code, index) in GenderList" :key="index">
                        <input class="form-check-input" type="radio" :value="code.code" v-model="memberGender">
                        <label class="form-check-label">{{code.codeName}}</label>
                    </div>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">연령대 <span style="color:red;">*</span></label>
                    <div class="col-4 m-2 form-check form-check-inline" v-for="(code, index) in Agelist" :key="index">
                        <input class="form-check-input" type="radio" :value="code.code" v-model="memberAge">
                        <label class="form-check-label">{{code.codeName}}</label>
                    </div>  
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">이메일 <span style="color:red;">*</span></label>
                    <input type="email" class="form-control" placeholder="ex) welcome@gmail.com" v-model="memberEmail" 
                                :class="{'is-valid':isEmailFocusAndValid, 'is-invalid':isEmailFocuseAndInvalid }"
                                @input="validateEmail" @focus="isEmailFocus=true"/>
                    <div class="invalid-feedback">유효한 이메일을 입력하세요.</div>
                </div>
                <div class="row mb-4 form-group">
                    <label class="mb-2">관심지역 <span style="color:red;">*</span></label>
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
                <div class="row justify-content-center">
                    <div class="col text-end">
                        <button type="button" class="btn btn-success" @click="SingUpBtn">가입</button>
                    </div>
                    <div class="col">
                        <button type="button" class="btn btn-secondary">취소</button>
                    </div>
                </div>
            </div>
            <div class="col"></div>
        </div>  
    </div>
    <!-- Close Sing-up -->
</template>

<script>

import http from "@/common/axios.js";

export default {
    name: 'Signup',
    data: function(){
        return {
            // v-model
            memberId: '',
            memberPwd: '',
            memberPwdMore: '',
            memberProfile: null,
            memberName: '',
            memberGender: '',
            memberAge: '',
            memberEmail: '',
            memberInterestArea: '0',
            memberType: '002', // 일반회원 default

            // 공통 코드 리스트
            GenderList: [],
            Agelist: [],

            // 구군 리스트
            GugunList: [],
            DongList: [],
            selectGugun:'0',

            // focus
            isIDFocus: false,
            isPwdFocus: false,
            isPwdMoreFocus: false,
            isNameFocus: false,
            isEmailFocus: false,

            // validation
            isIDValid: false,
            isPwdValid: false,
            isPwdMoreValid: false,
            isNameValid: false,
            isEmailValid: false,
        }
    },computed:{
        isIDFocusAndValid(){
            return this.isIDFocus && this.isIDValid;
        }, isIDFocuseAndInvalid(){
            return this.isIDFocus && ! this.isIDValid;
        }, isPwdFocusAndValid(){
            return this.isPwdFocus && this.isPwdValid;
        }, isPwdFocuseAndInvalid(){
            return this.isPwdFocus && ! this.isPwdValid;
        }, isPwdMoreFocusAndValid(){
            return this.isPwdMoreFocus && this.isPwdMoreValid;
        }, isPwdMoreFocuseAndInvalid(){
            return this.isPwdMoreFocus && ! this.isPwdMoreValid;
        }, isNameFocusAndValid(){
            return this.isNameFocus && this.isNameValid;
        }, isNameFocuseAndInvalid(){
            return this.isNameFocus && ! this.isNameValid;
        }, isEmailFocusAndValid(){
            return this.isEmailFocus && this.isEmailValid;
        }, isEmailFocuseAndInvalid(){
            return this.isEmailFocus && ! this.isEmailValid;
        }
    },methods:{
        validateID(){
            this.isIDValid = this.memberId.length >= 4 ? true : false;
            console.log(this.isIDValid);
        }, validatePwd(){
            this.isPwdValid = this.memberPwd.length >= 8 ? true : false;
            console.log(this.isPwdValid);
        }, validatePwdMore(){
            this.isPwdMoreValid = (this.memberPwd == this.memberPwdMore) ? true : false;
            console.log(this.isPwdMoreValid);
        }, validateName(){
            this.isNameValid = this.memberName.length > 0 ? true : false;
            console.log(this.isNameValid);
        }, validateEmail(){
            let regexp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
            this.isEmailValid = (regexp.test(this.memberEmail)) ? true : false;
            console.log(this.isEmailValid);
        }, insertFile(fileEvent) {
            if( fileEvent.target.files && fileEvent.target.files.length > 0 ){
                for( var i=0; i<fileEvent.target.files.length; i++ ){
                    const file = fileEvent.target.files[i];
                    this.memberProfile = URL.createObjectURL(file);
                    console.log(this.memberProfile);
                }
            }
        }, selectGugunData(event){
            this.memberInterestArea = 0;
            console.log(event.target.value);
            http.get("/gugun/"+this.selectGugun)
            .then(({data})=>{
                this.DongList = data;
                console.log(data);
            })
        }, SingUpBtn(){
            if (!this.isIDValid || !this.isPwdValid || !this.isPwdMoreValid || !this.isNameValid || !this.isEmailValid){
                this.$alertify.alert('회원가입 불가', '유효한 값을 넣었는지 확인해주세요!');
                return;
            } else if (this.memberGender == ''){
                this.$alertify.alert('회원가입 불가', '성별을 체크해주세요!');
                return;
            } else if (this.memberAge == ''){
                this.$alertify.alert('회원가입 불가', '연령대를 체크해주세요!');
                return;
            } else if (this.memberInterestArea == 0){
                this.$alertify.alert('회원가입 불가', '관심지역을 등록해주세요!');
                return;
            }

            http.post("/member", {
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
                console.log("SignUp Success : " + data);
                let $this = this;
                this.$alertify.alert(
                    '회원가입을 축하합니다. 로그인 페이지로 이동합니다',
                    function() {
                        $this.$router.push("/login");
                    }
                );  
            }).catch(error=>{
                console.log("Error : "+error);
                this.$alertify.error('문제가 발생했습니다.');          
            });
        }, 
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

        http.get("/gugun").then(({data})=>{
            console.log(data);
            this.GugunList = data;
        })
    }
}
</script>

<style>
    
</style>