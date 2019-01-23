import React, { Component } from "react";
import "./style.scss";
import { connect } from "react-redux";
import { nextFormStep, previousFormStep } from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";
import DemographicsForm from "./formSections/DemographicsForm.js";
import MailingForm from "./formSections/MailingForm.js";
import NameForm from "./formSections/NameForm.js";
import RegistrationForm from "./formSections/RegistrationForm.js";
import ResidenceForm from "./formSections/ResidenceForm.js";
// import contentPages from "../../contentpages";

class CenterForm extends Component {
  handleNextButton = () => {
    this.props.nextButton();
    this.props.setHelpText("");
  };

  handlePreviousButton = () => {
    this.props.prevButton();
    this.props.setHelpText("");
  };

  render() {

    const currentFormSection = this.props.formSections[
      this.props.step - 1
    ]

    return (
      <div className="center-form col-sm">
        {currentFormSection}
        <div className="button-container">
          <button onClick={this.handleNextButton}>Next</button>
          <button onClick={this.handlePreviousButton}>Previous</button>
        </div>
      </div>
    );
  }
}

// Set default props to hold all of the form sections
CenterForm.defaultProps = {
  // formSections: ["demographics", "name", "registration", "residence", "mailing"]
  formSections: [
    <DemographicsForm></DemographicsForm>,
    <MailingForm></MailingForm>,
    <NameForm></NameForm>,
    <RegistrationForm></RegistrationForm>,
    <ResidenceForm></ResidenceForm>
  ]
};

const mapStateToProps = state => ({
  step: state.form.currentStep
});

const mapDispatchToProps = {
  nextButton: nextFormStep,
  prevButton: previousFormStep,
  setHelpText: setInputHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
