#include <iostream>
#include <iomanip>
using namespace std;

// struct de cada aluno
struct dados
{
	int notas1;
	int notas2;
	int notas3;
	int notas4;
	float media; // média das notas dos alunos
};

int main()
{
	dados *alunos; // struct das notas dos alunos e a média deles
	
	// alocando memória para a struct
	alunos = new dados;
	
	// lendo as notas de cada aluno
	cin >> alunos->notas1 >> alunos->notas2 >> alunos->notas3 >> alunos->notas4;
	
	// fazendo a média das notas e armazenando na struct
	alunos->media = alunos->notas1 + alunos->notas2 + alunos->notas3 + alunos->notas4;
	
	// mostrando a média calculada
	cout << fixed << setprecision(2) << alunos->media / 4 << endl;
	
	// liberando a memória usada pela struct
	delete alunos;
	
	return 0;
}
