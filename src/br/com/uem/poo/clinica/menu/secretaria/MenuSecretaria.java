package br.com.uem.poo.clinica.menu.secretaria;

import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public class MenuSecretaria implements Menu {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public MenuSecretaria() {
    super();
  }

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("********* SECRETÁRIA *********\n");
      saidaTexto.println("  1- Pacientes");
      saidaTexto.println("  2- Consultas");
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
        submenu = new SubMenuPaciente();
        break;
      case 2:
        submenu = new SubMenuConsulta();
        break;
      case 3:
        submenu = new SubMenuRelatorioConsulta();
        break;
    }

    if(submenu == null){
      return;
    }

    submenu.showMenu();

  }

}
