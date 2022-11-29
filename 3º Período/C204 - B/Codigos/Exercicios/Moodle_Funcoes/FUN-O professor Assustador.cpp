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

int main()
{
	int n;
	int i;
	int notas[100];
	
	cin >> n;
	
	for(i = 0; i < n; i++)
		cin >> notas[i];
	
	cout << "Media da turma = " << fixed << setprecision(2) << media(notas, n) << endl;
	
	return 0;
}