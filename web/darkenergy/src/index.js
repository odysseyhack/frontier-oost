import { render } from "inferno";
import "./index.scss";
import App from "./App";
import * as serviceWorker from "./serviceWorker";
import { BrowserRouter } from "inferno-router";
import Auth from "./Service/Auth";

const auth = new Auth();
render(
  <BrowserRouter>
    <App auth={auth} />
  </BrowserRouter>,
  document.getElementById("root")
);
serviceWorker.unregister();
