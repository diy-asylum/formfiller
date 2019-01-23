import React, { Component } from "react";
import { connect } from "react-redux";
import { setSectionHelpText } from "../../../reducers/helpText";


class DemographicsForm extends Component {
  componentDidMount() {
    // console.log("firing", this.props.setHelpText)
    this.props.setHelpText("Please enter your Demographic information")
  }


  render() {
    return <div className="demographics-form">demo</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {
  setHelpText: setSectionHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(DemographicsForm);
