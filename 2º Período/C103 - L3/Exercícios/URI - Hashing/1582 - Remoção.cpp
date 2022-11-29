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

int hash_remove(dado t[], int m, int k)
{
	int j;

	j = hash_search(t, m, k);

	if(j != -1)
	{
		t[j].status = 2;
		t[j].k = -1;
		return 0; // consegui remover
	}

	else
		return -1; // k nao esta na tabela
}

int main()
{
	dado t[100]; // vetor
	int m; // tamanho do vetor
	int i; // contador
	int k; // chave a ser inserida no vetor
	int x; // chave a ser removida no vetor

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
		hash_insert(t, m, k); // vetor é passado por referência, logo fica salvo a chave inteira no vetor
		cin >> k;
	}

	// entrando com a chave a ser removida no vetor
	cin >> x;

	// removendo a chave inserida do vetor
	hash_remove(t, m, x);

	// mostrando a solução
	for(i = 0; i < m; i++)
	{
		// tirando o espaço do último caractere
		if(i == m - 1)
			cout << t[i].k;
		
		else
			cout << t[i].k << " ";
	}

	cout << endl;

	return 0;
}
