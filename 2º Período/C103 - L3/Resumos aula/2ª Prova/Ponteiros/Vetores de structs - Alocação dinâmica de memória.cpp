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
	int tam; // tamanho desejado para o vetor
	int i;

	// Ler o tamanho do vetor
	cin >> tam;

	// Alocando memória para a struct
	produto = new info[tam];

	// Armazenando os dados
	for(i = 0; i < tam; i++)
	{
		cin >> produto[i].codigo;
		cin >> produto[i].preco;
	}

	// Mostrando os dados
	for(i = 0; i < tam; i++)
		cout << produto[i].codigo << " " << produto[i].preco << endl;

	// Liberando a memória usada pela struct
	delete [] produto;

	return 0;
}

/*
    1. Usa-se o [tam] pois quer uma struct com tamanho tam
    
	2. Usa-se o ponto ao invés da flecha, pois nesse caso, o ponteiro (produto) tem mais de uma posição da struct

    3. Usa-se o [] depois de delete e antes de produto pois é um vetor de struct

*/
