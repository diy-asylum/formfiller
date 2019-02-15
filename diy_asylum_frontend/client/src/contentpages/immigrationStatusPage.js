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
    elementName: "proceedings",
    label: "Check the statement that best applies to you",
    inputType: makeChoicesType({
      choices: [
        makeChoice({
          label: "I have never been in Immigration Court proceedings",
          id: "NEVER"
        }),
        makeChoice({
          label: "I am now in Immigration Court proceedings",
          id: "NOW"
        }),
        makeChoice({
          label:
            "I am not now in Immigration Court proceedings, but I have been in the past",
          id: "PAST"
        })
      ]
    }),
    help:
      "If you have been in Immigration Court in the past, and it completed, and you are now in proceedings again, select (b)"
  }),
  makeFormElement({
    elementName: "lastLeaveHome",
    label: "When did you last leave your country?",
    inputType: makeDateType(),
    help:
      "The date you left your home country most recently, which may not be the same as the date you entered the United States"
  }),
  makeFormElement({
    elementName: "i94number",
    label: "What is your current I-94 number, if any?",
    inputType: makeTextType(),
    help: "If you do not have one, leave this blank"
  }),
  makeFormElement({
    elementName: "recentEntryDate",
    label: "When did you most recently enter the United States?",
    inputType: makeDateType(),
    help: "The date you most recently arrived at the United States"
  }),
  makeFormElement({
    elementName: "recentEntryPlace",
    label: "What is the place you most recently entered the United States?",
    inputType: makeTextType(),
    help:
      "The place you crossed into the United States, which may be at a border or at an airport. For example, Boston, Massachusetts."
  }),
  makeFormElement({
    elementName: "recentEntryStatus",
    label:
      "What is the status you entered the United States with most recently?",
    inputType: makeTextType(),
    help:
      'The status you crossed into the United States with. For example, "Visitor" or "Student" or "Entered Without Inspection" or possibly another status.'
  }),
  makeFormElement({
    elementName: "recentEntryStatusExpiry",
    label: "When does your current status expire?",
    inputType: makeDateType(),
    help: "The date at which your status expires. This date may be in the past."
  })
  // TODO #23 take a list of entry dates
];

export default makeContentPage({
  name: "Immigration Status",
  formElements,
  help: ""
});
