import java.util.*;

public class Conta {
  private double saldo;
  private double limite;
  private Set<Cliente> clientes = new HashSet<Cliente>();

  public Conta(double saldo, double limite) {
    this.saldo = saldo;
    this.limite = limite;
  }

  public void addCliente(Cliente cliente) {
    clientes.add(cliente);
  }

  public boolean sacar(double quantia){
    if(quantia < (saldo + limite)){
      saldo -= quantia;
      return true;
    }
    else{
      System.out.println("Saldo insuficiente");
      return false;
    }
  }

  public void mostraInfo(){
      for (Cliente cliente : clientes) {
        try{
          System.out.print("Nome: " + cliente.getNome());
          System.out.print(" com o CPF: " + cliente.getCpf());
          System.out.print(" possui o saldo de " + saldo + " e o limite " + limite);
          System.out.println();
        }catch(NullPointerException e){
          System.out.println("Erro: " + e);
        }
    }
  }
}

