#include <iostream>
#include <list>
using namespace std;

int main()
{
	list<int>lista; // ponteiro para a lista
	list<int>::iterator p; // iterador para varrer a lista
	int soma; // soma dos elementos da lista

	// inserindo elementos na lista
	lista.push_back(2);
	lista.push_back(1);
	lista.push_back(3);

	// mostrando a lista
	for(p = lista.begin(); p != lista.end() ; p++)
		cout << *p << " ";
	cout << endl;

	// calculando e mostrando a soma dos elementos da lista
	soma = 0;
	for(p = lista.begin(); p != lista.end() ; p++)
		soma = soma + *p;

	cout << "soma = " << soma << endl;
	
	// Desalocando memória usada pela lista
	while(!lista.empty())
		lista.pop_front();

	return 0;
}
