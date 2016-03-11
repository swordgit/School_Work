//Convert lower case to upper case

#include <stdio.h>

void main()
{
	int ch = getchar();
	
	while(ch != EOF)
	{
		if(ch >= 65 && ch <= 90)
		{
			putchar(ch);
			ch = getchar();
		}
		else if(ch >= 97 && ch <= 122)
		{
			ch = ch - 32;
			putchar(ch);
			ch = getchar();
		}
		else if (ch == ' '|| ch == '\t' || ch == '\n')
		{
			putchar(ch);
			ch = getchar();
		}
		else
		{
			ch = getchar();
		}
		
	}
}