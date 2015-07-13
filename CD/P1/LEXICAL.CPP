#include<fstream.h>
#include<string.h>

class Lexical
{
	fstream kwd, idf, cons, spsym;

	public:
		Lexical();
		~Lexical();
		void tokenCheck(char*);
		void consStore(int);
		void spsymStore(char*);
};

Lexical :: Lexical()
{
	kwd.open("kwdstore.txt", ios::app);
	idf.open("idfstore.txt",  ios::app);
	cons.open("consstore.txt", ios::app);
	spsym.open("spsymstore.txt", ios::app);
}

Lexical :: ~Lexical()
{
	kwd.close();
	idf.close();
	cons.close();
	spsym.close();
}

void Lexical :: tokenCheck(char *t)
{
	fstream f;

	f.open("keywords.txt", ios::in);
	char *k;
	int check=0;

	while(!f.eof())
	{
		if(f.eof())
			break;

		f.getline(k, '\n');
		if(strcmpi(k,t) == 0)
		{
			check=1;
			break;
		}
	}

	if(check==1)
	{
		kwd.write(t, sizeof(t));
		kwd<<"\n";
	}
	else
	{
		idf.write(t, sizeof(t));
		idf<<"\n";
	}
	f.close();
}

void Lexical :: consStore(int c)
{
	cons<<c<<"\n";
}

void Lexical :: spsymStore(char *s)
{
	spsym.write(s, sizeof(s));
	spsym<<"\n";
}