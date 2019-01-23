import React, { Component } from "react";
import { connect } from "react-redux";
import { setSectionHelpText } from "../../../reducers/helpText";

class MailingForm extends Component {
  componentDidMount() {
    // this.props.setHelpText("mailing")
    this.props.setHelpText("Use an address in the United States where you can currently receive mail. This may be a government facility. If this is the same as your answer to the previous set of questions, leave it blank.")
  }

  render() {
    return <div className="mailing-form">mail</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {
  setHelpText: setSectionHelpText
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MailingForm);
