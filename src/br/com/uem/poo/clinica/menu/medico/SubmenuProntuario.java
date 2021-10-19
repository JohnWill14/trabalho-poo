package br.com.uem.poo.clinica.menu.medico;

import br.com.uem.poo.clinica.menu.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public class SubmenuProntuario implements Menu {

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- PRONTUARIO PACIENTE");
      saidaTexto.print(topicosProntuarioMedico());
      saidaTexto.print("Digite a opção: ");

      op = leitor.nextInt();

      executaOperacao(op);
    }while (op!=4);

  }

  private String topicosProntuarioMedico(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Adicionar no prontuario\n");
    sb.append("   2- Atualiza prontuario\n");
    sb.append("   3- Remover dados do prontuario\n");
    sb.append("   4- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){

  }

}
