#!/bin/sh
if [ $(docker ps -a -f name=jyesseffe | grep -w jyesseffe | wc -l) -eq 1 ]; then
  docker rm -f jyesseffe
fi
mvn clean package && docker build -t fr.cours.jee/jyesseffe .
docker run -d -p 9080:9080 -p 9443:9443 --name jyesseffe fr.cours.jee/jyesseffe
