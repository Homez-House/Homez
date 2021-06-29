<script>
import { Pie } from "vue-chartjs";
import http from "@/common/axios.js";

export default {
  extends: Pie,
  data() {
    return {
      chartData: {
        labels: [],
        datasets: [
          {
            borderWidth: 1,
            borderColor: [
              "rgba(54, 162, 235, 1)",
              "rgba(255,99,132,1)",
              "rgba(255, 206, 86, 1)",
            ],
            backgroundColor: [
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 99, 132, 0.2)",
              "rgba(255, 206, 86, 0.2)",
            ],
            data: [40, 35, 10],
          },
        ],
      },
      options: {
        legend: {
          display: true,
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
    // 데이터 자료 구조
    let count = [];
    for (let i = 0; i <= 6; i++) count.push(0);

    // 회원 정보 호출
    http.get("/member").then(({ data }) => {
      // 정보 카운트
      data.forEach((element) => {
        let idx = Number(element.memberGender);
        count[idx] += 1;
      });
      count.shift(); // 불필요한 0 인덱스 삭제
      this.chartData.datasets[0].data = count; // chart data setting

      // 비동기 방식으로 회원 정보 후 사용되도록 함
      http.get("/codes", { params: { groupCode: "002" } }).then(({ data }) => {
        // 002 : gender
        let label = [];
        data.forEach((element) => {
          label.push(element.codeName);
        });
        this.chartData.labels = label; // chart label setting
        this.renderChart(this.chartData, this.options); // chart rendering
      });
    });
  },
};
</script>
