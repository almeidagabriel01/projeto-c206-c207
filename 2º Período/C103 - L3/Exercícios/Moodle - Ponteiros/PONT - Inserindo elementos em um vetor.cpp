#include <iostream>
using namespace std;

int main()
{
	int N; // tamanho do vetor
	int *v = NULL; // vetor declarado como ponteiro para ter o tamanho N
	int *p; // ponteiro para apontar para a posição correta do vetor
	int i; // contador
	
	// entrando com o tamanho do vetor
	cin >> N;
	
	// alocando espaço o vetor com o tamanho N
	v = new int[N];
	
	// entrando com os números no vetor
	p = v;
	
	for(i = 0; i < N; i++)
	{
		cin >> v[i];
	}
	
	// mostrando o vetor
	for(p = v; p < v + N; p++)
	{
		cout << *p << " ";
	}
	
	// deletando a memória alocada pelo vetor
	delete [] v;
	
	return 0;
}