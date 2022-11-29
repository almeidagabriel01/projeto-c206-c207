public class Conta {
  // Membros da Classe
  int numero;
  String nomeDoDono;
  float saldo;
  float limite;

  // Metódo para depositar
  void deposita(float quantia) {
    saldo += quantia;
  }

  // Método para sacar
  void saca(float quantia) {
    float novosaldo = saldo - quantia;
    saldo = novosaldo;
  }

  void transferir(Conta contaDestino, float quantia) {
    saldo -= quantia;
    contaDestino.saldo += quantia;
  }
}
