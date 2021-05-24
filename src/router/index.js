import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

import MainContent from '@/components/MainContent.vue';

export default new VueRouter({
  routes: [
    {path:'/',name:'MainContent', component:MainContent}
  ],
});
