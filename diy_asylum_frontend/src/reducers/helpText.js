const initState = {
  inputHelpText: "",
  sectionHelpText: ""
};

const SET_INPUT_HELP_TEXT = "SET_INPUT_HELP_TEXT";
const SET_SECTION_HELP_TEXT = "SET_SECTION_HELP_TEXT";


const inputHelpTextActionMaker = txtValue => ({
  type: SET_INPUT_HELP_TEXT,
  payload: txtValue
});

const sectionHelpTextActionMaker = txtValue => ({
  type: SET_SECTION_HELP_TEXT,
  payload: txtValue
});

export const setInputHelpText = helpText => dispatch => {
  dispatch(inputHelpTextActionMaker(helpText));
};

export const setSectionHelpText = helpText => dispatch => {
  dispatch(sectionHelpTextActionMaker(helpText));
};

export default (state = initState, action) => {
  switch (action.type) {
    case SET_INPUT_HELP_TEXT:
    console.log("SET_INPUT_HELP_TEXT")

      return {
        ...state,
        inputHelpText: action.payload
      };

    case SET_SECTION_HELP_TEXT:
    console.log("got SET_SECTION_HELP_TEXT")
      return {
        ...state,
        sectionHelpText: action.payload
      };
    default:
      return state;
  }
};
