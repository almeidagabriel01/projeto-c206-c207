#include <iostream>
#include <cmath>
#include <cstring>

using namespace std;

void rabin_karp(char T[], char P[], int tamT, int tamP, int d, int q, int &tam, int &ult)
{

  int h;     // valor utilizado para calculo de hash
  int p = 0; // padrao convertido para inteiro
  int t = 0; // texto convertido para inteiro

  for (int i = 0; i < tamP; i++)
  {
    p = (d * p + (P[i] - '0')) % q; // converte o padrao
    t = (d * t + (T[i] - '0')) % q; // converte o texto para o primeiro valor (t0)
  }

  h = (int)pow(d, tamP - 1) % q; // utilizado para calculo de hash

  for (int i = 0; i <= tamT - tamP; i++)
  {
    if (p == t) // Se encontrei um valor de hash valido
    {
      // Verifico se ha diferencas
      int j;
      for (j = 0; j < tamP; j++)
      {
        if (P[j] != T[i + j])
        {
          break;
        }
      }

      if (j == tamP)
      {
        tam++;
        ult = i;
      }
    }

    if (i < tamT - tamP) // se ainda nao cheguei no final
    {
      t = (d * (t - (T[i] - '0') * h) + (T[i + tamP] - '0')) % q; // atualizo o ti para ti+1
      if (t < 0)
        t += q;
    }
  }

  if (tam == 0)
  {
    cout << tam << " ocorrencia(s)" << endl;
  }
  else
  {
    cout << "Ultima ocorrencia: " << ult << endl;
    cout << tam << " ocorrencia(s)" << endl;
  }
}

int main()
{

  char texto[100];
  char padrao[100];

  // cardinalidade do alfabeto usado no texto, em outras palavras, qtd de caracteres diferentes utilizados
  int d;
  // n�mero primo grande, para calcular os valores no hash
  int q;

  int tam = 0;
  int ult = 0;

  cin >> d;
  cin >> q;
  cin >> texto;
  cin >> padrao;

  rabin_karp(texto, padrao, strlen(texto), strlen(padrao), d, q, tam, ult);

  return 0;
}