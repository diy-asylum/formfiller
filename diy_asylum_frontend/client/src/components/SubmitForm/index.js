import React from "react";
import "./style.scss";
import { connect } from "react-redux";
import fetch from 'isomorphic-fetch';
import FileSaver from 'file-saver';

const makeFillRequest = form => ({
  "applicantInfo": {
    "alsoApplyingConventionAgainstTorture": true,
    "alienRegistrationNumber": form['Registration Numbers']['alien-registration-number'],
    "socialSecurityNumber": "234-22-1113",
    "uscisAccountNumber": "A012345678",
    "lastName": "Parker",
    "firstName": "Peter",
    "middleName": "Benjamin",
    "aliases": [
      "Spider-man"
    ],
    "usResidence": {
      "inCareOf": null,
      "streetName": "50th Street",
      "streetNumber": "135 W.",
      "apartmentNumber": "6",
      "city": "New York",
      "state": "New York",
      "zipCode": "10020",
      "areaCode": "212",
      "phoneNumber": "3230122"
    },
    "usMailingAddress": {
      "inCareOf": "May Parker",
      "streetName": "34th street",
      "streetNumber": "7",
      "apartmentNumber": "6",
      "city": "New York",
      "state": "New York",
      "zipCode": "10020",
      "areaCode": "212",
      "phoneNumber": "3230122"
    },
    "gender": "MALE",
    "maritalStatus": "MARRIED",
    "dateOfBirth": "8/10/1962",
    "cityOfBirth": "Beijing",
    "countryOfBirth": "China",
    "presentNationality": "Chinese",
    "nationalityAtBirth": "Chinese",
    "raceEthnicOrTribalGroup": "Asian",
    "religion": "Christian",
    "immigrationCourtHistory": "NEVER",
    "countryWhoLastIssuedPassport": "China",
    "passportNumber": "999999999",
    "travelDocumentNumber": "29312",
    "travelDocumentExpirationDate": "12-12-9999",
    "nativeLanguage": "Chinese",
    "fluentInEnglish": true,
    "otherLanguages": [
      "English",
      "Spanish"
    ]
  },
  "usTravelHistory": {
    "travelEvents": [
      {
        "date": "12/12/2015",
        "place": "New York",
        "status": "visitor"
      },
      {
        "date": "12/12/2016",
        "place": "New York",
        "status": "visitor"
      },
      {
        "date": "12/12/2017",
        "place": "New York",
        "status": "visitor"
      }
    ],
    "lastLeftHomeCountry": "1/1/2018",
    "i94Number": "123456789 01",
    "dateStatusExpires": "4/2/2022"
  }
});

const SubmitForm = ({form}) => (
  <div className="submit-form col-sm">
    <div className="button-container">
      <button onClick={() => {
        console.log(form);
        fetch('http://localhost:3000/api/fill', {
          method: 'POST',
          mode: 'cors',
          body: JSON.stringify(makeFillRequest(form.formValues)),
          headers: {
            'Content-Type': 'application/json'
        }
    }).then(function(response) {
            return response.blob();
          }).then(function(blob) {
            FileSaver.saveAs(blob, 'e2e-test.pdf');
      })}}>
        Submit
      </button>
    </div>
  </div>
);

const mapStateToProps = state => ({
  form: state.form
});

const mapDispatchToProps = {};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(SubmitForm);
