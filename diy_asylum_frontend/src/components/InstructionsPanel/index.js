import React from "react";

const InstructionsPanel = () => (
  <div className="instructions-panel col-sm" style={{backgroundColor: "steelBlue"}}>
    <p>This is the instructions and helper text Panel</p>
    <p>
      A blurp or paragraph will be here and will change whenever a users either
      goes to another step or, if we want to go the extra mile, focuses on a new
      form element input.
    </p>
  </div>
);

export default InstructionsPanel;
