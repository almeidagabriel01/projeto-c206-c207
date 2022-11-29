#include <iostream>
using namespace std;

int main()
{
	int *list1 = NULL, *list2 = NULL, *list3 = NULL;
	int *pont1, *pont2, *pont3;
	int N1 = 0, N2 = 0, N3 = 0;
	int i = 0;

	// alocando espaço para as listas
	list1 = new int[100];
	list2 = new int[100];
	list3 = new int[100];

	// entrando com as listas 1 e 2 e armanando na lista 3 para colocar em ordem
	pont1 = list1;
	pont3 = list3;

	cin >> *pont1;

	while(*pont1 != 0)
	{
		*pont3 = *pont1;
		pont3++;
		pont1++;
		N1++;
		cin >> *pont1;
	}

	pont2 = list2;

	cin >> *pont2;

	while(*pont2 != 0)
	{
		*pont3 = *pont2;
		pont3++;
		pont2++;
		N2++;
		cin >> *pont2;
	}

	// armazenando o tamanho das listas juntas
	N3 = N1 + N2;

	// colocando em ordem crescente as duas listas
	pont1 = list1;
	pont2 = list2;
	pont3 = list3;

	bubbleSort();

	delete [] list1;
	delete [] list2;
	delete [] list3;

	return 0;
}
