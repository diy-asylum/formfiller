import React from "react";
import { Link } from "react-router-dom";

import { injectIntl, defineMessages } from "react-intl";

import Form from "./form";

const messages = defineMessages({
  title: {
    id: "FormStart.header",
    defaultMessage: "Form! page 1 of 3"
  },
  pageDescription: {
    id: "FormStart.pageDescription",
    defaultMessage:
      "This is the beginning of the form. If there was content, this would be where it started"
  },
  homeLink: {
    id: "FormStart.homeLink",
    defaultMessage: "Go back home"
  },
  formMiddleLink: {
    id: "FormStart.formMiddleLink",
    defaultMessage: "Go to the middle of the form"
  },
  formEndLink: {
    id: "FormStart.formEndLink",
    defaultMessage: "Go to the end of the form"
  }
});

const FormStart = ({ intl: { formatMessage } }) => (
  <div>
    <h1 className="title-header">{formatMessage(messages.title)}</h1>
    <p>{formatMessage(messages.pageDescription)}</p>
    <p>
      <Link to="/home">{formatMessage(messages.homeLink)}</Link>
    </p>
    <p>
      <Link to="/formMiddle">{formatMessage(messages.formMiddleLink)}</Link>
    </p>
    <p>
      <Link to="/formEnd">{formatMessage(messages.formEndLink)}</Link>
    </p>
    <p>
      <Form user={{}} />
    </p>
  </div>
);

export default injectIntl(FormStart);
