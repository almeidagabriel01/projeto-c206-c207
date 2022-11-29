#include <iostream>
using namespace std;

int main()
{
	int v[3]; // vetor de dados
	int *p; // ponteiro para varrer o vetor
	
	// Atribuindo valores para v
	v[0] = 2;
	v[1] = 7;
	v[2] = -5;
	
	p = v; // p aponta para o início do vetor, que também é um ponteiro
	cout << "*p = " << *p << endl;
	
	p++; // p vai apontar para a segunda posição do vetor
	cout << "*p = " << *p << endl;
	
	p++; // p vai apontar para a terceira posição do vetor
	cout << "*p = " << *p << endl;
	
	// Mostrando a terceira posição do vetor direto
	p = v;
	
	p += 2;
	cout << "v[2] = " << *p << endl;
	
	return 0;
}