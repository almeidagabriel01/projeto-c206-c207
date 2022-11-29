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

int hash1(int k, int i, int m, int c1, int c2)
{
	return (hash_aux(k, m) + c1 * i + (c2 * (i * i))) % m;
}

int main()
{
	int m; // tamanho do vetor
	int i; // contador
	int k; // chave a ser inserida no vetor
	int c1, c2; // var aux para calculo do hash1
	int res[100]; // var resultado para guardar as posições da sondagem

	// entrando com o tamanho do vetor
	cin >> k;

	// entrando com as chaves e inserindo no vetor
	cin >> m;

	// entrando com o c1 e c2
	cin >> c1 >> c2;
	
	// salvando as posições da sondagem
	for(i = 0; i < m; i++)
	{
		res[i] = hash1(k, i, m, c1, c2);
	}
	
	// mostrando o resultado
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
