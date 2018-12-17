import React from "react";
import { Link } from "react-router-dom";

import { injectIntl, defineMessages } from "react-intl";

const messages = defineMessages({
  title: {
    id: "FormEnd.header",
    defaultMessage: "Form! page 3 of 3"
  },
  pageDescription: {
    id: "FormEnd.pageDescription",
    defaultMessage:
      "This is the beginning of the form. If there was content, this would be where it started"
  },
  homeLink: {
    id: "FormEnd.homeLink",
    defaultMessage: "Go back home"
  },
  formStartLink: {
    id: "FormEnd.formStartLink",
    defaultMessage: "Go back to the beginning of the form"
  },
  formMiddleLink: {
    id: "FormEnd.formMiddleLink",
    defaultMessage: "Go back to the middle of the form"
  }
});

const FormEnd = ({ intl: { formatMessage } }) => (
  <div>
    <h1 className="title-header">{formatMessage(messages.title)}</h1>
    <p>{formatMessage(messages.pageDescription)}</p>
    <p>
      <Link to="/home">{formatMessage(messages.homeLink)}</Link>
    </p>
    <p>
      <Link to="/formStart">{formatMessage(messages.formStartLink)}</Link>
    </p>
    <p>
      <Link to="/formMiddle">{formatMessage(messages.formMiddleLink)}</Link>
    </p>
  </div>
);

export default injectIntl(FormEnd);
