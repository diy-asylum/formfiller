import React, { Component } from "react";

const inputMaker = ({ inputType, elementName, help }, helpTextSetter) => {
  const onfocus = () => helpTextSetter(help);
  switch (inputType.type) {
    case "text":
      return (
        <p>
          <input name={elementName} type="text" onFocus={onfocus} />
        </p>
      );

    case "date":
      return (
        <p>
          <input name={elementName} type="date" onFocus={onfocus} />
        </p>
      );

    case "radio":
      return inputType.choices.map(choiceStr => (
        <p>
          <input name={elementName} type="radio" onFocus={onfocus} />{" "}
          {choiceStr}
        </p>
      ));

    default:
      return <div>Unrecognized input type {inputType.type}</div>;
  }
};

const makeFormElement = helpTextSetter => formElement => {
  const inputs = inputMaker(formElement, helpTextSetter);

  return (
    <div className="form-group">
      <label>{formElement.label}</label> {inputs}
    </div>
  );
};

const FormContentComponent = ({ formElements, helpTextSetter }) => {
  const formElementMaker = makeFormElement(helpTextSetter);
  return (
    <div>
      <form>{formElements.map(formElementMaker)}</form>
    </div>
  );
};

export default FormContentComponent;
