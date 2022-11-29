#include <iostream>
using namespace std;

int main()
{
	int a; // variável "normal"
	int *b; // ponteirodo do tipo inteiro
	
	a=2;
	b = &a; // &: endereço de
	
	cout << "&a = " << &a << endl;
	cout << "b = " << b << endl;
	cout << "*b = " << *b << endl; // *: conteúdo apontado por, de referência
	
	*b = 3;
	cout << "a = " << a << endl;
	
	
	return 0;
}