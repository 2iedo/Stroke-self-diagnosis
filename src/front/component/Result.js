import { Component } from "./Core";

export default class Result extends Component {
  render() {
    this.el.innerHTML = /* html */ `
      <h1>Result Page</h1>
      <p>This is the result of your self-diagnosis.</p>
      
    `;
  }
}
