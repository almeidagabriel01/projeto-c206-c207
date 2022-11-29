#include <iostream>
using namespace std;

int acimaMedia(int *vetor, int N)
{
	int *p;
	int res = 0;
	double soma = 0;
	
	for(p = vetor; p < vetor + N; p++)
	{
		soma += *p;
	}
	
	for(p = vetor; p < vetor + N; p++)
	{
		if(*p > (soma / N))
			res++;
	}
	
	return res;
}

int main()
{
	int N; // tamanho do vetor
	int *vet = NULL; // vetor com os elementos
	int acima; // elementos acima da média
	int i; // contador
	
	// entrando com o tamanho do vetor
	cin >> N;
	
	// alocando memória para o vetor
	vet = new int[N];
	
	// inserindo elementos no vetor
	for(i = 0; i < N; i++)
	{
		cin >> vet[i];
	}
	
	// verificando os elementos acima da média
	acima = acimaMedia(vet, N);
	
	// mostrando o resultado
	cout << acima << " elementos acima da media" << endl;
	
	// deletando a memória alocada
	delete [] vet;
	
	return 0;
}