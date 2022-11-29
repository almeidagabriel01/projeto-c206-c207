#include <iostream>
using namespace std;

// struct para a tabela hashing
struct dado
{
	int k; // chave
	int status; // 0: vazio, 1: ocupado
};

// função auxiliar para a função hash1
int hash_aux(int k, int m)
{
	int res;

	res = k % m;

	if(res < 0)
		res = res + m;

	return res;
}

// função que retorna a posição que a chave pode ser inserida
int hash1(int k, int i, int m, int c1, int c2)
{
	return (hash_aux(k, m) + c1 * i + (c2 * (i * i))) % m;
}

// função para inserção das chaves na tabela hashing
int hash_insert(dado t[], int m, int k, int c1, int c2)
{
	int i = 0;
	int j;

	do
	{
		j = hash1(k, i, m, c1, c2);
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

// função para procura de uma chave dentro da tabela hashing
int hash_search(dado t[], int m, int k, int c1, int c2)
{
	int i = 0;
	int j;

	do
	{
		j = hash1(k, i, m, c1, c2);

		if (t[j].k == k)
			return j;

		i = i + 1;
	}
	while (t[j].status != 0 && i < m);

	return -1;
}

int main()
{
	dado T[100]; // tabela
	int m; // tamanho da tabela
	int c1, c2; // vars aux para achar a chave no vetor
	int k; // chaves a serem inseridas na tabela
	int x; // chave a ser verificada na tabela
	int i = 0; // contador
	int res;

	// entrando com o tamanho da tabela e os valores de c1 e c2
	cin >> m >> c1 >> c2;

	// inicializando o vetor
	for(i = 0; i < m; i++)
	{
		T[i].k = -1;
		T[i].status = 0;
	}

	// entrando com os valores das chaves na tabela
	cin >> k;

	while(k != 0)
	{
		hash_insert(T, m, k, c1, c2);
		cin >> k;
	}

	// entrando com a chave a ser verificada na tabela
	cin >> x;

	// pesquisando na tabela a chave
	res = hash_search(T, m, x, c1, c2);

	// apresentando a solução
	if (res != -1)
		cout << "Chave " << x << " encontrada na posicao " << res << endl;

	else
		cout << "Chave " << x << " nao encontrada" << endl;

	return 0;
}
