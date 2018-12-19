import React, { Component } from 'react';
import { connect } from 'react-redux';

class MainView extends Component {
  constructor() {
    super();
    this.state = {};
  }

  componentDidMount() {
    //
    //
  }

  render() {

    return (
      <div className="main-view">
        Hello World
      </div>);
  }
}

const mapStateToProps = state => ({});
const mapDispatchToProps = {};

export default connect(mapStateToProps, mapDispatchToProps)(MainView);
