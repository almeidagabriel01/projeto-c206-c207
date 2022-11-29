#include <iostream>
using namespace std;

int sequencial(int vet[], int tam, int x)
{
	int i = 0; // contador
	int cont = 0; // var aux
	bool achou; // var booleana para saber se achou ou não o elemento

	achou = false;
	// buscando o numero no vetor
	for(i = 0; i < tam; i++)
		if(vet[i] == x)
		{
			cont = i;
			achou = true;
		}

	if(achou == true)
		return cont;
	
	else
		return -1;
}

int main()
{
	int vetor[100]; // armazena os elementos
	int aux; // aux para ler o vetor
	int i = 0; // contador
	int numero; // numero a ser buscado
	int posi = 0; // posição encontrada no vetor

	// lendo o vetor
	cin >> aux;

	while(aux != -1)
	{
		vetor[i] = aux;
		i++;
		cin >> aux;
	}

	// lendo o numero a ser buscado
	cin >> numero;

	// verificando se o numero foi encontrado no vetor
	posi = sequencial(vetor, i, numero);

	// apresentando a solução
	if(posi != -1)
		cout << numero << " encontrado na posicao " << posi << endl;

	else
		cout << numero << " nao encontrado" << endl;

	return 0;
}
