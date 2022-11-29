#include <iostream>
#include <list>
#include <climits>
#include <cmath>
using namespace std;

// struct para os motoqueiros
struct dado
{
	int tempo; //tempo do motoboy ate o supermercado
	int motoqueiro; // identificação do motoqueiro
	int itens[100]; // itens que foram pegos
};

// struct para montar o grafo
struct no
{
	int v; // vertice de destino da aresta
	int peso; // peso da aresta
};

// função que cria a aresta do grafo
void cria_aresta(list<no>adj[], int u, int v, int p)
{
	no aux; // var aux para inserir as arestas em adj

	aux.v = v;
	aux.peso = p;
	adj[u].push_back(aux);
	aux.v = u;
	adj[v].push_back(aux);
}

// função que calcula o menor custo dos caminhos do grafo
void dijkstra(list<no>adj[], int nVertices, int start, int end, dado motoboy[], int &custo_total)
{
	bool intree[10];
	int distance[10];
	int parent[10];
	list<int> caminho; // lista para armazenar o caminho feito com menor custo
	int u, v;
	int destino;
	int weight;
	int dist;
	list<no>::iterator p; // iterator para varrer a lista adj
	int custo = 0; // var aux para armazenar o custo do caminho
	list<int>::iterator c;

	for(u = 1; u <= nVertices; u++)
	{
		intree[u] = false;
		distance[u] = INT_MAX;
		parent[u] = -1;
	}
	distance[start] = 0;
	v = start;
	while(intree[v] == false)
	{
		intree[v] = true;
		for(p = adj[v].begin(); p != adj[v].end(); p++)
		{
			destino = p->v;
			weight = p->peso;
			if(distance[destino] > distance[v] + weight)
			{
				distance[destino] = distance[v] + weight;
				parent[destino] = v;
			}
		}
		v = 0;
		dist = INT_MAX;
		for(u = 1; u <= nVertices; u++)
		{
			if(intree[u] == false && dist > distance[u])
			{
				dist = distance[u];
				v = u;
			}
		}
	}

	// salvando o end na var u para poder fazer o controle de parents
	u = end;
	// colocando o elemento final no primeiro lugar da fila
	caminho.push_front(end);
	// salvando o caminho na fila
	while(parent[u] != -1) // se parents for -1, quer dizer que não tem mais caminhos
	{
		caminho.push_front(parent[u]);
		u = parent[u];
	}
	// salvando o custo
	custo = distance[end]; // o custo, por ser acumulativo, é igual a distancia do último vértice

	// mostrando o vetor na ordem certa e o custo do caminho total
	cout << "Menor caminho: ";
	for(c = caminho.begin(); c != caminho.end(); c++) // foram salvos 4 caminhos, mas no vetor as posições vão de 0 - 3
	{
		cout << *c << " ";
	}

	// fazendo a somatória do custo do caminho percorrido por cada motoboy
	cout << endl;
	custo_total += custo;
}

//funcao de quick sort
void quickSort(dado motoboy[], int nmotoboys, int i, int j)
{
	//variaveis
	int esq = i, dir = j, pivo;
	dado trab;

	pivo = motoboy[(int)round((esq + dir) / 2.0)].tempo;

	//estrutura para reorganizar
	do
	{

		while(motoboy[esq].tempo < pivo)
			esq++;

		while(motoboy[dir].tempo > pivo)
			dir--;

		if(esq <= dir)
		{

			trab.tempo = motoboy[esq].tempo;
			motoboy[esq].tempo = motoboy[dir].tempo;
			motoboy[dir].tempo = trab.tempo;

			trab.motoqueiro = motoboy[esq].motoqueiro;
			motoboy[esq].motoqueiro = motoboy[dir].motoqueiro;
			motoboy[dir].motoqueiro = trab.motoqueiro;

			esq++;
			dir--;

		}

	}
	while(esq <= dir);

	if(dir - i >= 0)
		quickSort(motoboy, nmotoboys, i, dir);

	if(j - esq >= 0)
		quickSort(motoboy, nmotoboys, esq, j);

}

