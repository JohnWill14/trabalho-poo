package br.com.uem.poo.clinica.util.camposentidade;

import br.com.uem.poo.clinica.entidade.Contato;

import java.io.PrintStream;
import java.util.Scanner;

public class CamposContatoUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static Contato inseriCamposContato(){
    Contato.ContatoBuilder cb = new Contato.ContatoBuilder();

    saidaTexto.print("Digite o endereco: ");
    cb.endereco(leitor.nextLine());
    saidaTexto.print("Digite o bairro: ");
    cb.bairro(leitor.nextLine());
    saidaTexto.print("Digite a cidade: ");
    cb.cidade(leitor.nextLine());
    saidaTexto.print("Digite o email: ");
    cb.email(leitor.nextLine());
    saidaTexto.print("Digite o telefone: ");
    cb.telefone(leitor.nextLine());

    return cb.build();
  }
}
