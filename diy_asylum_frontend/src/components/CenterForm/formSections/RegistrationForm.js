import React, { Component } from "react";
import { connect } from "react-redux";
import { setSectionHelpText } from "../../../reducers/helpText";

class RegistrationForm extends Component {

  componentDidMount() {
    this.props.setHelpText("The numbers asked here will help identify you and track your application")
  }
  render() {
    return <div className="registration-form">registration</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {
  setHelpText: setSectionHelpText

};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(RegistrationForm);
