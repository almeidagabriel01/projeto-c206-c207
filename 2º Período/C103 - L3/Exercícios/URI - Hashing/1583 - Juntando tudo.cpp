#include <iostream>
using namespace std;

struct dado
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

int hash1(int k, int m, int i)
{
	return (h1(k, m) + i * h2(k, m)) % m;
}

int hash_insert(dado t[], int m, int k)
{
	int i = 0;
	int j;

	do
	{
		j = hash1(k, m, i);
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
		j = hash1(k, m, i);

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
	int opc; // opções a serem escolhida no menu
	int pesq; // var aux para guardar o resultado do hash_search

	// entrando com o tamanho do vetor
	cin >> m;

	// inicializando o vetor
	for(i = 0; i < m; i++)
	{
		t[i].k = -1;
		t[i].status = 0;
	}

	// entrando com a opção
	cin >> opc;

	// navegando pelo menu e fazendo o que cada opção é para ser feita
	while(opc != 5)
	{
		if(opc == 1)
		{
			cin >> k;
			hash_insert(t, m, k);
		}
		
		else if(opc == 2)
		{
			cin >> k;
			pesq = hash_search(t, m ,k);
			
			// mostrando se está ou não na tabela
			cout << pesq << endl;
		}
		
		else if (opc == 3)
		{
			cin >> k;
			hash_remove(t, m, k);
		}
		
		else if (opc == 4)
		{
			for(i = 0; i < m; i++)
			{
				if (i == m - 1)
					cout << t[i].k;
				
				else
					cout << t[i].k << " ";
			}
			cout << endl;
		}
		
		cin >> opc;
	}
	
	return 0;
}
