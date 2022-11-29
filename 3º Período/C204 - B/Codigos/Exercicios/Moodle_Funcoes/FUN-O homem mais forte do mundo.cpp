#include<iostream>
using namespace std;

struct dados
{
	char nome[100];
	int n1;
	int n2;
	int n3;
	int n4;
};

int strongest(dados atletas[], int nAtletas)
{
	int soma[100];
	int i;
	int res = 0, forte = 0;

	for(i = 0; i < nAtletas; i++)
	{
		soma[i] = 0;
		soma[i] = atletas[i].n1 + atletas[i].n2 + atletas[i].n3 + atletas[i].n4;
	}

	for(i = 0; i < nAtletas; i++)
	{
		if(i == 0)
		{
			res = soma[i];
			forte = i;
		}
			
		else if (soma[i] > res)
		{
			res = soma[i];
			forte = i;
		}
	}
	
	return forte;
}

int main()
{
	dados atletas[100];
	int n;
	int i;

	cin >> n;

	for(i = 0; i < n; i++)
	{
		cin.ignore();
		cin.getline(atletas[i].nome, 100);
		cin >> atletas[i].n1 >> atletas[i].n2 >> atletas[i].n3 >> atletas[i].n4;
	}

	cout << "Vencedor: " << atletas[strongest(atletas, n)].nome << endl;

	return 0;
}
