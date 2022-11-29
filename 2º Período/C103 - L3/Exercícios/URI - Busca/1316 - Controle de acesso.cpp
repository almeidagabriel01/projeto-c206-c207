#include <iostream>
using namespace std;

int binaria(int vetor[],int tamanho, int x)
{
	bool achou; // aux para saber se achou ou não
	int baixo, meio, alto; // aux para achar dentro do vetor
	baixo = 0; // definindo o baixo como o início do vetor
	alto = tamanho - 1; // definindo o alto como a última posição do vetor
	achou = false; // inicializando o "achou" como falso
	
	// fazendo a busca
	while ((baixo <= alto) && (achou == false))
	{
		meio = (baixo + alto) / 2;
		
		if(x < vetor[meio])
			alto = meio - 1;
		
		else if(x > vetor[meio])
			baixo = meio + 1;
		
		else
			achou = true;
	}
	
	// retornando os valores se achar ou não achar o valor no vetor
	if(achou)
		return meio;
	else
		return -1;
}

int main()
{
	int vetor[20]; // vetor a ser colocado os valores de entrada
	int aux; // var aux para ler o vetor
	int x; // número a ser buscado no vetor
	int i = 0; // contador
	int res = 0; // resolução da busca
	
	// lendo os valores a serem inseridos no vetor
	cin >> aux;
	
	while(aux != -1)
	{
		vetor[i] = aux;
		i++;
		cin >> aux;
	}
	
	// lendo o número a ser buscado no vetor
	cin >> x;
	
	// chamando a função para fazer a busca
	res = binaria(vetor, i, x);
	
	// apresentando a solução
	if(res != -1)
		cout << "Possui acesso" << endl;
	else
		cout << "Nao possui acesso" << endl;
	
	return 0;
}