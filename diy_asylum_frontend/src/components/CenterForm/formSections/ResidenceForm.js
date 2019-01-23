import React, { Component } from "react";
import { connect } from "react-redux";
import { setSectionHelpText } from "../../../reducers/helpText";

class ResidenceForm extends Component {
  componentDidMount() {
    this.props.setHelpText("Use the address where you are currently staying in the United States. This may be a government facility.")
  }

  render() {
    return <div className="residence-form">residence</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {
  setHelpText: setSectionHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ResidenceForm);
