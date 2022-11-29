#include <iostream>
#include <iomanip>
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
    ContaPreOrdem(arvore->esq, n);
    ContaPreOrdem(arvore->dir, n);
    if (arvore->esq == NULL && arvore->dir == NULL)
        n++;
  }
}

int ContaFolhas(treenodeptr arvore)
{
  int n = 0; // conta os nos

  ContaPreOrdem(arvore, n);
  return n;
}

int main()
{
  treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
  int aux;                   // auxiliar para inserir os elementos
  int n = 0;                 // numero de folhas

  cin >> aux;
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
  }

  n = ContaFolhas(arvore);
  cout << "Numero de folhas: " << n << endl;

  return 0;
}