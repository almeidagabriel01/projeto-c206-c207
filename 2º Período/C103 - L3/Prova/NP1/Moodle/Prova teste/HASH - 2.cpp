#include <iostream>
using namespace std;

struct dados
{
	int k; // chave
	int status; // 0: vazio, 1: ocupado
};

int h1(int k, int m)
{
	int res; // var que armazena a resposta

	// Fazendo o metódo da divisão
	res = k % m;

	// Se o valor for negativo, vai somar m a ele
	if(res < 0)
		res = res + m;

	return res;
}

int h2(int k, int m)
{
	int res; // var que armazena a resposta

	// Fazendo o metódo da divisão
	res = (1 + k % (m - 1));

	// Se o valor for negativo, vai somar m a ele
	if (res < 0)
		res = res + m;

	return res;
}

int princ1(int k, int m, int i)
{
	// realizando o double hashing
	return (h1(k, m) + i * h2(k, m)) % m;
}

int insert(dados t[], int m, int k)
{
	int i = 0;
	int j;

	do
	{
		j = princ1(k, m, i);
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

int search(dados t[], int m, int k)
{
	int i = 0;
	int j;

	do
	{
		j = princ1(k, m, i);

		if (t[j].k == k)
			return j;

		i = i + 1;
	}
	while (t[j].status != 0 && i < m);

	return -1;
}

int remove(dados t[], int m, int k)
{
	int j;

	j = search(t, m, k);

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
	dados t[100]; // vetor
	int m; // tamanho da tabela
	int i; // contador
	int x; // chave a ser removida
	int k; // chave a ser inserida no vetor

	// entrando com o tamanho da tabela
	cin >> m;

	// inicializando o vetor
	for(i = 0; i < m; i++)
	{
		t[i].k = -1;
		t[i].status = 0;
	}

	// entrando com as chaves a serem inseridas
	cin >> k;
	i = 0;

	while(k != 0)
	{
		insert(t, m, k);
		cin >> k;
	}

	// entrando com a chave para remover da tabela
	cin >> x;
	for(i = 0; i < m; i++)
	{
		remove(t, m, x);
	}
	
	// apresentando o resultado
	for(i = 0; i < m; i++)
	{
		if(i - 1 == m)
			cout << t[i].k;
		
		else
			cout << t[i].k << " ";
	}
	return 0;
}
