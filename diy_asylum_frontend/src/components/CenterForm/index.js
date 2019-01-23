import React, { Component } from "react";
import "./style.scss";
import { connect } from "react-redux";
import { nextFormStep, previousFormStep, setProgressStepList } from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";
import DemographicsForm from "./formSections/DemographicsForm.js";
import MailingForm from "./formSections/MailingForm.js";
import NameForm from "./formSections/NameForm.js";
import RegistrationForm from "./formSections/RegistrationForm.js";
import ResidenceForm from "./formSections/ResidenceForm.js";

class CenterForm extends Component {
  componentDidMount = () => {
    const sectionNames = this.props.formSections.map(section => section.name)
    this.props.setStepList(sectionNames);
  }

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
        {currentFormSection.component}
        <div className="button-container">
          <button onClick={this.handleNextButton}>Next</button>
          <button onClick={this.handlePreviousButton}>Previous</button>
        </div>
      </div>
    );
  }
}

// Set default props to hold all of the form sections
// NOTE this is the center of all truth!
// or atleast it is when comes to the ordering of form sections
CenterForm.defaultProps = {
  formSections: [
    { name: "Demographics", component: <DemographicsForm /> },
    { name: "Mailing", component: <MailingForm /> },
    { name: "Name", component: <NameForm /> },
    { name: "Registration", component: <RegistrationForm /> },
    { name: "Residence", component: <ResidenceForm /> }
  ]
};


const mapStateToProps = state => ({
  step: state.form.currentStep
});

const mapDispatchToProps = {
  nextButton: nextFormStep,
  prevButton: previousFormStep,
  setHelpText: setInputHelpText,
  setStepList : setProgressStepList
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
