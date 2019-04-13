import { Component } from "inferno";
import { Router } from "./Router";
import { Header } from "./Pages/Header/Header";
import { Footer } from "./Pages/Footer/Footer";
import { Login } from "./Pages/Login/Login";
import { withRouter } from "inferno-router";

class _App extends Component {
  constructor(props) {
    super();
    this.props = props;
  }

  render() {
    const auth = this.props.auth;

    const isAuthenticated = auth.isAuthenticated();

    if (!isAuthenticated) {
      if (this.props.location.pathname === "/callback") {
        auth.handleAuthentication(url => this.props.history.push(url));
        return <div>Please wait...</div>;
      }

      return <Login auth={auth} />;
    }

    return [<Header />, <Router />, <Footer />];
  }
}

export default withRouter(_App);
