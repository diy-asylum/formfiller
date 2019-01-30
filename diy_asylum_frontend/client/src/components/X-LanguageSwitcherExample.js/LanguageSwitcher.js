import React from "react";
import { injectIntl, defineMessages } from "react-intl";
import { connect } from "react-redux";
import { makeSetLocaleAction } from "../reducers/locale";

const messages = defineMessages({
  languageSwitcherTitle: {
    id: "LanguageSwitcher.title",
    defaultMessage: "Choose language"
  }
});

const LanguageSwitcher = ({ intl: { formatMessage }, setLocale }) => (
  <div className="languageSwitcher">
    <h2>{formatMessage(messages.languageSwitcherTitle)}</h2>
    <p>
      <button onClick={() => setLocale("en")}>English</button>
    </p>
    <p>
      <button onClick={() => setLocale("es")}>Español</button>
    </p>
  </div>
);

const mapStateToProps = () => ({});
const mapDispatchToProps = dispatch => ({
  setLocale: newLocale => dispatch(makeSetLocaleAction(newLocale))
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(injectIntl(LanguageSwitcher));
