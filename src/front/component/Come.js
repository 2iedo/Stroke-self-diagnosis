import { Component } from "./Core"

export default class Come extends Component {
  render() {
    const formData = JSON.parse(localStorage.getItem("formData"))
    this.el.innerHTML = /* html */ `
      <h1>병원 추천 드립니다</h1>
      <p>병원 이름 : 경북 신경외과</p>
      <p>병원 위치 : 산격동</p>
      <p>병원 여는시간 : 9</p>
      <p>병원 닫는시간 : 11</p>
    `
  }
}
