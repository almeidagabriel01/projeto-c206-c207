#include <iostream>
using namespace std;

struct treenode
{
	int info;
	treenode *esq;
	treenode *dir;
};
typedef treenode *treenodeptr;

void tInsere(treenodeptr &p, int x) // colocando os valores na árvore
{
	if (p == NULL) // insere na raiz
	{
		p = new treenode;
		p->info = x;
		p->esq = NULL;
		p->dir = NULL;
	}
	else if (x < p->info) // insere na subarvore esquerda
		tInsere(p->esq, x);
	else // insere na subarvore direita
		tInsere(p->dir, x);
}

treenodeptr tPesq(treenodeptr p, int x) // busca pelo elemento na árvore
{
	if (p == NULL) // elemento n~ao encontrado
		return NULL;
	else if (x == p->info) // elemento encontrado na raiz
		return p;
	else if (x < p->info) // procura na sub´arvore esquerda
		return tPesq(p->esq, x);
	else // procura na sub´arvore direita
		return tPesq(p->dir, x);
}

int main()
{
	treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
	treenodeptr p = NULL; // ponteiro para o elemento buscado  
  int N; // quantidade de números a serem inseridos na árvore
  int x[100]; // vetor para armazenar os números a serem inseridos na árvore
  int i; // contador
  int proc; // Elemento a ser buscado na árvore

  cin >> N;

  for(i = 0; i < N; i++)
    cin >> x[i];

  for(i = 0; i < N; i++)
    tInsere(arvore, x[i]);

  cin >> proc;
  p = tPesq(arvore, proc);

   if (p == NULL) // elemento nao encontrado
    cout << "Elemento nao encontrado" << endl;

  else // elemento encontrado 
    cout << "Elemento encontrado" << endl; 

	return 0;
}
