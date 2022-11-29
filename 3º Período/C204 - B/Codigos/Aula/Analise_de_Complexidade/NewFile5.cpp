#include <iostream>
using namespace std;

int main()
{
	
	for(i = 0; i < n; i++) // T(n)
		x=i*i;
	
	for(i = 0; i < n; i=i+2) // T(n) = n/2
		x=i*i;
	
	for(i = 0; i < n; i++) // T(n) = n * log (n)
	{
		j = 1;
		while(j < n)
		{
			x = i*i;
			j = j * 2;
			cont++;
		}
	}
	
	/* T(n) = n + n/2 + n * log(n) -> T(n) total
	   T(n) = 3/2 * n + n * log(n) -> Deixar todos coeficientes igual a 1
	   T(n) = n + n * log(n) -> Deixar apenas a parte que demora mais para rodar 
	   O(n * log(n))
	*/
	return 0;
}