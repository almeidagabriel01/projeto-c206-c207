#include <iostream> 
#include <climits> 
#include <algorithm>

using namespace std;

int main()
{
	int custo[8][8]; //  numero maximo de casas que serão visitadas
	int n; // numero de focos de dengue
	int casa_inicial; //
	int i, j;
 
    	
	cin >> n;
	
	
	for(i = 0; i < n; i++)
		for(j = i + 1; j < n; j++)
		{
			cin >> custo[i][j];
			custo[j][i] = custo[i][j];
		}
		
	cin >> casa_inicial;


	int v[100]; // vetor com as casas a serem permutadas 
	int p; // var. auxiliar
	int menor_custo; // menor custo da viagem
	int custo_caminho; // custo do caminho

	
	// colocando as casa que serao permutadas no vetor (todas exceto a inicial)
	p = 0;
	for(i = 0; i < n; i++)
		if(i != casa_inicial)
		{
			v[p] = i;
			p++;
		}

	
	menor_custo = INT_MAX; // inicializo o custo com infinito
	do
	{
		for(i = 0; i < n - 1; i++)

		custo_caminho = custo[casa_inicial][v[0]]; // custo da cidade inicial -> v[0]

		for(i = 0; i < n - 2; i++) // somar custo de v[0]->v[1]->v[2]...v[n-3]->v[n-2]
			custo_caminho += custo[v[i]][v[i + 1]];

		custo_caminho += custo[v[n - 2]][casa_inicial]; // custo v[n-2] -> cidade inicial

		menor_custo = min(menor_custo, custo_caminho);
	}
	
	while(next_permutation(v, v + (n - 1))); // n-1 = numero de cidades a serem permutadas
	// obs.: para fazer todas as permutacoes, o vetor deve estar ordenado no comeco

	cout << "Menor custo = " << menor_custo << endl;

	return 0;
}