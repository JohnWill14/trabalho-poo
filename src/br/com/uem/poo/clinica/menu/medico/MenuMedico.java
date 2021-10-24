package br.com.uem.poo.clinica.menu.medico;

import br.com.uem.poo.clinica.menu.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public class MenuMedico implements Menu {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("********* MEDICO *********\n");
      saidaTexto.println("  1- Dados Paciente");
      saidaTexto.println("  2- Prontuario");
      saidaTexto.println("  3- Relatório Consulta");
      saidaTexto.println("  4- Sair");
      saidaTexto.print("Digite a opção: ");

      op = leitor.nextInt();

      executaOperacao(op);
    }while (op!=4);

  }

  public void executaOperacao(int op){
    Menu submenu = null;

    switch (op){
      case 1:
        submenu = new SubMenuDadosPaciente();
        break;
      case 2:
        submenu = new SubmenuProntuario();
        break;
      case 3:
        submenu = new SubMenuRelatorio();
        break;
    }

    if(submenu == null){
      return;
    }

    submenu.showMenu();

  }


}
