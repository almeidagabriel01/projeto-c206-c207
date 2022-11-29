#include <iostream>
using namespace std;

int main()
{
	int i, j; // contadores
	int x; // var aux
	int n; // tamanho do problema
	int cont = 0; // # vezes que a linha x=i*i foi executada
	
	cin >> n;
	
	i = n;
	while(i>n)
	{
		x = i*i;
		i = i/2;
		cont++;
	}
	
	// Número de vezes que a linha x=i*i foi executada
	cout << cont << endl;
	
	return 0;
}