import React, { Component } from "react";
import { connect } from "react-redux";
import { updateUserLocale } from '../reducers/user';
import NavHeader from './NavHeader'
import ProgressPanel from './ProgressPanel'
import CenterForm from './CenterForm'
import InstructionsPanel from './InstructionsPanel'
import Footer from './Footer'


import { nextFormStep, previousFormStep } from '../reducers/form';

class MainView extends Component {
  constructor() {
    super();
    this.state = {};
  }

  componentDidMount() {
    //
    // potentially fetch user data here
    //
  }


  // Hello World
  // <br />
  // <button onClick={this.props.nextFormStep}>Next</button>
  // <button onClick={this.props.previousFormStep}>Previous</button>

  render() {
    return (
      <div className="main-view">
        <NavHeader></NavHeader>

        <div className="container">
          <div className="row">
            <ProgressPanel></ProgressPanel>
            <CenterForm></CenterForm>
            <InstructionsPanel></InstructionsPanel>
          </div>
          <Footer></Footer>
          
        </div>

      </div>
    );
  }
}

const mapStateToProps = state => ({
  step: state.form.currentStep
});
const mapDispatchToProps = {
  nextFormStep,
  previousFormStep,
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(MainView);
