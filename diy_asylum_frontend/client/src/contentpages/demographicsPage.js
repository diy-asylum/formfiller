import {
  makeFormElement,
  makeContentPage,
  makeChoicesType,
  makeChoice,
  makeTextType,
  makeDateType
} from "./util";

const formElements = [
  makeFormElement({
    elementName: "gender",
    label: "Gender",
    inputType: makeChoicesType({
      choices: [
        makeChoice({ label: "Male", id: "MALE" }),
        makeChoice({ label: "Female", id: "FEMALE" })
      ]
    }),
    help:
      "Choose one (and only one) box which best corresponds with your gender."
  }),
  makeFormElement({
    elementName: "date-of-birth",
    label: "Date of Birth",
    inputType: makeDateType(),
    help:
      "Input this in the form mm/dd/yyyy; for instance, if your birthday is June 12, 1954, input 06/12/1954."
  }),
  makeFormElement({
    elementName: "city-and-country-of-birth",
    label: "City and Country of Birth",
    inputType: makeTextType(),
    help: "Input this in the form City, Country. For example: Beijing, China"
  }),
  makeFormElement({
    elementName: "nationality",
    label: "Nationality",
    inputType: makeTextType(),
    help: "The country where you are currently a citizen. For example: China"
  }),
  makeFormElement({
    elementName: "birth-nationality",
    label: "Nationality at Birth",
    inputType: makeTextType(),
    help:
      "The country you were a citizen of, when you were born. This may be the same as your answer to the previous question."
  }),
  makeFormElement({
    elementName: "race",
    label: "Race, Ethnic, or Tribal Group",
    inputType: makeTextType(),
    help: "The racial, ethnic, or tribal group you belong to."
  }),
  makeFormElement({
    elementName: "religion",
    label: "Religion",
    inputType: makeTextType(),
    help: "Your current religion. If none, leave blank"
  })
];

export default makeContentPage({
  name: "Demographic Information",
  formElements,
  help: ""
});
