#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

double raiz(double x, double x0, double e)
{
	if(abs(x0 * x0 - x) <= e)
		return x0;
	else
		return raiz(x, ((x0 * x0 + x) / (2 * x0)), e);
}

int main()
{
	double x; // var para calcular a raiz
	double x0; // var para calcular a raiz
	double e; // var para calcular a raiz

	// lendos as variaveis para calcular a raiz
	cin >> x >> x0 >> e;

	// Calculando e mostrando a raiz das variaveis
	cout << fixed << setprecision(2) << raiz(x, x0, e) << endl;

	return 0;
}
