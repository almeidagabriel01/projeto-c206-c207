#include <iostream>
#include <iomanip>
#include <cmath>
using namespace std;

double raiz(double x, double x0, double e)
{
	if(abs((x0 * x0) - x) <= e)
	return x0;
	
	else
		return raiz(x,(pow(x0, 2) + x)/ (2 * x0), e);
}

int main()
{
	double x, x0, resultado, e;
		
	cin >> x >> x0 >> e;
	
	resultado = raiz(x, x0, e);
	
	cout << fixed << setprecision(4) << resultado << endl;
	
	return 0;
}