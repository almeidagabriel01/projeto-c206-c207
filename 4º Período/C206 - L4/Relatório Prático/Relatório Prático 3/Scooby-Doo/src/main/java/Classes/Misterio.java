package Classes;

import Exceptions.JaAdicionadoUnChecked;
import java.util.*;

public class Misterio {
    private int id;
    private String local;
    private String descricao;
    private Set<Pessoa> suspeitos = new HashSet<>();
    private List<String> pistas = new ArrayList<>();

    public Misterio(int id, String local, String descricao) {
        this.id = id;
        this.local = local;
        this.descricao = descricao;
    }

    public void adicionarSuspeito (Pessoa sus) throws JaAdicionadoUnChecked {
        if (suspeitos.contains(sus)) {
            throw new JaAdicionadoUnChecked("Suspeito já adicionado");
        }
        suspeitos.add(sus);
    }

    public String listarSuspeitos(){
        String suspect = "";
        for (Pessoa suspeito : suspeitos) {
            suspect += "Nome: " + suspeito.getNome() + "\nIdade: " + suspeito.getIdade() + "\nProfissão: " + suspeito.getProfissao() + "\n" + "\n";
        }
        return suspect;
    }

    public void adicionarPista(String pista){
        pistas.add(pista);
    }

    public String listarPistas(){
        String pista = "";
        for (String pistas : pistas) {
            pista += pistas + "\n";
        }
        return pista;
    }

    public void gravarInformacoes(){
        String content = "\n---------------------------\n" + "Local: " + local + "\n\nDescrição: " + descricao + "\n\nSuspeitos: \n";
        content += listarSuspeitos();
        content += "\nPistas: \n";
        content += listarPistas();
        content += "\n---------------------------\n";

        FileManager.writeTxt("mysteries/" + id + ".txt", content);
    }

    public void lerInformacoes(){
        FileManager.readTxt("mysteries/" + id + ".txt");
    }
}
