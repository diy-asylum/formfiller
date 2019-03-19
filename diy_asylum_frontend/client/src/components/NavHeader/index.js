import React, { Component } from "react";
import "./style.scss";
import { injectIntl, defineMessages } from "react-intl";
import { connect } from "react-redux";
import { updateUserLocale } from "../../reducers/user";

const messages = defineMessages({
  headerText: {
    id: "Header.headerText",
    defaultMessage: "Asylum"
  }
});

class NavHeader extends Component {
  handleChange = event => {
    this.props.updateUserLocale(event.target.value);
  };

  render() {
    return (
      <div className="nav-header container-fluid">
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
          <div className="container">
            <a className="navbar-brand" href="/">
              Start Form
            </a>
            <button
              className="navbar-toggler"
              type="button"
              data-toggle="collapse"
              data-target="#navbarResponsive"
              aria-controls="navbarResponsive"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span className="navbar-toggler-icon" />
            </button>
            <div className="collapse navbar-collapse" id="navbarResponsive">
              <ul className="navbar-nav ml-auto">
                <li className="nav-item">
                  <a className="nav-link" href="/landing">
                    Home
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link active" href="/about">
                    About
                    <span className="sr-only">(current)</span>
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/landing">
                    Services
                  </a>
                </li>
                <li className="nav-item">
                  <a className="nav-link" href="/landing">
                    Contact
                  </a>
                </li>
              </ul>
            </div>
            <select
              className="locale-select navbar-btn"
              onChange={this.handleChange}
              value={this.props.locale}
            >
              <option value="en">English</option>
              <option value="es">Español</option>
            </select>
          </div>
        </nav>
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
