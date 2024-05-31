import { Component } from "./Core"

export default class Come extends Component {
  render() {
    const formData = JSON.parse(localStorage.getItem("formData"))
    this.el.innerHTML = /* html */ `
    <h1>병원 추천 드립니다</h1>
    <ul>
      <li class="info">      
      <p>병원 이름 : 경북 신경외과</p>
      <p>병원 위치 : 산격동</p>
      <p>병원 여는시간 : 9</p>
      <p>병원 닫는시간 : 11</p>
      </li>
    <li class="info">   
      <p>병원 이름 : 강남 신경외과</p>
      <p>병원 위치 : 침산동</p>
      <p>병원 여는시간 : 9</p>
      <p>병원 닫는시간 : 11</p>
    </li>
    <li class="info">     
      <p>병원 이름 : 대구 신경외과</p>
      <p>병원 위치 : 복현동</p>
      <p>병원 여는시간 : 9</p>
      <p>병원 닫는시간 : 11</p>
    </li>
    </ul>

    <button type="button" class="reset" onclick="window.location.hash = '#'">홈으로</button>
    `

    // 모든 li 요소에 클릭 이벤트 리스너 추가
    const listItems = this.el.querySelectorAll(".info")
    listItems.forEach((item) => {
      item.addEventListener("click", () => {
        alert("병원 정보를 클릭하셨습니다.")
      })
    })
  }
}
