import { makeFormElement, makeContentPage, makeTextType } from "./util";

const formElements = [
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
  name: "Residence in the U.S.",
  formElements,
  help:
    "Use the address where you are currently staying in the United States. This may be a government facility."
});
