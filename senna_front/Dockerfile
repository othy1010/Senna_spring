# base image
FROM node:alpine

# create & set working directory
RUN mkdir -p /usr/src
WORKDIR /usr/src

# copy source files
COPY . /usr/src

# install dependencies
RUN yarn --netwrok -timeout 100000
RUN yarn install
# start app
EXPOSE 3000
CMD yarn dev