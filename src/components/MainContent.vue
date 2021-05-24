<template>
    <div>
        <!-- Start Banner Hero -->
        <div>
            <video id="video" muted autoplay loop style="width: 100%;">
                <source :src="'../assets/video/video' + VideoNum + '.mp4'" type="video/mp4" />
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
                <div class="row">
                    <div class="col">
                        <div class="card h-100">
                            <a href="shop-single.html">
                                <img src="../assets/img/feature_prod_01.jpg" class="card-img-top" alt="..." style="height: 100px;">
                            </a>
                            <div class="card-body">
                                <h3>서울 부동산 정보 조회 시스템</h3>
                                <p class="card-text ">
                                    부동산 관련 시스템을 활용하여 제공하는 정보입니다. 건축물 정보의 경우 실시간 정보가 아니니 해당 정보는 세움터 사이트를 이용하시기 바랍니다.
                                </p>
                                <div class="position-absolute bottom-0 mb-2">
                                    <a href="http://kras.seoul.go.kr/land_info/info/baseInfo/baseInfo.do" class="text-decoration-none text-muted">바로가기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <a href="shop-single.html">
                                <img src="../assets/img/feature_prod_02.jpg" class="card-img-top" alt="..." style="height: 100px;">
                            </a>
                            <div class="card-body">
                                <h3>건축 행정 시스템 - 세움터</h3>
                                <p class="card-text ">
                                    실시간 건축물 정보검색 및 현 상황 신고내역이 열람 가능합니다.
                                </p>
                                <div class="position-absolute bottom-0 mb-2">
                                    <a href="https://cloud.eais.go.kr/" class="text-decoration-none text-muted">바로가기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <a href="shop-single.html">
                                <img src="../assets/img/feature_prod_03.jpg" class="card-img-top" alt="..." style="height: 100px;">
                            </a>
                            <div class="card-body">
                                <h3>인테리어 견적서 내기 - 집닥</h3>
                                <p class="card-text ">
                                    인테리어 중개 플랫폼으로 공사 현장 방문 케어 서비스 제공합니다. 국내 최장 3년 A/S 기간 제공합니다.
                                </p>
                                <div class="position-absolute bottom-0 mb-2">
                                    <a href="https://zipdoc.co.kr/" class="text-decoration-none text-muted">바로가기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <a href="shop-single.html">
                                <img src="../assets/img/feature_prod_04.jpg" class="card-img-top" alt="..." style="height: 100px;">
                            </a>
                            <div class="card-body">
                                <h3>꼭 알아야 하는 부동산 용어</h3>
                                <p class="card-text ">
                                    삼성물산 건설부문으로 운용하는 부동산 필수 용어 사전입니다. 계약할 때의 모르는 단어가 많으면 힘들겠죠!
                                </p>
                                <div class="position-absolute bottom-0 mb-2">
                                    <a href="https://samsungblueprint.tistory.com/586" class="text-decoration-none text-muted">바로가기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <a href="shop-single.html">
                                <img src="../assets/img/feature_prod_05.jpg" class="card-img-top" alt="..." style="height: 100px;">
                            </a>
                            <div class="card-body">
                                <h3>2030 청춘이라면! 주거 지원 정책</h3>
                                <p class="card-text ">
                                    청년 공공임대주택 종류 및 청년 주택구입 자금지원 등 청년이라면 주목해야 할 주거 지원 정책들은 어떤 것들이 있을까요?
                                </p>
                                <div class="position-absolute bottom-0 mb-2">
                                    <a href="https://www.dailypop.kr/news/articleView.html?idxno=43444" class="text-decoration-none text-muted">바로가기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card h-100">
                            <a href="shop-single.html">
                                <img src="../assets/img/feature_prod_06.jpg" class="card-img-top" alt="..."  style="height: 100px;">
                            </a>
                            <div class="card-body">
                                <h3>원룸 셀프 인테리어 - 집 꾸미기</h3>
                                <p class="card-text ">
                                    우리 집도 내가 원하는 스타일대로 꾸미고싶다! 원하는 모습으로 탈바꿈할 수 있도록 많은 분들과 소통해보세요!
                                </p>
                                <div class="position-absolute bottom-0 mb-2">
                                    <a href="https://www.ggumim.co.kr/" class="text-decoration-none text-muted">바로가기</a>
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
    data:function(){
        return {
            VideoNum:"",
        }
    }, created:function(){
        this.VideoNum = Math.floor(Math.random() * 3) + 1;
    }
}
</script>

<style scoped>

</style>