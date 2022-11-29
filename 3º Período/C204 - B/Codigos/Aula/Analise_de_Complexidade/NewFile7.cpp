#include <iostream>
using namespace std;

int main()
{
	int i, j; // contadores
	int x; // var aux
	int n; // tamanho do problema
	int cont = 0; // # vezes que a linha x=i*i foi executada
	
	cin >> n;
	
	j = 0;
	while(j<n)
	{
		i = n;
		while(i > 1)
		{
			cout << i;
			i /= 2;	
		}
		j++;
	}
	
	// Número de vezes que a linha x=i*i foi executada
	cout << cont << endl;
	
	return 0;
}