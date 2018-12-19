import React, { Component } from "react";
import './style.scss';
import { injectIntl, defineMessages } from "react-intl";
import { connect } from "react-redux";
import { updateUserLocale } from '../../reducers/user';

const messages = defineMessages({
  headerText: {
    id: "Header.headerText",
    defaultMessage: "Asylum"
  }
});

class NavHeader extends Component {
  handleChange = event => {
    this.props.updateUserLocale(event.target.value)
  };

  render() {
    const formatMessage = this.props.intl.formatMessage;

    return (
      <div
        className="nav-header container-fluid"
      >
        <span>{formatMessage(messages.headerText)}</span>

        <select onChange={this.handleChange} style={{ float: "right" }}>
          <option value="en">English</option>
          <option value="es">Español</option>
        </select>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  locale: state.user.locale
});
const mapDispatchToProps = {
  updateUserLocale
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(injectIntl(NavHeader));
