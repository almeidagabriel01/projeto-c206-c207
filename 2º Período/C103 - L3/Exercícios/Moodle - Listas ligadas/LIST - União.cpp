#include <iostream>
#include <list>
using namespace std;

void juntar(list<int> lista1, list<int> lista2, list<int> &lista3)
{
	list<int>::iterator p1;
	list<int>::iterator p2;

	p1 = lista1.begin();
	p2 = lista2.begin();

	while(p1 != lista1.end() && p2 != lista2.end())
	{
		if(*p1 < *p2)
		{
			lista3.push_back(*p1);
			p1++;
		}
		else if (*p2 < *p1)
		{
			lista3.push_back(*p2);
			p2++;
		}
		else if(*p1 == *p2)
		{
			lista3.push_back(*p1);
			p1++;
			p2++;
		}
	}
	if(p1 == lista1.end())
    {
        while(p2 != lista2.end())
        {
            lista3.push_back(*p2);
            p2++;
        }
    }
    else if(p2 == lista2.end())
    {
        while(p1 != lista1.end())
        {
            lista3.push_back(*p1);
            p1++;
        }
    }
}

int main()
{
	list<int>lista1; // lista 1
	int x1; // var aux para leitura de dados da lista 1
	list<int>lista2; // lista 2
	int x2; // var aux para leitura de dados da lista 2
	list<int>lista3; // lista 3
	list<int>::iterator p; // iterador para varrer a lista 3

	// lendo a lista 1 e a lista 2
	cin >> x1;
	while(x1 != 0)
	{
		lista1.push_back(x1);
		cin >> x1;
	}

	cin >> x2;
	while(x2 != 0)
	{
		lista2.push_back(x2);
		cin >> x2;
	}

	// juntando as duas listas
	juntar(lista1, lista2, lista3);

	// mostrando a solução
	for(p = lista3.begin(); p != lista3.end() ; p++)
	{
		cout << *p << " ";
	}

	return 0;
}
