import React from "react";
import "./about.css";

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
              <li className="nav-item">
                <a className="nav-link" href="/landing">
                  Home
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link active" href="/about">
                  About
                  <span className="sr-only">(current)</span>
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
      <div className="empty-space" />
      <div className="container">
        <div className="container">
          <header className="logo-header mt-4" />
          <h2 className="mt-4"> Who are we </h2>
          <hr />
          <p>
            DIY Asylum LLC is a volunteer project. Our goal is to make the
            process of applying for asylum easier for asylum seekers who cannot
            afford lawyers. We make no pretense of offering legal advice to
            those who use our platform, and we strongly encourage anyone who can
            afford an immigration attorney to get one. Here are some important
            plain-language disclosures: We are not your lawyer. The use of DIY
            Asylum LLC’s resources does not create a legal or contractual
            relationship between the user and DIY Asylum LLC. We are not the
            United States government. Completing an asylum application using DIY
            Asylum LLC’s resources does not file, lodge, or ship your
            application to the U.S. Department of Homeland Security, U.S.
            Citizenship and Immigration Services, or the U.S. Department of
            Justice. It is the user’s responsibility to submit the printed form.
          </p>

          <h2 className="mt-4"> Privacy </h2>
          <hr />
          <p>
            Your information is private. We treat asylum applications and the
            information they contain with deep respect. The information you
            provide is strictly confidential and we will not share it with
            anyone at all.
          </p>

          <h2 className="mt-4"> Contributors </h2>
          <hr />
          <p>
            DIY Asylum LLC was cofounded by Michael Kreisel and James Montana.
            Here are brief biographies of our volunteer contributors.
          </p>

          <h2 className="mt-4"> Contact </h2>
          <hr />
          <p>
            Questions about DIY Asylum LLC should be directed to James Montana,
            Esq. at{" "}
            <a href="mailto:#" className="text-success">
              james@jmontanalaw.com
            </a>
            .
          </p>

          <div className="empty-space" />
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
