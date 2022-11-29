#include <iostream>
#include <list>
using namespace std;

int main()
{
	list<int> pilha; // ponteiros
	int x; // var aux para leitura dos dados
	int i; // contador

	// Lendo dados e inserindo na pilha
	for(i = 0; i < 3; i++) // 2 1 7
	{
		cin >> x;
		pilha.push_front(x); // insere x no início da pilha
	}

	// Mostrando e removendo elementos inseridos
	while(!pilha.empty())
	{
		cout << *pilha.begin() << endl; // pilha.begin() aponta para o primeiro nó da lista
		pilha.pop_front(); // remove o primeiro nó da lista
	}
	
	/*
	cout << *pilha.begin() << endl; // pilha.begin() aponta para o segundo nó da lista
	pilha.pop_front(); // removendo o segundo nó da lista

	cout << *pilha.begin() << endl; // pilha.begin() aponta para o terceiro nó da lista
	*/

	return 0;
}
