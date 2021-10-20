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
      saidaTexto.println("  3- Sair");
      saidaTexto.print("Digite a opção: ");

      op = Integer.parseInt(leitor.nextLine());

      executaOperacao(op);
    }while (op!=3);

  }

  public void executaOperacao(int op){
    Menu submenu = null;
    boolean mostraMenu = true;

    switch (op){
      case 1:
        submenu = new SubMenuPaciente();
        break;
      case 2:
        submenu = new SubMenuConsulta();
        break;
      default:
        mostraMenu = false;
        break;
    }

    if(mostraMenu) {
      submenu.showMenu();
    }
  }

}
