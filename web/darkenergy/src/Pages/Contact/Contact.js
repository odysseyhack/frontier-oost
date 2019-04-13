import { Component } from "inferno";
import { Input } from "../../Components/Input/Input";
import "./Contact.scss";

export class Contact extends Component {
  constructor(props) {
    super(props);
    this.props = props;
    this.state = {
      name: "",
      nameValid: false,
      email: "",
      emailValid: false,
      message: "",
      messageValid: false,
      error: false,
      errorMessage: null,
      sent: false,
      wasValidated: false
    };
  }

  sendmail = e => {
    e.preventDefault();

    if (this.state.emailValid && this.state.nameValid && this.state.messageValid) {
      const data = new FormData();
      data.append("name", this.state.name);
      data.append("email", this.state.email);
      data.append("message", this.state.message);

      fetch("/api/contactform.php", {
        method: "post",
        body: data
      })
        .then(res => {
          if (res.ok()) {
            this.setState({ sent: true, error: false });
          } else {
            this.setState({ sent: true, error: true });
          }
        })
        .catch(() => {
          this.setState({ sent: true, error: true });
        });
    } else {
      this.setState({ wasValidated: true });
    }
  };

  render() {
    const form = (
      <form action="api/contactform.php" method="POST" noValidate>
        <Input
          type="text"
          id="nameInput"
          name="name"
          label="Naam"
          placeholder="Your name..."
          onInput={e => this.setState({ name: e.target.value, nameValid: e.target.validity.valid })}
          value={this.state.name}
          feedback="Invalid name."
          wasValidated={this.state.wasValidated}
          isInvalid={!this.state.nameValid}
          required
        />
        <Input
          type="email"
          id="emailInput"
          name="email"
          label="Email"
          placeholder="Your email..."
          onInput={e => this.setState({ email: e.target.value, emailValid: e.target.validity.valid })}
          value={this.state.email}
          feedback="Invalid email."
          wasValidated={this.state.wasValidated}
          isInvalid={!this.state.emailValid}
          required
        />
        <div className="form-group">
          <label htmlFor="messageInput">Bericht</label>
          <textarea
            class="form-control"
            id="messageInput"
            name="message"
            rows="3"
            placeholder="Je bericht..."
            onInput={e => this.setState({ message: e.target.value, messageValid: e.target.validity.valid })}
            value={this.state.value}
            feedback="Vul een geldig bericht in."
            wasValidated={this.state.wasValidated}
            isInvalid={!this.state.messageValid}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary float-right" onClick={this.sendmail}>
          Verstuur
        </button>
      </form>
    );

    const card = (title, body, cssClasses) => (
      <div className={"card shadow-sm position-absolute " + cssClasses}>
        <div className="card-header">
          <h5>{title}</h5>
        </div>
        <div className="card-body">{body}</div>
        <div className="card-footer" />
      </div>
    );

    let thanksCard = null;

    if (this.state.sent) {
      thanksCard = this.state.error
        ? card("Aw.. snap", "Something went wrong sending your message", "animated bounceInDown delay-1s")
        : card("Thanks", "We will respond to your message as soon as possible.", "animated bounceInDown");
    }

    return (
      <div className="page animated fadeIn faster">
        <div className="container">
          <div className="row">
            <div className="col">&nbsp;</div>
            <div className="col-12 col-xs-12 col-sm-12 col-md-12 col-lg-8 col-xl-6">
              <div className="div-wrapper">
                {card("Send a message", form, this.state.sent ? (this.state.error ? "animated hinge" : "animated rollOut") : "")}
                {thanksCard}
              </div>
            </div>
            <div className="col">&nbsp;</div>
          </div>
        </div>
      </div>
    );
  }
}
