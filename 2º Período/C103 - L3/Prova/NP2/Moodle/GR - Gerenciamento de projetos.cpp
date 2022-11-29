#include <iostream>
#include <list>
using namespace std;

// no que contem as informações de cada aresta
struct no
{
	int v; // vertice de destino da aresta
	int peso; // peso da aresta
};

// função que cria a aresta do grado
void cria_aresta(list<no>adj[], int u, int v, int p)
{
	no aux; // var aux para inserir as arestas em adj

	aux.v = v;
	aux.peso = p;
	adj[u].push_back(aux);
}

// função para ordenação topológia
void ordenacao_topologica(int f[], int nVertices)
{
	int i, j; // contadores
	int trab;
	bool troca;
	int limite;
	int temp2[100]; // vetor aux para a ordenação

	troca = true;
	limite = nVertices - 1;

	// inicializando temp2 para ficar com os elementos do vetor f e poder fazer a comparação depois
	for(i = 0; i < nVertices; i++)
	{
		temp2[i] = f[i];
	}

	// fazendo a oredenação do vetor temp2
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
	
	// mostrando a ordem que as tarefas devem ser executadas
	for(i = 0; i < nVertices; i++)
	{
		for(j = 0; j < nVertices; j++)
		{
			if(temp2[i] == f[j])
				cout << j << " ";
		}
	}
}

// função auxiliar para o dfs
void dfs_visit(int color[], int pi[], int &time, int u, int nVertices, list<no>adj[], int f[])
{
	int d[100];
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
	time = time + 1;
	f[u] = time;
}

// função dfs
void dfs(list<no>adj[], int nVertices)
{
	int u;
	int color[100];
	int pi[100];
	int f[100];
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
	int u, v; // vertices de origem e destino
	int peso = 1; // peso da aresta (não tem peso, então é 1)
	int nTarefas; // numero de tarefas a serem executadas
	list<no>::iterator p; // iterator para varrer a lista de adjacência

	// entrando com o numero de vertices do grafo
	cin >> nTarefas;

	// inserindo as tarefas
	cin >> u >> v;
	while(u != -1 && v != -1)
	{
		cria_aresta(adj, u, v, peso);
		cin >> u >> v;
	}

	// verificando a ordem que as tarefas devem ser executadas e mostrando o resultado
	dfs(adj, nTarefas);

	return 0;
}
