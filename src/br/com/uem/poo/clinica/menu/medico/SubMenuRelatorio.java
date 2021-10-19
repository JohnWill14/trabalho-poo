package br.com.uem.poo.clinica.menu.medico;

import br.com.uem.poo.clinica.menu.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public class SubMenuRelatorio implements Menu {

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- RELATORIO");
      saidaTexto.print(topicosRelatorio());
      saidaTexto.print("Digite a opção: ");

      op = leitor.nextInt();

      executaOperacao(op);
    }while (op!=2);

  }

  private String topicosRelatorio(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Gera Relatorio\n");
    sb.append("   2- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){

  }

}