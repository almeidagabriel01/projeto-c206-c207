#include <iostream>
using namespace std;

int main()
{
	int N; // tamanho do vetor
	int *v = NULL; // vetor declarado como ponteiro para ter o tamanho N
	int *p; // ponteiro para varrer o vetor
	int i; // contador
	int soma = 0; // quantidade de números pares e positivos inseridos no vetor
	
	// lendo o tamanho do vetor
	cin >> N;
	
	// alocando memória e deixando o vetor com tamanho N
	v = new int[N];
	
	// entrando com os elementos do vetor
	p = v;
	
	for(i = 0; i < N; i++)
	{
		cin >> v[i];
	}
	
	// verificando os elementos pares positivos no vetor
	for(p = v; p < v + N; p++)
	{
		if(*p > 0 && *p % 2 == 0)
			soma++;
	}
	
	// mostrando o resultado
	cout << soma << endl;
	
	// deletando a memória alocada do vetor
	delete [] v;
	
	return 0;
}