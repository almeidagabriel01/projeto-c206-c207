#include <iostream>
using namespace std;

int fatorial(int n)
{
	if(n == 0) // condição de parada
		return 1;
	else // chamada recursiva
		return n * fatorial(n - 1);
}

int fibonacci(int n)
{
	if(n == 0 || n == 1) // condição de parada
		return 1;
	
	else // chamada recursiva
		return fibonacci(n - 1) + fibonacci(n - 2);
}

int main()
{
	int n; // numero do qual se quer calcular fatorial
	
	// Lendo n
	cin >> n;
	
	// Calculando e mostrando n!
	cout << "Fatorial de " << n << " eh: " << fatorial(n) << endl;
	cout << "Fibonacci de " << n << " eh: " << fibonacci(n) << endl;
	
	return 0;
}
