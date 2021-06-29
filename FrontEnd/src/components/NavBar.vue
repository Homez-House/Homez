<template>
  <!-- Header -->
  <nav class="navbar navbar-expand-lg navbar-light shadow">
    <div class="container d-flex justify-content-between align-items-center">
      <router-link
        to="/"
        class="navbar-brand text-success logo h1 align-self-center"
      >
        Homez
      </router-link>

      <button
        class="navbar-toggler border-0"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#templatemo_main_nav"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>

      <div
        class="
          align-self-centerr
          collapse
          navbar-collapse
          flex-fill
          d-lg-flex
          justify-content-lg-between
        "
        id="templatemo_main_nav"
      >
        <div class="flex-fill">
          <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
            <li class="nav-item">
              <router-link to="/about" class="nav-link">소개</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/notice" class="nav-link">공지사항</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/house" class="nav-link">주택 검색</router-link>
            </li>
          </ul>
        </div>
        <div class="navbar align-self-center d-flex">
          <div class="d-lg-none flex-sm-fill mt-3 mb-4 col-7 col-sm-auto pr-3">
            <div class="input-group"></div>
          </div>
          <div v-if="$store.state.login.isLogin">
            <a
              class="nav-icon position-relative text-decoration-none pointer"
              @click="logout"
              href=""
            >
              <i class="fas fa-sign-out-alt"></i>
              <span
                class="
                  position-absolute
                  top-0
                  left-100
                  translate-middle
                  badge
                  rounded-pill
                  bg-light
                  text-dark
                "
              ></span>
            </a>
            <router-link
              class="nav-icon position-relative text-decoration-none"
              to="/mypage"
              v-if="$store.state.login.memberType === '002'"
            >
              <i class="fas fa-address-card"></i>
              <span
                class="
                  position-absolute
                  top-0
                  left-100
                  translate-middle
                  badge
                  rounded-pill
                  bg-light
                  text-dark
                "
              ></span>
            </router-link>
            <router-link
              to="/admin"
              class="nav-icon position-relative text-decoration-none"
              v-if="$store.state.login.memberType === '001'"
            >
              <i class="fas fa-users-cog"></i>
              <span
                class="
                  position-absolute
                  top-0
                  left-100
                  translate-middle
                  badge
                  rounded-pill
                  bg-light
                  text-dark
                "
              ></span>
            </router-link>
          </div>
          <div v-else>
            <router-link
              to="/login"
              class="nav-icon position-relative text-decoration-none"
            >
              <i class="fas fa-sign-in-alt"></i>
              <span
                class="
                  position-absolute
                  top-0
                  left-100
                  translate-middle
                  badge
                  rounded-pill
                  bg-light
                  text-dark
                "
              ></span>
            </router-link>
            <router-link
              to="/signup"
              class="nav-icon position-relative text-decoration-none"
            >
              <i class="fas fa-user-plus"></i>
              <span
                class="
                  position-absolute
                  top-0
                  left-100
                  translate-middle
                  badge
                  rounded-pill
                  bg-light
                  text-dark
                "
              ></span>
            </router-link>
          </div>
        </div>
      </div>
    </div>
  </nav>
  <!-- Close Header -->
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: "NavBar",
  methods: {
    logout() {
      http.get("/logout").then(({ data }) => {
        console.log("Logout : " + data);
      });
    },
  },
};
</script>

<style scoped>
/* General */
.logo {
  font-weight: 500 !important;
}
.text-warning {
  color: #ede861 !important;
}
.text-muted {
  color: #bcbcbc !important;
}
.text-success {
  color: #59ab6e !important;
}
.text-light {
  color: #cfd6e1 !important;
}
.bg-dark {
  background-color: #212934 !important;
}
.bg-light {
  background-color: #e9eef5 !important;
}
.bg-black {
  background-color: #1d242d !important;
}
.bg-success {
  background-color: #59ab6e !important;
}
.btn-success {
  background-color: #59ab6e !important;
  border-color: #56ae6c !important;
}
.pagination .page-link:hover {
  color: #000;
}
.pagination .page-link:hover,
.pagination .page-link.active {
  background-color: #69bb7e;
  color: #fff;
}
</style>
