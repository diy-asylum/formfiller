import React, { Component } from "react";
import { connect } from "react-redux";

class ResidenceForm extends Component {
  render() {
    return <div className="residence-form">residence</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ResidenceForm);
