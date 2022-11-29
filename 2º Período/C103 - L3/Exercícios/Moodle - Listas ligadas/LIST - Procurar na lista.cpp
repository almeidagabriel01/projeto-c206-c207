#include <iostream>
#include <list>
using namespace std;

// função para encontrar o número procurado
bool encontrar(list<float> lista, float x)
{
	list<float>::iterator p; // iterador para varrer a lista
	bool res = false; // var aux para ver se achou
	
	for(p = lista.begin(); p != lista.end() ; p++)
	{
		if(*p == x)
			res = true;
	}
	return res;
}

int main()
{
	list<float>lista; // ponteiro para a lista
	int x; // var aux para leitura de dados
	float N; // numero a ser pesquisado na lista
	bool pesq; // var para armazenar o valor da função encontrar
	
	// inserindo os elementos na lista
	cin >> x;
	
	while(x != 0)
	{
		lista.push_front(x);
		cin >> x;
	}
	
	// entrando com o numero a ser pesquisado na lista
	cin >> N;
	
	// processamento de dados
	pesq = encontrar(lista, N);
	
	// saída de dados
	if(pesq == true)
		cout << "Encontrado" << endl;
	else
		cout << "Nao encontrado" << endl;
	
	return 0;
}
