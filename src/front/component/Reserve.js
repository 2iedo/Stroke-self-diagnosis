import { Component } from "./Core"

export default class Reserve extends Component {
  render() {
    //  name
    //  birthday
    //  address
    //  phone
    //  anamnesis // 가족력

    this.el.innerHTML = /* html */ `
    <div class="reservation">
        <h1> 개인 정보 입력</h1>
    <ul class="form-list">
      <li><span>이름 :    </span>
        <input type="text" class="textBox" placeholder="이름" />
      </li>
      <li><span>생년월일 : </span>
        <input type="text" class="textBox" placeholder="생년월일" />
      </li>
      <li><span>주소 :    </span>
        <input type="text" class="textBox" placeholder="주소" />
      </li>
      <li><span>전화번호 : </span>
        <input type="text" class="textBox" placeholder="전화번호" />
      </li>
      <li><span>가족력 :  </span>
        <input type="text" class="textBox" placeholder="가족력" />
      </li>
    </ul>
  </ul>
  <button onclick="collectData()">예약 하기</button>
  </div>
  `
  }
}
