![image](https://user-images.githubusercontent.com/45550607/123782648-83456780-d910-11eb-94da-d6d0e5de7bc0.png)

<div align="right">

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-nc-nd/4.0/) [![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0) <a href="https://hits.seeyoufarm.com"/><img src="https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https://github.com/Homez-House/Homez"/></a>

</div>

## OPEN API를 활용한 서울시 주택 거래 웹 사이트🏡 
> 새로운 집을 찾을 때, 각자의 기준이 있을 것 입니다. 따라서 최대한 많은 정보를 준비해 사용자가 원하는 정보를 선택해서 볼 수 있도록 제공합니다.<br>
> 나아가 웹 관리자가 사용자의 통계로 추후 광고, 운영 등의 방안을 제시할 수 있도록 통계를 제공합니다.

- 개발기간 : 2021.05.18 - 2021.05.27 (총 10일)
- 개발인원 : 2인
  - [당현아](https://github.com/eona1301) : 회원 기능 및 관리자 기능 구현, chart.js를 활용한 통계자료 구현
  - [안대현](https://github.com/daehyun1023) : 공지사항 및 매매 정보 검색 기능 구현, Kakao-map api를 활용한 위치 정보 제공
  - 공동 : Spring Boot 및 Vue 프로젝트 구조 설정, Database 설계/구현

<br>

### 🛠 사용 기술
- Language : HTML5, CSS3, JavaScript, Java (Zulu 8.33.0.1)
- Framework : Bootstrap5, vue-cli 4.5.13, SpringBoot 2.4.5, MyBatis 2.1.4
- Database : MySQL
- Library : CKEditor5, Chart.js, Swagger 2.9.2, Gson 2.8.6, Junit
- IDE : Visual Studio Code, Sprint Tool Suite 3.9.14
- OPEN API : Kakao-map

<br>

### 1️⃣ 프로젝트 구성

**Front-End**
```
front-end/
  public/
  src/
    assets/
    common/
      axios.js
      util.js
    components/
      chart/
      modals/
      .vue
    router/
    store/
    App.vue
    main.js
  package-lock.json
  package.json
  README.md
```

**Back-end**
```
back-end/
  gradle/wrapper/
  src/
    main/java/com/ssafy/homez/
      common/
      config/
      controller/
      dao/
      dto/
      service/
      HomezApplication.java
    text/java/com/ssafy/homez/
      HomezApplicationTests.java
      HouseTest.java
      NoticeTest.java
  .gitignore
  build.gradle
  gradlew
  gradlw.bat
  settings.gradle
```
