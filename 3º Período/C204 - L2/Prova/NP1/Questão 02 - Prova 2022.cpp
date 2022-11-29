#include <iostream>
#include <cstring>

using namespace std;

void calcula_LPS(int lps[], char P[], int tamP)
{
  // tamanho do maior prefixo que tambem eh sufixo anterior
  int tam = 0;

  lps[0] = 0; // caso base

  // o loop calcula lps[i] para i = 1 ate tamP-1
  int i = 1;
  while (i < tamP)
  {
    if (P[i] == P[tam]) // se encontrar uma letra que bate tanto como prefixo quanto como sufixo
    {
      tam++;        // aumento o tamanho do maior prefixo que tambem eh sufixo
      lps[i] = tam; // salvo o valor para esse prefixo
      i++;          // vou para o proximo prefixo
    }
    else // (p[i] != p[tam]) se encontrar uma letra que nao bate como prefixo e sufixo
    {
      if (tam != 0) // se o tamanho do maior prefixo que tambem eh sufixo atual for diferente de 0
      {
        tam = lps[tam - 1]; // volto pro maior prefixo que tambem eh sufixo considerando o prefixo anterior
                            // Note que neste caso nao incrementamos o 'i'
      }
      else // se o tamanho do maior prefixo que tambem eh sufixo atual for 0
      {
        lps[i] = 0; // o maior prefixo que tambem � prefixo agora vale 0
        i++;        // vou para o proximo prefixo
      }
    }
  }
}

void kmp(char T[], char P[], int tamT, int tamP, int &cont)
{
  int lps[tamP]; // vetor que indica para onde voltarei no padrao quando ocorrer um mismatch
  // lps -> indica o tamanho do maior sufixo de p[0...i] que tambem eh prefixo de p[0...i] (exceto a string inteira)

  calcula_LPS(lps, P, tamP);

  int j = 0; // j eh tamanho do meu match atual, ONDE EU ESTOU NO MEU PADRAO
  int i = 0; // posicao no texto
  while (i < tamT)
  {
    if (T[i] == P[j]) // match
    {
      j++;
      i++;
      if (j == tamP) // encontrei o padrao no texto na posicao (i-tamP) at� i
      {
        cont++;
        j = lps[j - 1];
      }
    }
    else // mismatch
    {
      if (j != 0) // se ocorreu mismatch depois de j matchs
        j = lps[j - 1];
      else // mismatch na comparacao da primeira letra
        i++;
    }
  }
}

int main()
{
  char mus[500]; // trecho da musica do pokemon
  char padrao[100]; // padrao a ser encontrado
  int cont; // contador de ocorrencias
  int i; // contador

  // copiando o trecho da música para a var mus
  strcpy(mus, "(POKEMON! TEMOS QUE PEGAR) ISSO EU SEI PEGA-LOS EU TENTAREI! (POKEMON!) JUNTOS TEREMOS QUE O MUNDO DEFENDER! POKEMON! (TEMOS QUE PEGA-LOS) ISSO EU SEI PEGA-LOS EU TENTAREI VAI SER GRANDE A EMOCAO POKEMON! TEMOS QUE PEGAR TEMOS QUE PEGAR!");

  // entrando com o padrao pela primeira vez
  cin.getline(padrao, 100);

  // contando as ocorrencias e entrando com o padrao até que digite 1
  while (strcmp(padrao, "1") != 0)
  {
    cont = 0;
    kmp(mus, padrao, strlen(mus), strlen(padrao), cont);

    for(i=0; i < strlen(padrao); i++)
      cout << padrao[i];

    cout << ": ";
    if(cont == 0)
      cout << "NAO APARECE NA MUSICA" << endl;
    else if(cont == 1)
      cout << cont << " VEZ" << endl;
    else
      cout << cont << " VEZES" << endl;

    cin.getline(padrao, 100);
  }

  return 0;
}