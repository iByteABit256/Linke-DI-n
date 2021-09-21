#!/bin/sh

scriptFile="./mock.sql"
sizefactor=25

case $1 in
    small)
        sizefactor=5
        ;;
    medium)
        sizefactor=25
        ;;
    large)
        sizefactor=100
        ;;
esac

echo "" > $scriptFile

#! Users, Information Pages, Proffessionals, Posts
for i in $(seq 1 $(($sizefactor*2)))
do
    echo "INSERT INTO user VALUES($((1+4*($i-1))), '$i@gmail.com', '$i', '$i', '$i', '$i', '$i', '$i');" >> $scriptFile
    echo "INSERT INTO information_page VALUES($((2+4*($i-1))), '$i', '$i');" >> $scriptFile
    echo "INSERT INTO proffessional VALUES($((3+4*($i-1))), $((2+4*($i-1))), $((1+4*($i-1))));" >> $scriptFile
    echo "INSERT INTO post VALUES($((4+4*($i-1))), $((3+4*($i-1))), '$i', '$i', '$(date +"%Y-%m-%d %H:%M:%S")');" >> $scriptFile
done

#! Connected, Interest Declarations
for i in $(seq 3 8 $(($sizefactor*8)))
do
    echo "INSERT INTO connected VALUES($i, $((i+4)));" >> $scriptFile
    echo "INSERT INTO interest_declaration VALUES($i, $((i+5)));" >> $scriptFile
done

