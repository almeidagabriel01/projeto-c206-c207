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
  int x; // variavel para armazenar o valor do novo nó

	x = 14; 
  tInsere(arvore, x); // colocando o valor na árvore

	x = 15;
  tInsere(arvore, x); // colocando o valor na árvore

	x = 4;
  tInsere(arvore, x); // colocando o valor na árvore

  p = tPesq(arvore, 4); // buscando o elemento na árvore

  if (p == NULL) // elemento encontrado
    cout << "Elemento nao encontrado" << endl;

  else // elemento nao encontrado 
    cout << p->info << endl; 
	return 0;
}
