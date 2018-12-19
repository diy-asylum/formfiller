// initial state of user
const initState = {
  locale: 'en',
};

// Action Constant Variables
//
const UPDATE_LOCALE = 'UPDATE_LOCALE';


// Dispatch Actions
//
const updateLocale = val => ({
  type: UPDATE_LOCALE,
  payload: val,
});


// Action creators, functions will dispatch certain actions
//
export const saveNewLocale = data => (dispatch) => {
  if (data !== "") {
    dispatch(updateLocale(data));
  }
};

// User Reducer
// takes dispatched actions (from action creators) and updates user state
export default (state = initState, action) => {
  switch (action.type) {
    case UPDATE_LOCALE:
      return {
        ...state,
        locale: action.payload,
      };
    default:
      return state;
  }
};

// const USER_EDIT_ACTION = "userEditAction";
//
// const userReducer = (state = {}, action) => {
//   console.log(state);
//   switch (action.type) {
//     case USER_EDIT_ACTION:
//       return {
//         ...state,
//         ...action.edits
//       };
//     default:
//       return state;
//   }
// };
//
// const makeEditUserAction = userEdits => {
//   console.log("doing this", userEdits);
//   return {
//     type: USER_EDIT_ACTION,
//     edits: userEdits
//   };
// };
//
// export { makeEditUserAction };
// export default userReducer;
