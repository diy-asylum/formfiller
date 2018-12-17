import React from "react";
import { Route } from "react-router-dom";

import Home from "./pages/Home";
import FormStart from "./pages/FormStart";
import FormMiddle from "./pages/FormMiddle";
import FormEnd from "./pages/FormEnd";
import LanguageSwitcher from "./components/LanguageSwitcher";

import "./App.css";

import { injectIntl, defineMessages } from "react-intl";

const messages = defineMessages({
  appTitle: {
    id: "App.title",
    defaultMessage: "Title of the app"
  }
});


const App = () => ({
  
})

/*
const App = ({ intl: { formatMessage } }) => (
  <div className="App">
    <h2 className="appTitle">{formatMessage(messages.appTitle)}</h2>
    <LanguageSwitcher />
    <div className="AppContent">
      <Route exact path="/" component={Home} />
      <Route path="/home" component={Home} />
      <Route path="/formStart" component={FormStart} />
      <Route path="/formMiddle" component={FormMiddle} />
      <Route path="/formEnd" component={FormEnd} />
    </div>
  </div>
);
*/

export default injectIntl(App);
