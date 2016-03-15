//This is script is made to calculate the average of marks and number of students improved their marks

#!/bin/sh
if [ $# -ne 2 ]
then 
	echo "Usage: sh $0 filename major"
	exit 1
fi
if [ ! -f $1 ]
then 
	echo "File $1 does not exist"
	exit 1
fi
if [ ! -s $1 ]
then 
	echo "File $1 is empty"
	exit 1
fi
if [ $2 != "Chemistry" ] && [ $2 != "Business" ] && [ $2 != "Psychology" ] && [ $2 != "Mathematics" ]
then
	echo There is no student whose major is $2.
	exit 1
fi
count=0 summid=0 sumfinal=0 avgmid=0 avgfinal=0 countimprove=0
while read lastname firstname midterm final major
do
	if [ $major == $2 ]
	then
		if [ $final -gt $midterm ]
		then
			echo $lastname $firstname $midterm $final +
		else
			echo $lastname $firstname $midterm $final 
		fi	
    fi	
	
	
done<$1	| sort -k1,1f -k2,2f 
while read lastname firstname midterm final major
do
	
	if [ $major == $2 ]
	then
		summid=`expr $summid + $midterm`
		sumfinal=`expr $sumfinal + $final`
		count=`expr $count + 1`
		
		if [ $final -gt $midterm ]
		then
			countimprove=`expr $countimprove + 1`
		fi
		
    fi	
	
	
done<$1
avgmid=`expr $summid / $count`
avgfinal=`expr $sumfinal / $count`

echo The average midterm mark of $2 students is $avgmid.
echo The average final mark of $2 students is $avgfinal.
echo $countimprove students have improved their mark.