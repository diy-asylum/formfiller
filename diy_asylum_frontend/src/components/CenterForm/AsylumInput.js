import React, { Component } from "react";
import "./style.scss";
import { connect } from "react-redux";

class AsylumInput extends Component {
  handleOnFocus = (event) => {
    // handle the helper txt
  }

  render() {
    return (
      <div>
        <p>{this.props.label}</p>
        <p>
          <input
            name={this.props.elementName}
            type={this.props.type}
            onFocus={this.handleOnFocus}
          />
        </p>
      </div>
    );
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(AsylumInput);
