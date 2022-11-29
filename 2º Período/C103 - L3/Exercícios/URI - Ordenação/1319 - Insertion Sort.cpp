#include <iostream>
using namespace std;

// ordenando o vetor na forma de insecao direta
void insercaoDireta(int vetor[], int tamanho)
{
	int i, j; // contadores
	int chave;
	
	for (j = 1; j < tamanho; j++)
	{
		chave = vetor[j];
		i = j - 1;
		while ((i >= 0) && (vetor[i] < chave))
		{
			vetor[i + 1] = vetor[i];
			i = i - 1;
		}
		vetor[i + 1] = chave;
	}
}

int main()
{
	int vetor[100]; // vetor
	int aux; // var aux
	int i = 0; // contador
	int tam = 0; // tamanho do vetor

	//lendo o vetor
	cin >> aux;

	while(aux != 0)
	{
		vetor[i] = aux;
		i++;
		cin >> aux;
	}

	// armazenando o tamanho do vetor
	tam = i;

	// ordenando o vetor
	insercaoDireta(vetor, tam);
	
	// mostrando a resolução
	for(i = 0; i < tam; i++)
	{
		cout << vetor[i] << " ";
	}
	cout << endl;

	return 0;
}
