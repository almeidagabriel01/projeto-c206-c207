#include <iostream>
using namespace std;

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
	int res;
	
	res = (1 + k % (m-1));
	
	if (res < 0)
		res = res + m;
	
	return res;
}

int hash1(int k, int m, int i)
{
	return (h1(k, m) + i * h2(k, m)) % m; 
}

int main()
{
	int m; // tamanho do vetor
	int i; // contador
	int k; // chave a ser inserida no vetor
	int res[100]; // var resultado para guardar as posições da sondagem

	// entrando com as chaves
	cin >> k;

	// entrando com o tamanho do vetor
	cin >> m;
	
	// salvando as posições da sondagem
	for(i = 0; i < m; i++)
	{
		res[i] = hash1(k, m, i);
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
