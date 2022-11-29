#include <iostream>
#include <list>
using namespace std;

struct no
{
	int v; // vertice de destino da aresta
	int peso; // peso da aresta
};

int main()
{
	list<no> adj[10]; // lista de adjacencia
	no aux; // var aux para inserir as arestas em adj
	int u,v; // vertices de origem e destino de cada aresta
	int peso; // peso da aresta
	int nVertices = 4; // numero de vertices do grafo
	int i; // contador
	list<no>::iterator p; // iterator para varrer a lista de adjacência
	int orientado = 0; // 1:orientado, 0:não orientado
	
	// inserindo arestas
	
	// 0 1 2
	// 0 2 6
	// 1 2 5
	// 2 3 7
	for(i = 0; i < 4; i++)
	{
		cin >> u >> v >> peso;
		aux.v = v;
		aux.peso = peso;
		adj[u].push_back(aux);
		if(orientado == 0)
		{
			aux.v = u;
			adj[v].push_back(aux);
		}
	}
	
	// mostrando o grafo
	cout << "Lista de adjacencia" << endl;
	for(i = 0; i < nVertices; i++)
		for(p = adj[i].begin(); p != adj[i].end(); p++)
			cout << i << " " << p->v << " " << p->peso << endl;
	
	return 0;
}