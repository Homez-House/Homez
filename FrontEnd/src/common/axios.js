import axios from "axios";

// axios 객체 생성
export default axios.create({
  baseURL: "http://localhost:8080",
  headers: {
    "Content-type": "application/json",
  },
  withCredentials: true // flase로 하면 jsessionid를 자꾸 바꿔서 보내기때문에
});