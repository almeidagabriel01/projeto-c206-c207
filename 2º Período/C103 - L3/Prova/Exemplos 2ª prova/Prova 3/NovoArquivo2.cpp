#include <iostream>
#include <list>
using namespace std;

struct no
{
	int v; // vertice de destino da aresta
	int peso; // peso da aresta
};

void criaAresta(list<no>adj[], int u, int v, int p)
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
	int state[10];
	int p[10];
	int res = 0;

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
		for(it = adj[u].begin(); it != adj[u].end() ; it++)
		{
			v = it -> v;
			if(state[v] == -1)
			{
				state[v] = 0; // discovered
				p[v] = u;
				Q.push_back(v);
			}
		}
		state[u] = 1; // processed
	}

	for(u = 0; u < nVertices; u++)
		if(state[u] == 1)
			res ++;

	if(res == nVertices)
		cout << "Conexo" << endl;
	else
		cout << "Nao conexo" << endl;
}

int main()
{
	list<no> adj[10]; // lista de vértices
	int u, v; // vertices de origem e destino de cada aresta
	int peso = 1; // peso 1 das arestas
	int nVertices; // vertices do grafo
	int start; // vértice inicial

	// entrando com o numero de vertices do grafo e o vértice inicial
	cin >> nVertices >> start;

	// inserindo arestas e verificando os vértices e arestas visitados
	cin >> u >> v;
	while(u != -1 && v != -1)
	{
		criaAresta(adj, u, v, peso);
		cin >> u >> v;
	}

	// mostrando os vértices e arestas visitados
	bfs(adj, nVertices, start);

	return 0;
}
