import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

// for bootstrap 5
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
