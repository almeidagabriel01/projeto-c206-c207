package br.inatel.cdg.view;

import br.inatel.cdg.controller.*;
import br.inatel.cdg.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class Main {
    // inicializa o banco de dados se ainda nao foi inicializado
    public static void init(){
        if(checkaDB()){
            preload();
        }
        else{
            System.out.println("Banco de dados já foi inicializado!");
        }
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
        LivroDB.insertLivro(livro2);
        LivroDB.insertLivro(livro3);

        Artigo artigo1 = new Artigo("A vida de um programador", "Ciência da computação", "Douglas Kim");
        Artigo artigo2 = new Artigo("Relógios atômicos: Medindo o segundo", "Física", "Muriel A. de Souza Lobo");
        Artigo artigo3 = new Artigo("A Ciência no Carnaval", "Ciência", "Sidcley Lyra");

        ArtigoDB.insertArtigo(artigo1);
        ArtigoDB.insertArtigo(artigo2);
        ArtigoDB.insertArtigo(artigo3);

        Revista revista1 = new Revista("Ciência Hoje", "Ciência", "Douglas Kim", 2022);
        Revista revista2 = new Revista("Física Hoje", "Física", "Muriel A. de Souza Lobo", 2018);
        Revista revista3 = new Revista("Ciência no Carnaval", "Ciência", "Sidcley Lyra", 2017);

        RevistaDB.insertRevista(revista1);
        RevistaDB.insertRevista(revista2);
        RevistaDB.insertRevista(revista3);
    }

    public static boolean login(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu usuário: ");
        String user = scanner.next();
        System.out.println("Digite sua senha: ");
        String senha = scanner.next();

        // verifica se o login é valido
        if (ContaDB.validarLogin(user, senha)) {
            return true;
        }

        return false;
    }

    public static boolean cadastro(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu cpf: ");
        String cpf = scanner.next();
        System.out.println("Digite seu nome completo: ");
        String nome = scanner.next();
        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();
        System.out.println("Digite seu celular: ");
        String celular = scanner.next();

        // cria o usuário com as informações digitadas e insere no banco de dados
        Usuário usuário = new Usuário(cpf, nome, idade, celular);
        UsuárioDB.insertUsuário(usuário);

        System.out.println("Digite seu usuário: ");
        String user = scanner.next();

        // verifica se o user já existe ao tentar cadastrar
        boolean cadastro = ContaDB.validarCadastro(user);
        if(!cadastro){
            return false;
        }
        System.out.println("Digite sua senha: ");
        String senha = scanner.next();
        Conta conta = new Conta(user, senha);
        ContaDB.insertConta(conta, cpf);

        return true;
    }
    public static void main(String[] args) {
        //init();
        Scanner scanner = new Scanner(System.in);
        boolean validado = false;
        System.out.println("Bem vindo ao sistema de biblioteca!");
        System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
        int opcao = scanner.nextInt();
        while(opcao != 1 && opcao != 2 && validado == false) {
            if (opcao == 1) {
                // verifica se o login é valido
                /*
                if (login()) {
                    System.out.println("Login realizado com sucesso!");
                    validado = true;
                } else {
                    System.out.println("Usuário ou senha incorretos!");
                }*/
            } else if (opcao == 2) {
                /*
                boolean cadastrado = cadastro();
                if(cadastrado){
                    System.out.println("Cadastro realizado com sucesso!");
                    validado = true;
                }
                else{
                    System.out.println("Usuário já existe!");
                }
                */
            } else {
                System.out.println("Opção inválida!");
                System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
                opcao = scanner.nextInt();
            }
        }
        System.out.println("Digite o título do livro para verificar a disponibilidade: ");
        String titulo = scanner.next();
        boolean disponivel = AcervoDB.pesquisaLivro(titulo);
        if(disponivel){
            System.out.println("Livro disponível!");
            System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
            int opcao2 = scanner.nextInt();
            while(opcao2 != 1 && opcao2 != 2) {
                if (opcao2 == 1) {
                    Date dataHoraAtual = new Date();
                    String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataHoraAtual);
                } else if (opcao2 == 2) {
                    System.out.println("Empréstimo cancelado!");
                } else {
                    System.out.println("Opção inválida!");
                    System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
                }
            }
        }
        else{
            System.out.println("Livro indisponível!");
        }
    }
}
