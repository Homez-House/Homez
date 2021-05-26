<template>
    <div>
        <!-- Start Banner Hero -->
        <div>
            <video id="video" muted autoplay loop style="width: 100%;">
                <source :src="requireVideo" type="video/mp4" />
                <strong>Your browser does not support the video tag.</strong>
                
            </video>
        </div>
        <!-- End Banner Hero -->

        <!-- Start Categories of The Month -->
        <section class="container py-5">
            <div class="row text-center pt-3">
                <div class="col-lg-6 m-auto">
                    <h1 class="h1">당신이 원하는 집</h1>
                    <p>
                        무수히 많은 집들 중에 당신이 원하는 곳 하나 없겠습니까?<br>
                        원하는 정보를 꼼꼼히 찾아드리겠습니다.
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="#"><img src="../assets/img/introduce_img_01.jpg" class="rounded-circle img-fluid border"></a>
                    <h5 class="text-center mt-3 mb-3">업무로 인해 찾으시는 분</h5>
                </div>
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="#"><img src="../assets/img/introduce_img_02.jpg" class="rounded-circle img-fluid border"></a>
                    <h2 class="h5 text-center mt-3 mb-3">학업을 위해 찾으시는 분</h2>
                </div>
                <div class="col-12 col-md-4 p-5 mt-3">
                    <a href="#"><img src="../assets/img/introduce_img_03.jpg" class="rounded-circle img-fluid border"></a>
                    <h2 class="h5 text-center mt-3 mb-3">새로운 시작을 위해 찾으시는 분</h2>
                </div>
            </div>
        </section>
        <!-- End Categories of The Month -->

        <!-- Start Featured Product -->
        <section class="bg-light">
            <div class="container py-5">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1 class="h1">부동산 정보</h1>
                        <p>
                            항상 편해야 하는 우리집!<br>
                            잘 보고 잘 구해봅시다!
                        </p>
                    </div>
                </div>
                <div class="row pb-3">
                    <div class="col">
                        <div class="card h-100">
                            <div class="row card-body">
                                <div class="col-5">
                                    <img src="../assets/img/feature_prod_01.jpg" class="card-img-top" alt="...">
                                </div>
                                <div class="col">
                                    <h4>서울 부동산 정보 조회 시스템</h4>
                                    <a class="card-text text-decoration-none text-muted" href="http://kras.seoul.go.kr/land_info/info/baseInfo/baseInfo.do">
                                        부동산 관련 시스템을 활용하여 제공하는 정보입니다. 건축물 정보의 경우 실시간 정보가 아니니 해당 정보는 세움터 사이트를 이용하시기 바랍니다.
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <div class="row card-body">
                                <div class="col-5">
                                    <img src="../assets/img/feature_prod_02.jpg" class="card-img-top" alt="...">
                                </div>
                                <div class="col">
                                    <h4>건축 행정 시스템 - 세움터</h4>
                                    <a class="card-text text-decoration-none text-muted" href="https://cloud.eais.go.kr/">
                                        실시간 건축물 정보검색 및 현 상황 신고내역이 열람 가능합니다.
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row pb-3">
                    <div class="col">
                        <div class="card h-100">
                            <div class="row card-body">
                                <div class="col-5">
                                    <img src="../assets/img/feature_prod_03.jpg" class="card-img-top" alt="...">
                                </div>
                                <div class="col">
                                    <h4>인테리어 견적서 내기 - 집닥</h4>
                                    <a class="card-text text-decoration-none text-muted" href="shop-single.html">
                                        인테리어 중개 플랫폼으로 공사 현장 방문 케어 서비스 제공합니다. 국내 최장 3년 A/S 기간 제공합니다.
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <div class="row card-body">
                                <div class="col-5">
                                    <img src="../assets/img/feature_prod_04.jpg" class="card-img-top" alt="...">
                                </div>
                                <div class="col">
                                <h4>꼭 알아야 하는 부동산 용어</h4>
                                    <a class="card-text text-decoration-none text-muted" href="https://samsungblueprint.tistory.com/586">
                                        삼성물산 건설부문으로 운용하는 부동산 필수 용어 사전입니다. 계약할 때의 모르는 단어가 많으면 힘들겠죠!
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row pb-3">
                    <div class="col">
                        <div class="card h-100">
                            <div class="row card-body">
                                <div class="col-5">
                                    <img src="../assets/img/feature_prod_05.jpg" class="card-img-top" alt="...">
                                </div>
                                <div class="col">
                                <h4>2030 청춘! 주거 지원 정책</h4>
                                    <a class="card-text text-decoration-none text-muted" href="https://www.dailypop.kr/news/articleView.html?idxno=43444">
                                        청년 공공임대주택 종류 및 청년 주택구입 자금지원 등 청년이라면 주목해야 할 주거 지원 정책들은 어떤 것들이 있을까요?
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <div class="row card-body">
                                <div class="col-5">
                                    <img src="../assets/img/feature_prod_06.jpg" class="card-img-top" alt="...">
                                </div>
                                <div class="col">
                                    <h4>원룸 셀프 인테리어 - 집 꾸미기</h4>
                                    <a class="card-text text-decoration-none text-muted" href="https://www.ggumim.co.kr/">
                                        우리 집도 내가 원하는 스타일대로 꾸미고싶다! 원하는 모습으로 탈바꿈할 수 있도록 많은 분들과 소통해보세요!
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Featured Product -->
    </div>
</template>

<script>
export default {
    name: 'MainContent',
    computed:{
        requireVideo : function(){
            let data = Math.floor(Math.random() * 3) + 1;
            return require("../assets/video/video"+data+".mp4");
        }
    }
}
</script>

<style scoped>

</style>