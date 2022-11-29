#include <iostream>
using namespace std;

int main()
{
	int n; //tamanho do problema
	//int i = 0;
	int i = 1; // contador
	int x; // var aux
	int cont = 0; // conta o número de repetições de x = 2 * i
	
	cout << "Digite o valor de n:" << endl;
	cin >> n;
	
	while(i < n)
	{
		x = 2 * i;
		//i++;
		i = i * 2; // f(n) = log2(n)2
		cont++;
	}
	
	cout << cont << " repeticoes" << endl;
	return 0;
}