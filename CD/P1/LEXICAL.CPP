#include<fstream.h>
#include<iostream.h>
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
	clrscr();

	char *prog[20], *data[20][20];
	int ic=0, sc[10], l, i, j, k, c;

	/*
	f.open("input.txt", ios::in);
	char *c;

	while(!f.eof())
	{
		if(!f.eof())
		{
			f.getline(c, ' ');
			cout<<c<<"\n";
		}
	}

	f.close();
	*/

	cout<<"ENTER PROGRAM:-[type 'end' to terminate code]\n";
	while(1)
	{
		gets(prog[ic]);
		if(strcmp(prog[ic],"end")==0)
			break;
		if(prog[ic][0]==' ' || prog[ic][0]=='\t')
		{
			j=0;
			while(prog[ic][j]==' ' || prog[ic][j]=='\t')
				j++;

			l = strlen(prog[ic]);
			for(i=j;i<=l;i++)
				prog[ic][i-j] = prog[ic][i];
		}
		ic++;
	}

	for(i=0;i<ic;i++)
	{
		l=strlen(prog[ic]);
		c=0;
		k=0;
		for(j=0;j<l;j++)
		{
			if(prog[ic][j]!=' ')
				data[ic][c][k++]=prog[ic][j];
			else
			{
				data[ic][c][k] = '\0';
				c++;
				k=0;
			}
		}
		sc[ic] = c+1;
	}

	for(i=0;i<ic;i++)
	{
		cout<<"Line "<<i+1<<":\n";

		for(j=0;j<sc[ic];j++)
		{
			cout<<"Segment "<<j+1<<": ";
			puts(data[ic][j]);
		}
	}

	getch();
}