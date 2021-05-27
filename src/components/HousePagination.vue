<template>
  <nav aria-label="Page navigation" class="my-3">
    <ul class="pagination justify-content-center mb-0">
      <li v-if="prev" class="page-item">
        <a
          class="page-link"
          href="#"
          aria-label="Previous"
          @click="paginationChanged(startPageIndex - 1)"
        >
          <span aria-hidden="true">&laquo;</span>
        </a>
      </li>
      <li
        v-for="index in endPageIndex - startPageIndex + 1"
        :key="index"
        v-bind:class="{
          active:
            startPageIndex + index - 1 == $store.state.house.currentPageIndex,
        }"
        class="page-item"
      >
        <a
          @click="paginationChanged(startPageIndex + index - 1)"
          class="page-link"
          href="#"
          >{{ startPageIndex + index - 1 }}</a
        >
        <!-- href 는 그대로, 커서 모양 유지-->
      </li>
      <li v-if="next" class="page-item">
        <a
          class="page-link"
          href="#"
          aria-label="Next"
          @click="paginationChanged(endPageIndex + 1)"
        >
          <span aria-hidden="true">&raquo;</span>
        </a>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "HousePagination",
  // props 사용 X
  // props: ['listRowCount', 'pageLinkCount', 'currentPageIndex', 'totalListItemCount'],
  data() {
    return {};
  },
  computed: {
    pageCount: function () {
      return Math.ceil(
        this.$store.state.house.totalListItemCount /
          this.$store.state.house.listRowCount
      );
    },
    startPageIndex: function () {
      if (
        this.$store.state.house.currentPageIndex %
          this.$store.state.house.pageLinkCount ==
        0
      ) {
        //10, 20...맨마지막
        return (
          (this.$store.state.house.currentPageIndex /
            this.$store.state.house.pageLinkCount -
            1) *
            this.$store.state.house.pageLinkCount +
          1
        );
      } else {
        return (
          Math.floor(
            this.$store.state.house.currentPageIndex /
              this.$store.state.house.pageLinkCount
          ) *
            this.$store.state.house.pageLinkCount +
          1
        );
      }
    },
    endPageIndex: function () {
      // 아래 코드는 Error in render: "RangeError: Maximum call stack size exceeded" 발생, this.endPageIndex 계산 할 때, 자기 자신 값을 단순 비교만하더라도 에러 발생
      // if( this.endPageIndex < this.pageCount ) return this.pageCount;

      let ret = 0;
      if (
        this.$store.state.house.currentPageIndex %
          this.$store.state.house.pageLinkCount ==
        0
      ) {
        //10, 20...맨마지막
        ret =
          (this.$store.state.house.currentPageIndex /
            this.$store.state.house.pageLinkCount -
            1) *
            this.$store.state.house.pageLinkCount +
          this.$store.state.house.pageLinkCount;
      } else {
        ret =
          Math.floor(
            this.$store.state.house.currentPageIndex /
              this.$store.state.house.pageLinkCount
          ) *
            this.$store.state.house.pageLinkCount +
          this.$store.state.house.pageLinkCount;
      }
      // 위 오류나는 코드를 아래와 같이 비교해서 처리
      return ret > this.pageCount ? this.pageCount : ret;
    },
    prev: function () {
      if (
        this.$store.state.house.currentPageIndex <=
        this.$store.state.house.pageLinkCount
      ) {
        return false;
      } else {
        return true;
      }
    },
    next: function () {
      if (this.endPageIndex >= this.pageCount) {
        return false;
      } else {
        return true;
      }
    },
  },
  methods: {
    // 부모에게 event 전달
    paginationChanged(pageIndex) {
      console.log(
        "paginationVue : paginationChanged : pageIndex : " + pageIndex
      );
      this.$emit("call-parent", pageIndex);
    },
  },
};
</script>

<style scoped>
.pagination > li > a
{
    background-color: white;
    color: #59ab6e;
}

.pagination > li > a:focus,
.pagination > li > a:hover,
.pagination > li > span:focus,
.pagination > li > span:hover
{
    color: #000000;
    background-color: #eee;
    border-color: #ddd;
}

.pagination > .active > a
{
    color: white;
    background-color: #59ab6e !Important;
    border: solid 1px #59ab6e !Important;
}

.pagination > .active > a:hover
{
    background-color: #59ab6e !Important;
    border: solid 1px #59ab6e;
}
</style>