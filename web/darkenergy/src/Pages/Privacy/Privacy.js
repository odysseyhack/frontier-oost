import { Component } from "inferno";

export class Privacy extends Component {
  render() {
    const card = (
      <div className="card shadow-sm">
        <div className="card-header">
          <h1>Privacy</h1>
        </div>

        <div className="card-body">
          <p>Privacy..</p>
        </div>
        <div className="card-footer" />
      </div>
    );
    return (
      <div className="page animated fadeIn faster">
        <div className="container">
          <div className="row">
            <div className="col">&nbsp;</div>
            <div className="col-12 col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xl-6">
              {card}
            </div>
            <div className="col">&nbsp;</div>
          </div>
        </div>
      </div>
    );
  }
}
