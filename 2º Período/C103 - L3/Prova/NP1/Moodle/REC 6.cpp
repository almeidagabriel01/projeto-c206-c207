#include <iostream>
using namespace std;

// função para determinar quantas vezes um dígito k ocorre em um número natural N
int conta(int N, int k)
{
	if(N == 0)
		return 0;
	else
		return conta(N / 10, k) + (N % 10 == k);
}

int main()
{
	int n; // número N
	int k; // dígito k

	// entrada de dados
	cin >> n >> k;

	// processamento e saída de dados
	while(n != -1 && k != -1)
	{
		cout << conta(n, k) << endl;

		cin >> n >> k;
	}

	return 0;
}
