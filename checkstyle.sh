#!/usr/bin/env bash

# Runs checkstyle and fails only if ERROR or WARNING is returned

EXIT=0
CONF=style.xml
CHECKSTYLE_PATH=`pwd`/checkstyle.jar
# check the file is a Java file
for f in "$@"
do
    if [[ "$f" == *.java ]]; then
        OUT=`java -jar $CHECKSTYLE_PATH -c=$CONF $f`
        if [[ "$OUT" == *"[ERROR]"* ]] || [[ "$OUT" == *"[WARN]"* ]] ; then
            echo "$OUT"
            EXIT=1
        fi
    fi
done

if [[ "$EXIT" == 1 ]];then
  exit 1
fi
