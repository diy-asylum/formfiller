import React from "react";
import "./landing.css";
import NavHeader from "../NavHeader";
const LandingPage = () => (
  <div>
    <div className="white-background">
      <NavHeader />

      <header className="business-header mt-4" />

      <div className="container">
        <div className="row">
          <div className="col-sm-8">
            <h2 className="mt-4">What We Do</h2>
            <p>
              Our goal is to make the process of applying for asylum easier for
              asylum seekers who cannot afford lawyers.
            </p>
            <p>
              <a className="btn btn-outline-success btn-lg" href="/landing">
                Call to Action &raquo;
              </a>
            </p>
          </div>
          <div className="col-sm-4">
            <h2 className="mt-4">Contact Us</h2>
            <address>
              <strong>James Montana</strong>
              <br />
            </address>
            <address>
              <abbr title="Email">Email: </abbr>
              <a href="mailto:#" className="text-success">
                james@jmontanalaw.com
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
