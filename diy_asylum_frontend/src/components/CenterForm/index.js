import React, { Component } from "react";
import "./style.scss";
import { connect } from "react-redux";
import { nextFormStep, previousFormStep } from "../../reducers/form";

class CenterForm extends Component {
  render() {
    return (
      <div className="center-form col-sm">
        <p className="dummy-text">
          This is a placeholder to represent step
          <span>{this.props.step}</span>
          and its associated form inputs
        </p>
        <div className="button-container">
          <button onClick={this.props.nextFormStep}>Next</button>
          <button onClick={this.props.previousFormStep}>Previous</button>
        </div>
      </div>
    );
  }
}
const mapStateToProps = state => ({
  step: state.form.currentStep
});
const mapDispatchToProps = { nextFormStep, previousFormStep };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
