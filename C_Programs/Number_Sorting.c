//This program sort the given amount of numbers

#include <stdio.h>

void bubbleSort(float *array, int size);
void swap(float *x, float *y);

main()
{
	int n, i;
	float *a;

	printf("Please enter the number of values to be sorted: ");
	scanf("%d", &n);
	printf("Please enter %d values: ", n);
	a[n];

	for(i = 0; i < n; i++)
	{
		scanf("%f", &a[i]);
	}

	bubbleSort(a, n);
	printf("Sorted list in ascending order:\n");

	for(i = 0; i < n; i++)
	{
		printf("%.1f", *(a + i));
		if (i != n-1)
		{
			printf(" ");
		}
	}
}

void bubbleSort(float *array, int size)
{
	int i, k;
	for(i = 0; i < size; i++)
	{
		for(k = 0; k < size; k++)
		{
			if( k < i);
			else
				if(array[i] < array[k])
				{
					swap(&array[i], &array[k]);
				}
		}
	}
}

void swap(float *x, float *y)
{
	float j;
	j = *x;
	*x = *y;
	*y = j;
}