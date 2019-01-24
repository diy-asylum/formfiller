// import { numPages } from "../contentpages";

// initial state of form
const initState = {
  currentStepCounter: 1,
  sectionsList: ["Demographics", "Mailing", "Name", "Registration", "Residence"],
  activeStepName: "Demographics"
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


// Action creators, functions will dispatch certain actions
//
export const nextFormStep = () => (dispatch, getState) => {
  const currentFormState = getState().form;
  const sectionListLength  = currentFormState.sectionsList.length;
  if (currentFormState.currentStepCounter < sectionListLength) {
    dispatch(incrementStep());
  }
};

export const previousFormStep = () => (dispatch, getState) => {
  const currentStepState = getState().form.currentStepCounter;

  if (currentStepState > 1) {
    dispatch(decrementStep());
  }
};


// User Reducer
// takes dispatched actions (from action creators) and updates user state
export default (state = initState, action) => {
  switch (action.type) {
    case INCREMENT_STEP:
      const counterIncreased = state.currentStepCounter + 1;
      return {
        ...state,
        currentStepCounter: counterIncreased,
        activeStepName : state.sectionsList[counterIncreased - 1]
      };

    case DECREMENT_STEP:
      const counterDecreased = state.currentStepCounter - 1;
      return {
        ...state,
        currentStepCounter: counterDecreased,
        activeStepName : state.sectionsList[counterDecreased - 1]
      };

    default:
      return state;
  }
};
