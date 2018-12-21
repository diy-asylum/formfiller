import React from "react";
import "./style.scss";

const ProgressPanel = props => {
  const stepNames = [
    "Name",
    "Background",
    "Birthdate",
    "Family Members",
    "Confirmation and Review"
  ];
  const mappedListItemsEl = stepNames.map((stepName, idx) => {
    return (
      <li
        key={`step${idx + 1}text`}
        className={props.currentStep > idx ? "completed" : "unfinished"}
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
