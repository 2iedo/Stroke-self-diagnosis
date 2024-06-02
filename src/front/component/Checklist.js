import { Component } from "./Core"

export default class Checklist extends Component {
  render() {
    this.el.innerHTML = /* html */ `
    <h1>🏥 뇌졸중 자가 진단 체크 리스트</h1>
    <input type="text" class="textBox" placeholder="나이"  />
    <input type="text" class="textBox" placeholder="BMI"  />
    <select class="select" id="gender">
      <option>여</option>
      <option>남</option>
    </select>
    
    <h2>✅ 자신에게 해당되는 증상을 체크해 주세요</h2>
      <ul>
        <li>
          <select class="select1" id="job">
          <option>공기업</option>
          <option>사기업</option>
          <option>자영업</option>
          <option>학생</option>
          </select>
        </li>
        <li><span>담배를 피십니까?</span>
        <select class="select2" id="smoke">
          <option>모른다</option>
          <option>가끔 핀다</option>
          <option>한번도 피운적 없다</option>
          <option>흡연</option>
        </select>
        </li>
        <li>
          <label>
            <input type="checkbox" class="task" value="pressure" />
            고혈압이십니까?
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="task" value="heart" />
            최근 심장 질환을 겪은 적이 있습니까?
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="task" value="marry" />
            결혼하셨습니까?
          </label>
        </li>
      </ul>
      <button type="submit">제출</button>
    `

    const inputEl = this.el.querySelector("button")
    inputEl.addEventListener("click", (e) => {
      e.preventDefault()
      var value1 = document.getElementById("gender").selectedIndex
      var value2 = document.getElementById("job").selectedIndex
      var value3 = document.getElementById("smoke").selectedIndex

      const formData = {
        gender: value1,

        age: parseInt(this.el.querySelector('input[type="text"][placeholder="나이"]').value),

        hypertension: this.el.querySelector('input[value="pressure"]').checked ? 1 : 0,

        heartdisease: this.el.querySelector('input[value="heart"]').checked ? 1 : 0,

        everMarried: this.el.querySelector('input[value="marry"]').checked ? 1 : 0,

        workType: value2,

        bmi: parseFloat(this.el.querySelector('input[type="text"][placeholder="BMI"]').value),

        smokingStatus: value3,

        strokePercent: null,
      }

      const jsonFormData = JSON.stringify(formData)
      console.log(jsonFormData)
      localStorage.setItem("formData", JSON.stringify(formData))

      fetch("http://localhost:8080/api/SurveyStroke", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: jsonFormData,
      })
        .then((response) => {
          if (!response.ok) {
            throw new Error("Network response was not ok")
          }
          return response.json()
        })
        .then((data) => {
          console.log("Data posted to server:", data)
        })
        .catch((error) => console.error("Error posting data:", error))
      console.log("hello")

      window.location.hash = "#result"
    })
  }
}
