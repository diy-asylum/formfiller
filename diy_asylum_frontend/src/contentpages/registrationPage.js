import { makeFormElement, makeContentPage, makeTextType } from "./util";

const formElements = [
  makeFormElement({
    elementName: "alien-registration-number",
    label: "Alien Registration Number(s)",
    inputType: makeTextType(),
    help:
      "If you have multiple, enter them separated by commas. If you do not have any, please leave this blank"
  }),
  makeFormElement({
    elementName: "us-ssn",
    label: "U.S. Social Security Number",
    inputType: makeTextType(),
    help: "If you do not have one, please leave this blank"
  }),
  makeFormElement({
    elementName: "uscis-acct-number",
    label: "USCIS Online Account Number",
    inputType: makeTextType(),
    help: "If you do not have one, please leave this blank"
  })
];

export default makeContentPage({
  name: "Registration Numbers",
  formElements,
  help: "Numbers that help identify you and track your application"
});
