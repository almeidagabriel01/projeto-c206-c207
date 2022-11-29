#include <iostream>
#include <iomanip>
#include <list>
using namespace std;
struct treenode
{
  int info;        // infoor a ser guardado
  treenode *p_esq; // ponteiro que aponta pro elemento da p_esquerda
  treenode *p_dir; // ponteiro que aponta pro elemento da p_direita
};
typedef treenode *treenodeptr;
void tInsere(treenodeptr &p, int x)
{
  if (p == NULL) // inserindo na raiz
  {
    p = new treenode;
    p->info = x;
    p->p_esq = NULL;
    p->p_dir = NULL;
  }
  else if (x < p->info) // insere na sub árvore da p_esquerda
    tInsere(p->p_esq, x);
  else // insere na sub árvore da p_direita
    tInsere(p->p_dir, x);
}
void preOrdem1(treenodeptr arvore, float &soma, float &num)
{
  if (arvore != NULL)
  {
    soma += arvore->info;
    num += 1;
    preOrdem1(arvore->p_esq, soma, num);
    preOrdem1(arvore->p_dir, soma, num);
  }
}
float calcMedia(treenodeptr arvore)
{
  float soma = 0; // soma dos elementos da árvore
  float n = 0;    // número de nos na arvore
  preOrdem1(arvore, soma, n);
  return soma / n;
}
int main()
{
  treenodeptr arvore = NULL; // ponteiro para as raízes
  int aux;                   // var. aux. para leitura de dados
  // insenrindo dados na árvore
  cin >> aux;
  while (aux != -1)
  {
    tInsere(arvore, aux);
    cin >> aux;
  }
  // Calculando e mostrando a media
  cout << fixed << setprecision(2);
  cout << "Media: " << calcMedia(arvore) << endl;
  return 0;
}