<template>
  <div class="container pt-5">
    <div class="text-center mb-5">
      <h2>관리자 화면</h2>
    </div>
    <div class="row">
      <div class="col mb-5" style="overflow: auto; width: 100%; height: 450px">
        <table class="table mt">
          <thead>
            <tr class="text-center">
              <th>회원구분</th>
              <th>아이디</th>
              <th>이메일</th>
              <th>이름</th>
              <th>성별</th>
              <th>연령대</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(memberdata, index) in memberList" :key="index">
              <td class="text-center">{{ memberdata.memberType }}</td>
              <td class="text-center">{{ memberdata.memberId }}</td>
              <td>{{ memberdata.memberEmail }}</td>
              <td class="text-center">{{ memberdata.memberName }}</td>
              <td class="text-center">{{ memberdata.memberGender }}</td>
              <td class="text-center">{{ memberdata.memberAge }}</td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="col">
        <div id="app" class="text-center">
          <div id="nav" class="mb-3">
            <router-link to="/register">신규 가입</router-link> |
            <router-link to="/ageChart">나이 분포</router-link> |
            <router-link to="/genderChart">성별 비율</router-link>
          </div>
        </div>
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: "Admin",
  data() {
    return {
      memberList: [],

      memberTypeList: [],
      memberGenderList: [],
      memberAgeList: [],

      // 원하는 값이 정상적으로 모두 업데이트가 되었는지 확인하는 변수
      isMemberList: false,
      isMemberTypeList: false,
      isMemberGenderList: false,
      isMemberAgeList: false,
    };
  },
  methods: {
    // 각 공통코드 자리에 값을 업데이트한다.
    memberListModify() {
      this.memberList.forEach((oneMember) => {
        this.memberTypeList.forEach((oneType) => {
          if (oneMember.memberType === oneType.code)
            oneMember.memberType = oneType.codeName;
        });

        this.memberGenderList.forEach((oneGender) => {
          if (oneMember.memberGender === oneGender.code)
            oneMember.memberGender = oneGender.codeName;
        });

        this.memberAgeList.forEach((oneAge) => {
          if (oneMember.memberAge === oneAge.code)
            oneMember.memberAge = oneAge.codeName;
        });
      });
    },
  },
  computed: {
    // 변동사항을 확인해 현재 리스트 값이 모두 업데이트 되면 true 반환
    isAllCheck: function () {
      if (
        this.isMemberList &&
        this.isMemberTypeList &&
        this.isMemberGenderList &&
        this.isMemberAgeList
      ) {
        this.memberListModify();
        return true;
      } else return false;
    },
  },
  created() {
    // 회원 정보 호출
    http.get("/member").then(({ data }) => {
      this.memberList = data;
      this.isMemberList = true;
    });

    // 회원 구분(001)에 따라 값 저장
    http.get("/codes", { params: { groupCode: "001" } }).then(({ data }) => {
      this.memberTypeList = data;
      this.isMemberTypeList = true;
    });

    // 회원 성별(002)에 따라 값 저장
    http.get("/codes", { params: { groupCode: "002" } }).then(({ data }) => {
      this.memberGenderList = data;
      this.isMemberGenderList = true;
    });

    // 회원 연령대(003)에 따라 값 저장
    http.get("/codes", { params: { groupCode: "003" } }).then(({ data }) => {
      this.memberAgeList = data;
      this.isMemberAgeList = true;
      this.memberListModify();
      // 가장 마지막에 끝나면 001~003에 따라 회원 정보를 업데이트
    });
  },
};
</script>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  //text-align: center;
  color: #2c3e50;
}

#nav {
  // padding: 30px 30px 60px;

  a {
    font-weight: bold;
    color: #2c3e50;
    text-decoration: none;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
