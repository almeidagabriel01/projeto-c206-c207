#include <iostream>
#include <list>
using namespace std;

int main()
{
	list<int> pilha; // ponteiro
	int num; // numero a ser inserido na pilha
	int i; // contador
	
	// lendo e inserindo os elementos na pilha
	for(i = 0; i < 4; i++)
	{
		cin >> num;
		pilha.push_front(num);
	}
	
	// mostrando e removendo os elementos inserido na pilha
	while(!pilha.empty())
	{
		cout << *pilha.begin() << " "; // mostra o elemento da lista antes de remover 
		pilha.pop_front(); // remove o nó da lista
	}
	
	return 0;
}