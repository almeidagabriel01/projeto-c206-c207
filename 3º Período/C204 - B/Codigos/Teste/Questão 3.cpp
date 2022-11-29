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

void MaioremOrd (treenodeptr arvore, int &maior)
{
  if (arvore != NULL)
  {
    MaioremOrd(arvore->esq, maior);
    if(arvore->info % 2 == 0)
      maior = arvore->info;

    else if(arvore->info > maior && arvore->info % 2 == 0)
      maior = arvore->info;  
    MaioremOrd(arvore->dir, maior);
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
  int maior; // variavel para armazenar o maior valor da arvore

  // entrando com o aux para inserir na arvore
  cin >> aux;

  // inserindo os valores na arvore
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
  }

  // verificado o maior valor da arvore
  MaioremOrd(arvore, maior);

  // imprimindo o maior valor da arvore
  cout << maior << endl;

  // destruindo a arvore
  tDestruir(arvore);
  return 0;
}