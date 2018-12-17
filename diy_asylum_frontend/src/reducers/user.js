const USER_EDIT_ACTION = "userEditAction";

const userReducer = (state = {}, action) => {
  console.log(state);
  switch (action.type) {
    case USER_EDIT_ACTION:
      return {
        ...state,
        ...action.edits
      };
    default:
      return state;
  }
};

const makeEditUserAction = userEdits => {
  console.log("doing this", userEdits);
  return {
    type: USER_EDIT_ACTION,
    edits: userEdits
  };
};

export { makeEditUserAction };
export default userReducer;
