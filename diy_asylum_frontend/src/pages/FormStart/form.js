import React from "react";
import { connect } from "react-redux";

import { injectIntl, defineMessages } from "react-intl";

import { withFormik } from "formik";
import * as Yup from "yup";
import { makeEditUserAction } from "../../reducers/user";

// this is the "raw" form -- the props are provider by Formik, below
const Form = props => {
  const {
    values,
    touched,
    errors,
    dirty,
    isSubmitting,
    handleChange,
    setFieldValue,
    handleBlur,
    handleSubmit,
    handleReset
  } = props;

  return (
    <form className="p-5" onSubmit={handleSubmit}>
      <h1>Hello this is form</h1>

      {dirty ? (
        <p>
          Please do not navigate away from this page, your changes will be lost
          unless you hit submit
        </p>
      ) : (
        ""
      )}

      <div className="form-group">
        <label>Imaginary Email</label>
        <input
          name="email"
          type="text"
          className={`form-control ${errors.email &&
            touched.email &&
            "is-invalid"}`}
          value={values.email}
          onChange={handleChange}
          onBlur={handleBlur}
        />
        {errors.email && touched.email && (
          <div className="invalid-feedback">{errors.email}</div>
        )}
      </div>

      <div className="form-group">
        <label>Imaginary Username</label>
        <input
          name="username"
          type="text"
          className={`form-control ${errors.username &&
            touched.username &&
            "is-invalid"}`}
          value={values.username}
          onChange={handleChange}
          onBlur={handleBlur}
        />
        {errors.username && touched.username && (
          <div className="invalid-feedback">{errors.username}</div>
        )}
      </div>

      <button
        type="submit"
        className="btn btn-outline-primary"
        disabled={isSubmitting}
      >
        {isSubmitting ? "Submitting, please wait" : "Submit"}
      </button>
    </form>
  );
};

// This injects the magic props into the above form
const boostedForm = withFormik({
  mapPropsToValues: ({ user }) => ({
    email: user.email,
    username: user.username
  }),

  validationSchema: Yup.object().shape({
    email: Yup.string()
      .email("Invalid email address")
      .required("Email is required!"),
    username: Yup.string().required("You'll need a username")
  }),

  handleSubmit: (values, { props, resetForm }) => {
    props.editUser(values);
    resetForm(values);
  }
})(Form);

// This lets you access i18n in your form ...
const intlForm = injectIntl(boostedForm);

// And this ties the whole thing to the store

const mapStateToProps = ({ user }) => ({ user });
const mapDispatchToProps = dispatch => ({
  editUser: values => dispatch(makeEditUserAction(values))
});

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(intlForm);
