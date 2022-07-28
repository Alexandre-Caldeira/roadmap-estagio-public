FROM ubuntu

RUN apt update 

RUN apt-get install openjdk-8-jre-headless -y

RUN apt-get install openjdk-8-jdk -y

RUN apt-get install vim -y

CMD [ "/bin/sh" ]