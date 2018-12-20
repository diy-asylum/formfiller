import React from "react";
import { Link } from "react-router-dom";

import { injectIntl, defineMessages } from "react-intl";

const messages = defineMessages({
  title: {
    id: "Home.header",
    defaultMessage: "Hello, international world!"
  },
  homeText: {
    id: "Home.paragraph",
    defaultMessage: "Welcome to the form! I'm sure everything will be fine."
  },
  formStartLink: {
    id: "Home.formStartLink",
    defaultMessage: "Go to the beginning of the form"
  },
  formMiddleLink: {
    id: "Home.formMiddleLink",
    defaultMessage: "Go to the middle of the form"
  },
  formEndLink: {
    id: "Home.formEndLink",
    defaultMessage: "Go to the end of the form"
  }
});

const Home = ({ intl: { formatMessage } }) => (
  <div>
    <h1 className="title-header">{formatMessage(messages.title)}</h1>
    <p>{formatMessage(messages.homeText)}</p>
    <p>
      <Link to="/formStart">{formatMessage(messages.formStartLink)}</Link>
    </p>
    <p>
      <Link to="/formMiddle">{formatMessage(messages.formMiddleLink)}</Link>
    </p>
    <p>
      <Link to="/formEnd">{formatMessage(messages.formEndLink)}</Link>
    </p>
  </div>
);

export default injectIntl(Home);
