import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Pessoa> pessoas = new ArrayList<>();
        Pessoa aluno1 = new Aluno("João", 20, "123", "ADS");
        Pessoa aluno2 = new Aluno("Maria", 19, "456", "ADS");
        Pessoa professor1 = new Professor("Maria", 30, "456", "Matemática");
        Pessoa professor2 = new Professor("João", 35, "123", "Matemática");
        Pessoa diretor1 = new Diretor("José", 40, "789", "Ensino Superior");
        Pessoa diretor2 = new Diretor("Ana", 45, "987", "Ensino Médio");

        pessoas.add(aluno1);
        pessoas.add(aluno2);
        pessoas.add(professor1);
        pessoas.add(professor2);
        pessoas.add(diretor1);
        pessoas.add(diretor2);

        Collections.sort(pessoas);

        for (Pessoa pessoa : pessoas) {
           pessoa.mostrarDados();
        }
    }
}
