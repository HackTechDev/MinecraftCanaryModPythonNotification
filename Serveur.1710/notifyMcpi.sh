#!/bin/sh

DIR="./"
EVENTS="modify"

inotifywait -m -e $EVENTS --timefmt '%Y-%m-%d %H:%M:%S' --format '%T %f' $DIR |
while read date time file
do
    if [ "$file" = "mcpi.txt" ];
    then
        echo "$date $time Modify : $file"
        mcpiScript=`./parseMcPi.py`
        eval $mcpiScript
    fi;
done

