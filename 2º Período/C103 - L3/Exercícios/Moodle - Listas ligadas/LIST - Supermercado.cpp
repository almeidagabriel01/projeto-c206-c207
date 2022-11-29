#include <iostream>
#include <list>
using namespace std;

int main()
{
	int N; // número de operações
	int i; // contador
	list<int>estoque; // ponteiro para a lista estoque
	int est; // var aux para leitura de dados do estoque
	list<int>::iterator p; // iterador para varrer as listas
	list<int>venda; // vetor que armazena o código do produto para venda
	int num; // var para ver se é de estoque ou de venda

	// lendo o número de operações
	cin >> N;

	// processamento de dados
	for(i = 0; i < N; i++)
	{
		cin >> num;
		if(num == 1)
		{
			cin >> est;
			estoque.push_back(est);
		}
		else if(num == 2)
		{
			venda.push_front(*estoque.begin());
			estoque.pop_front();
		}
	}

	// saída de dados
	cout << "Estoque: ";
	for(p = estoque.begin(); p != estoque.end() ; p++)
			cout << *p << " ";
			

	cout << "Venda: ";
	for(p = venda.begin(); p != venda.end(); p++)
			cout << *p << " ";

	return 0;
}
