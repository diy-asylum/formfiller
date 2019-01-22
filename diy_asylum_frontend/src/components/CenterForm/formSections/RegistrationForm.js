import React, { Component } from "react";
import { connect } from "react-redux";

class RegistrationForm extends Component {
  render() {
    return <div className="registration-form">registration</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(RegistrationForm);
