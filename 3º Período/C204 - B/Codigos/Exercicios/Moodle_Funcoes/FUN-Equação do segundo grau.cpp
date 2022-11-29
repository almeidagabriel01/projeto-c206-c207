#include<iostream>
#include<iomanip>
#include<cmath>
using namespace std;

int calc_raizes(float a, float b, float c, float &x1, float &x2)
{
	int delta = 0;

	if(a != 0)
	{
		delta = pow(b, 2) - 4 * a * c;

		x1 = (-b + sqrt(delta)) / (2 * a);
		x2 = (-b - sqrt(delta)) / (2 * a);
	}
	if (x1 || x2 >= 0)
		return 0;
	else
		return 1;
}

int main()
{
	int a, b, c, res;;
	float x1, x2;

	cin >> a >> b >> c;

	res = calc_raizes(a, b, c, x1, x2);

	cout << fixed << setprecision(2);
	if (res == 0 && x1 < x2)
	{
		cout << "x1 = " << x1 << endl;
		cout << "x2 = " << x2 << endl;
	}
	else if (res == 0 && x2 < x1)
	{
		cout << "x1 = " << x2 << endl;
		cout << "x2 = " << x1 << endl;
	}
	else if(res == 0 && x1 == x2)
		cout << fixed << setprecision(0) << "x = " << x1;
	else
		cout << "Nao ha raizes reais" << endl;

	return 0;
}
