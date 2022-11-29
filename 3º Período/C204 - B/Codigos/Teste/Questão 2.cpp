#include <iostream>
using namespace std;

int main()
{
  int *vetor = NULL; // vetor para armazenar os valores
  int n; // tamanho do vetor
  int i; // contador
  int maior = 0; // maior valor do vetor

  // lendo o tamanho do vetor
  cin >> n;

  // alocando memoria para o vetor
  vetor = new int[n];

  // lendo os valores do vetor
  for (i = 0; i < n; i++)
    cin >> vetor[i];

  // verificando o maior valor par no vetor
  for (i = 0; i < n; i++)
  {
    if(vetor[i] %	 2 == 0 && vetor[i] > 0)
      maior = vetor[i];
    else if(vetor[i] > maior && vetor[i] % 2 == 0 && vetor[i] > 0)
      maior = vetor[i];
      
  }

  // imprimindo o maior valor par
  cout << maior << endl;

  // liberando a memoria alocada para o vetor
  delete [] vetor;
  return 0;
}