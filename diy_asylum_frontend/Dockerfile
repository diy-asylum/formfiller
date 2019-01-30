FROM node:11.5

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
# A wildcard is used to ensure both package.json AND package-lock.json are copied
# where available (npm@5+)
COPY package*.json ./

RUN npm install --only=production

# Bundle app source
COPY . .

ENV BE_HOST "http://localhost:8080"

EXPOSE 3000
CMD [ "node", "server.js" ]
