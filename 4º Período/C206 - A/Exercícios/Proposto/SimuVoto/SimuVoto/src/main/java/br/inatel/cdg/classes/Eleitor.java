package br.inatel.cdg.classes;

import br.inatel.cdg.exceptions.CpfInválidoChecked;

public class Eleitor {
    public static void validaCPF(String cpf) throws CpfInválidoChecked {
        if (cpf.length() != 11) {
            throw new CpfInválidoChecked("CPF inválido!");
        }
    }
}
