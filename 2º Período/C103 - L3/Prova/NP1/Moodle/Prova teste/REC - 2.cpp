#include <iostream>
using namespace std;

int func(int n, int k)
{
	if(k == 1)
		return n;

	else if(k == n)
		return 1;

	else
		return(func(n - 1, k - 1) + func(n - 1, k));
}

int main()
{
	int n;
	int k;
	int res;

	cin >> n >> k;

	res = func(n, k);

	cout << res << endl;

	return 0;
}
