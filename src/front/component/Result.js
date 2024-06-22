import { Component } from "./Core"

export default class Result extends Component {
  render() {
    const formData = JSON.parse(localStorage.getItem("formData"))
    this.el.innerHTML = /* html */ `
      <div class="Result">
        <h1 style="text-align: center;">📄진단 결과</h1>
        <div id="spinner" class="spinner"></div> 
        <div id="resultContent"></div>
      </div>
    `

    const spinner = this.el.querySelector("#spinner")
    const resultContent = this.el.querySelector("#resultContent")
    spinner.style.display = "block"

    fetch("http://localhost:8080/api/DecisionStroke", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Origin: "http://localhost:1234",
      },
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok")
        }
        return response.json()
      })
      .then((data) => {
        const receivedData = data * 100
        resultContent.innerHTML = /* html */ `
          <h3 style="text-align: center;">💡머신러닝을 통한 뇌졸중 확률 결과 입니다 : ${receivedData}%</h3>
          <br>
          <button type="button" class="reset" onclick="window.location.hash = '#'">다시 진단하기</button>
          <button type="button" class="reserve" onclick="window.location.hash = '#hospital'">병원 예약</button>
        `
        spinner.style.display = "none" // Hide the spinner
      })
      .catch((error) => {
        console.error("Error fetching data:", error)
        spinner.style.display = "none" // Hide the spinner in case of error
        resultContent.innerHTML = `<p style="text-align: center; color: red;">데이터를 불러오는 중 오류가 발생했습니다. 나중에 다시 시도해주세요.</p>`
      })
  }
}
