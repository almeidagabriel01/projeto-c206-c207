package br.inatel.cdg.classes;

import br.inatel.cdg.exceptions.CandidatoInválidoChecked;
import br.inatel.cdg.exceptions.CpfInválidoChecked;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void efetivaVoto(int numero, int numDosCadidatos[]) throws CandidatoInválidoChecked {
        for (int i = 0; i < numDosCadidatos.length; i++) {
            if (numero == numDosCadidatos[i]) {
                return;
            }
        }
        throw new CandidatoInválidoChecked("Candidato inválido!");
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Candidatos PaulinhoAnão = new PaulinhoAnão("Paulinho Anão", 77, "Dos males o menor!");
        Candidatos Rogerão = new Rogerão("Rogerão", 51, "O amigo do povão!");
        Candidatos Darth = new DarthVerde("Darth Verde", 43, "O mais honesto das galáxias!");
        String finalizar = "nao";
        boolean votou = false;
        boolean cpfValido = false;
        StringBuilder paulinhoVotos = new StringBuilder();
        StringBuilder rogerVotos = new StringBuilder();
        StringBuilder darthVotos = new StringBuilder();
        int numDosCadidatos[] = {PaulinhoAnão.getNumero(), Rogerão.getNumero(), Darth.getNumero()};

        while(finalizar.equals("nao")){
            System.out.print("Digite seu CPF: ");
            String cpf = ler.next();
            try {
                Eleitor.validaCPF(cpf);
                cpfValido = true;
            } catch (CpfInválidoChecked e) {
                System.out.println(e.getMessage());
            }

            while(!cpfValido){
                System.out.print("Digite seu CPF: ");
                cpf = ler.next();
                try {
                    Eleitor.validaCPF(cpf);
                    cpfValido = true;
                } catch (CpfInválidoChecked e) {
                    System.out.println(e.getMessage());
                }
            }

            int candidato;
            System.out.println("Digite o número do candidato que deseja votar: ");
            System.out.println(PaulinhoAnão.getNome() + " - " + PaulinhoAnão.getNumero());
            System.out.println(Rogerão.getNome() + " - " + Rogerão.getNumero());
            System.out.println(Darth.getNome() + " - " + Darth.getNumero());
            candidato = ler.nextInt();

            while(!votou) {
                try {
                    efetivaVoto(candidato, numDosCadidatos);
                    votou = true;
                    if(candidato == PaulinhoAnão.getNumero()){
                        paulinhoVotos.append(cpf + "\n");
                    }
                    else if(candidato == Rogerão.getNumero()){
                        rogerVotos.append(cpf + "\n");
                    }
                    else if(candidato == Darth.getNumero()){
                        darthVotos.append(cpf + "\n");
                    }
                } catch (CandidatoInválidoChecked e) {
                    System.out.println(e.getMessage());
                    System.out.println("Digite o número do candidato que deseja votar: ");
                    System.out.println(PaulinhoAnão.getNome() + " - " + PaulinhoAnão.getNumero());
                    System.out.println(Rogerão.getNome() + " - " + Rogerão.getNumero());
                    System.out.println(Darth.getNome() + " - " + Darth.getNumero());
                    candidato = ler.nextInt();
                }
            }

            votou = false;
            cpfValido = false;
            System.out.println("Deseja finalizar a votação? (sim/nao)");
            finalizar = ler.next();
            finalizar = finalizar.toLowerCase();
            while(!finalizar.equals("sim") && !finalizar.equals("nao")){
                System.out.println("Deseja finalizar a votação? (sim/nao)");
                finalizar = ler.next();
                finalizar = finalizar.toLowerCase();
            }
        }

        Path pathPaulinho = Paths.get("candidatos/" + PaulinhoAnão.getNome() + ".txt");
        Path pathRoger = Paths.get("candidatos/" + Rogerão.getNome() + ".txt");
        Path pathDarth = Paths.get("candidatos/" + Darth.getNome() + ".txt");

        try {
            Files.writeString(pathPaulinho, paulinhoVotos);
            Files.writeString(pathRoger, rogerVotos);
            Files.writeString(pathDarth, darthVotos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<String> conteudo = Files.readAllLines(pathPaulinho);
            conteudo.forEach((linha)->{
                String[] linhaQuebrada = linha.split("\n");
                for(int i = 0; i < linhaQuebrada.length; i++){
                    PaulinhoAnão.quantVotos();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            List<String> conteudo = Files.readAllLines(pathRoger);
            conteudo.forEach((linha)->{
                String[] linhaQuebrada = linha.split("\n");
                for(int i = 0; i < linhaQuebrada.length; i++){
                    Rogerão.quantVotos();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            List<String> conteudo = Files.readAllLines(pathDarth);
            conteudo.forEach((linha)->{
                String[] linhaQuebrada = linha.split("\n");
                for(int i = 0; i < linhaQuebrada.length; i++){
                    Darth.quantVotos();
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Paulinho Anão: " + PaulinhoAnão.getVotos());
        System.out.println("Rogerão: " + Rogerão.getVotos());
        System.out.println("Darth Verde: " + Darth.getVotos());
    }
}
