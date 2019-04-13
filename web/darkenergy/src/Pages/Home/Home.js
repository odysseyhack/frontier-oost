import { Component } from "inferno";
import { Link } from "inferno-router";

export class Home extends Component {
  render() {
    return (
      <div className="page animated fadeIn faster">
        <div className="container">

          <div class="row text-center" style="margin-top:60px;margin-bottom:60px;">
            <div class="col-sm">
              <h1><strong>Mijn opbrengsten</strong></h1>
              <h5>jaar 2019</h5>
            </div>
          </div>

          <div class="row text-center" style="margin-bottom:60px;">
            <div class="col-sm">
              <p class="fas fa-bolt big-icon__bolt"></p>
              <p><span class="primary-text"><strong>13.2</strong></span> <span class="secondary-text">kWh</span></p>
            </div>
            <div class="col-sm">
              <p class="fas fa-medal big-icon__medal"></p>
              <p><span class="primary-text"><strong>1</strong></span> <span class="secondary-text">Certificaat</span></p>
            </div>
            <div class="col-sm">
              <p class="fas fa-leaf big-icon__green"></p>
              <p>
                <span class="primary-text"><strong>€50,-</strong></span>
                <div>Wordt automatisch uitgekeerd op 31-12-2019</div>
              </p>
            </div>
          </div>

          <div class="row text-center" style="margin-top:60px;margin-bottom:60px;">
            <div class="col-sm">
              <h1><strong>Mijn energiebronnen</strong></h1>
            </div>
          </div>

          <div class="card-deck mb-3 text-center">
            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Zonnepaneel</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-solar-panel big-icon__green"></p>
                <button type="button" class="btn btn-lg btn-block btn-secondary">Stop delen</button>
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Windenergie</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-wind big-icon"></p>
                <button type="button" class="btn btn-lg btn-block btn-primary">Start met delen</button>
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Slimme meter</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-tachometer-alt big-icon"></p>
                <button type="button" class="btn btn-lg btn-block btn-primary">Stop delen</button>
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Stopcontact</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-plug big-icon"></p>
                <button type="button" class="btn btn-lg btn-block btn-primary">Stop delen</button>
              </div>
            </div>

          </div>

        </div>
      </div>
    );
  }
}
