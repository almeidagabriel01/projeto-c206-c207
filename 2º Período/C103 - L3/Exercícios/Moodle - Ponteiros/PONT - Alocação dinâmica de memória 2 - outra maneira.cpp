#include <iostream>
#include <iomanip>
using namespace std;

// struct de cada aluno
struct dados
{
	int notas[100]; // notas dos alunos
	float media; // média das notas dos alunos
};

int main()
{
	dados *alunos; // struct das notas dos alunos e a média deles
	int i, j; // contador
	int n; // números de alunos

	// entrando com o número de alunos
	cin >> n;

	// alocando memória para a struct
	alunos = new dados[4];

	// lendo as notas de cada aluno
	for(i = 0; i < n; i++)
		for(j = 0; j < 4; j++)
			cin >> alunos[i].notas[j];

	// fazendo a média das notas e armazenando na struct
	alunos[0].media = 0; // excluindo o lixo da primeira posição para armazenar a média

	for(i = 0; i < n; i++)
		for(j = 0; j < 4; j++)
			alunos[0].media = alunos[0].media + alunos[i].notas[j];

	alunos[0].media = alunos[0].media / (n*4);

	// mostrando a média calculada
	cout << fixed << setprecision(2) << alunos[0].media << endl;

	// liberando a memória usada pela struct
	delete [] alunos;

	return 0;
}
