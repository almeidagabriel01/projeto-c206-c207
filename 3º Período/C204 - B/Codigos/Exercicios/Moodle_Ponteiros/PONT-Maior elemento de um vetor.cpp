#include <iostream>
using namespace std;

// função que define o maior elemento dentro do vetor
int Maior(int *v, int N)
{
	int maior = v[0]; // var aux para armazenar o maior valor
	int *p; // ponteiro para varrer o vetor

	// calulcando o maior elemento do vetor
	for(p = v; p < v + N; p++)
	{
		if(*p > maior)
			maior = *p;
	}

	return maior;
}

int main()
{
	int N; // tamanho do vetor
	int *v = NULL; // vetor declarado como ponteiro para ter o tamanho N
	int i; // contador
	int res; // var aux que armazena o valor retornado da função maior

	// lendo o tamanho do vetor
	cin >> N;

	// alocando memória e deixando o vetor com tamanho N
	v = new int[N];

	// entrando com os elementos do vetor
	for(i = 0; i < N; i++)
	{
		cin >> v[i];
	}

	// calculando o maior elemento de um vetor
	res = Maior(v, N);

	// mostrando o resultado
	cout << res << endl;

	// deletando a memória alocada do vetor
	delete [] v;

	return 0;
}
