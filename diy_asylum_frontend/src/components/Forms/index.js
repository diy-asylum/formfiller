import React from "react";
import { withFormik } from "formik";
import _ from "lodash";

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
        type={type.type}
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
    errors,
    contentPage,
    helpTextSetter,
    fullFormState,
    setFormElementState
  } = props;

  const { formElements: elements, name: pageId } = contentPage;
  const relevantFormState = _.get(fullFormState, pageId, {});

  console.log("RawFullForm props:", props);

  return (
    <form key={pageId}>
      {elements.map((elt, i) => {
        const { label, elementName: id, inputType: type, help } = elt;
        return (
          <RawFormGroup
            label={label}
            type={type}
            elementId={id}
            value={_.get(relevantFormState, id, "")}
            handleFocus={() => helpTextSetter(help)}
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
    </form>
  );
};

const FormikedForm = withFormik({
  mapPropsToValues: () => ({})
  // TODO: validationSchema
})(RawFullForm);

// Exposed in this way to control the props you can / should
// pass to the form (even though it's a fairly trivial wrapper)
const UsefulForm = ({
  contentPage,
  helpTextSetter,
  fullFormState,
  setFormElementState
}) => {
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
