import { Component } from "inferno";
import { Link } from "inferno-router";
import "./About.scss";

export class About extends Component {
  constructor(props){
    super(props);
    this.props = props;
    this.state = { step: -1 };
    this.stepper = this.stepper.bind(this);
    setInterval(this.stepper, 4000);
  }

  stepper() {
    this.state.step++;
    this.forceUpdate();
  }

  cardOne() {
    var display;
    if (this.state.step >= 1) {
      display = true;
    }
    return (
      <div className={`card ${display ? "" : "display-none"}`}>
        <div className="card-header" style="background: #4CD964;">
          <h5 style="color: WHITE">Step one</h5>
        </div>
        <div className="card-body text-center">
          { this.state.step > 1 ? this.iconDone() : this.loader()}
          <p> Searching neighbours
            </p>
        </div>
      </div>
    )
  }
  loader() {
    return (
      <div class="spinner-border" role="status">
        <span class="sr-only">Loading...</span>
      </div>
    );
  }

  iconDone() {
    return <p class="fas fa-3x fa-check big-check"></p>;
  }
  cardTwo() {
    var display;
    if (this.state.step >= 2) {
      display = true;
    }
    return (
      <div className={`card ${display ? "" : "display-none"}`}>
        <div className="card-header" style="background: #4CD964;">
          <h5 style="color: WHITE">Step two</h5>
        </div>
        <div className="card-body text-center">
          { this.state.step > 2 ? this.iconDone() : this.loader()}
          <p> Identifying solar panels
            </p>
        </div>
      </div>
    )
  }
  cardThree() {
    var display;
    if (this.state.step >= 3) {
      display = true;
    }
    return (
      <div className={`card ${display ? "" : "display-none"}`}>
        <div className="card-header" style="background: #4CD964;">
          <h5 style="color: WHITE">Step three</h5>
        </div>
        <div className="card-body text-center">

            { this.state.step > 3 ? this.iconDone() : this.loader()}
          <p> Fetching weather report
            </p>
        </div>
      </div>
    )
  }
  cardFour(display) {
    var display;
    if (this.state.step >= 4) {
      display = true;
    }
    return (
      <div className={`card ${display ? "" : "display-none"}`}>
        <div className="card-header" style="background: #4CD964;">
          <h5 style="color: WHITE">Step four</h5>
        </div>
        <div className="card-body text-center">

            { this.state.step > 4 ? this.iconDone() : this.loader()}
          <p> Determing missing yield
            </p>
        </div>
      </div>
    )
  }
  cardFive(display) {
    var display;
    if (this.state.step >= 5) {
      display = true;
    }
    return (
      <div className={`card ${display ? "" : "display-none"}`}>
        <div className="card-header" style="background: #4CD964;">
          <h5 style="color: WHITE">Step five</h5>
        </div>
        <div className="card-body text-center">

            { this.state.step > 5 ? this.iconDone() : this.loader()}
          <p> Calculating certificates
            </p>
        </div>
      </div>
    )
  }

  stepVisualer() {
    return (
      <div className="row">
        <div className="col">{this.cardOne()}</div>
        <div className="col">{this.cardTwo()}</div>
        <div className="col">{this.cardThree()}</div>
        <div className="col">{this.cardFour()}</div>
        <div className="col">{this.cardFive()}</div>
      </div>
    )
  }

  renderClaim() {
    var step = this.state.step;
    return (
      <div className={`row text-center ${step > 5 ? "" : "display-none"}`} style="margin-top: 20px">
        <div className="col-sm" style="background: #4CD964; margin-bottom: 20px;">
          <h2 style="color: white">Found <strong>ONE</strong> certificate to claim</h2>
          <button type="button" class="btn btn-lg btn-info"><Link to="/">Go to prosumer dashboard</Link></button>
        </div>
      </div>
    );
  }

  render() {
    var step = this.state.step;
    const table = (
        <table className="table">
          <thead>
            <tr>
              <th>ZipCode</th>
              <th>HouseNumber</th>
              <th>#SolarPanels</th>
              <th>Weather 12-04-2019</th>
              <th>Weather 13-04-2019</th>
              <th>Weather 14-04-2019</th>
              <th>Yield 12-04-2019</th>
              <th>Yield 13-04-2019</th>
              <th>Yield 14-04-2019</th>
            </tr>
          </thead>
          <tbody>
            <tr className={step > 1 ? "" : "display-none"}>
              <td>7411MZ</td>
              <td style={step > 1 ? "color: green" : ""}>1</td>
              <td>9</td>
              <td style="color: GREEN;">{step > 3 ? "336" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "284" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "301" : ""}</td>
              <td>273</td>
              <td>251</td>
              <td>260</td>
            </tr>
            <tr style="background: #eee">
              <td>7411MZ</td>
              <td>5</td>
              <td style="color: GREEN;">{step > 2 ? "16" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "336" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "284" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "301" : ""}</td>
              <td style={`font-weight: BOLD; color: ${step > 4 ? "GREEN" : "RED"}`}>{step > 4 ? "342" : "??"}</td>
              <td style={`font-weight: BOLD; color: ${step > 4 ? "GREEN" : "RED"}`}>{step > 4 ? "331" : "??"}</td>
              <td style={`font-weight: BOLD; color: ${step > 4 ? "GREEN" : "RED"}`}>{step > 4 ? "320" : "??"}</td>
            </tr>
            <tr className={step > 1 ? "" : "display-none"} >
              <td>7411MZ</td>
              <td style={step > 1 ? "color: green" : ""}>13</td>
              <td>9</td>
              <td style="color: GREEN;">{step > 3 ? "336" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "284" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "301" : ""}</td>
              <td>220</td>
              <td>208</td>
              <td>209</td>
            </tr>
            <tr className={step > 1 ? "" : "display-none"}>
              <td>7411MZ</td>
              <td style={step > 1 ? "color: green" : ""}>83</td>
              <td>12</td>
              <td style="color: GREEN;">{step > 3 ? "336" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "284" : ""}</td>
              <td style="color: GREEN;">{step > 3 ? "301" : ""}</td>
              <td>300</td>
              <td>295</td>
              <td>289</td>
            </tr>
          </tbody>
        </table>
    );

    return (
      <div className="page animated fadeIn faster">
        <div className="container-fluid">
          <div className="row">
            <div className="table-responsive">{table}</div>
          </div>
          <div className="row text-center" style="">
            <div className="col-sm" style="background: #4CD964; margin-bottom: 20px;">
              <h4 style="color: WHITE">{this.state.step >= 0 ? "Starting AI to fill in blank spots" : "" }</h4>
            </div>
          </div>
            {this.stepVisualer()}
            {this.renderClaim()}
        </div>
      </div>
    );
  }
}
