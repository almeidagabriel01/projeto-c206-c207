#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

struct dados
{
	int codigo; // codigo do produto
	int quantidade; // quantidade em estoque
	float preco; // preco unitario
};

// Usa o algoritmo quicksort para ordenar o vetor
void quickSort(dados vetor[], int i, int j)
{
	int esq, dir, pivo;
	dados trab; // var aux para trocar elementos de lugar
	esq = i;
	dir = j;
	pivo = vetor[(int)round((esq + dir) / 2.0)].codigo;
	do
	{
		while (vetor[esq].codigo < pivo)
			esq++;
		while (vetor[dir].codigo > pivo)
			dir--;
		if (esq <= dir)
		{
			trab = vetor[esq];
			vetor[esq] = vetor[dir];
			vetor[dir] = trab;
			esq++;
			dir--;
		}
	}
	while (esq <= dir);
	if (dir - i >= 0)
		quickSort(vetor, i, dir);
	if (j - esq >= 0)
		quickSort(vetor, esq, j);
}

int main()
{
	dados estoque[100]; // vetor de structs
	int i, j; // contadores
	int n; // numero de produtos a serem cadastrados
	
	// lendo o numero de produtos a serem cadastrados
	cin >> n;
	
	// lendo os dados
	for(j = 0; j < n; j++)
	{
		cin >> estoque[j].codigo >> estoque[j].quantidade >> estoque[j].preco;
	}
	i = 0;
	
	// ordenando a struct
	quickSort(estoque, 0, j-1);
	
	// mostrando a solução
	for(j = 0; j < n; j++)
	{
		cout << "Codigo: " << estoque[j].codigo << endl;
		cout << "Quantidade em estoque: " << estoque[j].quantidade << endl;
		cout << fixed << setprecision(2) << "Preco unitario: R$ " << estoque[j].preco << endl;
		cout << endl;
	}
	
	return 0;
}
