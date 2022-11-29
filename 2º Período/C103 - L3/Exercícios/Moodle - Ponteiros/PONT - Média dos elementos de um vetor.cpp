#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int N; // tamanho do vetor
	int *v = NULL; // vetor declarado como ponteiro para ter o tamanho N
	int *p; // ponteiro para varrer o vetor
	int i; // contador
	double soma; // var aux para somar todas as notas e fazer a meédia

	// entrando com tamanho do vetor
	cin >> N;

	// alocando memória para deixar o vetor com o tamanho N
	v = new int[N];

	// entrando com os números para calcular a média
	p = v;

	for(i = 0; i < N; i++)
	{
		cin >> v[i];
	}

	// calculando a média dos números
	for(p = v; p < v + N; p++)
	{
		soma += *p;
	}

	// mostrando o resultado
	cout << fixed << setprecision(2) << soma / N;

	// deletando o espaço alocado do vetor
	delete [] v;

	return 0;
}
