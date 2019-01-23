import React from "react";
import "./style.scss";
import { connect } from "react-redux";

const InstructionsPanel = ({ sectionHelpText, inputHelpText }) => (
  <div className="instructions-panel col-sm">
    <h6>Instructions</h6>
    <p>{sectionHelpText}</p>
    {inputHelpText ? ([
      <hr key="hr-spacer"/>,
      <p key="input-help-txt">{inputHelpText}</p>
    ]) : null }
  </div>
);

const mapStateToProps = state => ({
  inputHelpText: state.helpText.inputHelpText,
  sectionHelpText: state.helpText.sectionHelpText
});

export default connect(mapStateToProps)(InstructionsPanel);
