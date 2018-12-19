import React from "react";

import { injectIntl, defineMessages } from "react-intl";

const messages = defineMessages({
  footerText: {
    id: "Footer.footerText",
    defaultMessage:
      "DIY Asylum, LLC is not affiliated with any law firm, nor is it affiliated with any government agency. This tool is offered free of charge. The I-589 application for asylum can be downloaded at https://www.uscis.gov/i-589 . This website is not a lawyer, and does not offer legal advice."
  }
});

const Footer = ({ intl: { formatMessage } }) => (
  <div className="bottom-footer row">
    <div className="col-sm copyright">
      <p>© 2018 DIY Asylum, LLC</p>
    </div>
    <div className="col-sm footerText">
      <p>{formatMessage(messages.footerText)}</p>
    </div>
  </div>
);

export default injectIntl(Footer);
