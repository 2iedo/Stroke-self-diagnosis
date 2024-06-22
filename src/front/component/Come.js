import { Component } from "./Core"

export default class Come extends Component {
  render() {
    const formData = JSON.parse(localStorage.getItem("formData"))
    this.el.innerHTML = /* html */ `
    <h1> 🏥 병원 추천 드립니다</h1>
    `

    fetch("http://localhost:8080/api/Search/hospitalList", {
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
        console.log(data)
        Array.from(data).forEach((hospital) => {
          this.el.innerHTML += /* html */ `
            <ul>
              <li class="info">
                <p>병원 이름: ${hospital.hospitalName}</p>
                <p>병원 위치: ${hospital.address}</p>
                <p>병원 여는시간: ${hospital.hospitalOpening}</p>
                <p>병원 닫는시간: ${hospital.hospitalClosing}</p>
              </li>
            </ul>
          `
        })
        this.el.innerHTML += /* html */ `
        <button type="button" class="reset" onclick="window.location.hash = '#'">홈으로</button>`
        const listItems = this.el.querySelectorAll(".info")
        listItems.forEach((item) => {
          item.addEventListener("click", () => {
            alert("병원을 선택하셨습니다.")
            window.location.hash = "#reserve"
          })
        })
      })
      .catch((error) => console.error("Error fetching data:", error))
  }
}
