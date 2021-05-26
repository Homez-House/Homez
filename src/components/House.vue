a<template>
  <div style="width:99%;">
    <!-- 타입 선택 -->
    <div class="row">
      <div class="col container">
        <div class="row mt-2 mb-2">
          <div class="d-flex justify-content-center">
            <div class="form-check form-check-inline m-4">
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
            <div class="form-check form-check-inline m-4">
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
        </div>
        <div class="row mb-4">
          <!-- 동/아파트 검색 -->
          <div class="row d-flex justify-content-center">
            <select
              class="col-4"
              v-show="!isAptType"
              v-model="selectGugun"
              @change="selectGugunData()"
            >
              <option selected :value="0" hidden>구/군</option>
              <option
                v-for="(Gugun, index) in gugunList"
                :key="index"
                :value="Gugun.GUGUN_CODE"
              >
                {{ Gugun.GUGUN_NAME }}
              </option>
            </select>
            <select class="col-4 mx-4" v-model="selectDong" v-show="!isAptType">
              <option selected :value="0" hidden>동</option>
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
              class="col-6 mx-3"
              placeholder="아파트 이름을 검색하세요."
              @keydown.enter="getHouseList"
              v-model="houseSearchWord"
            />
            <button @click="getHouseList" class="col-1 btn-success btn">검색</button>
          </div>
        </div>
        <div class="row" style="margin-left:10px;">
          <div class="col">
            <!-- 검색된 집 리스트 테이블 -->
            <div
              class="row"
              v-show="!isEmptyHouseList"
              v-if="housePageList.length == 0 ? false : true"
            >
              <div class="col-6">
                <div class="row">
                  <div style="height:35px"></div>
                  <table class="table mt text-center table-hover">
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
                        v-for="idx in housePageList.length"
                        @click="
                          getHouseDetail(
                            housePageList[idx - 1].houseName,
                            housePageList[idx - 1].lat,
                            housePageList[idx - 1].lng
                          )
                        "
                        v-bind:key="idx"
                        style="cursor: pointer"
                      >
                        <td>{{ idx }}</td>
                        <td>
                          {{ housePageList[idx - 1].gugunName }}
                        </td>
                        <td>
                          {{ housePageList[idx - 1].dongName }}
                        </td>
                        <td>
                          {{ housePageList[idx - 1].houseName }}
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div class="row">
                  <!-- Pagination -->
                  <pagination v-on:call-parent="movePage"></pagination>
                </div>
              </div>
              <div class="col-6">
                <div v-show="isEmptyHouseDetailList" class="text-center mt-5">
                  <img src='https://ifh.cc/g/UIUsAc.png' border='0' style="width:100%">
                </div>
                <div style="overflow: auto; width: 100%; height: 550px">
                  <div v-show="!isEmptyHouseDetailList" class="text-end" style="height:35px;"><span class="text-success"><b>{{nowAprtName}}</b></span> 상세 내역</div>
                  <table
                    class="table mt text-center table-hover"
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
            <div v-if="(housePageList.length == 0 && onClick) ? true : false" class="text-center">
              검색결과가 없습니다 ㅠㅠ 😭😭😭
              <img src='https://ifh.cc/g/Ft0FRt.jpg' border='0' style="width:80%">
            </div>
          </div>
        </div>        
      </div>
      <div class="col mt-3 mb-3">
        <!-- 맵 -->
        <section id="map-section">
          <div id="map" style="height: 800px"></div>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/common/axios.js";
import Pagination from "./HousePagination.vue";

