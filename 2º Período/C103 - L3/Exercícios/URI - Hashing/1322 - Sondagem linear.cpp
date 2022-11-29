#include <iostream>
using namespace std;

int hash_aux(int k, int m)
{
	int res; // var que armazena a resposta

	// Fazendo o metódo da divisão
	res = k % m;

	// Se o valor for negativo, vai somar m a ele
	if(res < 0)
		res = res + m;

	return res;
}

int hash1(int k, int i, int m)
{
	int res; // var que armazena a resposta

	res = (hash_aux(k, m) + i) % m;

	return res;
}

int main()
{
	int k; // chave a ser inserida
	int m; // tamanho do vetor
	int res[100]; // vetor que armazena o valor retornado da função hash1
	int i; // contador

	// Entrada de dados
	cin >> k >> m;

	// processamento de dados
	for(i = 0; i < m; i++)
	{
		res[i] = hash1(k, i, m);
	}

	// mostrando a resposta sem espaço no último número
	for(i = 0; i < m; i++)
	{
		if(i == m - 1)
			cout << res[i];

		else
			cout << res[i] << " ";
	}

	cout << endl;

	return 0;
}
