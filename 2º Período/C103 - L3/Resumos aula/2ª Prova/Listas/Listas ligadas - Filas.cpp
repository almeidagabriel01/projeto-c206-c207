#include <iostream>
#include <list>
using namespace std;

int main()
{
	list<int> fila; // ponteiros
	int x; // var aux para leitura dos dados
	int i; // contador

	// Lendo dados e inserindo na fila
	for(i = 0; i < 3; i++) // 2 1 7
	{
		cin >> x;
		fila.push_back(x); // insere x no final da fila
	}

	// Mostrando e removendo elementos inseridos
	while(!fila.empty())
	{
		cout << *fila.begin() << endl; // fila.begin() aponta para o primeiro nó da lista
		fila.pop_front(); // remove o primeiro nó da lista
	}
	
	/*
	cout << *fila.begin() << endl; // fila.begin() aponta para o segundo nó da lista
	fila.pop_front(); // removendo o segundo nó da lista

	cout << *fila.begin() << endl; // fila.begin() aponta para o terceiro nó da lista
	*/

	return 0;
}
