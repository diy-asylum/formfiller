import React from "react";
import "./style.scss";

const InstructionsPanel = () => (
  <div className="instructions-panel col-sm">
    <p>This is the instructions and helper text Panel</p>
    <p>
      A blurp or paragraph will be here and will change whenever a users either
      goes to another step or, if we want to go the extra mile, focuses on a new
      form element input.
    </p>
  </div>
);

export default InstructionsPanel;
