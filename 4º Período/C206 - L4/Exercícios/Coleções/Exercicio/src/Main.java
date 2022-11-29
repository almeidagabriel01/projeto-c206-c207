public class Main {
    public static void main(String[] args) {
        Empresa inatel = new Empresa("Inatel", "XX. XXX. XXX/0001-XX");

        Funcionario professor = new Funcionario("Renzo", "XXX.XXX.XXX-XX", 1000);
        Funcionario monitor = new Funcionario("João", "XXX.XXX.XXX-XX", 1000);

        Departamento rh = new Departamento("Recursos Humanos", 10000);

        inatel.addFuncionario(professor);
        inatel.addFuncionario(monitor);

        inatel.addDepartamento(rh);

        
    }
}
