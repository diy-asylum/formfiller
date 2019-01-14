import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import { nextFormStep, previousFormStep } from "../../reducers/form";

import contentPages from "../../contentpages";
import makeContentPage from "../ContentPageMaker";

const DummyText = ({ step }) => {
  // index pages from zero, but steps start at one

  step -= 1;

  if (step >= 0 && step < contentPages.length) {
    return makeContentPage(contentPages[step]);
  } else {
    return <div>{`No form found for step ${step}`}</div>;
  }
};

const CenterForm = ({ step, nextButton, prevButton }) => (
  <div className="center-form col-sm">
    <DummyText step={step} />
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
  prevButton: previousFormStep
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
