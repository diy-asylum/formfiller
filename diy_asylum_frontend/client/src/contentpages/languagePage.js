import {
  makeFormElement,
  makeContentPage,
  makeChoicesType,
  makeChoice,
  makeTextType
} from "./util";

const formElements = [
  makeFormElement({
    elementName: "nativeLanguage",
    label: "What is your native language (include dialect, if applicable)",
    inputType: makeTextType(),
    help:
      "For example, Chinese (Mandarin). Choose only one; you can put in other fluencies later."
  }),
  makeFormElement({
    elementName: "fluentInEnglish",
    label: "Are you fluent in English?",
    inputType: makeChoicesType({
      choices: [
        makeChoice({ label: "Yes", id: true }),
        makeChoice({ label: "No", id: false })
      ]
    }),
    help:
      'Select "yes" if you are comfortable speaking English without a translator.'
  }),
  makeFormElement({
    elementName: "otherLanguages",
    label: "What other languages do you speak fluently?",
    inputType: makeTextType(),
    help:
      "For example, Spanish and Italian. Do not include English here, even if you are fluent. If you do not speak any other languages, leave this blank."
  })
];

export default makeContentPage({
  name: "Language",
  formElements,
  help: ""
});
