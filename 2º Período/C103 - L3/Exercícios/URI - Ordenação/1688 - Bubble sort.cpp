#include <iostream>
using namespace std;

void bubbleSort(int vetor[], int tamanho)
{
	int i, j; // contadores
	int trab;
	bool troca;
	int limite;
	troca = true;
	limite = tamanho - 1;
	while (troca)
	{
		troca = false;
		for (i = 0; i < limite; i++)
			if (vetor[i] > vetor[i + 1])
			{
				trab = vetor[i];
				vetor[i] = vetor[i + 1];
				vetor[i + 1] = trab;
				j = i;
				troca = true;
			}
		limite = j;
	}
}

int main()
{
	int vetor[100]; // vetor
	int aux; // aux para ler o vetor
	int i = 0; // contador
	int tam = 0; // var aux para armazenar o tamanho do vetor

	//lendo o vetor
	cin >> aux;

	while(aux != 0)
	{
		vetor[i] = aux;
		i++;
		cin >> aux;
	}

	// Armazenando o tamanho do vetor
	tam = i;
	
	// Ordenando
	bubbleSort (vetor, tam);
	
	// Mostrando o resultado
	for(i = 0; i < tam; i++)
	{
		cout << vetor[i] << " ";
	}
	
	cout << endl;

	return 0;
}
