<template>
  <div class="container">
    <h2 class="text-center my-5">공지사항</h2>

    <div class="table-div" style="min-height: 450px">
      <table class="table mt text-center table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">글쓴이</th>
            <th scope="col">제목</th>
            <th scope="col">작성일</th>
            <th scope="col">조회수</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="(notice, index) in listGetters"
            @click="noticeDetail(notice.noticeNo, notice.noticeAuthor)"
            v-bind:key="index"
            style="cursor: pointer"
          >
            <td>{{ notice.noticeNo }}</td>
            <td>{{ notice.noticeAuthor }}</td>
            <td>{{ notice.noticeTitle }}</td>
            <td>{{ notice.noticeRegdate }}</td>
            <td>{{ notice.noticeReadCnt }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <pagination v-on:call-parent="movePage"></pagination>

    <div class="d-flex justify-content-center my-5">
      <input
        v-model="$store.state.notice.searchWord"
        @keydown.enter="noticeList"
        type="text"
        class="col-4 mx-2"
        placeholder="검색할 제목을 입력해주세요."
      />
      <button @click="noticeList" class="col-1 btn-success btn me-4">
        검색
      </button>
      <button class="btn btn-success" @click="showInsertModal">글작성</button>
    </div>

    <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
    <!-- props 제거 -->
    <detail-modal
      v-on:call-parent-change-to-update="changeToUpdate"
      v-on:call-parent-change-to-delete="changeToDelete"
    ></detail-modal>
    <update-modal v-on:call-parent-update="closeAfterUpdate"></update-modal>
  </div>
</template>

<script>
import InsertModal from "./modals/InsertModal.vue";
import DetailModal from "./modals/DetailModal.vue";
import UpdateModal from "./modals/UpdateModal.vue";
import Pagination from "./Pagination.vue";

import { Modal } from "bootstrap";
import http from "@/common/axios.js";
import util from "@/common/util.js";

import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);

export default {
  name: "Notice",
  components: { InsertModal, DetailModal, UpdateModal, Pagination },
  data() {
    return {
      // modal
      insertModal: null,
      detailModal: null,
      updateModal: null,
    };
  },
  computed: {
    listGetters() {
      return this.$store.getters.getNoticeList;
    },
    formatDate: function () {
      let $this = this;
      // store 사용
      return this.$store.state.board.list.map(function (board) {
        return $this.makeDateStr(
          board.regDt.date.year,
          board.regDt.date.month,
          board.regDt.date.day,
          "."
        );
      });
    },
  },
  methods: {
    noticeList() {
      this.$store.dispatch("noticeList");
    },

    //pagination
    movePage(pageIndex) {
      console.log("BoardMainVue : movePage : pageIndex : " + pageIndex);
      this.$store.commit("SET_NOTICE_MOVE_PAGE", pageIndex);

      this.noticeList();
    },
    makeDateStr: util.makeDateStr,
    // insert
    showInsertModal() {
      this.insertModal.show();
    },

    closeAfterInsert() {
      this.insertModal.hide();
      this.noticeList();
    },
    //detail
    noticeDetail(noticeNo, noticeAuthor) {
      http
        .get("/notice/" + noticeNo, {
          params: {
            noticeAuthor: noticeAuthor,
          },
        })
        .then(({ data }) => {
          console.log("DetailModalVue: data: ", data);

          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            this.$store.commit("SET_NOTICE_DETAIL", {
              noticeNo: data.noticeDto.noticeNo,
              noticeAuthor: data.noticeDto.noticeAuthor,
              noticeTitle: data.noticeDto.noticeTitle,
              noticeContent: data.noticeDto.noticeContent,
              noticeRegdate: data.noticeDto.noticeRegdate,
              noticeReadCnt: data.noticeDto.noticeReadCnt,
              fileList: data.noticeDto.fileList,
              isOwner: data.isOwner,
            });
            this.detailModal.show();
          }
        })
        .catch((error) => {
          console.log("DetailModalVue: error ", error);
        });
    },

    changeToUpdate() {
      this.detailModal.hide();
      this.updateModal.show();
    },

    closeAfterUpdate() {
      this.updateModal.hide();
      this.noticeList();
    },

    changeToDelete() {
      this.detailModal.hide();
      var $this = this;
      this.$alertify.confirm(
        "이 글을 삭제하시겠습니까?",
        function () {
          $this.noticeDelete();
        },
        function () {
          console.log("cancle");
        }
      );
    },

    noticeDelete() {
      console.log(">>>>>>>>>>>>>>>>>>>>>>" + this.$store.state.notice.noticeNo);
      http
        .delete("/notice/" + this.$store.state.notice.noticeNo)
        .then(({ data }) => {
          console.log("noticeMainVue: data : ", data);
          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            this.noticeList();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
  created() {
    this.noticeList();
  },
  mounted() {
    this.insertModal = new Modal(document.getElementById("insertModal"));
    this.detailModal = new Modal(document.getElementById("detailModal"));
    this.updateModal = new Modal(document.getElementById("updateModal"));
  },
};
</script>

<style></style>
