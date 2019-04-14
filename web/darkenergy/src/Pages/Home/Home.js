import { Component } from "inferno";

export class Home extends Component {

  constructor(props) {
    super(props);
    this.props = props;
    this.state = {
      powerOptions: {
        solarPanels: false,
        windenergy: false,
        smartEnergyMeter: false,
        Outlets: false
      },
      production: {
        kWh: 0,
        certificates: 0,
        income: 0
      },
      claimed: false,
    };

    //bindings
    this.toggleSolarEnergy = this.toggleSolarEnergy.bind(this);
    this.toggleWindEnergy = this.toggleWindEnergy.bind(this);
    this.toggleSmartEnergyMeter = this.toggleSmartEnergyMeter.bind(this);
    this.toggleOutlets = this.toggleOutlets.bind(this);
    this.handleOnClick = this.handleOnClick.bind(this);
  }

  toggleSolarEnergy(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.solarPanels = !powerOptions.solarPanels

    if(powerOptions.solarPanels) {
      this.addToProduction(312,1,50);
    } else {
      this.addToProduction(-312,-1,-50);
    }
    this.setState({ powerOptions: powerOptions })
  }

  toggleWindEnergy(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.windenergy = !powerOptions.windenergy

    if(powerOptions.windenergy) {
      this.addToProduction(312,1,50);
    } else {
      this.addToProduction(-312,-1,-50);
    }

    this.setState({ powerOptions: powerOptions })
  }

  toggleSmartEnergyMeter(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.smartEnergyMeter = !powerOptions.smartEnergyMeter

    this.setState({ powerOptions: powerOptions })
  }

  toggleOutlets(e) {
    var powerOptions = this.state.powerOptions;
    powerOptions.Outlets = !powerOptions.Outlets

    this.setState({ powerOptions: powerOptions })
  }

  claimButton() {
    var claimed = this.state.claimed;
    if (claimed) {
      return <div>Claimed on 14-04-2019</div>;
    }
    if (this.state.production.kWh > 0) {
    return (
      <button onClick={this.handleOnClick} type="button" class="btn btn-lg btn-success">Claim tokens</button>
    );
  }
  }

  handleOnClick() {
    fetch('http://localhost:8080/myGvo/payout/zipCodeAddress/?zipCodeAddress=7411MZ&tokenId=555', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      }
    })
    .then(result => result.json())
    .then(beterresult => {
      this.state.claimed = true;
      this.forceUpdate();
    });
  }

  addToProduction(kwh, certificates, income) {
    var production = this.state.production;
    production.kWh = production.kWh + kwh;
    production.certificates = production.certificates + certificates;
    production.income = production.income + income

    this.setState({production: production})
  }

  getEnergyButton(isEnabled, onClick) {
    if (isEnabled) {
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
          <div className="text-center">
            <p style="margin-bottom: 0">Address: 0x85e4317daE7C3713050CE14f1B0255Fc91e79E6E</p>
            <p>MyGvo Tokens: {this.state.claimed ? 2 : 0}</p>
          </div>
          <div className="row text-center" style="margin-top:40px;margin-bottom:60px;">
            <div className="col-sm">
              <h1><strong>My proceeds</strong></h1>
              <h5>Year 2019</h5>
            </div>
          </div>

          <div class="row text-center" style="margin-bottom:60px;">
            <div class="col-sm">
              <p class="fas fa-bolt big-icon__bolt"></p>
              <p><span class="primary-text"><strong>{this.state.production.kWh}</strong></span> <span class="secondary-text">kWh</span></p>
            </div>
            <div class="col-sm">
              <p class="fas fa-medal big-icon__medal"></p>
              <p><span class="primary-text"><strong>{this.state.production.certificates}</strong></span> <span class="secondary-text">Certificate(s)</span>
              {this.claimButton()}</p>
            </div>
            <div class="col-sm">
              <p class="fas fa-leaf big-icon__green"></p>
              <p>
                <span class="primary-text"><strong>€{this.state.production.income},-</strong></span>
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
                {this.getEnergyButton(this.state.powerOptions.solarPanels, this.toggleSolarEnergy)}
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Wind energy</h4>
              </div>
              <div class="card-body">
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.windenergy, "fas fa-wind")}></p>
                {this.getEnergyButton(this.state.powerOptions.windenergy, this.toggleWindEnergy)}
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Smart meter</h4>
              </div>
              <div class="card-body">
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.smartEnergyMeter, "fas fa-tachometer-alt")}></p>
                {this.getEnergyButton(this.state.powerOptions.smartEnergyMeter, this.toggleSmartEnergyMeter)}
              </div>
            </div>

            <div class="card mb-4 shadow-sm">
              <div class="card-header primary">
                <h4 class="my-0 font-weight-normal">Outlets</h4>
              </div>
              <div class="card-body">
                <p className={this.getEnabledClassForIcons(this.state.powerOptions.Outlets, "fas fa-plug")}></p>
                {this.getEnergyButton(this.state.powerOptions.Outlets, this.toggleOutlets)}
              </div>
            </div>

          </div>

        </div>
      </div>
    );
  }
}
