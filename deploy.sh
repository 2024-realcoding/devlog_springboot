#!/bin/bash

SERVER_HOME=$(pwd)
APPLICATION=devlog_springboot-0.0.1-SNAPSHOT.jar

if [ -f $SERVER_HOME/application.pid ];then
  kill -9 $(cat $SERVER_HOME/application.pid)
  rm $SERVER_HOME/application.pid
fi

sleep 1s

nohup java -jar $APPLICATION >> spring.out 2>&1 & echo $! > application.pid