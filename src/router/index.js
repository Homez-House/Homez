import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

import About from '@/components/About.vue';
import House from '@/components/House.vue';
import Login from '@/components/Login.vue';
import MainContent from '@/components/MainContent.vue';
import MemberFind from '@/components/MemberFind.vue';
import Mypage from '@/components/Mypage.vue';
import Notice from '@/components/Notice.vue';
import Signup from '@/components/Signup.vue';

export default new VueRouter({
  routes: [
    { path: '/', name: 'MainContent', component: MainContent },
    { path: '/about', name: 'About', component: About },
    { path: '/notice', name: 'Notice', component: Notice },
    { path: '/house', name: 'House', component: House },
    { path: '/login', name: 'Login', component: Login },
    { path: '/find', name: 'MemberFind', component: MemberFind },
    { path: '/mypage', name: 'Mypage', component: Mypage },
    { path: '/signup', name: 'Signup', component: Signup }
  ],
});
