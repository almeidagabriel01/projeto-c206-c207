#include <iostream>
#include <list>
#include <iomanip>
using namespace std;

float calcSoma(list<float> lista)
{
	list<float>::iterator p; // iterator para varrer a lista ligada
	float soma = 0; // var para armazenar a soma dos elementos
	
	for(p = lista.begin(); p != lista.end(); p++)
		soma += *p;
	
	return soma;
}

int main()
{
	list<float> lista; // lista que contem os elementos
	float aux; // var aux para entrada de dados
	float res;
	
	// entrando com os dados
	cin >> aux;
	
	while(aux != 0)
	{
		lista.push_back(aux);
		cin >> aux;
	}
	
	// calculando a soma dos elementos
	res = calcSoma(lista);
	
	// mostrando a resposta
	cout << fixed << setprecision(2) << "soma = " << res << endl;
	
	return 0;
}