// mochila e distribuição dos motoboys para as entregas
void mochila(int nitens, int capacidadet, int nCasas, int cidade_inicial, int peso[], dado motoboy[], int nmotoboys, list<no>adj[])
{
	int capacidader; // capacidade restante da mochila para cada motoboy
	int j, i; // contadores
	capacidader = capacidadet; // setando a capacidade restante sendo igual a capacidade total da mochila
	bool pega[100]; // var aux para ver se o item ja foi pego ou não
	bool aux = false; // caso ele parta do supermercado ou não
	int k = 0; // contador de itens pegos
	int custo_total = 0; // custo total percorrido pelo caminho de cada motoboy

	//inicializando os itens pegos pelos motoboys como -1
	for(j = 1; j <= nmotoboys; j++)
		for(i = 1; i <= nitens + 1; i++)
			motoboy[j].itens[i] = -1;

	//setando que nenhum item foi pego
	for(i = 0; i <= nitens; i++)
		pega[i] = false;

	//analizando quais itens serao pegos pelos motoboys
	for(j = 1; j <= nmotoboys; j++)
	{
		custo_total = motoboy[j].tempo; // custo total inicial é até o supermercado
		for(i = 1; i <= nitens + 1; i++)
		{
			if(capacidader >= peso[i] && i != cidade_inicial && pega[i] == false) // verificando os itens a serem pegos
			{
				k++;
				motoboy[j].itens[k] = i;
				capacidader -= peso[i];
				pega[i] = true;
			}
		}

		// mostrando as compras pegas pelos motoboys
		if(k == 0) // não pegou nenhum item
		{
			cout << "Motoboy " << motoboy[j].motoqueiro << " nao pegou nenhum item" << endl;
			cout << "Nao realizou entregas" << endl;
			cout << "Nao teve tempo de entrega" << endl;
		}

		else if(k != 0) // caso pegou alguma coisa
		{
			cout << "Motoboy " << motoboy[j].motoqueiro << " pegou o(s) item(ns): ";
			for(i = 1; i <= k; i++)
				if(motoboy[j].itens[i] != -1)
					cout << motoboy[j].itens[i] << " ";

			cout << endl;

			// criando a rota e mostrando o caminho feito por cada entregador
			for(i = 1; i <= k; i++)
			{
				if(aux == false) // caso base, em que ele sai do supermercado
				{
					dijkstra(adj, nCasas, cidade_inicial, motoboy[j].itens[i], motoboy, custo_total);
					aux = true;
				}
				else // caso geral, caso ele não parta do supermercado
					dijkstra(adj, nCasas, motoboy[j].itens[i - 1], motoboy[j].itens[i], motoboy, custo_total); // sai da casa anterior e vai até a casa atual

			}
		}
		if (k != 0) // mostrando o tempo total gasto por cada motoboy
			cout << "Ele gastou " << custo_total << " min" << endl;

		custo_total = 0; // resetando o tempo total para o próximo motoboy
		aux = false; // resetando o caso base para o próximo motoboy
		capacidader = capacidadet; // resetando a capacidade restante para o próximo motoboy
		k = 0; // resetando a posição do item que foi pego pelo motoboy
		cout << endl;
	}
}

int main()
{
	list<no> adj[100]; // lista de adjacencia
	int casa1, casa2; // casa de origem e casa de destino
	int tempo_entre_casas; // tempo entre as casas a serem preenchidas
	int nCasas; // numero de casas
	list<no>::iterator p; // iterator para varrer a lista de adjacência
	int supermercado; // local do supermercado
	int i, j; // contadores
	int nmotoboys; // numero de motoboys
	dado motoboy[100]; // struct para cada motoboy
	int capacidadet; //capacidade total da mochila
	int nitens; // quantidade de compras
	int peso[100]; // peso de cada item

	// entrando com o numero de casas
	cout << "Entre com o numero de casas" << endl;
	cin >> nCasas;

	// entrando com o número do supermercado
	cout << "Entre com o número que pertence ao supermercado" << endl;
	cin >> supermercado;

	// entrando com a casa de origem, casa de destino e o tempo entre elas para criar o grafo
	cout << "Entre a casa de origem, a de destino e o tempo entre elas" << endl;
	cout << "OBS: Digite -1 -1 -1 quando preencher todas as casas e o tempo entre elas" << endl;
	cin >> casa1 >> casa2 >> tempo_entre_casas;
	while(casa1 != -1 && casa2 != -1 && tempo_entre_casas != -1)
	{
		cria_aresta(adj, casa1, casa2, tempo_entre_casas);
		cout << "Entre a casa de origem, a de destino e o tempo entre elas" << endl;
		cin >> casa1 >> casa2 >> tempo_entre_casas;
	}

	//entrando com o número de motoboys disponíveis
	cout << "Entre com o numero de motoboys " << endl;
	cin >> nmotoboys;

	//entrada do tempo de cada motoboy
	for(i = 1; i <= nmotoboys; i++)
	{
		cout << "Motoqueiro ";
		cin >> motoboy[i].motoqueiro;

		cout << "Tempo do motoboy " << motoboy[i].motoqueiro << endl;
		cin >> motoboy[i].tempo;
	}

	//ordenando os motoboys pelo menor tempo até o supermercado
	j = nmotoboys;
	quickSort(motoboy, nmotoboys, 1, j);


	// ENTRANDO COM AS VARIAVEIS PARA A MOCHILA
	cout << "Entre com a quantidade de itens" << endl;
	cin >> nitens;

	cout << "Entre com a capacidade da mochila" << endl;
	cin >> capacidadet;

	// ENTRANDO COM O PESO DE CADA ITEM
	for(i = 1; i <= nitens + 1; i++)
		if(i != supermercado)
		{
			cout << "Entre com o peso do item " << i << endl;
			cin >> peso[i];
		}
		
	cout << endl;

	// VENDO QUAIS ITENS VAO PARA A MOCHILA  E MOSTRANDO O MENOR CUSTO COM O MENOR CAMINHO
	mochila(nitens, capacidadet, nCasas, supermercado, peso, motoboy, nmotoboys, adj);

	cout << endl;
	
	return 0;
}