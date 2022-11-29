#include <iostream>
#include <list>
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

void emNivel(treenodeptr t)
{
  treenodeptr n;
  list<treenodeptr> q;
  int cont = 0;

  if (t != NULL)
  {
    q.push_back(t);
    while (!q.empty())
    {
      n = *q.begin();
      q.pop_front();
      if (n->esq != NULL)
        q.push_back(n->esq);
      if (n->dir != NULL)
        q.push_back(n->dir);
      cont += n->info;
    }
    cout << cont << endl;
  }
}

void tDestruir(treenodeptr &arvore)
{
  if (arvore != NULL)
  {
    tDestruir(arvore->esq);
    tDestruir(arvore->dir);
    delete arvore;
  }
  arvore = NULL;
}

int main()
{
  treenodeptr arvore = NULL; // ponteiro para a raiz
  int aux; // variavel auxiliar para entrada de dados

  // entrando com o aux para inserir na arvore
  cin >> aux;

  // inserindo na arvore
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
  }

  // imprimindo o somatorio dos valores da arvore
  emNivel(arvore);

  // liberando a memoria alocada para a arvore
  tDestruir(arvore);
  return 0;
}