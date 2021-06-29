window.onload = function () {
    loadMap();
  }
  
  function loadMap() {
    var mapContainer = document.querySelector('#map');
    var options = {
      center: new kakao.maps.LatLng(37.56052721408219, 126.99416487053335),
      level: 8,
    }
    var map = new kakao.maps.Map(mapContainer, options);
  }