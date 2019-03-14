import fetch from "isomorphic-fetch";
import FileSaver from "file-saver";

const endpoint = "http://localhost:3000/api/fill";
const fileName = "e2e-test.pdf";

const makeFillRequest = formValues => ({
  applicantInfo: {
    // TODO: Add convention on torture question to UI
    alsoApplyingConventionAgainstTorture: true,
    alienRegistrationNumber:
      formValues["Registration Numbers"]["alien-registration-number"],
    socialSecurityNumber: formValues["Registration Numbers"]["us-ssn"],
    uscisAccountNumber: formValues["Registration Numbers"]["uscis-acct-number"],
    lastName: formValues["Your name"]["last-name"],
    firstName: formValues["Your name"]["first-name"],
    middleName: formValues["Your name"]["middle-name"],
    aliases: formValues["Your name"]["other-names"].split(","),
    usResidence: {
      inCareOf: null,
      streetName: formValues["Residence in the U.S."]["us-street-address"],
      // TODO: Note that street name and number are separate in the form assembly API
      // but combined in the form input UI
      // TODO: Backend throw error if this is left blank
      streetNumber: "1",
      apartmentNumber: formValues["Residence in the U.S."]["us-apt-number"],
      city: formValues["Residence in the U.S."]["us-city"],
      state: formValues["Residence in the U.S."]["us-state"],
      zipCode: formValues["Residence in the U.S."]["us-zip-code"],
      // TODO: Note that area code and phone number are separate in the form assembly API
      // but combined in the form input UI
      // TODO: Backend throw error if this is left blank
      areaCode: "1",
      phoneNumber: formValues["Residence in the U.S."]["us-phone-number"]
    },
    usMailingAddress: {
      inCareOf: formValues["Mailing Address in the U.S."]["us-mailing-care-of"],
      streetName:
        formValues["Mailing Address in the U.S."]["us-street-address"],
      // TODO: Note that street name and number are separate in the form assembly API
      // but combined in the form input UI
      // TODO: Backend throw error if this is left blank
      streetNumber: "1",
      apartmentNumber:
        formValues["Mailing Address in the U.S."]["us-apt-number"],
      city: formValues["Mailing Address in the U.S."]["us-city"],
      state: formValues["Mailing Address in the U.S."]["us-state"],
      zipCode: formValues["Mailing Address in the U.S."]["us-zip-code"],
      // TODO: Note that area code and phone number are separate in the form assembly API
      // but combined in the form input UI
      // TODO: Backend throw error if this is left blank
      areaCode: "1",
      phoneNumber: formValues["Mailing Address in the U.S."]["us-phone-number"]
    },
    gender: formValues["Demographic Information"]["gender"],
    //TODO: Add marital status to UI
    maritalStatus: "MARRIED",
    dateOfBirth: formValues["Demographic Information"]["date-of-birth"],
    // TODO: Note that city and country are separate in form assembly API but combined in form input API
    cityOfBirth:
      formValues["Demographic Information"]["city-and-country-of-birth"],
    countryOfBirth: "China",
    presentNationality: formValues["Demographic Information"]["nationality"],
    nationalityAtBirth:
      formValues["Demographic Information"]["birth-nationality"],
    raceEthnicOrTribalGroup: formValues["Demographic Information"]["race"],
    religion: formValues["Demographic Information"]["religion"],
    immigrationCourtHistory: formValues["Immigration Status"]["proceedings"],
    countryWhoLastIssuedPassport:
      formValues["Travel Documents"]["countryIssuedTravelDocuments"],
    passportNumber:
      formValues["Travel Documents"]["documentType"] == "Passport"
        ? formValues["Travel Documents"]["travelDocumentNumber"]
        : "",
    travelDocumentNumber:
      formValues["Travel Documents"]["documentType"] == "TravelDocument"
        ? formValues["Travel Documents"]["travelDocumentNumber"]
        : "",
    travelDocumentExpirationDate:
      formValues["Travel Documents"]["travelDocumentExpiration"],
    nativeLanguage: formValues["Language"]["nativeLanguage"],
    fluentInEnglish: formValues["Language"]["fluentInEnglish"],
    otherLanguages: formValues["Language"]["otherLanguages"].split(",")
  },
  usTravelHistory: {
    travelEvents: [
      {
        date: formValues["Immigration Status"]["recentEntryDate"],
        place: formValues["Immigration Status"]["recentEntryPlace"],
        status: formValues["Immigration Status"]["recentEntryStatus"]
      }
    ],
    lastLeftHomeCountry: formValues["Immigration Status"]["lastLeaveHome"],
    i94Number: formValues["Immigration Status"]["i94number"],
    dateStatusExpires:
      formValues["Immigration Status"]["recentEntryStatusExpiry"]
  }
});

const executeFillRequest = formValues => {
  fetch(endpoint, {
    method: "POST",
    mode: "cors",
    body: JSON.stringify(makeFillRequest(formValues)),
    headers: {
      "Content-Type": "application/json"
    }
  })
    .then(function(response) {
      return response.blob();
    })
    .then(function(blob) {
      FileSaver.saveAs(blob, fileName);
    });
};

export default executeFillRequest;
