const path = require('path');
const express = require('express');
const bodyParser = require('body-parser');
const app = express();
const axios = require('axios');

const PORT = process.env.PORT || 3000;
const BE_HOST = process.env.BE_HOST || "http://localhost:8080";
console.log(BE_HOST)

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post('/api/encrypt', (req, res) => {
  axios.post(BE_HOST.concat('/encryption/v1'), req.body)
  .then(response => {
    res.send(response.data.message);
  })
  .catch(error => {
    console.log(error);
  });
});

app.post('/api/decrypt', (req, res) => {
  axios.post(BE_HOST.concat('/decryption/v1'), req.body)
  .then(response => {
    res.send(response.data.message);
  })
  .catch(error => {
    console.log(error);
  });
});

app.post('/api/fill', (req, res) => {
  axios({
    method:'post',
    url:BE_HOST.concat('/i589/fill'),
    responseType: 'arraybuffer', 
    data: req.body})
  .then(response => {
    res.setHeader('Content-Type', 'application/pdf');
    res.send(response.data);
  })
  .catch(error => {
    console.log(error);
  });
});

// Serve any static files
app.use(express.static(path.join(__dirname, 'client/build')));

// Handle React routing, return all requests to React app
app.get('*', function(req, res) {
  res.sendFile(path.join(__dirname, 'client/build', 'index.html'));
});

app.listen(PORT, () => console.log(`Listening on port ${PORT}`));