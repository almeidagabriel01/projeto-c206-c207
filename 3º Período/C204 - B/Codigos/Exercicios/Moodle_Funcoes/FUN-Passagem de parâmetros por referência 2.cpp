#include<iostream>
#include <iomanip>
using namespace std;

void converte(float F, float &C, float &K)
{
	C = (F - 32) * 5/9;
	K = C + 273;
}

int main()
{
	float F, Cel, Kel;
	
	cin >> F;
	converte(F, Cel, Kel);
	
	cout << fixed << setprecision(2);
	cout << "Celsius: " << Cel << endl;
	cout << "Kelvin: " << Kel << endl;
	
	return 0;
}