import { makeFormElement, makeTextType, makeContentPage } from "./util";

const formElements = [
  makeFormElement({
    elementName: "us-mailing-care-of",
    label: "In Care Of",
    inputType: makeTextType(),
    help:
      "The name of a person who will receive the mail and deliver it to you. If you will receive the mail, leave this blank."
  }),
  makeFormElement({
    elementName: "us-street-address",
    label: "Street Number and Name",
    inputType: makeTextType(),
    help: "For example, 123 Freedom Street"
  }),
  makeFormElement({
    elementName: "us-apt-number",
    label: "Apartment Number",
    inputType: makeTextType(),
    help: "For example, 5. If not applicable, leave blank."
  }),
  makeFormElement({
    elementName: "us-city",
    label: "City",
    inputType: makeTextType(),
    help: "For example, Winstonville."
  }),
  makeFormElement({
    elementName: "us-state",
    label: "State",
    inputType: makeTextType(),
    help: "Use the full name of the state. For example, Arizona."
  }),
  makeFormElement({
    elementName: "us-zip-code",
    label: "Zip Code",
    inputType: makeTextType(),
    help: "For example, 12345"
  }),
  makeFormElement({
    elementName: "us-phone-number",
    label: "Phone Number",
    inputType: makeTextType(),
    help:
      "This should be a phone number you can receive calls to at your current residence in the U.S. For example (850)-555-1234."
  })
];

export default makeContentPage({
  name: "Mailing Address in the U.S.",
  formElements,
  help:
    "Use an address in the United States where you can currently receive mail. This may be a government facility. If this is the same as your answer to the previous set of questions, leave it blank."
});
