import React from "react";
import { Link } from "react-router-dom";

import { injectIntl, defineMessages } from "react-intl";

const messages = defineMessages({
  title: {
    id: "FormMiddle.header",
    defaultMessage: "Form! page 2 of 3"
  },
  pageDescription: {
    id: "FormMiddle.pageDescription",
    defaultMessage:
      "This is the middle of the form. If there was content, some good stuff would go right here."
  },
  homeLink: {
    id: "FormMiddle.homeLink",
    defaultMessage: "Go back home"
  },
  formStartLink: {
    id: "FormMiddle.formStartLink",
    defaultMessage: "Go to the beginning of the form"
  },
  formEndLink: {
    id: "FormMiddle.formEndLink",
    defaultMessage: "Go to the end of the form"
  }
});

const FormMiddle = ({ intl: { formatMessage } }) => (
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
      <Link to="/formEnd">{formatMessage(messages.formEndLink)}</Link>
    </p>
  </div>
);

export default injectIntl(FormMiddle);
