import React from "react";
import ReactDOM from "react-dom";
import { Provider as ReduxProvider } from "react-redux";
import App from "./App";
import store from "./store";

it("renders the main application without crashing", () => {
  const div = document.createElement("div");
  const app = (
    <ReduxProvider store={store}>
      <App />
    </ReduxProvider>
  );
  ReactDOM.render(app, div);
  ReactDOM.unmountComponentAtNode(div);
});
