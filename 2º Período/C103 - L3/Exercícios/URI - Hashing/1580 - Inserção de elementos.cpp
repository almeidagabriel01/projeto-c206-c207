#include <iostream>
using namespace std;

struct dado
{
	int k; // chave
	int status; // 0: vazio, 1: ocupado
};

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

int hash_insert(dado t[], int m, int k)
{
	int i = 0;
	int j;

	do
	{
		j = hash1(k, i, m);
		if (t[j].status != 1)
		{
			t[j].k = k;
			t[j].status = 1;
			return j;
		}
		else
			i = i + 1;

	}
	while (i != m);

	return -1; // tabela cheia
}

int main()
{
	dado t[100]; // vetor
	int m; // tamanho do vetor
	int i; // contador
	int k; // chave a ser inserida no vetor

	// entrando com o tamanho do vetor
	cin >> m;

	// inicializando o vetor
	for(i = 0; i < m; i++)
	{
		t[i].k = -1;
		t[i].status = 0;
	}

	// entrando com as chaves
	cin >> k;

	while(k != 0)
	{
		t[i].k = k;
		i++;
		hash_insert(t, m, k);
		cin >> k;
	}

	// mostrando a solução
	for(i = 0; i < m; i++)
	{
		if(i == m - 1)
			cout << t[i].k;
		else
			cout << t[i].k << " ";
	}

	cout << endl;

	return 0;
}
