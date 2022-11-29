#include <iostream>
using namespace std;

int main()
{
	char *vet;
	char *vet1;
	char *p;
	char *p1;
	int acertos = 0;

	// alocando memória dinamicamente para os vetores
	vet = new char[20];
	vet1 = new char [20];

	// entrando com os vetores
	cin.getline(vet, 20);
	cin.getline(vet1, 20);

	// verificando o número de acertos
	p = vet;
	p1 = vet1;

	while(p < vet + 19) // sao 19 caracteres contando com os espaços
	{
		if(*p == 'A' && *p1 == 'A')
			acertos++;
		else if(*p == 'B' && *p1 == 'B')
			acertos++;
		else if(*p == 'C' && *p1 == 'C')
			acertos++;
		else if(*p == 'D' && *p1 == 'D')
			acertos++;
		else if(*p == 'E' && *p1 == 'E')
			acertos++;
		p++;
		p1++;
	}


	// mostrando a resposta
	cout << acertos << " acertos" << endl;

	// deletando a memória alocada pelos vetores
	delete [] vet;
	delete [] vet1;


	return 0;
}
