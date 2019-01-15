import React, { Component } from "react";
import "./landing.css";

const LandingPage = () => (
  <div>
    <body>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
        <div class="container">
          <a class="navbar-brand" href="/">
            Start Form
          </a>
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarResponsive"
            aria-controls="navbarResponsive"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon" />
          </button>
          <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
              <li class="nav-item active">
                <a class="nav-link" href="#">
                  Home
                  <span class="sr-only">(current)</span>
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  About
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  Services
                </a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="#">
                  Contact
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>

      <header class="business-header mt-4">
        <div class="container">
          <div class="row">
            <div class="col-lg-12 mt-5">
              <h1 class="display-3 text-center extra-space mt-5">
                D.I.Y. Asylum
              </h1>
            </div>
          </div>
        </div>
      </header>

      <div class="container">
        <div class="row">
          <div class="col-sm-8">
            <h2 class="mt-4">What We Do</h2>
            <p>We help asylum seekers fill forms.</p>
            <p>We have a team of dedicated volunteers.</p>
            <p>
              <a class="btn btn-outline-success btn-lg" href="#">
                Call to Action &raquo;
              </a>
            </p>
          </div>
          <div class="col-sm-4">
            <h2 class="mt-4">Contact Us</h2>
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

        <div class="row">
          <div class="col-sm-4 my-4">
            <div class="card">
              <img
                class="card-img-top"
                src="http://placehold.it/300x200"
                alt=""
              />
              <div class="card-body">
                <h4 class="card-title">Card title</h4>
                <p class="card-text">Card content.</p>
              </div>
              <div class="card-footer">
                <a href="#" class="btn btn-outline-success">
                  Find Out More!
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-4 my-4">
            <div class="card">
              <img
                class="card-img-top"
                src="http://placehold.it/300x200"
                alt=""
              />
              <div class="card-body">
                <h4 class="card-title">Card title</h4>
                <p class="card-text">Card content.</p>
              </div>
              <div class="card-footer">
                <a href="#" class="btn btn-outline-success">
                  Find Out More!
                </a>
              </div>
            </div>
          </div>
          <div class="col-sm-4 my-4">
            <div class="card">
              <img
                class="card-img-top"
                src="http://placehold.it/300x200"
                alt=""
              />
              <div class="card-body">
                <h4 class="card-title">Card title</h4>
                <p class="card-text">Card content.</p>
              </div>
              <div class="card-footer">
                <a href="#" class="btn btn-outline-success">
                  Find Out More!
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>

      <footer class="py-5 bg-dark">
        <div class="container">
          <p class="m-0 text-center text-white">
            Copyright &copy; DIYASYLUM 2019
          </p>
        </div>
      </footer>
    </body>
  </div>
);

export default LandingPage;
