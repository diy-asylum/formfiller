import { createStore, applyMiddleware, combineReducers } from "redux";
import thunk from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";
import userReducer from "./reducers/user";
import formReducer from "./reducers/form";
import helpTextReducer from "./reducers/helpText";

const reducer = combineReducers({
  user: userReducer,
  form: formReducer,
  helpText: helpTextReducer
});

export default createStore(
  reducer,
  composeWithDevTools(applyMiddleware(thunk))
);
