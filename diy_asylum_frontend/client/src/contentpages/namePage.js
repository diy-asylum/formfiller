import { makeFormElement, makeContentPage, makeTextType } from "./util";

const formElements = [
  makeFormElement({
    elementName: "last-name",
    label: "Last Name",
    inputType: makeTextType(),
    help: "Your complete last (family) name"
  }),
  makeFormElement({
    elementName: "first-name",
    label: "First Name",
    inputType: makeTextType(),
    help: "Your first (given) name"
  }),
  makeFormElement({
    elementName: "middle-name",
    label: "Middle Name",
    inputType: makeTextType(),
    help: "Your middle name"
  }),
  makeFormElement({
    elementName: "other-names",
    label: "Other names",
    inputType: makeTextType(),
    help:
      "Include maiden name and aliases, if any. Separate by commas. If there are no other names, please leave this blank."
  })
];

export default makeContentPage({
  name: "Your name",
  formElements,
  help: "Your complete name"
});
