<template>
  <div class="container">
    <!-- 타입 선택 -->
    <div class="d-flex justify-content-center">
      <div class="form-check form-check-inline m-5">
        <input
          class="form-check-input"
          type="radio"
          name="houseSearch"
          id="aptSearch"
          value="aptName"
          v-model="houseSearchType"
        />
        <label class="form-check-label" for="aptSearch"
          >아파트명으로 검색</label
        >
      </div>
      <div class="form-check form-check-inline m-5">
        <input
          class="form-check-input"
          type="radio"
          name="houseSearch"
          id="dongSearch"
          value="dongName"
          v-model="houseSearchType"
        />
        <label class="form-check-label" for="dongSearch"
          >지역(서울시/구/군)으로 검색</label
        >
      </div>
    </div>
    <!-- 동/아파트 검색 -->
    <div class="row d-flex justify-content-center mb-4">
      <select
        class="col-3"
        v-show="!isAptType"
        v-model="selectGugun"
        @change="selectGugunData()"
      >
        <option selected :value="0" hidden>구/군을 선택하세요.</option>
        <option
          v-for="(Gugun, index) in gugunList"
          :key="index"
          :value="Gugun.GUGUN_CODE"
        >
          {{ Gugun.GUGUN_NAME }}
        </option>
      </select>
      <select class="col-3 mx-4" v-model="selectDong" v-show="!isAptType">
        <option selected :value="0" hidden>동을 선택하세요.</option>
        <option
          v-for="(Dong, index) in dongList"
          :key="index"
          :value="Dong.DONG_CODE"
        >
          {{ Dong.DONG_NAME }}
        </option>
      </select>

      <input
        v-show="isAptType"
        type="text"
        class="col-4 mx-3"
        placeholder="동/아파트 이름을 검색하세요."
        @keydown.enter="getHouseList"
        v-model="houseSearchWord"
      />
      <button @click="getHouseList" class="col-1 btn-success btn">검색</button>
    </div>

    <!-- 맵 -->
    <section id="map-section" class="container my-5" style="width: 100%">
      <div id="map" style="height: 700px"></div>
    </section>

    <!-- 검색된 집 리스트 테이블 -->
    <div class="row" v-show="!isEmptyHouseList">
      <!-- 클릭했을 때 디테일한 집 정보 -->
      <div class="col-6">
        <table class="table mt text-center table-striped table-hover">
          <thead>
            <tr>
              <th scope="col">번호</th>
              <th scope="col">구/군</th>
              <th scope="col">동</th>
              <th scope="col">아파트명</th>
            </tr>
          </thead>
          <tbody>
            <tr
              v-for="(houseSetInfo, index) in houseSet"
              @click="
                getHouseDetail(
                  houseSetInfo.houseName,
                  houseSetInfo.lat,
                  houseSetInfo.lng
                )
              "
              v-bind:key="index"
              style="cursor: pointer"
            >
              <td>{{ index + 1 }}</td>
              <td>{{ houseSetInfo.gugunName }}</td>
              <td>{{ houseSetInfo.dongName }}</td>
              <td>{{ houseSetInfo.houseName }}</td>
            </tr>
            <span v-show="isEmptyHouseSet">
              검색결과가 없습니다 ㅠㅠ 😭😭😭
            </span>
          </tbody>
        </table>
      </div>
      <div class="col-6">
        <div v-show="isEmptyHouseDetailList" class="text-center mt-5">
          <h2>
            좌측에서 관심있는 아파트를 클릭하시면 자세한 정보를 얻을 수
            있습니다.
          </h2>
        </div>

        <table
          class="table mt text-center table-striped table-hover"
          v-show="!isEmptyHouseDetailList"
        >
          <thead>
            <tr>
              <th scope="col">거래가격</th>
              <th scope="col">거래년/월/일</th>
              <th scope="col">실면적</th>
            </tr>
          </thead>
          <tbody>
            <tr
              v-for="(houseDetailListInfo, index) in houseDetailList"
              v-bind:key="index"
            >
              <td>{{ houseDetailListInfo.dealAmount }}</td>
              <td>
                {{
                  houseDetailListInfo.dealYear +
                  "/" +
                  houseDetailListInfo.dealMonth +
                  "/" +
                  houseDetailListInfo.dealDay
                }}
              </td>
              <td>{{ houseDetailListInfo.area }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/common/axios.js";

export default {
  name: "House",
  data: function () {
    return {
      houseSearchType: "dongName",
      houseSearchWord: "",
      // DB를 통해 전체 불러온 집 리스트
      houseList: [],
      // 전체 집 리스트에서 조건에 맞는 검색후, 중복을 제거한 리스트
      houseSet: [],
      // 집 하나 클릭했을 때 상세정보 보여주기 위한 리스트
      houseDetailList: [],
      houseLimit: 10,
      houseOffset: 0,
      // 구군 리스트
      gugunList: [],
      // 동리스트
      dongList: [],
      selectGugun: "",
      selectDong: "",
      map: null,
      markerPositions: [],
      markers: [],
    };
  },
  methods: {
    setGugunList() {
      http.get("/gugun").then(({ data }) => {
        console.log(data);
        this.gugunList = data;
      });
    },
    selectGugunData() {
      http.get("/gugun/" + this.selectGugun).then(({ data }) => {
        this.dongList = data;
        console.log(data);
      });
    },
    getHouseList: function () {
      if (this.isAptType == true) {
        if (this.houseSearchWord == "" || this.houseSearchWord == null) {
          alert("검색어를 입력해주세요.");
          return;
        }
        this.searchByAptName();
      } else {
        this.searchByDong();
      }
    },

    searchByDong: function () {
      http
        .get("/houses", {
          params: {
            houseLimit: this.houseLimit,
            houseOffset: this.houseOffset,
            houseSearchType: this.houseSearchType,
            houseSearchWord: this.selectDong,
          },
        })
        .then(({ data }) => {
          this.houseList = data;
          this.setHouseSet();
          this.displayMarker();
        })
        .catch((error) => {
          console.log(error);
        });
    },

    searchByAptName() {
      http
        .get("/houses", {
          params: {
            houseLimit: this.houseLimit,
            houseOffset: this.houseOffset,
            houseSearchType: this.houseSearchType,
            houseSearchWord: this.houseSearchWord,
          },
        })
        .then(({ data }) => {
          this.houseList = data;
          this.setHouseSet();
          this.displayMarker();
        })
        .catch((error) => {
          console.log(error);
        });
    },
    initMap() {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(37.566826, 126.978656),
        level: 5,
      };
      this.map = new kakao.maps.Map(container, options);
    },
    setMarkerPositions() {
      this.houseList.forEach((el) => {
        if (!([el.lat, el.lng] in this.markerPositions)) {
          this.markerPositions.push([el.lat, el.lng]);
        }
      });
      console.log(this.markerPositions);
    },

    displayMarker() {
      console.log("------------------------");
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }
      this.setMarkerPositions();
      const positions = this.markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );
        this.map.setBounds(bounds);
        this.markerPositions = [];
      }
    },
    setHouseSet() {
      this.houseSet = [];
      this.houseList.forEach((el) => {
        let houseListInfo = {
          gugunName: el.gugunName,
          dongName: el.dongName,
          houseName: el.houseName,
          lat: el.lat,
          lng: el.lng,
        };
        var isDuplicated = false;

        this.houseSet.forEach((houseSetInfo) => {
          if (
            houseSetInfo.gugunName == houseListInfo.gugunName &&
            houseSetInfo.dongName == houseListInfo.dongName &&
            houseSetInfo.houseName == houseListInfo.houseName
          ) {
            isDuplicated = true;
            return;
          }
        });
        if (isDuplicated == false) {
          this.houseSet.push(houseListInfo);
        }
      });
    },
    getHouseDetail(houseName, lat, lng) {
      this.houseDetailList = [];
      this.houseList.forEach((houseListInfo) => {
        if (
          houseListInfo.houseName == houseName &&
          houseListInfo.lat == lat &&
          houseListInfo.lng == lng
        ) {
          this.houseDetailList.push(houseListInfo);
        }
      });
    },
  },
  computed: {
    isAptType: function () {
      if (this.houseSearchType == "dongName") {
        return false;
      } else {
        return true;
      }
    },
    isEmptyHouseSet: function () {
      if (this.houseSet.length == 0 && this.selectDong != "") {
        return true;
      } else {
        return false;
      }
    },
    isEmptyHouseList: function () {
      if (this.houseList.length == 0) {
        return true;
      } else {
        return false;
      }
    },
    isEmptyHouseDetailList: function () {
      if (this.houseDetailList.length == 0) {
        return true;
      } else {
        return false;
      }
    },
  },
  created: function () {
    this.setGugunList();
  },
  mounted() {
    if (this.$store.state.login.isLogin) {
      let memberDong = this.$store.state.login.memberInterestArea;
      console.log(memberDong);
      let memberGugun = memberDong.substring(0, 5);
      this.selectGugun = memberGugun;
      this.selectGugunData();
      this.selectDong = memberDong;
      this.displayMarker();
    }
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b2ba33ccb13cddb0974004341817d8e9";
      document.head.appendChild(script);
    }
  },
};
</script>

<style>
.button-group {
  margin: 10px 0px;
}

button {
  margin: 0 3px;
}
</style>
