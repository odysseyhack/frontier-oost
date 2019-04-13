import { Component } from "inferno";
import { Link } from "inferno-router";
import config from "../../Service/config.json";

export class Header extends Component {
  render() {
    return (
      <nav className="navbar">
        <Link className="navbar-brand" to="/">
          <i className="fas fa-power-off" />
          {" " + config.company.name}
        </Link>
      </nav>
    );
  }
}
