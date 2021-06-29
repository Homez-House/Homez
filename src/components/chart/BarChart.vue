<script>
import { Bar } from "vue-chartjs";
import http from "@/common/axios.js";

export default {
  extends: Bar,
  data() {
    return {
      chartData: {
        labels: [],
        datasets: [
          {
            label: "연령대 분포",
            borderWidth: 1,
            backgroundColor: [
              "rgba(255, 99, 132, 0.2)",
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)",
              "rgba(255, 159, 64, 0.2)",
            ],
            borderColor: [
              "rgba(255,99,132,1)",
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)",
              "rgba(255, 159, 64, 1)",
            ],
            pointBorderColor: "#2554FF",
            data: [],
          },
        ],
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true,
              },
              gridLines: {
                display: true,
              },
            },
          ],
          xAxes: [
            {
              gridLines: {
                display: false,
              },
            },
          ],
        },
        legend: {
          display: false,
        },
        responsive: true,
        maintainAspectRatio: false,
      },
    };
  },
  mounted() {
    this.renderChart(this.chartData, this.options);
  },
  created() {
    // 데이터 정렬 자료구조 생성
    let count = [];
    for (let i = 0; i <= 6; i++) count.push(0);

    // 회원 정보 호출
    http.get("/member").then(({ data }) => {
      data.forEach((element) => {
        let idx = Number(element.memberAge);
        count[idx] += 1;
      });
      count.shift(); // 불필요한 0 인덱스를 삭제
      this.chartData.datasets[0].data = count; // chart data setting

      // 비동기 구조로 인해 앞 과정이 끝난 이후에 수행
      http.get("/codes", { params: { groupCode: "003" } }).then(({ data }) => {
        // 003 : 연령대
        let label = [];
        data.forEach((element) => {
          label.push(element.codeName);
        });
        this.chartData.labels = label; // chart label setting
        this.renderChart(this.chartData, this.options); //rendering
      });
    });
  },
};
</script>
