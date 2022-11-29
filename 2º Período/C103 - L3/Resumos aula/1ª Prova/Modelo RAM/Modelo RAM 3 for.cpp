#include <iostream>
using namespace std;

int main()
{
	int n; //tamanho do problema
	int i, j, k; // contadores
	int x; // var aux
	int cont = 0; // conta o número de repetições de x = 2 * i

	cout << "Digite o valor de n:" << endl;
	cin >> n;

	for(i = 0; i < n; i++) // n
		for(j = 0; j < n; j++) // n
			for(k = 0; k < n; k++) // n
			{
				x = 2 * i;
				cont++;
			}

	// f(n) = n^3
	cout << cont << " repeticoes" << endl;
	return 0;
}
