<template>
  <div style="width: 99%">
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
            <button @click="getHouseList" class="col-1 btn-success btn">
              검색
            </button>
          </div>
        </div>
        <div class="row" style="margin-left: 10px">
          <div class="col">
            <!-- 검색된 집 리스트 테이블 -->
            <div
              class="row"
              v-show="!isEmptyHouseList"
              v-if="housePageList.length == 0 ? false : true"
            >
              <div class="col-6">
                <div class="row">
                  <div style="height: 35px"></div>
                  <table class="table mt text-center table-hover">
                    <thead>
                      <tr>
                        <th scope="col">-</th>
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
                  <img
                    src="https://ifh.cc/g/UIUsAc.png"
                    border="0"
                    style="width: 100%"
                  />
                </div>
                <div style="overflow: auto; width: 100%; height: 550px">
                  <div
                    v-show="!isEmptyHouseDetailList"
                    class="text-end"
                    style="height: 35px"
                  >
                    <span class="text-success"
                      ><b>{{ nowAprtName }}</b></span
                    >
                    상세 내역
                  </div>
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
                        <td>{{ houseDetailListInfo.dealAmount }}원</td>
                        <td>
                          {{
                            houseDetailListInfo.dealYear +
                            "/" +
                            houseDetailListInfo.dealMonth +
                            "/" +
                            houseDetailListInfo.dealDay
                          }}
                        </td>
                        <td>{{ houseDetailListInfo.area }}m<sup>2</sup></td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
            <div
              v-if="housePageList.length == 0 && onClick ? true : false"
              class="text-center"
            >
              <h1>😭😭😭</h1>
              <img
                src="https://ifh.cc/g/Ft0FRt.jpg"
                border="0"
                style="width: 80%"
              />
            </div>
          </div>
        </div>
      </div>
      <div class="col mt-3 mb-3">
        <!-- 맵 -->
        <section id="map_wrap">
          <div id="map" style="height: 800px">
            <ul id="category">
              <li id="BK9" data-order="0">
                <span class="category_bg bank"></span>
                은행
              </li>
              <li id="MT1" data-order="1">
                <span class="category_bg mart"></span>
                마트
              </li>
              <li id="PM9" data-order="2">
                <span class="category_bg pharmacy"></span>
                약국
              </li>
              <li id="OL7" data-order="3">
                <span class="category_bg oil"></span>
                주유소
              </li>
              <li id="CE7" data-order="4">
                <span class="category_bg cafe"></span>
                카페
              </li>
              <li id="CS2" data-order="5">
                <span class="category_bg store"></span>
                편의점
              </li>
            </ul>
          </div>
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
      marker: "",
      mapMarkers: [],
      nowAprtName: "",
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
          content: `<div style="padding: 10px;width:300px;height:85px;" class="text-center">
            ${el.gugunName} ${el.dongName} ${el.houseName} <br>
            <a href="https://map.kakao.com/link/map/${el.houseName},${el.lat},${el.lng}" style="color:blue" target="_blank"> 지도 확대</a> |
            <a href="https://map.kakao.com/link/to/${el.houseName},${el.lat},${el.lng}" style="color:blue" target="_blank">길찾기</a>
            <br>
            </div>
            `,
          latlng: new kakao.maps.LatLng(el.lat, el.lng),
        });
        this.markers.push([el.lat, el.lng]);
      });
    },
    displayMarker() {
      // this.initMap();
      this.mapMarkers.forEach((mapMarker) => {
        mapMarker.setMap(null);
      });
      this.markers.forEach((mapMarker) => {
        mapMarker.setMap(null);
      });
      this.mapMarkers = [];
      this.markerPositions = [];
      this.markers = [];

      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }
      this.setMarkerPositions();
      const positions = this.markers.map(
        (position) => new kakao.maps.LatLng(...position)
      );
      var imageSrc =
          "https://image.flaticon.com/icons/png/512/3771/3771140.png", // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(44, 49),
        imageOption = { offset: new kakao.maps.Point(27, 69) };

      var markerImage = new kakao.maps.MarkerImage(
        imageSrc,
        imageSize,
        imageOption
      );
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
      for (var i = 0; i < this.markerPositions.length; i++) {
        // 마커를 생성합니다
        this.marker = new kakao.maps.Marker({
          map: this.map, // 마커를 표시할 지도
          position: this.markerPositions[i].latlng, // 마커의 위치
          image: markerImage,
        });
        this.mapMarkers.push(this.marker);
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
          this.marker,
          "click",
          this.makeClickListener(this.map, this.marker, infowindow)
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
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=b2ba33ccb13cddb0974004341817d8e9&libraries=services";
      document.head.appendChild(script);
    }
    if (this.$store.state.login.isLogin) {
      let memberDong = this.$store.state.login.memberInterestArea;
      console.log(memberDong);
      let memberGugun = memberDong.substring(0, 5);
      this.selectGugun = memberGugun;
      this.selectGugunData();
      this.selectDong = memberDong;
      this.displayMarker();
    }
  },
  updated() {
    // 마커를 클릭했을 때 해당 장소의 상세정보를 보여줄 커스텀오버레이입니다
    var placeOverlay = new kakao.maps.CustomOverlay({ zIndex: 1 }),
      contentNode = document.createElement("div"), // 커스텀 오버레이의 컨텐츠 엘리먼트 입니다
      markers = [], // 마커를 담을 배열입니다
      currCategory = ""; // 현재 선택된 카테고리를 가지고 있을 변수입니다

    var map = this.map;

    // 장소 검색 객체를 생성합니다
    var ps = new kakao.maps.services.Places(map);

    // 지도에 idle 이벤트를 등록합니다
    kakao.maps.event.addListener(map, "idle", searchPlaces);

    // 커스텀 오버레이의 컨텐츠 노드에 css class를 추가합니다
    contentNode.className = "placeinfo_wrap";

    // 커스텀 오버레이의 컨텐츠 노드에 mousedown, touchstart 이벤트가 발생했을때
    // 지도 객체에 이벤트가 전달되지 않도록 이벤트 핸들러로 kakao.maps.event.preventMap 메소드를 등록합니다
    addEventHandle(contentNode, "mousedown", kakao.maps.event.preventMap);
    addEventHandle(contentNode, "touchstart", kakao.maps.event.preventMap);

    // 커스텀 오버레이 컨텐츠를 설정합니다
    placeOverlay.setContent(contentNode);

    // 각 카테고리에 클릭 이벤트를 등록합니다
    addCategoryClickEvent();

    // 엘리먼트에 이벤트 핸들러를 등록하는 함수입니다
    function addEventHandle(target, type, callback) {
      if (target.addEventListener) {
        target.addEventListener(type, callback);
      } else {
        target.attachEvent("on" + type, callback);
      }
    }

    // 카테고리 검색을 요청하는 함수입니다
    function searchPlaces() {
      if (!currCategory) {
        return;
      }

      // 커스텀 오버레이를 숨깁니다
      placeOverlay.setMap(null);

      // 지도에 표시되고 있는 마커를 제거합니다
      removeMarker();

      ps.categorySearch(currCategory, placesSearchCB, { useMapBounds: true });
    }

    // 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
    function placesSearchCB(data, status) {
      if (status === kakao.maps.services.Status.OK) {
        // 정상적으로 검색이 완료됐으면 지도에 마커를 표출합니다
        displayPlaces(data);
      } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
        // 검색결과가 없는경우 해야할 처리가 있다면 이곳에 작성해 주세요
      } else if (status === kakao.maps.services.Status.ERROR) {
        // 에러로 인해 검색결과가 나오지 않은 경우 해야할 처리가 있다면 이곳에 작성해 주세요
      }
    }

    // 지도에 마커를 표출하는 함수입니다
    function displayPlaces(places) {
      // 몇번째 카테고리가 선택되어 있는지 얻어옵니다
      // 이 순서는 스프라이트 이미지에서의 위치를 계산하는데 사용됩니다
      var order = document
        .getElementById(currCategory)
        .getAttribute("data-order");

      for (var i = 0; i < places.length; i++) {
        // 마커를 생성하고 지도에 표시합니다
        var marker = addMarker(
          new kakao.maps.LatLng(places[i].y, places[i].x),
          order
        );

        // 마커와 검색결과 항목을 클릭 했을 때
        // 장소정보를 표출하도록 클릭 이벤트를 등록합니다
        (function (marker, place) {
          kakao.maps.event.addListener(marker, "click", function () {
            displayPlaceInfo(place);
          });
        })(marker, places[i]);
      }
    }

    // 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
    function addMarker(position, order) {
      var imageSrc =
          "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(27, 28), // 마커 이미지의 크기
        imgOptions = {
          spriteSize: new kakao.maps.Size(72, 208), // 스프라이트 이미지의 크기
          spriteOrigin: new kakao.maps.Point(46, order * 36), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
          offset: new kakao.maps.Point(11, 28), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(
          imageSrc,
          imageSize,
          imgOptions
        ),
        marker = new kakao.maps.Marker({
          position: position, // 마커의 위치
          image: markerImage,
        });

      marker.setMap(map); // 지도 위에 마커를 표출합니다
      markers.push(marker); // 배열에 생성된 마커를 추가합니다

      return marker;
    }

    // 지도 위에 표시되고 있는 마커를 모두 제거합니다
    function removeMarker() {
      for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
      }
      markers = [];
    }

    // 클릭한 마커에 대한 장소 상세정보를 커스텀 오버레이로 표시하는 함수입니다
    function displayPlaceInfo(place) {
      var content =
        '<div class="placeinfo">' +
        '   <a class="title" href="' +
        place.place_url +
        '" target="_blank" title="' +
        place.place_name +
        '">' +
        place.place_name +
        "</a>";

      if (place.road_address_name) {
        content +=
          '    <span title="' +
          place.road_address_name +
          '">' +
          place.road_address_name +
          "</span>" +
          '  <span class="jibun" title="' +
          place.address_name +
          '">(지번 : ' +
          place.address_name +
          ")</span>";
      } else {
        content +=
          '    <span title="' +
          place.address_name +
          '">' +
          place.address_name +
          "</span>";
      }

      content +=
        '    <span class="tel">' +
        place.phone +
        "</span>" +
        "</div>" +
        '<div class="after"></div>';

      contentNode.innerHTML = content;
      placeOverlay.setPosition(new kakao.maps.LatLng(place.y, place.x));
      placeOverlay.setMap(map);
    }

    // 각 카테고리에 클릭 이벤트를 등록합니다
    function addCategoryClickEvent() {
      var category = document.getElementById("category"),
        children = category.children;

      for (var i = 0; i < children.length; i++) {
        children[i].onclick = onClickCategory;
      }
    }

    // 카테고리를 클릭했을 때 호출되는 함수입니다
    function onClickCategory() {
      var id = this.id,
        className = this.className;

      placeOverlay.setMap(null);

      if (className === "on") {
        currCategory = "";
        changeCategoryClass();
        removeMarker();
      } else {
        currCategory = id;
        changeCategoryClass(this);
        searchPlaces();
      }
    }

    // 클릭된 카테고리에만 클릭된 스타일을 적용하는 함수입니다
    function changeCategoryClass(el) {
      var category = document.getElementById("category"),
        children = category.children,
        i;

      for (i = 0; i < children.length; i++) {
        children[i].className = "";
      }

      if (el) {
        el.className = "on";
      }
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
.map_wrap,
.map_wrap * {
  margin: 0;
  padding: 0;
  font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
  font-size: 12px;
}
.map_wrap {
  position: relative;
  width: 100%;
  height: 350px;
}
#category {
  position: absolute;
  top: 10px;
  left: 10px;
  border-radius: 5px;
  border: 1px solid #909090;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.4);
  background: #fff;
  overflow: hidden;
  z-index: 2;
}
#category li {
  float: left;
  list-style: none;
  width: 50px;
  border-right: 1px solid #acacac;
  padding: 6px 0;
  text-align: center;
  cursor: pointer;
}
#category li.on {
  background: #eee;
}
#category li:hover {
  background: #ffe6e6;
  border-left: 1px solid #acacac;
  margin-left: -1px;
}
#category li:last-child {
  margin-right: 0;
  border-right: 0;
}
#category li span {
  display: block;
  margin: 0 auto 3px;
  width: 27px;
  height: 28px;
}
#category li .category_bg {
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_category.png)
    no-repeat;
}
#category li .bank {
  background-position: -10px 0;
}
#category li .mart {
  background-position: -10px -36px;
}
#category li .pharmacy {
  background-position: -10px -72px;
}
#category li .oil {
  background-position: -10px -108px;
}
#category li .cafe {
  background-position: -10px -144px;
}
#category li .store {
  background-position: -10px -180px;
}
#category li.on .category_bg {
  background-position-x: -46px;
}
.placeinfo_wrap {
  position: absolute;
  bottom: 28px;
  left: -150px;
  width: 300px;
}
.placeinfo {
  position: relative;
  width: 100%;
  border-radius: 6px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  padding-bottom: 10px;
  background: #fff;
}
.placeinfo:nth-of-type(n) {
  border: 0;
  box-shadow: 0px 1px 2px #888;
}
.placeinfo_wrap .after {
  content: "";
  position: relative;
  margin-left: -12px;
  left: 50%;
  width: 22px;
  height: 12px;
  background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
}
.placeinfo a,
.placeinfo a:hover,
.placeinfo a:active {
  color: #fff;
  text-decoration: none;
}
.placeinfo a,
.placeinfo span {
  display: block;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
.placeinfo span {
  margin: 5px 5px 0 5px;
  cursor: default;
  font-size: 13px;
}
.placeinfo .title {
  font-weight: bold;
  font-size: 14px;
  border-radius: 6px 6px 0 0;
  margin: -1px -1px 0 -1px;
  padding: 10px;
  color: #fff;
  background: #d95050;
  background: #d95050
    url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/arrow_white.png)
    no-repeat right 14px center;
}
.placeinfo .tel {
  color: #0f7833;
}
.placeinfo .jibun {
  color: #999;
  font-size: 11px;
  margin-top: 0;
}
</style>
