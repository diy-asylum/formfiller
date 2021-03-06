import React, { Component } from "react";
import { connect } from "react-redux";
import { stepSetter } from "../reducers/form";
import NavHeader from "./NavHeader";
import ProgressPanel from "./ProgressPanel";
import CenterForm from "./CenterForm";
import SubmitForm from "./SubmitForm";
import InstructionsPanel from "./InstructionsPanel";
import Footer from "./Footer";
import { numPages } from "../contentpages";
import "./style.scss";

class MainView extends Component {
  constructor() {
    super();
    // set up state here
    this.state = {};
  }

  componentDidMount() {
    //
    // potentially fetch user data here
    //
  }

  render() {
    let middle;

    if (this.props.formStep <= numPages) {
      middle = <CenterForm />;
    } else {
      middle = <SubmitForm />;
    }

    return (
      <div className="main-view">
        <NavHeader />

        <div className="container flex-container">
          <div className="row top-pad data-entry">
            <ProgressPanel
              currentStep={this.props.formStep}
              setStep={this.props.setStep}
            />
            {middle}
            <InstructionsPanel currentStep={this.props.formStep || 1} />
          </div>
        </div>
        <Footer />
      </div>
    );
  }
}
// any redux state you want to read as props
const mapStateToProps = state => ({
  formStep: state.form.currentStep
});
// any dispatcher you want to update redux state
const mapDispatchToProps = {
  setStep: stepSetter
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MainView);
