import { numPages } from "../contentpages";

// initial state of form
const initState = {
  currentStep: 1,
  stepList: []
};

// Action Constant Variables
//
export const INCREMENT_STEP = "INCREMENT_STEP";
export const DECREMENT_STEP = "DECREMENT_STEP";
export const SET_STEP_LIST = "SET_STEP_LIST";


// Dispatch Actions
//
const incrementStep = () => ({
  type: INCREMENT_STEP
});

const decrementStep = () => ({
  type: DECREMENT_STEP
});

const setStepList = val => ({
  type: SET_STEP_LIST,
  payload: val
});

// Action creators, functions will dispatch certain actions
//
export const nextFormStep = () => (dispatch, getState) => {
  const currentStepState = getState().form.currentStep;
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

export const setProgressStepList = newList => dispatch => {
  dispatch(setStepList(newList));
};



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

    case SET_STEP_LIST:
      return {
        ...state,
        stepList: action.payload
      };

    default:
      return state;
  }
};
