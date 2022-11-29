#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

struct ponto
{
	float x;
	float y;
};
typedef ponto vetor; //renomea a struct "ponto" para "vetor"

vetor cria_vetor(ponto A, ponto B)
{
	vetor AB;
	AB.x = B.x - A.x;
	AB.y = B.y - A.y;
	return AB;
}

float vetorial(vetor A, vetor B)
{
	float v;
	v = A.x * B.y - A.y * B.x;
	return v;
}

float area_triangulo(ponto A, ponto B, ponto C)
{
	vetor AB;
	vetor AC;
	float area;
	AB = cria_vetor(A, B);
	AC = cria_vetor(A, C);
	area = fabs(vetorial(AB, AC)) / 2; //fabs é o abs mas para quando retorna um valor float
	return area;
}

int main()
{
	int N; //quantidade de conjunto de pontos.
	ponto p1, p2, p3; //pontos
	float area; //area do triângulo

	cin >> N;

	for(int i = 0; i < N; i++)
	{
		cin >> p1.x >> p1.y;
		cin >> p2.x >> p2.y;
		cin >> p3.x >> p3.y;

		area = area_triangulo(p1, p2, p3);
		
		if(area == 0)
			cout << endl << "Nao formam triangulo" << endl;
		else
			cout << fixed << setprecision(2) << endl << area << endl;
	}

	return 0;
}