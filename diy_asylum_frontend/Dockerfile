FROM node:11.5

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
COPY package*.json ./

RUN npm install --only=production

# Install nodemon globally
RUN npm install nodemon -g

# Bundle app source
COPY . .
RUN cd /usr/src/app/client && npm install --only=production && npm rebuild node-sass && npm run build

ENV BE_HOST "http://localhost:8080"

EXPOSE 3000
CMD [ "node", "server.js" ]