export default {
  name: "House",
  components: { Pagination },
  data: function () {
    return {
      onClick: false,
      houseSearchType: "dongName",
      houseSearchWord: "",
      // DB를 통해 전체 불러온 집 리스트
      houseList: [],
      // 한 페이지 집 리스트
      housePageList: [],
      // 전체 집 리스트에서 조건에 맞는 검색후, 중복을 제거한 리스트
      houseSet: [],
      // 집 하나 클릭했을 때 상세정보 보여주기 위한 리스트
      houseDetailList: [],
      // 구군 리스트
      gugunList: [],
      // 동리스트
      dongList: [],
      selectGugun: "0",
      selectDong: "0",
      map: null,
      markerPositions: [],
      infoWindow: [],
      markers: [],

      nowAprtName:'',
    };
  },
  methods: {
    movePage(pageIndex) {
      this.housePageList = [];
      console.log(pageIndex);
      this.$store.commit("SET_HOUSE_MOVE_PAGE", pageIndex);
      this.houseDetailList = [];
      this.setLimit(pageIndex);
      for (var i = 0; i < this.$store.state.house.limit; i++) {
        this.housePageList.push(this.houseSet[i + (pageIndex - 1) * 10]);
      }
      this.displayMarker();
    },
    setLimit(pageIndex) {
      this.$store.commit("SET_HOUSE_LIMIT", {
        pageIndex: pageIndex,
        length: this.houseSet.length,
      });
    },
    setGugunList() {
      http.get("/gugun").then(({ data }) => {
        console.log(data);
        this.gugunList = data;
      });
    },
    selectGugunData() {
      this.selectDong = "0";
      http.get("/gugun/" + this.selectGugun).then(({ data }) => {
        this.dongList = data;
        console.log(data);
      });
    },
    getHouseList: function () {
      this.onClick = true;
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
            houseSearchType: this.houseSearchType,
            houseSearchWord: this.selectDong,
          },
        })
        .then(({ data }) => {
          this.houseList = data;
          this.setHouseSet();
          this.displayMarker();
          this.$store.commit("SET_HOUSE_CURRENT_PAGE", 1);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    searchByAptName() {
      http
        .get("/houses", {
          params: {
            houseSearchType: this.houseSearchType,
            houseSearchWord: this.houseSearchWord,
          },
        })
        .then(({ data }) => {
          this.houseList = data;
          this.setHouseSet();
          this.displayMarker();
          this.$store.commit("SET_HOUSE_CURRENT_PAGE", 1);
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
      this.housePageList.forEach((el) => {
        this.markerPositions.push({
          content:
            `<div style="padding: 10px;width:300px;height:80px;" class="text-center">
            ${el.gugunName} ${el.dongName} ${el.houseName} <br>
            <a href="https://map.kakao.com/link/map/${el.houseName},${el.lat},${el.lng}" style="color:blue" target="_blank"> 지도 확대</a> | 
            <a href="https://map.kakao.com/link/to/${el.houseName},${el.lat},${el.lng}" style="color:blue" target="_blank">길찾기</a>
            </div>
            `,
          latlng: new kakao.maps.LatLng(el.lat, el.lng),
        });
        this.markers.push([el.lat, el.lng]);
      });
    },
    displayMarker() {
      this.initMap();
      console.log("------------------------");
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }
      this.setMarkerPositions();
      const positions = this.markers.map(
        (position) => new kakao.maps.LatLng(...position)
      );
      var imageSrc = 'https://image.flaticon.com/icons/png/512/3771/3771140.png', // 마커이미지의 주소입니다    
      imageSize = new kakao.maps.Size(44, 49),
      imageOption = {offset: new kakao.maps.Point(27, 69)};

      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
              image: markerImage,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );
        this.map.setBounds(bounds);
      }
      console.log("markerPositions: " + this.markerPositions);
      for (var i = 0; i < this.markerPositions.length; i++) {
        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: this.markerPositions[i].latlng, // 마커의 위치
          image: markerImage,
        });
        var isRemovable = true;
        // 마커에 표시할 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: this.markerPositions[i].content, // 인포윈도우에 표시할 내용
          removable: isRemovable,
        });

        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
        // 이벤트 리스너로는 클로저를 만들어 등록합니다
        // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        kakao.maps.event.addListener(
          marker,
          "click",
          this.makeClickListener(this.map, marker, infowindow)
        );
        // kakao.maps.event.addListener(
        //   marker,
        //   "mouseover",
        //   this.makeOverListener(this.map, marker, infowindow)
        // );
        // kakao.maps.event.addListener(
        //   marker,
        //   "mouseout",
        //   this.makeOutListener(infowindow)
        // );
      }
      this.markerPositions = [];
      this.markers = [];
    },
    makeClickListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    },
    // makeOverListener(map, marker, infowindow) {
    //   return function () {
    //     infowindow.open(map, marker);
    //   };
    // },
    // makeOutListener(infowindow) {
    //   return function () {
    //     infowindow.close();
    //   };
    // },
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
      this.$store.commit(
        "SET_HOUSE_TOTAL_LIST_ITEM_COUNT",
        this.houseSet.length
      );
      this.movePage(1);
    },
    getHouseDetail(houseName, lat, lng) {
      this.nowAprtName = houseName;
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
    isEmptyHousePageList: function () {
      if (this.housePageList.length == 0 && this.selectDong != "") {
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

tbody > tr:hover {
  background-color: #ecfff1;
}
</style>
