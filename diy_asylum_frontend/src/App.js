import React, { Component } from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { connect } from "react-redux";
import MainView from "./components/MainView";
import { IntlProvider, addLocaleData, injectIntl } from "react-intl";
// import { IntlProvider } from "react-intl";
// import { IntlProvider, addLocaleData } from "react-intl";
import enLocaleData from "react-intl/locale-data/en";
import esLocaleData from "react-intl/locale-data/es";
import translations from "./i18n/locales";
import "./App.scss";

class App extends Component {
  // when the app mounts, before rendering add the locale i18n data
  componentDidMount() {
    addLocaleData(enLocaleData);
    addLocaleData(esLocaleData);
  }

  // then render and pass the correct locale messages to the IntlProvider
  render() {
    const { locale } = this.props;
    const messages = translations[locale];
    return (
      <IntlProvider locale={locale} key={locale} messages={messages}>
        <div className="App">
          <Router>
            <Route
              path="/:filter?"
              render={({ match }) => <MainView filter={match.params.filter} />}
            />
          </Router>
        </div>
      </IntlProvider>
    );
  }
}

const mapStateToProps = state => ({
  locale: state.user.locale
});

export default connect(
  mapStateToProps,
  {}
)(App);
