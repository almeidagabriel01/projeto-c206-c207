#include<iostream>
#include<iomanip>
using namespace std;

float media(int notas[], int nAlunos)
{
	float soma = 0;
	int i;
	
	for(i = 0; i < nAlunos; i++)
		soma += notas[i];
	
	return soma / nAlunos;
}

int nAbaixo(int notas[], int nAlunos, float media)
{
	int i, res = 0;
	
	for(i = 0; i < nAlunos; i++)
		if(notas[i] < media)
			res ++;
	
	return res;
}

int nAcima(int notas[], int nAlunos, float media)
{
	int i, res = 0;
	
	for(i = 0; i < nAlunos; i++)
		if(notas[i] > media)
			res ++;
	
	return res;
}

int main()
{
	int n;
	int i;
	int notas[100];
	float Media = 0;
	
	cin >> n;
	
	for(i = 0; i < n; i++)
		cin >> notas[i];
	
	Media = media(notas, n);
	cout << "Media da turma = " << fixed << setprecision(2) << media(notas, n) << endl;
	
	cout << "Alunos com nota abaixo da media: " << nAbaixo(notas, n, Media) << endl;
	cout << "Alunos com nota acima da media: " << nAcima(notas, n, Media) << endl;
	
	return 0;
}