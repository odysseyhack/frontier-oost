import { Component } from "inferno";
import { Link } from "inferno-router";
import "./Footer.scss";
import config from "../../Service/config.json";

export class Footer extends Component {
  render() {
    return (
      <footer className="footer page-footer">
        <div className="container">
          <div className="row">
            <div className="col-12 col-md-6">
              <h5>
                <i className="fab fa-leanpub" /> {config.company.name}
              </h5>
              <p className="gray">
                At {config.company.name} you can claim your energy certificates
                in exchange for your data.
              </p>
            </div>
            <div className="col-12 col-md-3">
              <h5>Information</h5>
              <ul className="link-list gray">
                <li>
                  <Link to="/about">
                    <i className="fas fa-id-card" /> About
                  </Link>
                </li>
                <li>
                  <Link to="/contact">
                    <i className="fas fa-comments" /> Contact
                  </Link>
                </li>
                <li>
                  <Link to="/terms">
                    <i className="fas fa-balance-scale" /> Terms
                  </Link>
                </li>
                <li>
                  <Link to="/privacy">
                    <i className="fas fa-user-shield" /> Privacy
                  </Link>
                </li>
                <li>
                  <Link to="/cookies">
                    <i className="fas fa-cookie-bite" /> Cookies
                  </Link>
                </li>
                <li>
                  <Link to="/copyright">
                    <i className="fas fa-copyright" /> Copyright
                  </Link>
                </li>
              </ul>
            </div>
            <div className="col-12 col-md-3">
              <h5>Social</h5>
              <ul className="link-list gray">
                <li>
                  <Link to="/facebook">
                    <i className="fab fa-facebook" /> Facebook
                  </Link>
                </li>
                <li>
                  <Link to="/twitter">
                    <i className="fab fa-twitter" /> Twitter
                  </Link>
                </li>
                <li>
                  <Link to="/google-plus">
                    <i className="fab fa-google-plus-g" /> Google+
                  </Link>
                </li>
                <li>
                  <Link to="/pinterest">
                    <i className="fab fa-pinterest" /> Pinterest
                  </Link>
                </li>
                <li>
                  <Link to="/youtube">
                    <i className="fab fa-youtube" /> Youtube
                  </Link>
                </li>
                <li>
                  <Link to="/instagram">
                    <i className="fab fa-instagram" /> Instagram
                  </Link>
                </li>
              </ul>
            </div>
          </div>
          <div className="row small">
            <div className="col text-center gray">
              <i className="fas fa-copyright" /> copyright {config.company.name}{" "}
              {new Date().getFullYear()}
              <br />
              All Rights Reserved.
            </div>
          </div>
        </div>
      </footer>
    );
  }
}
