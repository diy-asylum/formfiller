import React, { Component } from "react";
import { connect } from "react-redux";

class NameForm extends Component {
  render() {
    return <div className="name-form">name</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(NameForm);
