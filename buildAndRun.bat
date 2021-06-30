@echo off
call mvn clean package
call docker build -t fr.cours.jee/jyesseffe .
call docker rm -f jyesseffe
call docker run -d -p 9080:9080 -p 9443:9443 --name jyesseffe fr.cours.jee/jyesseffe