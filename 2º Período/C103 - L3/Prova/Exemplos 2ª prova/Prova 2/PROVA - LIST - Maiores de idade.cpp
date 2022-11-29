#include <iostream>
#include <list>
using namespace std;

int nMaiores(list<int> lista)
{
	list<int>::iterator p;
	int res = 0;

	for(p = lista.begin(); p != lista.end(); p++)
		if(*p >= 18)
			res++;

	return res;
}

int main()
{
	list<int> lista; // lista de todas as idades
	int aux; // var aux para entrada de dados
	int maiores; // maiores de idade

	// entrando com as idades
	cin >> aux;
	
	while(aux != 0)
	{
		lista.push_back(aux);
		cin >> aux;
	}

	// verificando os maiores de idade
	maiores = nMaiores(lista);
	
	// mostrando o resultado
	cout << maiores << " pessoas com 18 anos ou mais" << endl;

	return 0;
}
