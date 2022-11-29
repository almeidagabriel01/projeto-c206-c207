#include <iostream>
using namespace std;

int main()
{
  int *vetor = NULL; // vetor para armazenar os valores
  int *p; // ponteiro para o vetor
  int n; // tamanho do vetor
  int i; // contador
  int soma = 0; // soma dos valores divisiveis por 3

  // lendo o tamanho do vetor
  cin >> n;

  // alocando memoria para o vetor
  vetor = new int[n];

  // lendo os valores do vetor
  for (i = 0; i < n; i++)
    cin >> vetor[i];

  // somando os valores divisiveis por 3
  for (p = vetor; p < vetor + n; p++)
    if(*p % 3 == 0)
      soma++;

  // imprimindo a soma
  cout << soma << endl;

  // liberando a memoria alocada para o vetor
  delete [] vetor;
  return 0;
}