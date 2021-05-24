<template>
  <div id="app">
    <top-nav></top-nav>
    <nav-bar></nav-bar>
    <router-view></router-view>
    <footer-bar></footer-bar>
  </div>
</template>

<script>
import TopNav from './components/TopNav.vue';
import NavBar from './components/NavBar.vue';
import FooterBar from './components/FooterBar.vue';

export default {
  name: 'App',
  components :{
    TopNav,
    NavBar,
    FooterBar,
  },
}
</script>

<style>
    @import "./assets/css/bootstrap.min.css";
    @import "./assets/css/custom.css";
    @import "./assets/css/fontawesome.css";
    @import "./assets/css/fontawesome.min.css";
    @import "./assets/css/slick-theme.css";
    @import "./assets/css/slick-theme.min.css";
    @import "./assets/css/slick.min.css";
    @import "./assets/css/templatemo.css";
    @import "./assets/css/templatemo.min.css";
</style>
