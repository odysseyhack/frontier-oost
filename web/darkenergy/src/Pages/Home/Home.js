import { Component } from "inferno";

export class Home extends Component {

  constructor(props){
    super(props);
    this.props = props;
    this.state = { 
      powerOptions: {
        solarPanels: true,
        windenergy: false,
        smartEnergyMeter: true,
        Outlets: true
      }, 
      item: { Horsepower: 0} };

    //bindings
    this.toggleSolarEnergy = this.toggleSolarEnergy.bind(this);
    this.toggleWindEnergy = this.toggleWindEnergy.bind(this);
    this.toggleSmartEnergyMeter = this.toggleSmartEnergyMeter.bind(this);
    this.toggleOutlets = this.toggleOutlets.bind(this);
  }

  toggleSolarEnergy(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.solarPanels = !powerOptions.solarPanels

    this.setState({powerOptions: powerOptions})
  }

  toggleWindEnergy(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.windenergy = !powerOptions.windenergy

    this.setState({powerOptions: powerOptions})
  }

  toggleSmartEnergyMeter(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.smartEnergyMeter = !powerOptions.smartEnergyMeter

    this.setState({powerOptions: powerOptions})
  }

  toggleOutlets(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.Outlets = !powerOptions.Outlets

    this.setState({powerOptions: powerOptions})
  }

  componentDidMount(){
    fetch('https://storage.googleapis.com/tfjs-tutorials/carsData.json')
    .then(result => result.json())
    .then(beterresult => {
      this.setState( {item: beterresult[0]});
    });
  }

  getEnergyButton(isEnabled, onClick){
    if(isEnabled) {
      return <button type="button" class="btn btn-lg btn-block btn-secondary" onClick={onClick}>Stop sharing</button>
    }
    return <button type="button" class="btn btn-lg btn-block btn-primary" onClick={onClick}>Start sharing</button>
  }

  getEnabledClassForIcons(enabled, baseClass) {
    return enabled ? baseClass + " big-icon__green" : baseClass + " big-icon";
  }

  render() {
    return (
      <div className="page animated fadeIn faster">
        <div className="container">

          <div class="row text-center" style="margin-top:60px;margin-bottom:60px;">
            <div class="col-sm">
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
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.solarPanels, "fas fa-solar-panel")}></p>
                { this.getEnergyButton(this.state.powerOptions.solarPanels, this.toggleSolarEnergy) }
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Wind energy</h4>
              </div>
              <div class="card-body">
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.windenergy, "fas fa-wind")}></p>
                { this.getEnergyButton(this.state.powerOptions.windenergy, this.toggleWindEnergy) }
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Smart energy meter</h4>
              </div>
              <div class="card-body">
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.smartEnergyMeter, "fas fa-tachometer-alt")}></p>
                { this.getEnergyButton(this.state.powerOptions.smartEnergyMeter, this.toggleSmartEnergyMeter) }
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Outlets</h4>
              </div>
              <div class="card-body">
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.Outlets, "fas fa-plug")}></p>
                { this.getEnergyButton(this.state.powerOptions.Outlets, this.toggleOutlets) }
              </div>
            </div>

          </div>

        </div>
      </div>
    );
  }
}
