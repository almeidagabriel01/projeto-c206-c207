public class Main {
    public static void main(String[] args) throws Exception {
        Cliente c1 = new Cliente("Zezinho", "123.456.789-00", 19);
        Vendedor v1 = new Vendedor("Sergio Maluco", "987.654.321-00", 89);
        Gerente g1 = new Gerente("Roberto Justos", "123.345.567-89", 19);

        Usuário Usuarios[] = {c1, v1, g1};

        for (Usuário usuario : Usuarios) {
            usuario.mostraInfos();
            if (usuario instanceof Funcionário) {
                ((Funcionário) usuario).receberSalário();
            }
            System.out.println("----------");
        }
    }
}
