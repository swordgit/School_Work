//Eliminate extra newline character

#include <stdio.h>

void main()
{
	int ch = getchar();
	while(ch != EOF)
	{
		putchar(ch);
		if(ch != '\n')
		{
			ch = getchar();
		}
		else
		{
			while(ch == '\n')
			{
				ch = getchar();
			}
		}
	}
}