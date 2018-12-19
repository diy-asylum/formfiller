import React, { Component } from "react";
import { connect } from "react-redux";
import { updateUserLocale } from "../reducers/user";
import { nextFormStep, previousFormStep } from "../reducers/form";

class MainView extends Component {
  constructor() {
    super();
    this.state = {};
  }

  componentDidMount() {
    //
    // potentially fetch user data here
    //
  }

  handleChange = event => {
    const newValue = event.target.value;
    this.props.updateUserLocale(newValue);
  };

  render() {
    return (
      <div className="main-view">
        Hello World
        <br />
        <button onClick={this.props.nextFormStep}>Next</button>
        <button onClick={this.props.previousFormStep}>Previous</button>
        <br />
        <select onChange={this.handleChange}>
          <option value="en">English</option>
          <option value="es">Español</option>
        </select>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  step: state.form.currentStep,
  locale: state.user.locale
});
const mapDispatchToProps = {
  updateUserLocale,
  nextFormStep,
  previousFormStep
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MainView);
