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

const makeFormElement = formElement => {
  const inputs = inputMaker(formElement);

  return (
    <div className="form-group">
      <label>{formElement.label}</label> {inputs}
    </div>
  );
};

class ContentPage extends Component {
  constructor({ formElements }) {
    super();
    // set up state here
    this.state = {};
    this.formElements = formElements;
  }

  componentDidMount() {
    //
    // potentially fetch user data here
    //
  }

  render() {
    console.log(this.helpTextSetter);
    return (
      <div>
        <form>{this.formElements.map(makeFormElement)}</form>
      </div>
    );
  }
}

// TODO: action dispatcher which attaches help text

const makeContentPage = contentPage => new ContentPage(contentPage);

export default makeContentPage;
