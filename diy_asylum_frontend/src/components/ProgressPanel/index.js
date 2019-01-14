import React from "react";
import "./style.scss";

import { pageNames } from "../../contentpages";

const ProgressPanel = ({ currentStep }) => {
  const stepNames = pageNames;
  const mappedListItemsEl = stepNames.map((stepName, idx) => {
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
      <ol>{mappedListItemsEl}</ol>
    </div>
  );
};

export default ProgressPanel;
