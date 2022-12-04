package br.inatel.projeto.view;

import br.inatel.projeto.controller.*;
import br.inatel.projeto.model.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public final class Main {
    // inicializa o banco de dados se ainda nao foi inicializado
    public static void init(){
        if(!checkaDB()){
            System.out.println("Banco de dados já foi inicializado!");
        }else{
            preload();
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
        AcervoDB.insertAcervo(livro1.getTitulo(), livro1.getCDU());
        LivroDB.insertLivro(livro1);
        LivroDB.updateFkLivro(1, 1);

        AcervoDB.insertAcervo(livro2.getTitulo(), livro2.getCDU());
        LivroDB.insertLivro(livro2);
        LivroDB.updateFkLivro(2, 2);

        AcervoDB.insertAcervo(livro3.getTitulo(), livro3.getCDU());
        LivroDB.insertLivro(livro3);
        LivroDB.updateFkLivro(3, 3);

        Artigo artigo1 = new Artigo("A vida de um programador", "Ciência da computação", "Douglas Kim");
        Artigo artigo2 = new Artigo("Relógios atômicos: Medindo o segundo", "Física", "Muriel A. de Souza Lobo");
        Artigo artigo3 = new Artigo("A Ciência no Carnaval", "Ciência", "Sidcley Lyra");

        AcervoDB.insertAcervo(artigo1.getTitulo(), artigo1.getCDU());
        ArtigoDB.insertArtigo(artigo1);
        ArtigoDB.updateFkArtigo(1, 4);

        AcervoDB.insertAcervo(artigo2.getTitulo(), artigo2.getCDU());
        ArtigoDB.insertArtigo(artigo2);
        ArtigoDB.updateFkArtigo(2, 5);

        AcervoDB.insertAcervo(artigo3.getTitulo(), artigo3.getCDU());
        ArtigoDB.insertArtigo(artigo3);
        ArtigoDB.updateFkArtigo(3, 6);

        Revista revista1 = new Revista("Ciência Hoje", "Ciência", "Douglas Kim", 2022);
        Revista revista2 = new Revista("Física Hoje", "Física", "Muriel A. de Souza Lobo", 2018);
        Revista revista3 = new Revista("Ciência no Carnaval", "Ciência", "Sidcley Lyra", 2017);

        AcervoDB.insertAcervo(revista1.getTitulo(), revista1.getCDU());
        RevistaDB.insertRevista(revista1);
        RevistaDB.updateFkRevista(1, 7);

        AcervoDB.insertAcervo(revista2.getTitulo(), revista2.getCDU());
        RevistaDB.insertRevista(revista2);
        RevistaDB.updateFkRevista(2, 8);

        AcervoDB.insertAcervo(revista3.getTitulo(), revista3.getCDU());
        RevistaDB.insertRevista(revista3);
        RevistaDB.updateFkRevista(3, 9);
    }

    public static String login(){
        Scanner scanner = new Scanner(System.in);
        Map<String, String> validaLogin;

        System.out.println("Digite seu usuário: ");
        String user = scanner.next();
        System.out.println("Digite sua senha: ");
        String senha = scanner.next();

        // verifica se o login é valido
        validaLogin = ContaDB.validaLogin(user, senha);
        for (Map.Entry<String,String> pair : validaLogin.entrySet()) {
            if(user.equals(pair.getKey()) && senha.equals(pair.getValue())){
                System.out.println("Login efetuado com sucesso!");
                return user;
            }
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
            String senha = scanner.nextLine();

            System.out.println("Digite seu nome completo: ");
            String nome = scanner.nextLine();

            System.out.println("Digite seu cpf (somente número): ");
            String cpf = scanner.nextLine();

            System.out.println("Digite sua idade: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite seu celular: ");
            String celular = scanner.nextLine();

            Usuario usuario = new Usuario(nome, cpf, idade, celular);
            UsuarioDB.insertUsuario(usuario);
            ContaDB.insertConta(user, senha);

            int idUsuario = UsuarioDB.selectIdUsuario(cpf);
            ContaDB.updateFkConta(user, idUsuario);

            System.out.println("Cadastro efetuado com sucesso!");
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

    public static void emprestimoLivro(String titulo, String user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Livro disponível!");
        System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
        int opcao2 = scanner.nextInt();
        do{
            if (opcao2 == 1) {
                // data de empréstimo
                String dataAgora = DataAgora();

                // data de devolução: 7 dias apos o dia de empréstimo
                String dataDevolucao = DataDevolucao();

                Emprestimo emprestimo = new Emprestimo(dataAgora, dataDevolucao);

                // insere o empréstimo no banco de dados
                int idAcervo = AcervoDB.selectIdAcervo(titulo);
                int idConta = ContaDB.selectIdConta(user);
                boolean valida = EmprestimoDB.insertEmprestimo(idConta, idAcervo, user, emprestimo);
                if(valida){
                    System.out.println("Empréstimo efetuado com sucesso!");
                }
                else{
                    System.out.println("Erro ao efetuar o empréstimo! Tente novamente mais tarde.");
                }

            } else if (opcao2 == 2) {
                System.out.println("Empréstimo cancelado!");
            } else {
                System.out.println("Opção inválida!");
                System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
            }
        }while(opcao2 != 1 && opcao2 != 2);
    }

    public static void emprestimoRevista(String titulo, String user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Revista disponível!");
        System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
        int opcao2 = scanner.nextInt();
        do{
            if (opcao2 == 1) {
                // data de empréstimo
                String dataAgora = DataAgora();

                // data de devolução: 7 dias apos o dia de empréstimo
                String dataDevolucao = DataDevolucao();

                Emprestimo emprestimo = new Emprestimo(dataAgora, dataDevolucao);

                // insere o empréstimo no banco de dados
                int idAcervo = AcervoDB.selectIdAcervo(titulo);
                int idConta = ContaDB.selectIdConta(user);
                boolean valida = EmprestimoDB.insertEmprestimo(idConta, idAcervo, user, emprestimo);
                if(valida){
                    System.out.println("Empréstimo efetuado com sucesso!");
                }
                else{
                    System.out.println("Erro ao efetuar o empréstimo! Tente novamente mais tarde.");
                }

            } else if (opcao2 == 2) {
                System.out.println("Empréstimo cancelado!");
            } else {
                System.out.println("Opção inválida!");
                System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
            }
        }while(opcao2 != 1 && opcao2 != 2);
    }

    public static void emprestimoArtigo(String titulo, String user){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Artigo disponível!");
        System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
        int opcao2 = scanner.nextInt();
        do{
            if (opcao2 == 1) {
                // data de empréstimo
                String dataAgora = DataAgora();

                // data de devolução: 7 dias apos o dia de empréstimo
                String dataDevolucao = DataDevolucao();

                Emprestimo emprestimo = new Emprestimo(dataAgora, dataDevolucao);

                // insere o empréstimo no banco de dados
                int idAcervo = AcervoDB.selectIdAcervo(titulo);
                int idConta = ContaDB.selectIdConta(user);
                boolean valida = EmprestimoDB.insertEmprestimo(idConta, idAcervo, user, emprestimo);
                if(valida){
                    System.out.println("Empréstimo efetuado com sucesso!");
                }
                else{
                    System.out.println("Erro ao efetuar o empréstimo! Tente novamente mais tarde.");
                }

            } else if (opcao2 == 2) {
                System.out.println("Empréstimo cancelado!");
            } else {
                System.out.println("Opção inválida!");
                System.out.println("Digite 1 para fazer o empréstimo ou 2 para cancelar: ");
            }
        }while(opcao2 != 1 && opcao2 != 2);
    }
    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        String user = "erro";
        System.out.println("Bem vindo ao sistema de biblioteca!");
        System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
        int opcao = scanner.nextInt();
        do {
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
            if (user.equals("erro") && checkCadastro) { // caso o usuário já exista
                System.out.println("Usuário já existente!");
                System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro com usuário diferente: ");
                opcao = scanner.nextInt();
            }
            if (user.equals("erro") && checkLogin) { // caso o login esteja errado
                System.out.println("User ou senha inválidos!");
                System.out.println("Digite 1 para fazer login ou 2 para fazer cadastro: ");
                opcao = scanner.nextInt();
            }
        } while ((opcao != 1 && opcao != 2) || user.equals("erro"));
        scanner.nextLine();

        String escolha;
        String titulo;
        String resultadoTitulo;
        do {
            System.out.println("Digite o que deseja pesquisar (livro/revista/artigo): ");
            escolha = scanner.nextLine();
            escolha.toLowerCase();
            resultadoTitulo = "";
            titulo = "";

            if (escolha.equals("livro")) {
                System.out.println("Digite o título do livro para verificar a disponibilidade: ");
                titulo = scanner.nextLine();
                resultadoTitulo = AcervoDB.pesquisaLivro(titulo);
                if (resultadoTitulo.equals(titulo)) {
                    emprestimoLivro(titulo, user);
                } else {
                    System.out.println("Livro indisponível!");
                }
            } else if (escolha.equals("revista")) {
                System.out.println("Digite o título da revista para verificar a disponibilidade: ");
                titulo = scanner.nextLine();
                resultadoTitulo = AcervoDB.pesquisaRevista(titulo);
                if (resultadoTitulo.equals(titulo)) {
                    emprestimoRevista(titulo, user);
                } else {
                    System.out.println("Revista indisponível!");
                }
            } else if (escolha.equals("artigo")) {
                System.out.println("Digite o título do artigo para verificar a disponibilidade: ");
                titulo = scanner.nextLine();
                resultadoTitulo = AcervoDB.pesquisaArigo(titulo);
                if (resultadoTitulo.equals(titulo)) {
                    emprestimoArtigo(titulo, user);
                } else {
                    System.out.println("Artigo indisponível!");
                }
            } else if (titulo.equals("")) {
                System.out.println("Título inválido!");
                System.out.println("Digite o que deseja pesquisar (livro/revista/artigo): ");
                escolha = scanner.nextLine();
                escolha.toLowerCase();
            } else {
                System.out.println("Opção inválida!");
                System.out.println("Digite o que deseja pesquisar (livro/revista/artigo): ");
                escolha = scanner.nextLine();
            }
        } while ((escolha.equals("livro") && escolha.equals("revista") && escolha.equals("artigo")) || titulo.equals("") || resultadoTitulo.equals(""));
        System.out.println("Obrigado por utilizar o sistema de biblioteca!");
    }
}
