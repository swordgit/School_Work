//This program calculate the BMI

#include <stdio.h>

void convert(float *pweight, float *pheight)
{
	*pweight = *pweight * 2.2046;
	*pheight = *pheight * 0.3937;
}

int computeBMI(float w, float h, float *pbmi)
{
	float bmi = 703 * w / (h * h);
	*pbmi = bmi;
	if(bmi < 18.5)
	{
		return 1;
	}
	else if(bmi < 25)
	{
		return 2;
	}
	else if(bmi < 30)
	{
		return 3;
	}
	else
	{
		return 4;
	}
}

main()
{
	float kg, cm, bmi;
	int result;
	printf("Please enter your weight in kilograms: ");
	scanf("%f", &kg);
	printf("Please enter your height in centimeters: ");
	scanf("%f", &cm);
	convert(&kg, &cm);
	result = computeBMI(kg, cm, &bmi);
	printf("Your BMI value is %.1f and you are ", bmi);
	if(result == 1)
	{
		printf("underweight.\n");
	}
	if(result == 2)
	{
		printf("normal.\n");
	}
	if(result == 3)
	{
		printf("overweight.\n");
	}
	if(result == 4)
	{
		printf("obese.\n");
	}

	
}