import Checklist from "./component/Checklist"
import Result from "./component/Result"
import Come from "./component/Come"

document.addEventListener("DOMContentLoaded", () => {
  const root = document.querySelector(".root")

  function render() {
    const hash = window.location.hash.trim() // 해시 값의 공백 제거
    root.innerHTML = "" // Clear the root element

    console.log("Current hash:", hash) // 해시 값을 콘솔에 출력하여 디버깅

    switch (hash) {
      case "":
      case "#":
        {
          const checklist = new Checklist()
          checklist.render()
          root.appendChild(checklist.el)
        }
        break
      case "#result":
        {
          const result = new Result()
          result.render()
          root.appendChild(result.el)
        }
        break
      case "#hospital":
        {
          const hospital = new Come()
          hospital.render()
          root.appendChild(hospital.el)
        }
        break

      default:
        root.innerHTML = "<p>The requested page could not be found.</p>"
    }
  }

  window.addEventListener("hashchange", render)
  render()
})
