import { Component } from "./Core"

export default class Result extends Component {
  render() {
    const formData = JSON.parse(localStorage.getItem("formData"))
    this.el.innerHTML = /* html */ `
      <h1>Result Page</h1>
      <p>This is the result of your self-diagnosis.</p>
      <h1>진단 결과</h1>
    
      <button type="button" class="reset" onclick="window.location.hash = '#'">다시 진단하기</button>
      <button type="button" class="reserve" onclick="window.location.hash = '#hospital'">병원 예약</button>
    `
  }
}
