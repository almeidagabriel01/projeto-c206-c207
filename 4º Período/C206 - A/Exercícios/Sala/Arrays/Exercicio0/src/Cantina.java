public class Cantina {
  String nome;
  Salgado[] salgados = new Salgado[5];

  void addSalgado(Salgado salgadoNovo){
    
    for (int i = 0; i < salgados.length; i++){
      if(salgados[i] == null){
        salgados[i] = salgadoNovo;
        break;
      }

    }

  }

  void mostraInfo(){

    System.out.println("A cantina: " + nome + "possui os seguintes salgados: ");

    for (Salgado salgado : salgados){

      if(salgado != null){
        System.out.println(salgado.nome);
      }

    }
  }
}