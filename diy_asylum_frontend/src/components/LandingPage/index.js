import React from "react";
import "./landing.css";

const LandingPage = () => (
  <div>
    <div className="white-background">
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div className="container">
          <a className="navbar-brand" href="/">
            Start Form
          </a>
          <button
            className="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarResponsive"
            aria-controls="navbarResponsive"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon" />
          </button>
          <div className="collapse navbar-collapse" id="navbarResponsive">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item active">
                <a className="nav-link" href="/landing">
                  Home
                  <span className="sr-only">(current)</span>
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/landing">
                  About
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/landing">
                  Services
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="/landing">
                  Contact
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <header className="business-header mt-4" />

      <div className="container">
        <div className="row">
          <div className="col-sm-8">
            <h2 className="mt-4">What We Do</h2>
            <p>We help asylum seekers fill forms.</p>
            <p>We have a team of dedicated volunteers.</p>
            <p>
              <a className="btn btn-outline-success btn-lg" href="/landing">
                Call to Action &raquo;
              </a>
            </p>
          </div>
          <div className="col-sm-4">
            <h2 className="mt-4">Contact Us</h2>
            <address>
              <strong>DIYASYLUM</strong>
              <br />
              1234
              <br />
              USA
              <br />
            </address>
            <address>
              <abbr title="Phone">Phone: </abbr>
              (123) 456-7890
              <br />
              <abbr title="Email">Email: </abbr>
              <a href="mailto:#" className="text-success">
                name@example.com
              </a>
            </address>
          </div>
        </div>

        <div className="row">
          <div className="col-sm-4 my-4">
            <div className="card">
              <img
                className="card-img-top"
                src="http://placehold.it/300x200"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Card title</h4>
                <p className="card-text">Card content.</p>
              </div>
              <div className="card-footer">
                <a href="/landing" className="btn btn-outline-success">
                  Find Out More!
                </a>
              </div>
            </div>
          </div>
          <div className="col-sm-4 my-4">
            <div className="card">
              <img
                className="card-img-top"
                src="http://placehold.it/300x200"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Card title</h4>
                <p className="card-text">Card content.</p>
              </div>
              <div className="card-footer">
                <a href="/landing" className="btn btn-outline-success">
                  Find Out More!
                </a>
              </div>
            </div>
          </div>
          <div className="col-sm-4 my-4">
            <div className="card">
              <img
                className="card-img-top"
                src="http://placehold.it/300x200"
                alt=""
              />
              <div className="card-body">
                <h4 className="card-title">Card title</h4>
                <p className="card-text">Card content.</p>
              </div>
              <div className="card-footer">
                <a href="/landing" className="btn btn-outline-success">
                  Find Out More!
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer className="py-5 bg-dark">
        <div className="container">
          <p className="m-0 text-center text-white">
            Copyright &copy; DIYASYLUM 2019
          </p>
        </div>
      </footer>
    </div>
  </div>
);

export default LandingPage;
