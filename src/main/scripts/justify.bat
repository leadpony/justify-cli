@echo off

SET JAVA_OPTS=
java %JAVA_OPTS% -jar lib\justify-cli-${project.version}.jar %*
