public class Main {
    public static void main(String[] args) {
        Zumbi zumbi = new Zumbi();
        zumbi.forca = 10;
        zumbi.vida = 100;
        zumbi.kills = 0;

        zumbi.matou();
        zumbi.tomouDano();
        zumbi.energetico();

        System.out.println("Matou: " + zumbi.kills);
        System.out.println("Vida: " + zumbi.vida);
        System.out.println("Forca: " + zumbi.forca);
    }
}
