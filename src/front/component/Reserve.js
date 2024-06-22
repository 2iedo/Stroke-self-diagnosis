import { Component } from "./Core"

export default class Reserve extends Component {
  render() {
    this.el.innerHTML = /* html */ `
    <div class="reservation">
      <h1>개인 정보 입력</h1>
      <ul class="form-list">
        <li><span>이름 : </span>
          <input type="text" class="textBox" placeholder="이름" />
        </li>
        <li><span>생년월일 : </span>
          <input type="text" class="textBox" placeholder="0100101" />
        </li>
        <li><span>주소 : </span>
          <input type="text" class="textBox" placeholder="주소" />
        </li>
        <li><span>전화번호 : </span>
          <input type="text" class="textBox" placeholder="01012345678" />
        </li>
        <li><span>가족력 : </span>
          <input type="text" class="textBox" placeholder="가족력 (ex: 당뇨,심장병)" />
        </li>
      </ul>
      <button id="reserveButton">예약 하기</button>
    </div>
    `
    const reserveButton = this.el.querySelector("#reserveButton")
    reserveButton.addEventListener("click", this.collectData.bind(this))
  }

  collectData() {
    const nameInput = this.el.querySelector('.textBox[placeholder="이름"]')
    const birthInput = this.el.querySelector('.textBox[placeholder="0100101"]')
    const addressInput = this.el.querySelector('.textBox[placeholder="주소"]')
    const phoneInput = this.el.querySelector('.textBox[placeholder="01012345678"]')
    const familyInput = this.el.querySelector('.textBox[placeholder="가족력 (ex: 당뇨,심장병)"]')
    if (!nameInput.value || !birthInput.value || !addressInput.value || !phoneInput.value || !familyInput.value) {
      alert("⚠️ 모든 항목을 입력해주세요.")
    } else {
      const isConfirmed = confirm("개인정보 수집 및 이용에 동의하시나요?")
      if (isConfirmed) {
        alert("예약이 완료되었습니다!")
        window.location.hash = "#"
      } else {
        alert("예약이 취소되었습니다.")
      }
    }
  }
}
