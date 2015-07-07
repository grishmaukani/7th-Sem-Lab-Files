#include<fstream.h>
#include<conio.h>
#include<stdio.h>
#include<string.h>
#include<ctype.h>

void main()
{
	char *a;
	int state=0, i=0;

	clrscr();

	cout<<"Enter Code: ";
	gets(a);

	while(a[i]!='\0')
	{
		switch(state)
		{
			case 0: if(isalpha(a[i]))
					state=1;
				else if(isdigit(a[i]))
					state=2;
				else
					state=3;
				break;

			case 1: while(isalpha(a[i]))
				{
					cout<<a[i];
					i++;
				}
				cout<<"\n";
				getch();
				state=0;
				break;

			case 2: while(isdigit(a[i]))
				{
					cout<<a[i];
					i++;
				}
				cout<<"\n";
				getch();
				state=0;
				break;

			case 3: if(a[i]==' ' || a[i]=='\t')
				{
					i++;
					state=0;
					break;
				}
				while(!isalpha(a[i]) || !isdigit(a[i]))
				{
					cout<<a[i];
					i++;
				}
				cout<<"\n";
				getch();
				state=0;
				break;
		}
	}

	getch();
}