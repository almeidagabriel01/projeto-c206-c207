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

void preOrd(treenodeptr arvore, int x, int &pre, int &cont)
{
  if (arvore != NULL)
  {
    cont++;
    if (arvore->info == x)
      pre = cont;
    preOrd(arvore->esq, x, pre, cont);
    preOrd(arvore->dir, x, pre, cont);
  }
}

void emOrd(treenodeptr arvore, int x, int &em, int &cont)
{
  if (arvore != NULL)
  {
    emOrd(arvore->esq, x, em, cont);
    cont++;
    if (arvore->info == x)
      em = cont;
    emOrd(arvore->dir, x, em, cont);
  }
}

void posOrd(treenodeptr arvore, int x, int &pos, int &cont)
{
  if (arvore != NULL)
  {
    posOrd(arvore->esq, x, pos, cont);
    posOrd(arvore->dir, x, pos, cont);
    cont++;
    if (arvore->info == x)
      pos = cont;
  }
}

void menorcaminho(treenodeptr arvore, int x)
{
  int i = 0, j = 0, k = 0;
  int menor_pre = 0, menor_pos = 0, menor_em = 0; // menor elemento de cada caminho

  preOrd(arvore, x, menor_pre, i);
  posOrd(arvore, x, menor_pos, j);
  emOrd(arvore, x, menor_em, k);

  if (menor_pre < menor_pos && menor_pre < menor_em)
    cout << "Pre" << endl;
  else if (menor_pos < menor_pre && menor_pos < menor_em)
    cout << "Pos" << endl;
  else if (menor_em < menor_pre && menor_em < menor_pos)
    cout << "Em" << endl;
}

int main()
{
  treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
  int aux;                   // auxiliar para inserir os elementos
  int x;                     // elemento que representa a cidade que o chocolate está localizado

  cin >> aux;
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
  }
  cin >> x;

  menorcaminho(arvore, x);

  return 0;
}