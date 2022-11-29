#include <iostream>
using namespace std;

int main()
{
	int *vetor = NULL; // ponteiro para o vetor
	int tam; // tamanho desejado para o vetor
	int i; // contador
	
	// Ler o tamanho desejado para o vetor
	cout << "Qual o tamanho desejado para o vetor?" << endl;
	cin >> tam;
	
	// Criar o vetor de tamanho tam
	vetor = new int[tam];
	
	// Ler os elementos do vetor
	cout << "Digite os elementos do vetor" << endl;
 	
	for(i = 0; i < tam; i++)
		cin >> vetor[i];
	
	// Mostrar o vetor
	cout << "Elementos inseridos:" << endl;
 	
	for(i = 0; i < tam; i++)
		cout << vetor[i] << " ";
	
	cout << endl;
	
	//liberando memória usada pelo vetor
	delete [] vetor;
	
	return 0;
}

/*
    1. Usa-se o [tam] pois quer uma struct com tamanho tam
    
    2. Usa-se o [] depois de delete e antes de produto pois é um vetor de struct

*/