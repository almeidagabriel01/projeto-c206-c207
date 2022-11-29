import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner entrada = new Scanner(System.in);
        int bombaX = rand.nextInt(2);
        int bombaY = rand.nextInt(2);
        int linhadigitada;
        int colunadigitada;
        int[][] matriz = new int[2][2];
        boolean explodiu = false;
        int pontos = 0;

        matriz[bombaX][bombaY] = 1;
        do{
            linhadigitada = entrada.nextInt();
            colunadigitada = entrada.nextInt();

            if(matriz[linhadigitada][colunadigitada] == matriz[bombaX][bombaY]){
                explodiu = true;
                System.out.println("Troxao, explodiu ae mane");
                pontos = 0;
            }
            else{
                System.out.println("Coe, os guri ta em peso");
                pontos++;
            }
        }while(pontos < 3);

        entrada.close();
    }
}
