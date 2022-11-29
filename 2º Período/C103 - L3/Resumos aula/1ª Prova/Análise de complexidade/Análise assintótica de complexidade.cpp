#include <iostream>
using namespace std;

int main()
{
	int i, j;
	int n;
	int cont;
	int x;

	cin >> n;

	// Parte 1
	cont = 0;
	for(i = 0; i < n; i++)
	{
		x = 2 * i;
		cont++;
	} // n

	cout << "cont1: " << cont << endl;

	// Parte 2
	cont = 0;
	for(i = 0; i < 2*n; i++)
	{
		x = 2 * i;
		cont++;
	} // 2n

	cout << "cont2: " << cont << endl;

	// Parte 3
	cont = 0;
	for(i = 0; i < n; i++) // n
		for(j = 0; j < n; j++) // n
		{
			x = 2 * i;
			cont++;
		} // n*n = n²

	cout << "cont3: " << cont << endl;
	
	/* T(n) = T1(n) + T2(n) + T3(n)
       T(n) = n + 2n + n²
       T(n) = n² + 3n
       
       Passo 1 - trocar os coeficientes por 1
       T(n) = n² + n
       
       Passo 2 - Manter o maior termo da função (log(n), n, nlog(n), n2, n3, . . . , nk, 2n, n!)
       O(n) = n²
	*/

	return 0;
}
