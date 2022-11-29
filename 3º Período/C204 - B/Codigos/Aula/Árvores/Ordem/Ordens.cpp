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

void preOrdem(treenodeptr arvore)
{
	if (arvore != NULL)
	{
		cout << arvore->info << endl;
		preOrdem(arvore->esq);
		preOrdem(arvore->dir);
	}
}

void emOrdem(treenodeptr arvore)
{
	if (arvore != NULL)
	{
		emOrdem(arvore->esq);
		cout << arvore->info << endl;
		emOrdem(arvore->dir);
	}
}

void posOrdem(treenodeptr arvore)
{
	if (arvore != NULL)
	{
		posOrdem(arvore->esq);
		posOrdem(arvore->dir);
		cout << arvore->info << endl;
	}
}

int main()
{
	treenodeptr arvore = NULL; // ponteiro para a raiz da arvore

	tInsere(arvore, 12); // colocando o valor na árvore
	tInsere(arvore, 9);	 // colocando o valor na árvore
	tInsere(arvore, 20); // colocando o valor na árvore
	tInsere(arvore, 7);	 // colocando o valor na árvore
	tInsere(arvore, 10); // colocando o valor na árvore

	cout << "Pre-Ordem: " << endl; // imprimindo a árvore em pré-ordem
	preOrdem(arvore);

	cout << "Em-Ordem: " << endl; // imprimindo a árvore em em-ordem
	emOrdem(arvore);

	cout << "Pos-Ordem: " << endl; // imprimindo a árvore em pos-ordem
	posOrdem(arvore);

	return 0;
}