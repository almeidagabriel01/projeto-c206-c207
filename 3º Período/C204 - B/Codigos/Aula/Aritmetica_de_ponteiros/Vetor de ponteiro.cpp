#include <iostream>
using namespace std;

int main()
{
	int *vetor = NULL; // ponteiro para o vetor
	int N; // tamanho desejado para o vetor
	int i; //contador

	//lendo o tamanho do vetor
	cin >> N;

	//alocando memória
	vetor = new int[N];
	//lendo elementos
	for(i = 0; i < N; i++)
		cin >> vetor[i];
	//mostrando o vetor
	for(i = 0; i < N; i++)
		cout << vetor[i] << endl;
	//liberando memória
	delete [] vetor;

	return 0;
}
