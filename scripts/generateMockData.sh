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

#! Connected, Interest Declarations, Comments, Job Offers
for i in $(seq 3 8 $(($sizefactor*8)))
do
    #! Connected with half of users
    for j in $(seq $(($i+4)) 4 $(($sizefactor*8)))
    do
        echo "INSERT INTO connected VALUES($i, $j);" >> $scriptFile
    done

    for j in $(seq $(($i+5)) 4 $(($sizefactor*8)))
    do
        echo "INSERT INTO interest_declaration VALUES($i, $j);" >> $scriptFile
    done

    for j in $(seq $(($i+5)) 4 $(($sizefactor*8)))
    do
        echo "INSERT INTO comment VALUES(default, $i, $j, 'Hello world!');" >> $scriptFile
    done

    echo "INSERT INTO job_offer VALUES(default, $i, 'Newborn Software Engineer', 'At least 5 years of prior experience');" >> $scriptFile

done

#! Job Offers Seen
for i in $(seq 3 4 $(($sizefactor*2)))
do

    echo "INSERT INTO job_offer_seen VALUES($i, $(( RANDOM%$i+1 )));" >> $scriptFile

done

