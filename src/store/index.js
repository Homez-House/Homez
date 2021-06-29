import Vue from "vue";
import Vuex from "vuex";

// vuex를 사용하기 위한 코드
Vue.use(Vuex);

// axios import
import http from "@/common/axios.js";
import router from "@/router";

export default new Vuex.Store({
  state: {
    login: {
      isLogin: false,
      memberId: "",
      memberName: "",
      memberPwd: "",
      memberEmail: "",
      memberInterestArea: "",
      memberJoindate: "",
      memberProfile: "",
      memberGender: "",
      memberAge: "",
      memberType: "",
    },
    notice: {
      // list
      list: [],
      limit: 10,
      offset: 0,
      searchWord: "",

      // pagination
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,

      totalListItemCount: 0,

      // detail, update, delete
      noticeNo: 0,
      noticeTitle: "",
      noticeContent: "",
      noticeAuthor: "",
      noticeRegdate: {},
      noticeReadCnt: 0,
      fileList: [],
      isOwner: false,
    },
    house: {
      list: [],
      limit: 10,
      offset: 0,
      listRowCount: 10,
      pageLinkCount: 10,
      currentPageIndex: 1,
      totalListItemCount: 0,
    },
  },
  mutations: {
    // state 변경
    SET_LOGIN(state, payload) {
      console.log("LOGIN 진행");
      state.login.isLogin = payload.isLogin;
      state.login.memberId = payload.memberId;
      state.login.memberName = payload.memberName;
      state.login.memberPwd = payload.memberPwd;
      state.login.memberEmail = payload.memberEmail;
      state.login.memberInterestArea = payload.memberInterestArea;
      state.login.memberJoindate = payload.memberJoindate;
      state.login.memberProfile = payload.memberProfile;
      state.login.memberGender = payload.memberGender;
      state.login.memberAge = payload.memberAge;
      state.login.memberType = payload.memberType;
    },

    SET_UPDATE(state, payload) {
      console.log("UPDATE 진행");
      console.log(payload.memberPwd);
      state.login.memberName = payload.memberName;
      state.login.memberPwd = payload.memberPwd;
      state.login.memberEmail = payload.memberEmail;
      state.login.memberInterestArea = payload.memberInterestArea;
      state.login.memberProfile = payload.memberProfile;
      state.login.memberGender = payload.memberGender;
      state.login.memberAge = payload.memberAge;
    },

    SET_NOTICE_LIST(state, list) {
      state.notice.list = list;
    },

    SET_HOUSE_LIST(state, list) {
      state.house.list = list;
    },

    SET_NOTICE_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.notice.totalListItemCount = count;
    },

    SET_HOUSE_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.house.totalListItemCount = count;
    },
    SET_HOUSE_CURRENT_PAGE(state, idx) {
      state.house.currentPageIndex = idx;
    },

    SET_NOTICE_MOVE_PAGE(state, pageIndex) {
      state.notice.offset = (pageIndex - 1) * state.notice.listRowCount;
      state.notice.currentPageIndex = pageIndex;
    },
    SET_HOUSE_MOVE_PAGE(state, pageIndex) {
      state.house.offset = (pageIndex - 1) * state.house.listRowCount;
      state.house.currentPageIndex = pageIndex;
    },
    SET_HOUSE_LIMIT(state, payload) {
      state.house.limit =
        10 -
        (payload.pageIndex * 10 > payload.length ? payload.pageIndex * 10 - payload.length : 0);
      console.log(payload.pageIndex * 10 + "=====" + payload.length);
      console.log(state.house.limit);
    },
    SET_NOTICE_DETAIL(state, payload) {
      state.notice.noticeNo = payload.noticeNo;
      state.notice.noticeTitle = payload.noticeTitle;
      state.notice.noticeContent = payload.noticeContent;
      state.notice.noticeAuthor = payload.noticeAuthor;
      state.notice.noticeRegdate = payload.noticeRegdate;
      state.notice.noticeReadCnt = payload.noticeReadCnt;
      state.notice.fileList = payload.fileList;
      state.notice.isOwner = payload.isOwner;
    },
  },
  actions: {
    noticeList(context) {
      http
        .get("/notice", {
          // get query string
          params: {
            noticeLimit: this.state.notice.limit,
            noticeOffset: this.state.notice.offset,
            noticeSearchWord: this.state.notice.searchWord,
          },
        })
        .then(({ data }) => {
          console.log("noticeMainVue: data : ");
          console.log(data);
          if (data.result == "login") {
            router.push("/login");
          } else {
            context.commit("SET_NOTICE_LIST", data.noticeList);
            context.commit("SET_NOTICE_TOTAL_LIST_ITEM_COUNT", data.noticeCount);
          }
        });
    },
  },
  modules: {},
  getters: {
    isLogin: function (state) {
      return state.login.isLogin;
    },
    getNoticeList: function (state) {
      return state.notice.list;
    },
  },
});
