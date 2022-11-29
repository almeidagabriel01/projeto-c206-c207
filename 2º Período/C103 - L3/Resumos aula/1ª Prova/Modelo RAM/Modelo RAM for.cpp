#include <iostream>
using namespace std;

int main()
{
	int n; //tamanho do problema
	int i; // contador
	int x; // var aux
	int cont = 0; // conta o número de repetições de x = 2 * i
	
	cout << "Digite o valor de n:" << endl;
	cin >> n;
	
	for(i = 0; i < n; i++)
	{
		x = 2 * i; // f(n) = n
		cont++;
	}
	
	cout << cont << " repeticoes" << endl;
	return 0;
}