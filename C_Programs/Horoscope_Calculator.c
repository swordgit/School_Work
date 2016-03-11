//This program will find the corresponding horoscope with given
//date

#include <stdio.h>
#include <stdlib.h>

int checkValidity(char *month, char *day, int *m, int *d)
{
	char ma[2] = {*month, *(month + 1)};
	char da[2] = {*day, *(day + 1)};
	*m = atoi(ma);
	*d = atoi(da);
	if(*m > 12 || *m < 1 || *d > 31 || *d < 0)
	{
		return 0;
	}
	else
	{
		if( *m == 4 || *m == 6 || *m == 9 || *m == 11)
		{
			if(*d > 30)
			{
				return 0;
			}
		}
		if(*m == 2)
		{
			if(*d > 29)
			{
				return 0;
			}
		}
		return 1;
	}
}

void main(int agrc, char **argv)
{
	int m,d,h,count = agrc;
	int valid = checkValidity(argv[1], argv[2], &m, &d);
	char month[13][10] = {"\0", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	char horo[13][15] = { "\0", "Aquarius", "Pisces", "Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo", "Libra", "Scorpio",
					 "Sagittarius", "Capricorn"};
	if(count != 3)
	{
		printf("Invalid number of command line arguments!\n");
	}
	else if(valid)
	{

		switch(m)
		{
			case 1:
			if(d >= 20)
			{
				h = m;
			}
			else
			{
				h = 12;
			}
			break;

			case 2:
			if(d >= 19)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 3:
			if(d >= 21)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 4:
			if(d >= 20)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 5:
			if(d >= 21)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 6:
			if(d >= 22)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 7:
			if(d >= 23)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 8:
			if(d >= 23)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 9:
			if(d >= 23)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 10:
			if(d >= 23)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 11:
			if(d >= 22)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;

			case 12:
			if(d >= 22)
			{
				h = m;
			}
			else
			{
				h = m - 1;
			}
			break;
		}
		printf("The horoscope sign for %s %d is %s.\n", month[m], d, horo[h]);
	}
	else
	{
		printf("Invalid command line arguments!\n");
	}
}