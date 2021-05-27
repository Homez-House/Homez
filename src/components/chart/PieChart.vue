<script>
  import { Pie } from 'vue-chartjs'

  export default {
    extends: Pie,
    data () {
      return {
        chartData: {
          labels: ["남자", "여자", "기타"],
          datasets: [{
              borderWidth: 1,
              borderColor: [
              'rgba(54, 162, 235, 1)',
              'rgba(255,99,132,1)',
              'rgba(255, 206, 86, 1)',           
              ],
              backgroundColor: [
              'rgba(54, 162, 235, 0.2)',
              'rgba(255, 99, 132, 0.2)',
              'rgba(255, 206, 86, 0.2)',             
              ],
              data: [40,	35,	10]
            }]
        },
        options: {
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
    }
  }
</script>