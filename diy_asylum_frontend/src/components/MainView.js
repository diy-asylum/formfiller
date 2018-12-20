import React, { Component } from "react";
import { connect } from "react-redux";
import NavHeader from "./NavHeader";
import ProgressPanel from "./ProgressPanel";
import CenterForm from "./CenterForm";
import InstructionsPanel from "./InstructionsPanel";
import Footer from "./Footer";

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
    return (
      <div className="main-view">
        <NavHeader />

        <div className="container">
          <div className="row">
            <ProgressPanel currentStep={this.props.formStep} />
            <CenterForm />
            <InstructionsPanel />
          </div>
          <Footer />
        </div>
      </div>
    );
  }
}
// any redux state you want to read as props
const mapStateToProps = state => ({
  formStep: state.form.currentStep
});
// any dispatcher you want to update redux state
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MainView);
