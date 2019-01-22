import React, { Component } from "react";
import { connect } from "react-redux";

class MailingForm extends Component {
  componentDidMount(){
    // update helper
  }

  render() {
    return <div className="mailing-form">mail</div>;
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MailingForm);
