//this script is made to determine the letter grade of student work

#!/bin/sh
if [ $# -ne 1 ]
then 
	echo Usage: sh $0 filename
	exit 1
fi
if [ ! -f $1 ]
then 
	echo File $1 does not exist
	exit 1
fi
if [ ! -s $1 ]
then 
	echo File $1 is empty 
	exit 1
fi
while read lastname firstname midterm final major
do
	total=`expr $midterm \* 40 / 100 + $final \* 60 / 100`

	if [ $total -ge 90 ] 
		then	grade=A+
	elif [ $total -ge 80 ] 
		then	grade=A
	elif [ $total -ge 75 ]
		then	grade=B+
	elif [ $total -ge 70 ] 
		then	grade=B
	elif [ $total -ge 65 ] 
		then	grade=C+
	elif [ $total -ge 60 ] 
		then	grade=C
	elif [ $total -ge 55 ] 
		then	grade=D+
	elif [ $total -ge 50 ] 
		then	grade=D
	elif [ $total -ge 40 ] 
		then	grade=E
	else
		grade=F
	fi
	echo $major $lastname $firstname $total $grade
done<$1	| sort -k1,1 -k4,4nr -k2,2f -k3,3f