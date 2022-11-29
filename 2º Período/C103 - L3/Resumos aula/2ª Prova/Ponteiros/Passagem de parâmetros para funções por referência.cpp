#include <iostream>
using namespace std;

// retorna em s, o valor de x + y
void soma(int x, int y, int *s)
{
	*s = x + y;
}

int main()
{
	int a = 2, b = 3, c = 0;
	
	soma(a,b,&c);
	
	cout << "c = " << c << endl;
	
	return 0;
}
