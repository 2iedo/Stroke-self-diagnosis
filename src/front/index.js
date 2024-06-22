import Checklist from "./component/Checklist"
import Result from "./component/Result"
import Come from "./component/Hospital"
import Reserve from "./component/Reserve"

document.addEventListener("DOMContentLoaded", () => {
  const root = document.querySelector(".root")

  function render() {
    const hash = window.location.hash.trim()
    root.innerHTML = ""
    console.log("Current hash:", hash)
    switch (hash) {
      case "":
      case "#":
        {
          const checklist = new Checklist()
          root.appendChild(checklist.el)
        }
        break
      case "#result":
        {
          const result = new Result()
          root.appendChild(result.el)
        }
        break
      case "#hospital":
        {
          const hospital = new Come()
          root.appendChild(hospital.el)
        }
        break
      case "#reserve":
        {
          const reserve = new Reserve()
          root.appendChild(reserve.el)
        }
        break
      default:
        root.innerHTML = "<p>The requested page could not be found.</p>"
    }
  }
  window.addEventListener("hashchange", render)
  render()
})
