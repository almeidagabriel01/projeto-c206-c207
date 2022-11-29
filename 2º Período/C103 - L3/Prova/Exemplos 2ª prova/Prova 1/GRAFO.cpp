#include <iostream>
#include <list>
#include <climits>
using namespace std;

struct no
{
	int v; // vertice de destino da aresta
	double peso; // peso da aresta
};

void cria_aresta(list<no>adj[], int u, int v, double p)
{
	no aux; // var aux para inserir as arestas em adj

	aux.v = v;
	aux.peso = p;
	adj[u].push_back(aux);
}

void prim(list<no>adj[], int nVertices, int start)
{
	bool intree[10];
	double distance[10];
	int parent[10];
	int u, v;
	int destino;
	double weight;
	int dist;
	list<no>::iterator p;
	double custo = 0;

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
			weight = p->peso;
			if(distance[destino] > weight && intree[destino] == false)
			{
				distance[destino] = weight;
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
	cout << "Ligacoes:" << endl;

	for(u = 1; u < nVertices; u++)
	{
		cout << parent[u] << " " << u << endl;
		custo += distance[u];
	}

	cout << "Custo total: " << custo << " m" << endl;
}

int main()
{
	list<no> adj[100]; // lista de adjacencia
	int u, v; // vertices de origem e destino de cada aresta
	double peso; // peso da aresta
	int nVertices; // numero de vertices do grafo
	list<no>::iterator p; // iterator para varrer a lista de adjacência
	int start; // vértice inicial da árvore

	// entrando com o numero de vertices do grafo e se é orientado ou não
	cin >> nVertices >> start;

	// inserindo arestas
	cin >> u >> v >> peso;
	while(u != -1 && v != -1 && peso != -1)
	{
		cria_aresta(adj, u, v, peso);
		cin >> u >> v >> peso;
	}

	// mostrando o grafo
	prim(adj, nVertices, start);

	return 0;
}
