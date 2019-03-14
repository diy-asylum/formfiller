import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import formfill from "../../requests/formfill";
import { previousFormStep } from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";

const SubmitForm = ({ formValues, prevButton, helpTextSetter }) => (
  <div className="submit-form col-sm">
    <h4>Submit</h4>
    <p>
      Click below to download your i-589 form. Follow the instructions on the
      first page to complete your application for asylum.
    </p>
    <div className="button-container">
      <button
        onClick={() => {
          prevButton();
          helpTextSetter("");
        }}
      >
        Previous
      </button>
      <button onClick={() => formfill(formValues)}>Submit</button>
    </div>
  </div>
);

const mapStateToProps = state => ({
  formValues: state.form.formValues
});

const mapDispatchToProps = {
  prevButton: previousFormStep,
  helpTextSetter: setInputHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(SubmitForm);
