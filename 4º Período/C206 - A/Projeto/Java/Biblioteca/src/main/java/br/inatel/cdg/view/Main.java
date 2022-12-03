package br.inatel.cdg.view;

import br.inatel.cdg.controller.*;
import br.inatel.cdg.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public final class Main {
    // inicializa o banco de dados se ainda nao foi inicializado
    public static void init(){
        if(!checkaDB()){
            System.out.println("Banco de dados já foi inicializado!");
        }
        preload();
    }

    // Verifica se o banco de dados já foi inicializado
    public static boolean checkaDB() {
        boolean check = false;
        int art = ArtigoDB.readAllArtigo().size();
        int rev = RevistaDB.readAllRevista().size();
        int liv = LivroDB.readAllLivro().size();

        if(art == 0 && rev == 0 && liv == 0){
            check = true;
        }
        return check;
    }

    // função para preencher o banco de dados com dados iniciais
    public static void preload(){
        Livro livro1 = new Livro("O Senhor dos Anéis", "Literatura estrangeira", "J.R.R. Tolkien", "Rocco", "Volume 1");
        Livro livro2 = new Livro("O Hobbit", "Literatura estrangeira", "J.R.R. Tolkien", "Rocco", "Volume 2");
        Livro livro3 = new Livro("Livro da filosofia", "100", "Douglas Kim", "Globo livros", "Volume 3");
        LivroDB.insertLivro(livro1);
        LivroDB.updateFkLivro(1, 1);
        LivroDB.insertLivro(livro2);
        LivroDB.updateFkLivro(2, 2);
        LivroDB.insertLivro(livro3);
        LivroDB.updateFkLivro(3, 3);

        Artigo artigo1 = new Artigo("A vida de um programador", "Ciência da computação", "Douglas Kim");
        Artigo artigo2 = new Artigo("Relógios atômicos: Medindo o segundo", "Física", "Muriel A. de Souza Lobo");
        Artigo artigo3 = new Artigo("A Ciência no Carnaval", "Ciência", "Sidcley Lyra");

        ArtigoDB.insertArtigo(artigo1);
        ArtigoDB.updateFkArtigo(1, 4);
        ArtigoDB.insertArtigo(artigo2);
        ArtigoDB.updateFkArtigo(2, 5);
        ArtigoDB.insertArtigo(artigo3);
        ArtigoDB.updateFkArtigo(3, 6);

        Revista revista1 = new Revista("Ciência Hoje", "Ciência", "Douglas Kim", 2022);
        Revista revista2 = new Revista("Física Hoje", "Física", "Muriel A. de Souza Lobo", 2018);
        Revista revista3 = new Revista("Ciência no Carnaval", "Ciência", "Sidcley Lyra", 2017);

        RevistaDB.insertRevista(revista1);
        RevistaDB.updateFkRevista(1, 7);
        RevistaDB.insertRevista(revista2);
        RevistaDB.updateFkRevista(2, 8);
        RevistaDB.insertRevista(revista3);
        RevistaDB.updateFkRevista(3, 9);
    }

    public static String login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu usuário: ");
        String user = scanner.next();
        System.out.println("Digite sua senha: ");
        String senha = scanner.next();

        // verifica se o login é valido
        if (ContaDB.validarLogin(user, senha)) {
            return user;
        }

        return "erro";
    }

    public static String cadastro(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> users;
        boolean valid = false; // valida se o usuario ja existe

        System.out.println("Digite seu usuário: ");
        String user = scanner.next();
        scanner.nextLine();
        users = ContaDB.selectUser();

        // valida se o usuario ja existe
        for (String u : users) {
            if (u.equals(user)) {
                valid = true;
            }
        }
        if(!valid) {
            System.out.println("Digite sua senha: ");
            String senha = scanner.next();
            System.out.println("Digite seu nome completo: ");
            String nome = scanner.next();
            System.out.println("Digite seu cpf: ");
            scanner.nextLine();
            String cpf = scanner.next();
            System.out.println("Digite sua idade: ");
            int idade = scanner.nextInt();
            System.out.println("Digite seu celular: ");
            String celular = scanner.next();

            Usuário usuário = new Usuário(cpf, nome, idade, celular);
            UsuárioDB.insertUsuário(usuário);
            ContaDB.insertConta(user, senha);
            ContaDB.updateFkConta(user, cpf);

            return user;
        }
        return "erro";
    }

    public static String DataAgora(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = agora.format(formatter);
        return agoraFormatado;
    }

    public static String DataDevolucao(){
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime maisSeteDias = agora.plusDays(7);
        String maisSeteDiasFormatado = maisSeteDias.format(formatter);

        return maisSeteDiasFormatado;
    }
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        String user = "erro";
        System.out.println("Bem vindo ao sistema de biblioteca!");
        System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
        int opcao = scanner.nextInt();
        do{
            boolean checkCadastro = false; // var aux para mostrar entrar no if caso o usuário já exista
            boolean checkLogin = false; // var aux para mostrar entrar no if caso o usuário não exista
            if (opcao == 1) {
                user = login();
                checkLogin = true;
            } else if (opcao == 2) {
                user = cadastro();
                checkCadastro = true;
            } else {
                System.out.println("Opção inválida!");
                System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
                scanner.nextLine();
                opcao = scanner.nextInt();
            }
            if(user.equals("erro") && checkCadastro){ // caso o usuário já exista
                System.out.println("Usuário já existente!");
                System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro com usuário diferente: ");
                scanner.nextLine();
                opcao = scanner.nextInt();
            }
            if(user.equals("erro") && checkLogin){ // caso o login esteja errado
                System.out.println("User ou senha inválidos!");
                System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
                scanner.nextLine();
                opcao = scanner.nextInt();
            }
        }while((opcao != 1 && opcao != 2) || user.equals("erro"));
        System.out.println("Digite o título do livro para verificar a disponibilidade: ");
        String titulo = scanner.next();
        boolean disponivel = AcervoDB.pesquisaLivro(titulo);
        if(disponivel){
            System.out.println("Livro disponível!");
            System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
            int opcao2 = scanner.nextInt();
            do{
                if (opcao2 == 1) {
                    String dataAgora = DataAgora();
                    String dataDevolucao = DataDevolucao();
                    Empréstimo emprestimo = new Empréstimo(dataAgora, dataDevolucao);
                    EmpréstimoDB.insertEmpréstimo(emprestimo, user);
                } else if (opcao2 == 2) {
                    System.out.println("Empréstimo cancelado!");
                } else {
                    System.out.println("Opção inválida!");
                    System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
                }
            }while(opcao2 != 1 && opcao2 != 2);
        }
        else{
            System.out.println("Livro indisponível!");
        }
    }
}
