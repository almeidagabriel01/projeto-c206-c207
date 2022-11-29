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

void Ordenando(treenodeptr arvore, int elementos[], int &i)
{
  if (arvore != NULL)
  {
    Ordenando(arvore->esq, elementos, i);
    elementos[i] = arvore->info;
    i++;
    Ordenando(arvore->dir, elementos, i);
  }
}

void MaiorMenor(treenodeptr arvore, int n, int &maior)
{
  int elementos[100]; // vetor de elementos da arvore
  int i = 1;          // indice do vetor
	
  Ordenando(arvore, elementos, i);

  for (i = 1; i < n; i++)
  {
    if (i == 1)
    {
      maior = elementos[i];
      
    }
    else
    {
      if (elementos[i] > maior && elementos[i]%2==0)
        maior = elementos[i];
    }
  }

}


int main()
{
  treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
  int aux;                   // auxiliar para inserir os elementos
  int n = 1;                 // nÃºmero de elementos da Ã¡rvore
  int maior, menor;          // maior e menor elemento da arvore

  cin >> aux;
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
    n++;
  }

  MaiorMenor(arvore, n, maior);

  cout  << maior << endl;
  return 0;
}