#include <iostream>
using namespace std;

int sinal(int n)
{
	// verificando se é positivo, negativo ou zero
	if(n < 0)
		return -1;
	else if (n > 0)
		return 1;
	else
		return 0;
	
}
int main()
{
	int num; // numero a ser digitado
	
	// entrada de dados
	cin >> num;
	
	// calculando e mostrando o resultado
	if(sinal(num) == 1)
		cout << "Positivo" << endl;
	else if(sinal(num) == -1)
		cout << "Negativo" << endl;
	else
		cout << "Zero" << endl;
	
	return 0;
}