import React from "react";
import "./style.scss";
import { connect } from "react-redux";

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

const InstructionsPanel = ({ currentStep, inputHelpText }) => (
  <div className="instructions-panel col-sm">
    <h6>Instructions</h6>
    <p>{getHelpText({ currentStep })}</p>
    <div>
      <h6>Help</h6>
      <p>
        {inputHelpText ||
          "Click on a question box to for specific instructions"}
      </p>
    </div>
  </div>
);

const mapStateToProps = state => ({
  step: state.form.currentStep,
  inputHelpText: state.helpText.inputHelpText
});

export default connect(mapStateToProps)(InstructionsPanel);
