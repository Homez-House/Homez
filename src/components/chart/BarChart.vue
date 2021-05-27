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
    let count = [];
    console.log("BarChar created");
    for (let i = 0; i <= 6; i++) count.push(0);

    http.get("/member").then(({ data }) => {
      data.forEach((element) => {
        let idx = Number(element.memberAge);
        count[idx] += 1;
      });
      count.shift();
      this.chartData.datasets[0].data = count;

      http.get("/codes", { params: { groupCode: "003" } }).then(({ data }) => {
        let label = [];
        data.forEach((element) => {
          console.log(element.codeName);
          label.push(element.codeName);
        });
        console.log(label);
        this.chartData.labels = label;
        this.renderChart(this.chartData, this.options);
      });
    });

    console.log("BarChar created End");
  },
};
</script>
