import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import {
  nextFormStep,
  previousFormStep,
  setFormElementState
} from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";

import FormikedForm from "../Forms";

import contentPages from "../../contentpages";

const FormContent = ({
  step,
  fullFormState,
  helpTextSetter,
  setFormElementState
}) => {
  // index pages from zero, but steps start at one

  step -= 1;

  if (step >= 0 && step < contentPages.length) {
    const contentPage = contentPages[step];
    return (
      <FormikedForm
        contentPage={contentPage}
        helpTextSetter={helpTextSetter}
        fullFormState={fullFormState}
        setFormElementState={setFormElementState}
      />
    );
  } else {
    return <div>{`No form found for step ${step}`}</div>;
  }
};

const CenterForm = ({
  step,
  nextButton,
  prevButton,
  helpTextSetter,
  setFormElementState,
  fullFormState
}) => (
  <div className="center-form col-sm">
    <h4>{contentPages[step - 1].name}</h4>
    <FormContent
      step={step}
      helpTextSetter={helpTextSetter}
      setFormElementState={setFormElementState}
      fullFormState={fullFormState}
    />
    <div className="button-container">
      <button
        onClick={() => {
          nextButton();
          helpTextSetter("");
        }}
      >
        Next
      </button>
      <button
        onClick={() => {
          prevButton();
          helpTextSetter("");
        }}
      >
        Previous
      </button>
    </div>
  </div>
);

const mapStateToProps = state => ({
  step: state.form.currentStep,
  fullFormState: state.form.formValues
});

const mapDispatchToProps = {
  nextButton: nextFormStep,
  prevButton: previousFormStep,
  helpTextSetter: setInputHelpText,
  setFormElementState
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
