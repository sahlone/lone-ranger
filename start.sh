#!/bin/bash
#
JAVA_VER=$(java -version 2>&1 | sed -n ';s/.* version "\(.*\)\.\(.*\)\..*"/\1\2/p;')
if [ $JAVA_VER != 18 ]
then
	echo "Java 8 required to run the game"
	exit;
fi
java -version
rm -rf lone-ranger.jar
cp target/lone-ranger.jar .
java -jar lone-ranger.jar
