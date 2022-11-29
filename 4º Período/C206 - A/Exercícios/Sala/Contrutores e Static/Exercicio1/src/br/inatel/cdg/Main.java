package br.inatel.cdg;

import br.inatel.cdg.inimigo.Asteroide;
import br.inatel.cdg.jogador.Nave;

public class Main {
    public static void main(String[] args) {
        Asteroide ast1 = new Asteroide("Asteroide1", "Pequeno");
        Asteroide ast2 = new Asteroide("Asteroide2", "Grande");
        Nave nave1 = new Nave("Nave1", 90, "Normal");
        Nave nave2 = new Nave("Nave2", 100, "Explosivo");

        nave1.atirar(ast1);
        nave1.atirar(ast2);


        nave2.atirar(ast1);
        nave2.atirar(ast2);
    }
}
