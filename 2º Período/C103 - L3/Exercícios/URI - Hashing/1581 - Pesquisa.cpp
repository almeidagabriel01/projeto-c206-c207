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

int hash_search(dado t[], int m, int k)
{
	int i = 0;
	int j;

	do
	{
		j = hash1(k, i, m);

		if (t[j].k == k)
			return j;

		i = i + 1;
	}
	while (t[j].status != 0 && i < m);

	return -1;
}

int main()
{
	dado t[100]; // vetor
	int m; // tamanho do vetor
	int i; // contador
	int k; // chave a ser inserida no vetor
	int x; // chave a ser verificada no vetor
	int pos; // var aux que armazena a posição da chave verificada

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
		hash_insert(t, m, k); // vetor é passado por referência, logo fica salvo a chave
		cin >> k;
	}

	// entrando com a chave a ser verificada e pesquisando no vetor
	cin >> x;

	pos = hash_search(t, m, x);

	// mostrando a solução
	if(pos != -1)
		cout << "Chave " << x << " encontrada na posicao " << pos << endl;

	else
		cout << "Chave " << x << " nao encontrada" << endl;

	return 0;
}
