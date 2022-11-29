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

void ContaPreOrdem(treenodeptr arvore, int &n)
{
  if (arvore != NULL)
  {
    n++;
    ContaPreOrdem(arvore->esq, n);
    ContaPreOrdem(arvore->dir, n);
  }
}

int contaNos(treenodeptr arvore)
{
  int n = 0; // conta os nos

  ContaPreOrdem(arvore, n);
  return n;
}

int main()
{
  treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
  int n;                     // numero de elementos inseridos

  tInsere(arvore, 12); // colocando o valor na árvore
  tInsere(arvore, 9);  // colocando o valor na árvore
  tInsere(arvore, 20); // colocando o valor na árvore
  tInsere(arvore, 7);  // colocando o valor na árvore
  tInsere(arvore, 10); // colocando o valor na árvore

  n = contaNos(arvore);
  cout << n << " elementos inseridos" << endl;

  return 0;
}