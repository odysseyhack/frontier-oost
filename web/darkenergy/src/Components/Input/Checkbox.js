import { Component } from "inferno";

export class Checkbox extends Component {
  render() {
    return (
      <div className="form-group form-check">
        <input
          type="checkbox"
          className={"form-check-input" + ((this.props.isInvalid && this.props.wasValidated) ? " is-invalid" : "")}
          id={this.props.id}
          name={this.props.name}
          required={this.props.required}
          checked={this.props.checked}
          onInput={this.props.onInput}
        />
        <label className="form-check-label" htmlFor={this.props.id}>
          {this.props.label || this.props.name}
        </label>
        <div className="invalid-feedback">{this.props.feedback}</div>
      </div>
    );
  }
}
