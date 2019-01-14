import { numPages } from "../contentpages";

// initial state of form
const initState = {
  currentStep: 1
};

// Action Constant Variables
//
const INCREMENT_STEP = "INCREMENT_STEP";
const DECREMENT_STEP = "DECREMENT_STEP";

// Dispatch Actions
//
const incrementStep = () => ({
  type: INCREMENT_STEP
});

const decrementStep = () => ({
  type: DECREMENT_STEP
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
    default:
      return state;
  }
};
