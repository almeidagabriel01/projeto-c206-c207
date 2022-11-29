#include <iostream>
using namespace std;

int main()
{
	int n; //tamanho do problema
	int i, j; // contadores
	int x; // var aux
	int cont = 0; // conta o número de repetições de x = 2 * i

	cout << "Digite o valor de n:" << endl;
	cin >> n;

	for(i = 0; i < n; i++) // f1(n) = n
	{
		j = 1;
		while(j < n) // f2(n) = log2(n)
		{
			x = 2 * i;
			cont++;
			j = j * 2;
		}
	}

	// Tempo total = f1(n) * f2(n) = n * log2(n)
	cout << cont << " repeticoes" << endl;
	return 0;
}
