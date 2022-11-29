#include <iostream>
using namespace std;

struct dado
{
	int qtd;
	float preco;
};

int main()
{
	dado v[3]; // vetor de dados
	dado *p; // ponteiro para varrer o vetor
	
	// Atribuindo valores para v
	v[0].qtd = 2;
	v[0].preco = 2.00;
	
	v[1].qtd = 3;
	v[1].preco = 1.00;
	
	v[2].qtd = 20;
	v[2].preco = 0.50;
	
	// Mostrando a terceira posição do vetor direto
	p = v+2;
	cout << "preco = " << p->preco << endl;
	cout << "quantidade = " << p->qtd << endl;
	
	return 0;
}