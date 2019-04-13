import { Component } from "inferno";

export class Input extends Component {
  constructor(props) {
    super();
    this.props = props;
  }

  render() {
    return (
      <div className="form-group">
        <label htmlFor={this.props.id}>{this.props.label || this.props.name}</label>
        <input className={"form-control" + (this.props.isInvalid && this.props.wasValidated ? " is-invalid" : "")} {...this.props} />
        <div className="invalid-feedback">{this.props.feedback}</div>
      </div>
    );
  }
}
