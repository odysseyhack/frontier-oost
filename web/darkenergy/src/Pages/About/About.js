import { Component } from "inferno";
import "./About.scss";

export class About extends Component {
  constructor(props){
    super(props);
    this.props = props;
    this.state = { step: 5 };
    console.log(this.state);
    setTimeout(this.stepIterater, 1000);
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

        <div class="spinner-border" role="status">
          <span class="sr-only">Loading...</span>
          </div>
          <p> Searching neighbours
            </p>
        </div>
      </div>
    )
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

        <div class="spinner-border" role="status">
          <span class="sr-only">Loading...</span>
          </div>
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

        <div class="spinner-border" role="status">
          <span class="sr-only">Loading...</span>
          </div>
          <p> Fetch weather report
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

        <div class="spinner-border" role="status">
          <span class="sr-only">Loading...</span>
          </div>
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

        <div class="spinner-border" role="status">
          <span class="sr-only">Loading...</span>
          </div>
          <p> Calculating certificates
            </p>
        </div>
      </div>
    )
  }

  stepIterater() {
    // console.log(this.state.step);
    console.log(this.state.step);
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

  render() {
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
            <tr>
              <td>7411MZ</td>
              <td>1</td>
              <td>9</td>
              <td>336</td>
              <td>284</td>
              <td>301</td>
              <td>273</td>
              <td>251</td>
              <td>260</td>
            </tr>
            <tr>
              <td>7411MZ</td>
              <td>5</td>
              <td>16</td>
              <td>336</td>
              <td>284</td>
              <td>301</td>
              <td className="color-red">??</td>
              <td className="color-red">??</td>
              <td className="color-red">??</td>
            </tr>
            <tr>
              <td>7411MZ</td>
              <td>13</td>
              <td>9</td>
              <td>336</td>
              <td>284</td>
              <td>301</td>
              <td>220</td>
              <td>208</td>
              <td>209</td>
            </tr>
            <tr>
              <td>7411MZ</td>
              <td>83</td>
              <td>12</td>
              <td>336</td>
              <td>284</td>
              <td>301</td>
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
              <h4 style="color: WHITE">Starting AI to fill in blank spots</h4>
            </div>
          </div>
            {this.stepVisualer()}
        </div>
      </div>
    );
  }
}
