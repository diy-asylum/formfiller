import React from "react";

import { injectIntl, defineMessages } from "react-intl";

const messages = defineMessages({
  headerText: {
    id: "Header.headerText",
    defaultMessage:
      "Some header text would go here, if we had any. We might even do some kind of navbar, although to be honest, I'm not sure what we would nav."
  }
});

const Header = ({ intl: { formatMessage } }) => (
  <div className="headerPanel">
    <p>{formatMessage(messages.headerText)}</p>
  </div>
);

export default injectIntl(Header);
