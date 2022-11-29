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

int main()
{
	int k; // chave a ser inserida
	int m; // tamanho do vetor
	int reso[100]; // var aux para armazenar o valor retornado
	int i = 0; // contador
	int n; // var aux

	// Entrada de dados
	cin >> k >> m;

	// fazendo o processamento e entrando com os dados
	while(k != 0 && m != 0)
	{
		reso[i] = hash_aux(k, m);
		i++;
		cin >> k >> m;
	}

	n = i;

	// mostrando a solução
	for(i = 0; i < n; i++)
	{
		cout << reso[i] << endl;
	}

	return 0;
}
