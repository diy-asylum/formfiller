import { INCREMENT_STEP, DECREMENT_STEP } from "./form";

const initState = {
  inputHelpText: ""
};

export const SET_INPUT_HELP_TEXT = "SET_INPUT_HELP_TEXT";

const inputHelpTextActionMaker = helpText => ({
  type: SET_INPUT_HELP_TEXT,
  inputHelpText: helpText
});

export const setInputHelpText = helpText => dispatch => {
  console.log(helpText);
  dispatch(inputHelpTextActionMaker(helpText));
};

export default (state = initState, action) => {
  switch (action.type) {
    case INCREMENT_STEP:
      return {
        ...state,
        inputHelpText: ""
      };

    case DECREMENT_STEP:
      return {
        ...state,
        inputHelpText: ""
      };

    case SET_INPUT_HELP_TEXT:
      return {
        ...state,
        inputHelpText: action.inputHelpText
      };

    default:
      return state;
  }
};
