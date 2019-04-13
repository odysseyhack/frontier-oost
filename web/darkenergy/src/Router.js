import { Component } from "inferno";
import { Switch, Route, withRouter } from "inferno-router";
import PropTypes from "prop-types";
import { Home } from "./Pages/Home/Home";
import { About } from "./Pages/About/About";
import { Privacy } from "./Pages/Privacy/Privacy";
import { Error404 } from "./Pages/Error/Error404";
import { Contact } from "./Pages/Contact/Contact";
import { Terms } from "./Pages/Terms/Terms";
import { Cookies } from "./Pages/Cookies/Cookies";
import { Copyright } from "./Pages/Copyright/Copyright";

class _Router extends Component {
    static propTypes = {
      location: PropTypes.object.isRequired
    };
  
    componentDidUpdate(prevProps) {
      if (this.props.location !== prevProps.location) {
        window.scrollTo(0, 0);
      }
    }
  
    render() {
      return (
        <Switch location={this.props.location}>
          <Route exact path="/" component={Home} />
          
          <Route path="/about" component={About} />
          <Route path="/contact" component={Contact} />
          <Route path="/terms" component={Terms} />
          <Route path="/privacy" component={Privacy} />
          <Route path="/cookies" component={Cookies} />
          <Route path="/copyright" component={Copyright} />
  
          <Route component={Error404} />
        </Switch>
      );
    }
  }
  
  export const Router = withRouter(_Router);