import Checklist from "./component/Checklist";
import Result from "./component/Result";

document.addEventListener("DOMContentLoaded", () => {
  const root = document.querySelector(".root");

  function render() {
    const hash = window.location.hash;
    root.innerHTML = ""; // Clear the root element

    switch (hash) {
      case "":
      case "#":
        const checklist = new Checklist();
        root.appendChild(checklist.el);
        break;
      case "#result":
        const result = new Result();
        root.appendChild(result.el);
        break;
      default:
        root.innerHTML = "<p>The requested page could not be found.</p>";
    }
  }
  window.addEventListener("hashchange", render);
  render();
});
