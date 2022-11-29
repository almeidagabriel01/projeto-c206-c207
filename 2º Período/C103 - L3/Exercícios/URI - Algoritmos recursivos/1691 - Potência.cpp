#include <iostream>
using namespace std;

int potencia(int a, int n)
{
	if(n == 0) // condição de parada
		return 1;
	else // chamada recursiva
		return a * potencia(a, n-1);
}

int main()
{
	int a; // base da potencia
	int n; // expoente da potencia
	
	// Lendo a base e o expoente da potencia
	cin >> a >> n;
	
	// Calculando e mostrando a potencia
	cout << potencia(a, n) << endl;
	
	return 0;
}
