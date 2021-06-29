<script>
import { Line } from "vue-chartjs";
import http from "@/common/axios.js";

export default {
  extends: Line,
  data() {
    return {
      tempData: [],
      chartData: {
        labels: [
          "1월",
          "2월",
          "3월",
          "4월",
          "5월",
          "6월",
          "7월",
          "8월",
          "9월",
          "10월",
          "11월",
          "12월",
        ],
        datasets: [
          {
            label: "2021년 신규",
            data: [],
            fill: false,
            borderColor: "#2554FF",
            backgroundColor: "#2554FF",
            borderWidth: 1,
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
          display: true,
        },
        responsive: true,
        maintainAspectRatio: false,
      },
    };
  },
  created() {
    // 데이터 자료구조 생성
    let count = [];
    for (let i = 0; i < 12; i++) count.push(0);

    // 회원 정보 호출
    http.get("/member").then(({ data }) => {
      data.forEach((element) => {
        // joindate : YYYY-MM-DD HH:MM:SS
        // MM을 추출해서 카운트
        let idx = Number(element.memberJoindate.split("-")[1]) - 1;
        count[idx] += 1;
      });
      count.shift(); // 불필요한 0 인덱스 삭제
      this.chartData.datasets[0].data = count; // chart data setting
      this.renderChart(this.chartData, this.options); // chart rendering
    });
  },
};
</script>
