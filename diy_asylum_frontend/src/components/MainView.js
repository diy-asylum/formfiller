import React, { Component } from "react";
import { connect } from "react-redux";
import NavHeader from "./NavHeader";
import ProgressPanel from "./ProgressPanel";
import CenterForm from "./CenterForm";
import InstructionsPanel from "./InstructionsPanel";
import Footer from "./Footer";

class MainView extends Component {
  render() {
    return (
      <div className="main-view">
        <NavHeader />

        <div className="container">
          <div className="row">
            <ProgressPanel
              stepCounter={this.props.stepCounter}
              sectionsList={this.props.sectionsList}
            />
            <CenterForm />
            <InstructionsPanel
              sectionsList={this.props.sectionsList}
            />
          </div>
          <Footer />
        </div>
      </div>
    );
  }
}
// any redux state you want to read as props
const mapStateToProps = state => ({
  stepCounter: state.form.currentStepCounter,
  sectionsList: state.form.sectionsList
});
// any dispatcher you want to update redux state
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MainView);
