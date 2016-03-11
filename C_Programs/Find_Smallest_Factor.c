//This program find the smallest factor of the given number

#include <stdio.h>

int prime(int y)
{
	int i;
	for(i = 2; i <= y/2; i++)
	{
		if(y % i == 0)
		{
			return 0;
		}
	}
	return 1;
}
int smallestFactor(int x)
{
	int i;
	if(prime(x))
	{
		return x;
	}
	else
	{
		for(i = 2; i <= x/2; i++)
		{
			if(x % i == 0)
			{
				return i;
			}
		}
	}
}

void main()
{
	int input, factor;
	do
	{
		printf("Enter an integer greater than 1: ");
		scanf("%d", &input);
	}while(input <= 1);

	if(smallestFactor(input) == input)
	{
		printf("%d is a prime\n", input);
	}
	else
	{
		printf("The smallest factor of %d is %d\n", input, smallestFactor(input));
	}
}