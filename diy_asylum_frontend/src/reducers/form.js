import { numPages } from "../contentpages";

// initial state of form
const initState = {
  currentStep: 1,
  formValues: {}
};

// Action Constant Variables
//
export const INCREMENT_STEP = "INCREMENT_STEP";
export const DECREMENT_STEP = "DECREMENT_STEP";
export const SET_FORM_ELEMENT_STATE = "SET_FORM_ELEMENT_STATE";

// Dispatch Actions
//
const incrementStep = () => ({
  type: INCREMENT_STEP
});

const decrementStep = () => ({
  type: DECREMENT_STEP
});

const setFormElementStateAction = ({ sectionId, elementId, newValue }) => ({
  type: SET_FORM_ELEMENT_STATE,
  sectionId,
  elementId,
  newValue
});

// Action creators, functions will dispatch certain actions
//
export const nextFormStep = () => (dispatch, getState) => {
  const currentStepState = getState().form.currentStep;
  // TODO: this is some placeholder control flow, replace it when we get srs
  if (currentStepState < numPages) {
    dispatch(incrementStep());
  }
};

export const previousFormStep = () => (dispatch, getState) => {
  const currentStepState = getState().form.currentStep;
  if (currentStepState > 1) {
    dispatch(decrementStep());
  }
};

export const setFormElementState = ({
  sectionId,
  elementId,
  newValue
}) => dispatch =>
  dispatch(setFormElementStateAction({ sectionId, elementId, newValue }));

// User Reducer
// takes dispatched actions (from action creators) and updates user state
export default (state = initState, action) => {
  switch (action.type) {
    case INCREMENT_STEP:
      return {
        ...state,
        currentStep: state.currentStep + 1
      };

    case DECREMENT_STEP:
      return {
        ...state,
        currentStep: state.currentStep - 1
      };

    case SET_FORM_ELEMENT_STATE:
      console.log("Triggered!", action);
      const { sectionId, elementId, newValue } = action;
      const out = {
        ...state,
        [sectionId]: {
          ...state[sectionId],
          [elementId]: newValue
        }
      };
      console.log("Result", out);
      return out;

    default:
      return state;
  }
};
