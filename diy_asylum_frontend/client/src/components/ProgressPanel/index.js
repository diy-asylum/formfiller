import React from "react";
import "./style.scss";

import { pageNames } from "../../contentpages";

const ProgressPanel = ({ currentStep, setStep }) => {
  const stepNames = pageNames;
  const mappedListItemsEl = stepNames.map((stepName, idx) => {
    return (
      <li
        key={`step${idx + 1}text`}
        className={currentStep > idx ? "completed" : "unfinished"}
        onClick={() => setStep(idx + 1)}
      >
        {stepName}
      </li>
    );
  });

  return (
    <div className="progress-panel col-lg-3">
      <h4>Application Progress</h4>
      <ol>{mappedListItemsEl}</ol>
    </div>
  );
};

export default ProgressPanel;
