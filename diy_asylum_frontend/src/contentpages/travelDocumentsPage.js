import {
  makeFormElement,
  makeContentPage,
  makeChoicesType,
  makeChoice,
  makeDateType,
  makeTextType
} from "./util";

const formElements = [
  makeFormElement({
    elementName: "countryIssuedTravelDocuments",
    label: "What country issued your last passport or travel document?",
    inputType: makeTextType(),
    help:
      "For example, China. If no travel document has been issued to you, leave this blank."
  }),
  makeFormElement({
    elementName: "documentType",
    label: "Do you have a passport or a travel document?",
    inputType: makeChoicesType({
      choices: [
        makeChoice({ label: "Passport", id: "Passport" }),
        makeChoice({ label: "Travel Document", id: "TravelDocument" }),
        makeChoice({ label: "Neither", id: "Neither" })
      ]
    }),
    help:
      'If no passport or travel document has been issued to you, select "Neither"'
  }),
  makeFormElement({
    elementName: "travelDocumentNumber",
    label: "What is the number on your travel document or passport?",
    inputType: makeTextType(),
    help: "If you do not have one, leave this blank."
  }),
  makeFormElement({
    elementName: "travelDocumentExpiration",
    label: "When does your passport/travel document expire?",
    inputType: makeDateType(),
    help: "If you do not have one, leave this blank."
  })
];

export default makeContentPage({
  name: "Travel Documents",
  formElements,
  help: ""
});
