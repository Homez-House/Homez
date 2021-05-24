<template>
  <div class="modal" tabindex="-1" id="insertModal">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">글 작성</h5>
          <button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></button>
        </div>
        <div class="modal-body">
          <div class="mb-3">
            <input
              v-model="title"
              type="text"
              class="form-control"
              placeholder="제목"
            />
          </div>
          <div class="mb-3">
            <div id="divEditorInsert"></div>
          </div>
          <div class="form-check mb-3">
            <input
              v-model="attachFile"
              class="form-check-input"
              type="checkbox"
              value=""
              id="chkFileUploadInsert"
            />
            <label class="form-check-label" for="chkFileUploadInsert"
              >파일 추가</label
            >
          </div>
          <div class="mb-3" v-show="attachFile" id="imgFileUploadInsertWrapper">
            <input
              @change="changeFile"
              type="file"
              id="inputFileUploadInsert"
              multiple
            />
            <div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper">
              <!-- vue way img 를 만들어서 append 하지 않고, v-for 로 처리 -->
              <img
                v-for="(file, index) in fileList"
                v-bind:src="file"
                v-bind:key="index"
              />
            </div>
          </div>
        </div>
        <div class="modal-footer">
          <button
            @click="noticeInsert"
            class="btn btn-sm btn-primary btn-outline"
            data-dismiss="modal"
            type="button"
          >
            등록
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Vue from "vue";
import CKEditor from "@ckeditor/ckeditor5-vue2";
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import VueAlertify from "vue-alertify";

Vue.use(CKEditor).use(VueAlertify);

import http from "@/common/axios.js";

export default {
  name: "InsertModal",
  data() {
    return {
      title: "",
      CKEditor: "",
      attachFile: false,
      fileList: [],
    };
  },
  methods: {
    initUI() {
      this.title = "";
      this.CKEditor.setData("");
      this.attachFile = false;
      this.fileList = [];
      document.querySelector("#inputFileUploadInsert").value = "";
    },
    changeFile(fileEvent) {
      if (fileEvent.target.files && fileEvent.target.files.length > 0) {
        for (var i = 0; i < fileEvent.target.files.length; i++) {
          const file = fileEvent.target.files[i];
          this.fileList.push(URL.createObjectURL(file));
        }
      }
    },
    noticeInsert() {
      var formData = new FormData();
      formData.append("noticeTitle", this.title);
      formData.append("noticeContent", this.CKEditor.getData());

      // file upload
      var attachFiles = document.querySelector("#inputFileUploadInsert");
      console.log("InsertModalVue: data 1: ");
      console.log(attachFiles);

      var cnt = attachFiles.files.length;
      for (var i = 0; i < cnt; i++) {
        formData.append("file", attachFiles[i]);
      }

      http
        .post("/notice", formData, {
          headers: { "Content-Type": "multipart/form-data" },
        })
        .then(({ data }) => {
          console.log("InsertModalVue: data : ");
          console.log(data);
          if (data.result == "login") {
            this.$router.push("/login");
          } else {
            this.$alertify.success("글이 등록되었습니다.");
            this.closeModal();
          }
        })
        .catch((error) => {
          console.log("InsertModalVue: error ");
          console.log(error);
        });
    },
    closeModal() {
      this.$emit("call-parent-insert");
    },
  },
  mounted() {
    ClassicEditor.create(document.querySelector("#divEditorInsert"))
      .then((editor) => {
        this.CKEditor = editor;
      })
      .catch((err) => {
        console.log(err.stack);
      });
    let $this = this;
    this.$el.addEventListener("show.bs.modal", function () {
      $this.initUI();
    });
  },
};
</script>

<style>
.ck-editor__editable {
  min-height: 300px !important;
}

.thumbnail-wrapper {
  margin-top: 5px;
}

.thumbnail-wrapper img {
  width: 100px !important;
  margin-right: 5px;
  max-width: 100%;
}
</style>
