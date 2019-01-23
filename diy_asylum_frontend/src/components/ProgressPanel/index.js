import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import { pageNames } from "../../contentpages";

const ProgressPanel = ({ progressList, currentStep }) => {
  const mappedListItemsEl = progressList.map((stepName, idx) => {
    return (
      <li
        key={`step${idx + 1}text`}
        className={currentStep > idx ? "completed" : "unfinished"}
      >
        {stepName}
      </li>
    );
  });

  return (
    <div className="progress-panel col-sm">
      <h6>Application Progress</h6>
      <ol>{mappedListItemsEl}</ol>
    </div>
  );
};


const mapStateToProps = state => ({
  progressList: state.form.stepList
});

const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ProgressPanel);
