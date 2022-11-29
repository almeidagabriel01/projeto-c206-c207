#include <iostream>
using namespace std;

struct treenode
{
	int info;
	treenode *esq;
	treenode *dir;
};
typedef treenode *treenodeptr;

void tInsere(treenodeptr &p, int x)
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

void OrdemDec(treenodeptr arvore)
{
	if (arvore != NULL)
	{
		OrdemDec(arvore->dir);
		cout << arvore->info << " ";
		OrdemDec(arvore->esq);
	}
}

int main()
{
	treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
	int aux;                   // auxiliar para inserir os elementos

  cin >> aux;
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
  }

  OrdemDec(arvore);

	return 0;
}