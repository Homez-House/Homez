<script>
  import { Line } from 'vue-chartjs'
  import http from "@/common/axios.js";

  export default {
    extends: Line,
    data () {
      return {
        chartData: {
          labels: ["1월",	"2월",	"3월",	"4월",	"5월",	"6월",	"7월", "8월", "9월", "10월", "11월", "12월"],
          datasets: [
            {
              label: '2021년 신규',
              data: [2,	5,	10,	7,	20,	30,	0,	0,	0, 0, 0, 0],
              fill: false,
              borderColor: '#2554FF',
              backgroundColor: '#2554FF',
              borderWidth: 1
            }
          ]
        },
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true
              },
              gridLines: {
                display: true
              }
            }],
            xAxes: [ {
              gridLines: {
                display: false
              }
            }]
          },
          legend: {
            display: true
          },
          responsive: true,
          maintainAspectRatio: false
        }
      }
    },
    mounted () {
      this.renderChart(this.chartData, this.options)
    }, created(){
      http.get("/member").then(({ data }) => {
        data.forEach(element => {
          console.log(element);
        });
      });
    }
  }
</script>