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
    let count = [];
    console.log("Pie created");
    for (let i = 0; i <= 6; i++) count.push(0);

    http.get("/member").then(({ data }) => {
      data.forEach((element) => {
        let idx = Number(element.memberGender);
        count[idx] += 1;
      });
      count.shift();
      this.chartData.datasets[0].data = count;

      http.get("/codes", { params: { groupCode: "002" } }).then(({ data }) => {
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

    console.log("Pie created End");
  },
};
</script>
