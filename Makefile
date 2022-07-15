CHECKSTYLE_VERSION:=10.3.1
CHECKSTYLE_JAR:=checkstyle.jar

${CHECKSTYLE_JAR}:
	curl -L https://github.com/checkstyle/checkstyle/releases/download/checkstyle-${CHECKSTYLE_VERSION}/checkstyle-${CHECKSTYLE_VERSION}-all.jar -o $@
