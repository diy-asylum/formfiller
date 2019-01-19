import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import {
  nextFormStep,
  previousFormStep,
  setFormElementState
} from "../../reducers/form";
import { setInputHelpText } from "../../reducers/helpText";

import FormikedForm from "../Forms";

import contentPages from "../../contentpages";

const CenterFormInput = ({
  formElement: { inputType, elementName, help, label },
  helpTextSetter
}) => {
  const onfocus = () => helpTextSetter(help);

  switch (inputType.type) {
    case "text":
      return (
        <div>
          <p>{label}</p>
          <p>
            <input name={elementName} type="text" onFocus={onfocus} />
          </p>
        </div>
      );

    case "date":
      return (
        <div>
          <p>{label}</p>
          <p>
            <input name={elementName} type="date" onFocus={onfocus} />
          </p>
        </div>
      );

    case "radio":
      return (
        <div>
          <p>{label}</p>
          <p>
            {inputType.choices.map(choiceStr => (
              <p>
                <input name={elementName} type="radio" onFocus={onfocus} />{" "}
                {choiceStr}
              </p>
            ))}
          </p>
        </div>
      );

    default:
      return <div>Unrecognized input type {inputType.type}</div>;
  }
};

const FormContentComponent = ({ formElements, helpTextSetter, id }) => (
  <form id={id}>
    {formElements.map((elt, i) => (
      <CenterFormInput
        formElement={elt}
        helpTextSetter={helpTextSetter}
        key={i}
      />
    ))}
  </form>
);

const FormContent = ({
  step,
  fullFormState,
  helpTextSetter,
  setFormElementState
}) => {
  // index pages from zero, but steps start at one

  step -= 1;

  if (step >= 0 && step < contentPages.length) {
    const contentPage = contentPages[step];
    // const { formElements } = contentPage;
    return (
      // TODO: we're replacing these components, but need to
      // not lose any functionality
      /*
      <FormContentComponent
        formElements={formElements}
        helpTextSetter={helpTextSetter}
        formId={step}
      />
      */
      <FormikedForm
        contentPage={contentPage}
        helpTextSetter={helpTextSetter}
        fullFormState={fullFormState}
        setFormElementState={setFormElementState}
      />
    );
  } else {
    return <div>{`No form found for step ${step}`}</div>;
  }
};

const CenterForm = ({
  step,
  nextButton,
  prevButton,
  helpTextSetter,
  setFormElementState,
  fullFormState
}) => (
  <div className="center-form col-sm">
    <FormContent
      step={step}
      helpTextSetter={helpTextSetter}
      setFormElementState={setFormElementState}
      fullFormState={fullFormState}
    />
    <div className="button-container">
      <button
        onClick={() => {
          nextButton();
          helpTextSetter("");
        }}
      >
        Next
      </button>
      <button
        onClick={() => {
          prevButton();
          helpTextSetter("");
        }}
      >
        Previous
      </button>
    </div>
  </div>
);

const mapStateToProps = state => ({
  step: state.form.currentStep,
  fullFormState: state.form.formValues
});

const mapDispatchToProps = {
  nextButton: nextFormStep,
  prevButton: previousFormStep,
  helpTextSetter: setInputHelpText,
  setFormElementState
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(CenterForm);
