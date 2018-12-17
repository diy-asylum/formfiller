import React from "react";
import { connect } from "react-redux";

import { injectIntl, defineMessages } from "react-intl";

import { withFormik } from "formik";
import * as Yup from "yup";

const messages = defineMessages({
  stayHere: {
    id: "ContactInformation.stayHere",
    defaultMessage:
      "Please do not navigate away from this page, your changes will be lost unless you hit submit"
  },
  firstNameLabel: {
    id: "ContactInformation.firstNameLabel",
    defaultMessage: "First (given) name"
  },
  firstNameError: {
    id: "ContactInformation.firstNameMissing",
    defaultMessage: "Please enter a first name"
  },
  lastNameLabel: {
    id: "ContactInformation.lastNameLabel",
    defaultMessage: "Last (family) name"
  },
  lastNameError: {
    id: "ContactInformation.lastNameMissing",
    defaultMessage: "Please enter a last name"
  },
  submitWait: {
    id: "ContactInformation.submitWait",
    defaultMessage: "Please wait"
  },
  submitReady: {
    id: "ContactInformation.submitReady",
    defaultMessage: "Save changes"
  }
});

const RawForm = ({
  values,
  touched,
  errors,
  dirty,
  isSubmitting,
  handleChange,
  setFieldValue,
  handleBlur,
  handleSubmit,
  handleReset,
  intl: { formatMessage }
}) => (
  <form onSubmit={handleSubmit}>
    {dirty ? <p>{formatMessage(messages.stayHere)}</p> : ""}

    <div className="form-group">
      <label>{formatMessage(messages.firstNameLabel)}</label>
      <input
        name="firstName"
        type="text"
        className={`form-control ${errors.firstName && "is-invalid"}`}
        value={values.firstName}
        onChange={handleChange}
        onBlur={handleBlur}
      />
      {errors.firstName && (
        <div className="invalid-feedback">{errors.firstName}</div>
      )}
    </div>

    <div className="form-group">
      <label>{formatMessage(messages.lastNameLabel)}</label>
      <input
        name="lastName"
        type="text"
        className={`form-control ${errors.lastName && "is-invalid"}`}
        value={values.lastName}
        onChange={handleChange}
        onBlur={handleBlur}
      />
      {errors.lastName && (
        <div className="invalid-feedback">{errors.lastName}</div>
      )}
    </div>

    <button
      type="submit"
      className="btn btn-outline-primary"
      disable={isSubmitting}
    >
      {isSubmitting
        ? formatMessage(messages.submitWait)
        : formatMessage(messages.submitReady)}
    </button>
  </form>
);

// TODO: i18n for these yup validations, somehow? How to pass intl here?
const FormikedForm = withFormik({
  mapPropsToValues: props => ({}),

  validationSchema: ({ intl: { formatMessage } }) =>
    Yup.object().shape({
      firstName: Yup.string().required(formatMessage(messages.firstNameError)),
      lastName: Yup.string().required(formatMessage(messages.lastNameError))
    }),

  handleSubmit: (values, { props, resetForm }) => {
    alert(
      `In a real app we would do something here, but at least note we know what you did: ${JSON.stringify(
        values
      )}`
    );
    resetForm(values);
  }
})(RawForm);

const IntlForm = injectIntl(FormikedForm);

const mapStateToProps = () => ({});
const mapDispatchToProps = dispatch => ({});

const FormPanel = connect(
  mapStateToProps,
  mapDispatchToProps
)(IntlForm);

export default FormPanel;
