#include <iostream>
#include <list>
using namespace std;

struct no
{
	int v; // vertice de destino da aresta
	int peso; // peso da aresta
};

void cria_aresta(list<no>adj[], int u, int v, int p, int orientado)
{
	no aux; // var aux para inserir as arestas em adj

	aux.v = v;
	aux.peso = p;
	adj[u].push_back(aux);
	if(orientado == 0)
	{
		aux.v = u;
		adj[v].push_back(aux);
	}
}

void ordenacao_topologica(int f[], int nVertices)
{
	int i, j;
	int trab;
	bool troca;
	int limite;
	int temp2[10];

	troca = true;
	limite = nVertices - 1;

	for(i = 0; i < nVertices; i++)
	{
		temp2[i] = f[i];
	}

	while (troca)
	{
		troca = false;
		for (i = 0; i < limite; i++)
			if (temp2[i] < temp2[i + 1])
			{
				trab = temp2[i];
				temp2[i] = temp2[i + 1];
				temp2[i + 1] = trab;
				j = i;
				troca = true;
			}
		limite = j;
	}
	for(i = 0; i < nVertices; i++)
	{
		for(j = 0; j < nVertices; j++)
		{
			if(temp2[i] == f[j])
				cout << j << " ";
		}
	}
}

void dfs_visit(int color[], int pi[], int &time, int u, int nVertices, list<no>adj[], int f[])
{
	int d[10];
	list<no>::iterator p;

	color[u] = 1; // vértice u descoberto
	time = time + 1;
	d[u] = time;

	for(p = adj[u].begin(); p != adj[u].end(); p++)
	{
		if(color[p->v] == 0)
		{
			pi[p->v] = u;
			dfs_visit(color, pi, time, p->v, nVertices, adj, f);
		}
	}
	color[u] = 2; // Blacken u; it is finished
	time = time +1;
	f[u] = time;
}

void dfs(list<no>adj[], int nVertices)
{
	int u;
	int color[10];
	int pi[10];
	int f[10];
	int time;

	for(u = 0; u < nVertices; u++)
	{
		color[u] = 0; // white
		pi[u] = -1; // nil
	}
	time = 0;

	for(u = 0; u < nVertices; u++)
		if(color[u] == 0)
			dfs_visit(color, pi, time, u, nVertices, adj, f);

	ordenacao_topologica(f, nVertices);
}

int main()
{
	list<no> adj[100]; // lista de adjacencia
	int u, v; // vertices de origem e destino de cada aresta
	int peso = 1; // peso da aresta
	int nVertices; // numero de vertices do grafo
	list<no>::iterator p; // iterator para varrer a lista de adjacência
	int orientado; // 1:orientado, 0:não orientado

	// entrando com o numero de vertices do grafo e se é orientado ou não
	cin >> nVertices >> orientado;

	// inserindo arestas
	cin >> u >> v;
	while(u != -1 && v != -1)
	{
		cria_aresta(adj, u, v, peso, orientado);
		cin >> u >> v;
	}

	// mostrando o grafo
	dfs(adj, nVertices);

	return 0;
}
