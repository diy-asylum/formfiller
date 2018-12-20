import { createStore, applyMiddleware, combineReducers } from 'redux';
import thunk from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';
import userReducer from './reducers/user';
import formReducer from './reducers/form';


const reducer = combineReducers({
  user: userReducer,
  form: formReducer
});

export default createStore(
  reducer,
  composeWithDevTools(applyMiddleware(thunk)),
);
