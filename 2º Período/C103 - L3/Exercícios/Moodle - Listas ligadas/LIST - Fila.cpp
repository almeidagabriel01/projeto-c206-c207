#include <iostream>
#include <list>
using namespace std;

int main()
{
	list<int> fila; // ponteiro
	int num; // numero a ser inserido na fila
	int i; // contador
	
	// lendo e inserindo os elementos na fila
	for(i = 0; i < 4; i++)
	{
		cin >> num;
		fila.push_back(num);
	}
	
	// mostrando e removendo os elementos inserido na fila
	while(!fila.empty())
	{
		cout << *fila.begin() << " "; // mostra o elemento da lista antes de remover 
		fila.pop_front(); // remove o nó da lista
	}
	
	return 0;
}