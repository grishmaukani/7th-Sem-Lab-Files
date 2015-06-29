#include<fstream.h>
#include<conio.h>
#include<string.h>
#include<stdio.h>

fstream f;

int keyword(char *c)
{
	f.open("keyword.txt", ios::in);
	char *k;

	while(!f.eof())
	{
		if(!f.eof())
		{
			f.getline(k, '\n');
			if(strcmpi(k,c) == 0)
			{
				f.close();
				return 1;
			}
		}
	}

	f.close();
	return 0;
}

void main()
{
	f.open("input.txt", ios::in);
	char *c;

	while(!f.eof())
	{
		if(!f.eof())
		{
			f.getline(c, '\n');
			cout<<c<<"\n";
		}
	}

	f.close();
	getch();
}