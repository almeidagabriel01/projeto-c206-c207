#include <iostream>
using namespace std;

int main()
{
	int i, j; // contadores
	int x; // var aux
	int n; // tamanho do problema
	int cont = 0; // # vezes que a linha x=i*i foi executada
	
	cin >> n;
	
	for(i = 0; i < n; i++)
	{
		j = 1;
		while(j < n)
		{
			x = i*i;
			j = j * 2;
			cont++;
		}
	}
	// Número de vezes que a linha x=i*i foi executada
	cout << cont << endl;
	
	return 0;
}