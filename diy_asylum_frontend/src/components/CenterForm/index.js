import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import { nextFormStep, previousFormStep } from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";

import contentPages from "../../contentpages";
import FormContentComponent from "../FormContentComponent";

const FormContent = ({ step, helpTextSetter }) => {
  // index pages from zero, but steps start at one

  step -= 1;

  if (step >= 0 && step < contentPages.length) {
    return (
      <FormContentComponent
        formElements={contentPages[step].formElements}
        helpTextSetter={helpTextSetter}
      />
    );
  } else {
    return <div>{`No form found for step ${step}`}</div>;
  }
};

const CenterForm = ({ step, nextButton, prevButton, helpTextSetter }) => (
  <div className="center-form col-sm">
    <FormContent step={step} helpTextSetter={helpTextSetter} />
    <div className="button-container">
      <button onClick={nextButton}>Next</button>
      <button onClick={prevButton}>Previous</button>
    </div>
  </div>
);

const mapStateToProps = state => ({
  step: state.form.currentStep
});

const mapDispatchToProps = {
  nextButton: nextFormStep,
  prevButton: previousFormStep,
  helpTextSetter: setInputHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
