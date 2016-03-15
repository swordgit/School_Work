//this script is made to do +-X/ calculation

#!/bin/sh
#no local variables,all globle variables!
power(){
	count=1
	result=1
	while [ $3 -ge $count ]
	do
		result=`expr $result \* $1`
		count=`expr $count + 1`
	done
}

if [ $# -ne 3 ]
then 
	echo Usage: sh $0 operand1 operator operand2 
	exit 1
fi
#right quote doesn't matters,but left quote matters.
if [ "$2" = '^' ]
then
	#result=`power $*` $* or $1 $2 $3  
	power $*
	echo $result #the result of power()
elif [ "$2" = '+' ]
then
	echo `expr $1 + $3` 
elif [ "$2" = '-' ]
then
	echo `expr $1 - $3` 
elif [ "$2" = '/' ]
then
	echo `expr $1 / $3` 
elif [ "$2" = 'x' ]
then
	echo `expr $1 \* $3`
elif [ "$2" = '%' ]
then
	echo `expr $1 % $3`
else
	echo Error: invalid operator
	exit 1
fi