import { Component } from "./Core";

export default class Checklist extends Component {
  render() {
    this.el.innerHTML = /* html */ `
    <h1>뇌졸중 자가 진단 체크 리스트</h1>
    <h2>✅ 최근 3개월 동안 자신에게 해당되는 증상을 체크해 주세요</h2>
      <ul>
        <li>
          <label>
            <input type="checkbox" class="tasks" value="task1" />
            가족 중에 뇌 질환 관련 질명을 앓고 있는 사람이 있었다.
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="tasks" value="task2" />
            최근 어지러움을 자주 느낀다.
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="tasks" value="task3" />
            자고 일어났을 때 눈을 뜨면 헛구역질을 한다.
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="tasks" value="task4" />
            병원 정기검진 결과 혈당 수치가 높게 나왔다.
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="tasks" value="task4" />
            과도한 업무 스트레스에 시달리고 있다.
          </label>
        </li>
        <li>
          <label>
            <input type="checkbox" class="tasks" value="task4" />
            최근 들어 부쩍 사람 이름이나 장소 등을 잊어버린다.
          </label>
        </li>
      </ul>
      <button type="submit">제출</button>
    `;

    const inputEl = this.el.querySelector("button");
    inputEl.addEventListener("click", (e) => {
      e.preventDefault();
      window.location.hash = "#result";
    });
  }
}
