import { Component } from "inferno";

export class Copyright extends Component {
  render() {
    return (
      <div className="page animated fadeIn faster">
        <div className="jumbotron">
          <h1>All rights reserved.</h1>
        </div>
      </div>
    );
  }
}
