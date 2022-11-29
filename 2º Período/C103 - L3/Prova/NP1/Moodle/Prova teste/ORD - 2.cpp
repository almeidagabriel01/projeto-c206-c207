#include <iostream>
#include <cmath>
using namespace std;

void quickSort(int vetor[], int tamanho, int i, int j)
{
	int trab, esq, dir, pivo;
	esq = i;
	dir = j;
	pivo = vetor[(int)round((esq + dir) / 2.0)];
	do
	{
		while (vetor[esq] < pivo)
			esq++;
		while (vetor[dir] > pivo)
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
		quickSort(vetor, tamanho, i, dir);
	if (j - esq >= 0)
		quickSort(vetor, tamanho, esq, j);
}

int main()
{
	int vet[100];
	int i = 0, j = 0;
	int n;
	int tam;

	cin >> n;

	while(n != -1)
	{
		vet[j] = n;
		j++;
		cin >> n;
	}

	tam = j;

	for(i = 0; i < tam; i++)
	{
		quickSort(vet, tam, i, j - 1);
	}

	for(i = 0; i < tam; i++)
	{
		if(i - 1 == tam)
			cout << vet[i];
		
		else
			cout << vet[i] << " ";
	}


	return 0;
}
