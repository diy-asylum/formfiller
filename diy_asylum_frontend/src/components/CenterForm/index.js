import React, { Component } from "react";
import "./style.scss";
import { connect } from "react-redux";
import {
  nextFormStep,
  previousFormStep
} from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";
import DemographicsForm from "./formSections/DemographicsForm.js";
import MailingForm from "./formSections/MailingForm.js";
import NameForm from "./formSections/NameForm.js";
import RegistrationForm from "./formSections/RegistrationForm.js";
import ResidenceForm from "./formSections/ResidenceForm.js";

class CenterForm extends Component {
  // componentDidMount = () => {
  //   const sectionNames = this.props.formSections.map(section => section.name);
  //   this.props.setStepList(sectionNames);
  // };

  handleNextButton = () => {
    this.props.nextButton();
    this.props.setHelpText("");
  };

  handlePreviousButton = () => {
    this.props.prevButton();
    this.props.setHelpText("");
  };

  render() {
    const currentFormSection = this.props.sectionsDictionary[
      this.props.activeStepName
    ];

    // console.log(this.activeStepName)
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

// Set default props to hold all of a dictionary for pairing
// section name to it's relevant component
CenterForm.defaultProps = {
  sectionsDictionary: {
    Demographics: <DemographicsForm />,
    Mailing: <MailingForm />,
    Name: <NameForm />,
    Registration: <RegistrationForm />,
    Residence: <ResidenceForm />
  }
};

// [
//   { name: "Demographics", component: <DemographicsForm /> },
//   { name: "Mailing", component: <MailingForm /> },
//   { name: "Name", component: <NameForm /> },
//   { name: "Registration", component: <RegistrationForm /> },
//   { name: "Residence", component: <ResidenceForm /> }
// ]
// };

const mapStateToProps = state => ({
  activeStepName: state.form.activeStepName
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
