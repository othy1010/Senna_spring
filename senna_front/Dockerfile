# base image
FROM node:alpine

# create & set working directory
RUN mkdir -p /usr/src
WORKDIR /usr/src

COPY ./package.json package.json

# install dependencies
RUN yarn --network -timeout 100000
RUN yarn install

# copy source files
COPY . /usr/src

# start app
EXPOSE 3000
CMD yarn dev