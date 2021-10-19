package br.com.uem.poo.clinica.util.leitor;

import br.com.uem.poo.clinica.entidade.Contato;

import java.io.PrintStream;
import java.util.Scanner;

public class CapturaContatoUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static Contato inseriCamposContato(){
    Contato.ContatoBuilder cb = new Contato.ContatoBuilder();

    saidaTexto.print("Digite o endereco: ");
    cb.endereco(leitor.next());
    saidaTexto.print("Digite o bairro: ");
    cb.bairro(leitor.next());
    saidaTexto.print("Digite a cidade: ");
    cb.cidade(leitor.next());
    saidaTexto.print("Digite o email: ");
    cb.email(leitor.next());
    saidaTexto.print("Digite o telefone: ");
    cb.telefone(leitor.next());

    return cb.build();
  }
}
