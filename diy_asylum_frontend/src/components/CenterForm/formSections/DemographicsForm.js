import React, { Component } from "react";
import { connect } from "react-redux";

class DemographicsForm extends Component {
  render() {
    return <div className="demographics-form">demo</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(DemographicsForm);
