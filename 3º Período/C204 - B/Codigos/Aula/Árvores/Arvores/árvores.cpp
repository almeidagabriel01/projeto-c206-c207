#include <iostream>
using namespace std;

struct treenode{
  int info;
  treenode *esq;
  treenode *dir;
};
typedef treenode *treenodeptr;

int main(){
  treenodeptr arvore = NULL; // ponteiro para a raiz da arvore
  int x; // variavel para armazenar o valor do novo nó
  
  arvore = new treenode; // criando a bolinha da raiz
  
  x = 14; // valor da raiz
  arvore->info = x; // colocando o valor na raiz
  arvore->esq = NULL;
  arvore->dir = NULL;

  x = 15;
  arvore->dir = new treenode; // criando a bolinha
  (arvore->dir)->info = x; // colocando o valor dentro da bolinha
  (arvore->dir)->esq = NULL;
  (arvore->dir)->dir = NULL;

  x = 4;
  arvore->esq = new treenode; // criando a bolinha
  (arvore->esq)->info = x; // colocando o valor dentro da bolinha
  (arvore->esq)->esq = NULL;
  (arvore->esq)->dir = NULL;

  cout << arvore->info << endl;
  cout << (arvore->esq)->info << endl;
  cout << (arvore->dir)->info << endl;

  return 0;
}