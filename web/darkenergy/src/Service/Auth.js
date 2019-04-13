import auth0 from "auth0-js";
import config from "./config.json";

export default class Auth {
  accessToken;
  idToken;
  expiresAt;

  auth0 = new auth0.WebAuth(config.auth);

  constructor() {
    this.login = this.login.bind(this);
    this.logout = this.logout.bind(this);
    this.handleAuthentication = this.handleAuthentication.bind(this);
    this.isAuthenticated = this.isAuthenticated.bind(this);
    this.getAccessToken = this.getAccessToken.bind(this);
    this.getIdToken = this.getIdToken.bind(this);
    this.renewSession = this.renewSession.bind(this);
  }

  login() {
    this.auth0.authorize();
  }

  handleAuthentication(redirect) {
    this.auth0.parseHash((err, authResult) => {
      if (authResult && authResult.accessToken && authResult.idToken) {
        this.setSession(authResult, redirect);
        console.log("success!!!!");
      } else if (err) {
        redirect("/");
      }
    });
  }

  getAccessToken() {
    return this.accessToken;
  }

  getIdToken() {
    return this.idToken;
  }

  setSession(authResult, redirect) {
    // Set isLoggedIn flag in localStorage
    localStorage.setItem("isLoggedIn", "true");
    localStorage.setItem("accessToken", authResult.accessToken);
    localStorage.setItem("idToken", authResult.idToken);

    // Set the time that the access token will expire at
    let expiresAt = authResult.expiresIn * 1000 + new Date().getTime();
    this.accessToken = authResult.accessToken;
    this.idToken = authResult.idToken;
    this.expiresAt = expiresAt;
    localStorage.setItem("expiresAt", expiresAt);

    // navigate to the home route
    redirect("/");
  }

  renewSession(redirect) {
    this.auth0.checkSession({}, (err, authResult) => {
      if (authResult && authResult.accessToken && authResult.idToken) {
        this.setSession(authResult);
      } else if (err) {
        this.logout(redirect);
        console.log(err);
      }
    });
  }

  logout(redirect) {
    // Remove tokens and expiry time
    this.accessToken = null;
    this.idToken = null;
    this.expiresAt = 0;

    // Remove isLoggedIn flag from localStorage
    localStorage.removeItem("isLoggedIn");

    this.auth0.logout({
      return_to: window.location.origin
    });

    // navigate to the home route
    redirect("/");
  }

  isAuthenticated() {
    if (localStorage.getItem("isLoggedIn") === "true") {
        const expiresAt = localStorage.getItem("expiresAt");

      return new Date().getTime() < expiresAt;
    }
  }
}
