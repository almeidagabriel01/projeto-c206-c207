#include <iostream>
#include <list>
using namespace std;

// função para contar os elementos da lista
int contar(list<int> lista)
{
	list<int>::iterator p; // iterador para varrer a lista
	int res = 0; // var aux para contar os elementos da lista

	for(p = lista.begin(); p != lista.end() ; p++)
		res ++;
	
	return res;
}

int main()
{
	list<int>fila; // ponteiro para a fila
	int x; // var aux para leitura de dados
	int res = 0; // var para armazenar o valor da soma

	// inserindo os elementos na lista
	cin >> x;

	while(x != 0)
	{
		fila.push_back(x);
		cin >> x;
	}

	// processamento de dados
	res = contar(fila);

	// saída de dados
	cout << res << endl;

	return 0;
}
