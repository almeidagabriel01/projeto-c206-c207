#include <iostream>
using namespace std;

void mochila(int nitens, int capacidadet, int n, int cidade_inicial, int peso[], int v1[], int aux_p[])
{
	int p = 0;
	int capacidader;
	capacidader = capacidadet;

	for(int i = 1; i <= n; i++)
		if(i != cidade_inicial)
		{
			v1[p] = i;
			p++;
		}

	p = 0;
	for(int i = 1; i <= n; i++)
	{
		if(capacidader >= peso[i] && i != cidade_inicial)
		{
			v1[p] = i;
			capacidader -= peso[i];
			p++;
		}
	}
	
	for(int i = 0; i < p; i++)
	{
		aux_p[i] = i;
	}

}

int main()
{
	int nitens;
	int capacidadet; //capacidade total da mochila e capacidade restante da mochila
	int n;
	int p = 0;
	int aux_p[100];
	int peso[100];
	int v1[100];
	int cidade_inicial;

	cout << "Entre com a quantidade de itens" << endl;
	cin >> nitens;

	cout << "Entre com a capacidade da mochila" << endl;
	cin >> capacidadet;

	cout << "Entre com o numero de cidades" << endl;
	cin >> n;

	cout << "Entre com a cidade inicial" << endl;
	cin >> cidade_inicial;

	for(int i = 1; i <= nitens + 1; i++)
		if(i != cidade_inicial)
		{
			cout << "Entre com o peso do item " << i << endl;
			cin >> peso[i];
		}
		
	for(int i = 0; i < n; i++)
	{
		aux_p[i] = -1;
	}	

	mochila(nitens, capacidadet, n, cidade_inicial, peso, v1, aux_p);
	
	for(int i = 0; i < n; i++)
		if(aux_p[i] != -1)
			p++;
	
	for(int i = 0; i < p; i++)
		cout << v1[i] << " ";

	return 0;
}
