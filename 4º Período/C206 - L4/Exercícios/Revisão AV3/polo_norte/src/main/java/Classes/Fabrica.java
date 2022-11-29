package Classes;

import Exceptions.NenhumaCriancaUnChecked;

import java.util.ArrayList;

public class Fabrica {
    private ArrayList<Crianca> criancas = new ArrayList<>();
    private ArrayList<Elfo> elfos = new ArrayList<>();
    private ArrayList<Crianca> listarBonzinhos = new ArrayList<>();

    public void novaElfo (Elfo elfo){
        elfos.add(elfo);
    }

    public void novaCrianca (Crianca crianca){
        criancas.add(crianca);
    }

    public void addBonzinho(String nomeCrianca) throws NenhumaCriancaUnChecked {
        for(Crianca crianca : criancas) {
            if(crianca.getNome().equals(nomeCrianca)) {
                String content = "\n---------------------------\n" + "Nome: " + crianca.getNome() + "\nIdade: " + crianca.getIdade() + "\nNacionalidade: " + crianca.getNacionalidade() + "\nPresente desejado: " + crianca.getPresenteDesejado() + "\n---------------------------\n";
                FileManager.writeTxt("lista_bonzinhos.txt", content);
                return;
            }
        }
        throw new NenhumaCriancaUnChecked("Criança não encontrada");
    }

    public void listarBonzinhos(){
        FileManager.readTxt("lista_bonzinhos.txt");
    }
}
