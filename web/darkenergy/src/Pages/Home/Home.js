import { Component } from "inferno";

export class Home extends Component {

  constructor(props){
    super(props);
    this.props = props;
    this.state = { item: { Horsepower: 0} };
  }

  componentDidMount(){
    fetch('https://storage.googleapis.com/tfjs-tutorials/carsData.json')
    .then(result => result.json())
    .then(beterresult => {
      console.log(beterresult[0])
      this.setState( {item: beterresult[0]});
    });
  }

  render() {
    return (
      <div className="page animated fadeIn faster">
        <div className="container">

          <div className="row text-center" style="margin-top:60px;margin-bottom:60px;">
            <div className="col-sm">
              <h1><strong>My proceeds</strong></h1>
              <h5>Year 2019</h5>
            </div>
          </div>

          <div class="row text-center" style="margin-bottom:60px;">
            <div class="col-sm">
              <p class="fas fa-bolt big-icon__bolt"></p>
              <p><span class="primary-text"><strong>{this.state.item.Weight_in_lbs}</strong></span> <span class="secondary-text">kWh</span></p>
            </div>
            <div class="col-sm">
              <p class="fas fa-medal big-icon__medal"></p>
              <p><span class="primary-text"><strong>{this.state.item.Cylinders}</strong></span> <span class="secondary-text">Certificate(s)</span></p>
            </div>
            <div class="col-sm">
              <p class="fas fa-leaf big-icon__green"></p>
              <p>
                <span class="primary-text"><strong>€{this.state.item.Horsepower},-</strong></span>
                <div>Automaticly processed on 31-12-2019</div>
              </p>
            </div>
          </div>

          <div class="row text-center" style="margin-top:60px;margin-bottom:60px;">
            <div class="col-sm">
              <h2><strong>My energy sources</strong></h2>
            </div>
          </div>

          <div class="card-deck mb-3 text-center">
            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Solar panels</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-solar-panel big-icon__green"></p>
                <button type="button" class="btn btn-lg btn-block btn-secondary">Stop sharing</button>
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Wind energy</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-wind big-icon"></p>
                <button type="button" class="btn btn-lg btn-block btn-primary">Start sharing</button>
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Smart energy meter</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-tachometer-alt big-icon"></p>
                <button type="button" class="btn btn-lg btn-block btn-primary">Start sharing</button>
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Outlets</h4>
              </div>
              <div class="card-body">
                <p class="fas fa-plug big-icon"></p>
                <button type="button" class="btn btn-lg btn-block btn-primary">Start sharing</button>
              </div>
            </div>

          </div>

        </div>
      </div>
    );
  }
}
