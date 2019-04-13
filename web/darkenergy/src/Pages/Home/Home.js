import { Component } from "inferno";
import { Link } from "inferno-router";

export class Home extends Component {
  render() {
    const card = (
      <div className="card shadow-sm">
        <div className="card-header">
          <h5>Balance</h5>
        </div>

        <div className="card-body">
          <p>
           Euro's / Crypto
          </p>
        </div>
        <div className="card-footer">
          <Link to="/select" className="btn btn-primary btn-lg btn-block">
            Payout <i className="fas fa-coins" />
          </Link>
        </div>
      </div>
    );

    return (
      <div className="page animated fadeIn faster">
        <div className="container">
          <div className="row">
            <div className="col">&nbsp;</div>
            <div className="col-12 col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xl-6">{card}</div>
            <div className="col">&nbsp;</div>
          </div>
        </div>
      </div>
    );
  }
}
