#include <iostream>
#include <list>
using namespace std;

void maiorMenor(list<int> lista, int &menor, int &maior)
{
	list<int>::iterator p;
	
	for(p = lista.begin(); p != lista.end(); p++)
	{
		if(*p < menor)
			menor = *p;
		
		else if (*p > maior)
			maior = *p;
	}
}

int main()
{
	list<int> lista; // lista de todos os números inteiros
	int aux; // var aux para entrada de dados
	int menor; // menor elemento
	int maior; // maior elemento
	
	// entrando com os números
	cin >> aux;
	
	while(aux != 0)
	{
		lista.push_back(aux);
		cin >> aux;
	}
	
	// deixando as vars maior e menor com o primeiro elemento da lista para comparar com o resto dos elementos
	menor = lista.front();
	maior = lista.front();
	
	// verificando o maior e menor elemento da lista
	maiorMenor(lista, menor, maior);
	
	// mostrando o resultado
	cout << "menor: " << menor << endl;
	cout << "maior: " << maior << endl;
	
	return 0;
}