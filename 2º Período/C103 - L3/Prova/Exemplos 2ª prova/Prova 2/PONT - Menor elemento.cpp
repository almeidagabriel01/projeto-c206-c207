#include <iostream>
using namespace std;

int menor(int *vetor, int n)
{
	int *p;
	int res = vetor[0];
	
	for(p = vetor; p < vetor + n; p++)
	{
		if(*p < res)
			res = *p;
	}
	
	return res;
}

int main()
{
	int n; // tamanho do vetor
	int *vet = NULL; // ponteiro
	int i; // contador
	int men; // menor elemento do vetor
	
	// entrando com o tamanho do vetor
	cin >> n;
	
	// alocando memória dinamicamente para o vet
	vet = new int[n];
	
	// inserindo elementos no vetor
	for(i = 0; i < n; i++)
	{
		cin >> vet[i];
	}
	
	// calculando o menor elemento inserido
	men = menor(vet, n);
	
	// mostrando o menor elemento do vetor
	cout << men << endl;
	
	// deletando a memória alocada pelo vet
	delete [] vet;
	
	return 0;
}