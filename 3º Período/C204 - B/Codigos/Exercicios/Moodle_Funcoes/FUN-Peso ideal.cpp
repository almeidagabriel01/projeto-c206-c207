#include <iostream>
#include<iomanip>
using namespace std;

float ideal(float h, char sexo)
{
	float ideal = 0; // peso ideal
	
	// verificando se é masculino ou feminino e fazendo as contas 
	switch(sexo)
	{
	case 'M':
		ideal = 72.7 * h - 58;
		break;
	case 'F':
		ideal = 62.1 * h - 44.7;
		break;
	}
	
	return ideal;
}

int main(){
	float altura; // altura da pessoa
	char sexo; // sexo da pessoa
	
	// entrando com os dados
	cin >> altura >> sexo;
	
	// mostrando o peso ideal
	cout << fixed << setprecision(2) << "Peso ideal = " << ideal(altura,sexo) << " kg" << endl;
	
	return 0;
}