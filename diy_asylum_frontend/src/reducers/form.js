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
export const nextFormStep = data => (dispatch, getState) => {
  const currentStepState = getState().currentStep
  if (currentStepState < 5) {
    dispatch(incrementStep(data));
  }
};

export const previousFormStep = data => (dispatch, getState) => {
  const currentStepState = getState().currentStep
  if (currentStepState > 1) {
    dispatch(decrementStep(data));
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
