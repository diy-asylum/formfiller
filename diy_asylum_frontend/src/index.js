import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import './index.css';
import App from './App';
// import registerServiceWorker from './registerServiceWorker';
import * as serviceWorker from "./serviceWorker";
import store from './store';

/* eslint-disable */
ReactDOM.render(<Provider store={store}><App /></Provider>, document.getElementById('root'));

// registerServiceWorker();



// ************************************
// ReactDOM.render(<FullApplication />, document.getElementById("root"));
//
// // If you want your app to work offline and load faster, you can change
// // unregister() to register() below. Note this comes with some pitfalls.
// // Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();


// import React from "react";
// import ReactDOM from "react-dom";
// import "./index.css";
// import "bootstrap/dist/css/bootstrap.min.css";
// import App from "./components/layout/App";
// import * as serviceWorker from "./serviceWorker";
//
// import { createStore } from "redux";
// import { Provider, connect } from "react-redux";
//
// import mainReducer from "./reducers";
//
// import { BrowserRouter } from "react-router-dom";
// import { IntlProvider, addLocaleData } from "react-intl";
//
// import enLocaleData from "react-intl/locale-data/en";
// import esLocaleData from "react-intl/locale-data/es";
//
// import translations from "./i18n/locales";
//
// addLocaleData(enLocaleData);
// addLocaleData(esLocaleData);
//
// const store = createStore(mainReducer);
//
// const AppWrapper = ({ locale }) => {
//   const messages = translations[locale];
//
//   return (
//     <IntlProvider locale={locale} key={locale} messages={messages}>
//       <BrowserRouter>
//         <App />
//       </BrowserRouter>
//     </IntlProvider>
//   );
// };
//
// const mapStateToProps = ({ locale }) => ({ locale });
//
// const AppContainer = connect(mapStateToProps)(AppWrapper);
//
// const FullApplication = () => (
//   <Provider store={store}>
//     <AppContainer />
//   </Provider>
// );
//
// ReactDOM.render(<FullApplication />, document.getElementById("root"));
//
// // If you want your app to work offline and load faster, you can change
// // unregister() to register() below. Note this comes with some pitfalls.
// // Learn more about service workers: http://bit.ly/CRA-PWA
// serviceWorker.unregister();
