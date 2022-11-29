#include <iostream> // Entrada e saida
#include <cmath>
using namespace std;

struct dado{
	int tempo; //tempo do motoboy ate o supermercado
	int motoqueiro;
};

//funcao de quick sort
void quickSort(dado motoboy[], int nmotoboys, int i, int j){
	//variaveis
	int esq = i, dir = j, pivo;
	dado trab;
	
	pivo = motoboy[(int)round((esq + dir)/2.0)].tempo;
	
	//estrutura para reorganizar
	do{
		
		while(motoboy[esq].tempo < pivo)
			esq++;
		
		while(motoboy[dir].tempo > pivo)
			dir--;
		
		if(esq <= dir){
			
			trab.tempo = motoboy[esq].tempo;
			motoboy[esq].tempo = motoboy[dir].tempo;
			motoboy[dir].tempo = trab.tempo;
			
			trab.motoqueiro = motoboy[esq].motoqueiro;
			motoboy[esq].motoqueiro = motoboy[dir].motoqueiro;
			motoboy[dir].motoqueiro = trab.motoqueiro;
			
			esq++;
			dir--;
			
		}
		
	}while(esq <= dir);
	
	if(dir - i >= 0)
		quickSort(motoboy, nmotoboys, i, dir);
	
	if(j - esq >= 0)
		quickSort(motoboy, nmotoboys, esq, j);
	
}

int main()
{
	int nmotoboys; // numero de motoboys
	dado motoboy[100]; //ponteiro pro vetor dos motoboys
	int i, j;
	
	cout << "Entre com o numero de motoboys " << endl;
	cin >> nmotoboys;
	
	//entrada do tempo de cada motoboy
	for(i=1; i <= nmotoboys; i++){
		cout << "Motoqueiro ";
		cin >> motoboy[i].motoqueiro;
		
		cout << "Tempo do motoboy " << motoboy[i].motoqueiro << endl;
		cin >> motoboy[i].tempo;
	}
	
	j = nmotoboys;
	quickSort(motoboy, nmotoboys, 1, j);
	
	//saida de dados
	for(i=1; i <= nmotoboys; i++){
		
		cout << "Motoboy: " << motoboy[i].motoqueiro << endl;
		cout << "Tempo ate o supermercado: " << motoboy[i].tempo << endl;
	}
	
	return 0;
}