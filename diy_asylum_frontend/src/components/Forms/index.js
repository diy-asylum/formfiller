import React from "react";
import { connect } from "react-redux";
import { injectIntl, defineMessages } from "react-intl";
import { withFormik } from "formik";
import * as Yup from "yup";

// TODO: i18n injection
// TODO: form valiation with Yup (parametrized somehow)
const RawFormGroup = props => {
  const {
    label,
    type,
    elementId,
    value,
    error,
    handleFocus,
    handleChange
  } = props;
  console.log("Form group props:", props);
  return (
    <div className="form-group">
      <label>{label}</label>
      <input
        name={elementId}
        type={type}
        className={`form-control ${error && "is-invalid"}`}
        value={value}
        onFocus={handleFocus}
        onChange={handleChange}
      />
      {error && <div className="invalid-feedback">{error}</div>}
    </div>
  );
};

const RawFullForm = props => {
  const {
    values,
    errors,
    isSubmitting,
    handleSubmit,
    contentPage,
    helpTextSetter,
    fullFormState,
    setFormElementState
  } = props;

  const { formElements: elements, name: pageId } = contentPage;

  console.log("RawFullForm props:", props);

  return (
    <form onSubmit={handleSubmit} key={pageId}>
      {elements.map((elt, i) => {
        const { label, elementName: id, inputType: type } = elt;
        return (
          <RawFormGroup
            label={label}
            type={type}
            elementId={id}
            value={values[id]}
            error={errors[id]}
            handleChange={event => {
              setFormElementState({
                sectionId: pageId,
                elementId: id,
                newValue: event.target.value
              });
            }}
            key={i}
          />
        );
      })}

      <button
        type="submit"
        className="btn btn-outline-primary"
        disable={isSubmitting ? "true" : "false"}
      >
        {isSubmitting ? "Please wait" : "Save changes"}
      </button>
    </form>
  );
};

const FormikedForm = withFormik({
  mapPropsToValues: () => ({}),
  // TODO: validationSchema
  handleSubmit: (values, { props, resetForm }) => {
    alert(
      `Placeholder for now, but we did get all your info: ${JSON.stringify(
        values
      )}, redux state is ${JSON.stringify(props.fullFormState)}`
    );
    resetForm(values);
  }
})(RawFullForm);

/*
  helpTextSetter={helpTextSetter}
  setFormElementState={setFormElementState}
  */
const UsefulForm = ({
  contentPage,
  helpTextSetter,
  fullFormState,
  setFormElementState
}) => {
  // ... stuff?

  return (
    <FormikedForm
      contentPage={contentPage}
      fullFormState={fullFormState}
      helpTextSetter={helpTextSetter}
      setFormElementState={setFormElementState}
    />
  );
};

export default UsefulForm;
