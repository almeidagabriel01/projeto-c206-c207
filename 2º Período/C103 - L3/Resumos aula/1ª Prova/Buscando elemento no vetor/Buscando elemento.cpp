#include <iostream>
using namespace std;

int main()
{
	int vetor[30]; // armazena os elementos
	int i = 0; // contador
	int n = 0; // var aux para armazenar o tamanho do vetor
	int numero; // numero a ser buscado
	int cont = 0; // var aux
	bool achou; // var booleana para saber se achou ou não o elemento

	// lendo o vetor
	cin >> vetor[i];

	while(vetor[i] != -1)
	{
		i++;
		cin >> vetor[i];
	}

	// armazenando o tamanho do vetor
	n = i;

	// lendo o numero a ser buscado
	cin >> numero;

	// buscando o numero no vetor
	achou = false;

	for(i = 0; i < n; i++)
		if(vetor[i] == numero)
		{
			cont = i;
			achou = true;
		}

	// verificando se foi encontrado
	if(achou == true)
		cout << "Encontrado na posicao: " << cont << endl;

	else
		cout << "Nao encontrado" << endl;
}
