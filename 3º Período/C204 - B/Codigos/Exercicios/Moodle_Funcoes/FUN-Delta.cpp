#include<iostream>
#include<cmath>
using namespace std;

float calc_delta(float a, float b, float c)
{
	float res = 0;
	
	if (a != 0)
		res = pow(b, 2) - 4 * a * c;
	
	return res;
}

int main()
{
	float a, b, c;
	
	cin >> a >> b >> c;
	
	cout << "delta = " << calc_delta(a, b, c);
	
	return 0;
}