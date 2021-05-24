import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

// action, axios 작업할 때 주석 풀기
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
      isOwner: true,
    },
  },
  mutations: {
    // state 변경
    SET_LOGIN(state, payload) {
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

    SET_NOTICE_LIST(state, list) {
      state.notice.list = list;
    },

    SET_NOTICE_TOTAL_LIST_ITEM_COUNT(state, count) {
      state.notice.totalListItemCount = count;
    },

    SET_NOTICE_MOVE_PAGE(state, pageIndex) {
      state.notice.offset = (pageIndex - 1) * state.notice.listRowCount;
      state.notice.currentPageIndex = pageIndex;
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
