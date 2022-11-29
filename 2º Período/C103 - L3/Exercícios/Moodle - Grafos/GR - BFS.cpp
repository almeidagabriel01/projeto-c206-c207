#include <iostream>
#include <list>
using namespace std;

struct no
{
	int v; // vertice de destino da aresta
	int peso; // peso da aresta
};

void cria_aresta(list<no>adj[], int u, int v, int p)
{
	no aux; // var aux para inserir as arestas em adj

	aux.v = v;
	aux.peso = p;
	adj[u].push_back(aux);
	
	// grafo não orientado
	aux.v = u;
	adj[v].push_back(aux);
}

void bfs(list<no>adj[], int nVertices, int s)
{
	list<no>::iterator it;
	int u, v;
	list<int> Q;
	int state[100];
	int p[100];

	for(u = 0; u < nVertices; u++)
		if(u != s)
		{
			state[u] = -1; // undiscovered
			p[u] = -1;
		}

	state[s] = 0; // discovered
	p[s] = -1;
	Q.push_back(s);

	while(!Q.empty())
	{
		u = Q.front();
		Q.pop_front();
		cout << u << endl;
		for(it = adj[u].begin(); it != adj[u].end() ; it++)
		{
			v = it -> v;
			cout << u << " " << v << endl;
			if(state[v] == -1)
			{
				state[v] = 0; // discovered
				p[v] = u;
				Q.push_back(v);
			}
		}
		state[u] = 1; // processed
	}
}

int main()
{
	list<no> adj[100]; // lista de adjacencia
	int u, v; // vertices de origem e destino de cada aresta
	int peso; // peso da aresta
	int nVertices; // numero de vertices do grafo
	list<no>::iterator p; // iterator para varrer a lista de adjacência
	int s; // vértice inicial

	// entrando com o numero de vertices do grafo e o vértice inicial
	cin >> nVertices >> s;

	// inserindo arestas e verificando os vértices e arestas visitados
	cin >> u >> v >> peso;
	while(u != -1 && v != -1 && peso != -1)
	{
		cria_aresta(adj, u, v, peso);
		cin >> u >> v >> peso;
	}

	// mostrando os vértices e arestas visitados
	bfs(adj, nVertices, s);

	return 0;
}
