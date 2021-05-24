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
        class="align-self-center collapse navbar-collapse flex-fill d-lg-flex justify-content-lg-between"
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
          <router-link
            to="/login"
            class="nav-icon position-relative text-decoration-none"
          >
            <i class="fas fa-sign-in-alt"></i>
            <span
              class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"
            ></span>
          </router-link>
          <router-link
            to="/signup"
            class="nav-icon position-relative text-decoration-none"
          >
            <i class="fas fa-user-plus"></i>
            <span
              class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark"
            ></span>
          </router-link>
        </div>
      </div>
    </div>
  </nav>
  <!-- Close Header -->
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style>
</style>