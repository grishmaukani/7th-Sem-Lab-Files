#include<iostream.h>
#include<conio.h>
#include<stdio.h>
#include<ctype.h>
#include"lexical.cpp"

void main()
{
	char *a;
	int state=0, i=0;
	Lexical l;


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

			case 1: char *t;
				int tc=0;
				while(isalpha(a[i]))
				{
					t[tc++]=a[i];
					cout<<a[i++];
				}
				t[tc]='\0';
				l.tokenCheck(t);
				memset(t, 0, strlen(t));
				cout<<"\n";
				getch();
				state=0;
				break;

			case 2: int c=0;
				while(isdigit(a[i]))
				{
					c = c*10 + a[i]-'0';
					cout<<a[i++];
				}
				l.consStore(c);
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
				char *s;
				int sc=0;
				while(!isalnum(a[i]) && a[i]!='\0')
				{
					s[sc++]=a[i];
					cout<<a[i++];
				}
				s[sc]='\0';
				l.spsymStore(s);
				cout<<"\n";
				getch();
				state=0;
				break;
		}
	}
	getch();
}