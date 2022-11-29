public class Main {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[3];
        mamiferos[0] = new Cachorro("Cachorro", 10);
        mamiferos[1] = new Boi("Boi", 20);
        mamiferos[2] = new Lontra("Lontra", 15);
        for (Mamifero mamifero : mamiferos) {
            mamifero.emitirSom();
            if (mamifero instanceof Aquatico) {
                Aquatico aquatico = (Aquatico) mamifero;
                aquatico.nadar();
            }
        }
    }
}
