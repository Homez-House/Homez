import Vue from "vue";
import VueRouter from "vue-router";

// vue에서 router를 쓰기 위한 코드
Vue.use(VueRouter);

// vue import
import About from "@/components/About.vue";
import Admin from "@/components/Admin.vue";
import House from "@/components/House.vue";
import Login from "@/components/Login.vue";
import MainContent from "@/components/MainContent.vue";
import MemberFind from "@/components/MemberFind.vue";
import Mypage from "@/components/Mypage.vue";
import MypageModify from "@/components/MypageModify.vue";
import Notice from "@/components/Notice.vue";
import Signup from "@/components/Signup.vue";

// routes 설계
export default new VueRouter({
  routes: [
    { path: "/", name: "MainContent", component: MainContent },
    { path: "/about", name: "About", component: About },
    {
      // nest-route 구조
      path: "/admin",
      name: "Admin",
      component: Admin,
      children: [
        {
          path: "/",
          name: "defulat",
          component: () => import("../components/chart/DefulatChart.vue"),
        },
        {
          path: "/register",
          name: "register",
          component: () => import("../components/chart/LineChart.vue"),
        },
        {
          path: "/ageChart",
          name: "ageChart",
          component: () => import("../components/chart/BarChart.vue"),
        },
        {
          path: "/genderChart",
          name: "genderChart",
          component: () => import("../components/chart/PieChart.vue"),
        },
      ],
    },
    { path: "/notice", name: "Notice", component: Notice },
    { path: "/house", name: "House", component: House },
    { path: "/login", name: "Login", component: Login },
    { path: "/find", name: "MemberFind", component: MemberFind },
    { path: "/mypage", name: "Mypage", component: Mypage },
    { path: "/modify", name: "MypageModify", component: MypageModify },
    { path: "/signup", name: "Signup", component: Signup },
  ],
});
