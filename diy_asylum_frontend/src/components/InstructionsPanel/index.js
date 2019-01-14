import React from "react";
import "./style.scss";

import contentPages from "../../contentpages";

const getHelpText = ({ currentStep }) => {
  const helpIndex = currentStep - 1;
  if (
    helpIndex === undefined ||
    helpIndex < 0 ||
    helpIndex >= contentPages.length
  ) {
    return "";
  }
  const page = contentPages[helpIndex];
  return page.help;
};

const InstructionsPanel = ({ currentStep }) => (
  <div className="instructions-panel col-sm">
    <h6>Help</h6>
    <p>{getHelpText({ currentStep })}</p>
    {/* Integrate the per-form-item help here somehow (how user interaction???) */}
  </div>
);

export default InstructionsPanel;
