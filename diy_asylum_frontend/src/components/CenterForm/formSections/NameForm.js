import React, { Component } from "react";
import { connect } from "react-redux";
import { setSectionHelpText } from "../../../reducers/helpText";

class NameForm extends Component {
  componentDidMount() {
    // this.props.setHelpText("Name")
    this.props.setHelpText("Your first, last, and middle name will be entered here.")
  }

  render() {
    return <div className="name-form">name</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {
  setHelpText: setSectionHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(NameForm);
