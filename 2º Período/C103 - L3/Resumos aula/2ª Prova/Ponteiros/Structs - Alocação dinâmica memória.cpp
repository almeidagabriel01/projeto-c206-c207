#include <iostream>
using namespace std;

struct info
{
	int codigo; // código do produto
	float preco; // preço unitário
};

int main()
{
	info *produto; // ponteiro para a informação do produto
	
	// Alocando memória para a struct
	produto = new info;
	
	// Armazenando os dados
	produto->codigo = 2;
	produto->preco = 1.50;
	
	/* 
	Usa-se a flecha pois a struct está declarada como ponteiro.
	*/
	
	// Mostrando os dados
	cout << "Codigo: " << produto -> codigo << endl;
	cout << "Preco: " << produto -> preco << endl;
	
	// Liberando a memória usada pela struct
	delete produto;
	
	/*
	não coloca o [] depois do delete e antes da variável pois é uma posição apenas
	*/
	
	return 0;
}

/*
    1. Não coloca o [] depois de info pois nesse caso não é um vetor de struct
    
	2. Usa-se a flecha ao invés de ponto, pois para mostrar a struct é necessário o ponteiro produto que tem apenas 1 posição, (não é um vetor do ponteiro), e para mostrar com uma posição do ponteiro utiliza-se a flecha.

    3. não coloca o [] depois do delete e antes da variável pois não é um vetor

*/