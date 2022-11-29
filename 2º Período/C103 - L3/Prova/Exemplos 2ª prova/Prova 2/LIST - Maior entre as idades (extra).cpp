#include <iostream>
#include <list>
using namespace std;

int Maior_idade(list<int> lista)
{
	list<int>::iterator p;
	int res = lista.front();

	for(p = lista.begin(); p != lista.end(); p++)
		if(*p > res)
			res = *p;

	return res;
}

int main()
{
	list<int> lista; // lista de todas as idades
	int aux; // var aux para entrada de dados
	int maior; // maior de idade
	
	// entrando com as idades
	cin >> aux;
	
	while(aux != 0)
	{
		lista.push_back(aux);
		cin >> aux;
	}

	// verificando o maior de idade
	maior = Maior_idade(lista);
	
	// mostrando o resultado
	cout << maior << endl;

	return 0;
}
