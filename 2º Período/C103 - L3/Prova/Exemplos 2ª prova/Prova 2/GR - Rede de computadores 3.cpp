#include <iostream>
#include <list>
#include <climits>
#include <iomanip>
using namespace std;

// struct para montar o grafo
struct no
{
	int v; // vertice de destino da aresta
	double tempo; // tempo gasto pela mensagem no percurso
};

// função que cria a aresta do grafo
void cria_aresta(list<no>adj[], int u, int v, double p)
{
	no aux; // var aux para inserir as arestas em adj

	aux.v = v;
	aux.tempo = p;
	adj[u].push_back(aux);
}

// função que calcula o menor custo dos caminhos do grafo
void dijkstra(list<no>adj[], int nVertices, int start, int end)
{
	bool intree[10];
	double distance[10];
	int parent[10];
	list<int> caminho; // lista para armazenar o caminho feito com menor custo
	int u, v;
	int destino;
	double weight;
	int dist;
	list<no>::iterator p; // iterator para varrer a lista adj
	double tempo = 0; // var aux para armazenar o custo do caminho
	list<int>::iterator c;

	for(u = 0; u < nVertices; u++)
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
			weight = p->tempo;
			if(distance[destino] > distance[v] + weight)
			{
				distance[destino] = distance[v] + weight;
				parent[destino] = v;
			}
		}
		v = 0;
		dist = INT_MAX;
		for(u = 0; u < nVertices; u++)
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
	// salvando o tempo gasto
	tempo = distance[end]; // o custo, por ser acumulativo, é igual a distancia do último vértice

	// mostrando o vetor na ordem certa e o tempo do percurso total
	cout << "Caminho: ";
	for(c = caminho.begin(); c != caminho.end(); c++)
	{
		cout << *c << " ";
	}

	cout << fixed << setprecision(1) << endl << "Tempo total: " << tempo << "ms" << endl;
}

int main()
{
	list<no> adj[100]; // lista de adjacencia
	int u, v; // vertices de origem e destino de cada aresta
	double tempo; // peso da aresta
	int nVertices; // numero de vertices do grafo
	list<no>::iterator p; // iterator para varrer a lista de adjacência
	int start; // vértice inicial da árvore
	int end; // vértice final da árvore

	// entrando com o numero de vertices do grafo e se é orientado ou não
	cin >> nVertices >> start >> end;

	// inserindo arestas
	cin >> u >> v >> tempo;
	while(u != -1 && v != -1 && tempo != -1)
	{
		cria_aresta(adj, u, v, tempo);
		cin >> u >> v >> tempo;
	}

	// mostrando o grafo
	dijkstra(adj, nVertices, start, end);

	return 0;
}