#include <iostream>
#include <list>
using namespace std;
int main()
{
	list<int> lista;
	list<int>::iterator p;
	int aux;
	
	cin >> aux;
	while(aux != 0)
	{
		lista.push_front(aux);
		cin >> aux;
	}
	
	for(p = lista.begin(); p != lista.end(); p++)
		cout << *p << " ";
	
}
