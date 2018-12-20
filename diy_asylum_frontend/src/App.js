import React from 'react';
import { BrowserRouter as Router, Route } from 'react-router-dom';
import MainView from './components/MainView';
import './App.scss';


export default () => (
  <div className="App">
    <Router>
      <Route path="/:filter?" render={({ match }) => (<MainView filter={match.params.filter} />)} />
    </Router>
  </div>
);
