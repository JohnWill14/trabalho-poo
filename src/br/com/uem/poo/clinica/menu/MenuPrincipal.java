package br.com.uem.poo.clinica.menu;

import br.com.uem.poo.clinica.menu.medico.MenuMedico;
import br.com.uem.poo.clinica.menu.secretaria.MenuSecretaria;

import java.io.PrintStream;
import java.util.Scanner;

public  class MenuPrincipal implements Menu {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("********* Saúde & Cia1 *********\n");
      saidaTexto.println("  1- Secretaria");
      saidaTexto.println("  2- Medico");
      saidaTexto.println("  3- Sair");
      saidaTexto.print("Digite a opção: ");

      op = Integer.parseInt(leitor.nextLine());

      executaOperacao(op);
    }while (op!=3);

    saidaTexto.println("\nBYE !!!!!\n");
  }

  public void executaOperacao(int op){
    Menu menu = null;
    boolean mostraMenu = true;

    switch (op){
      case 1:
        menu = new MenuSecretaria();
        break;
      case 2:
        menu = new MenuMedico();
        break;
      default:
        mostraMenu = false;
        break;
    }

    if(mostraMenu){
      menu.showMenu();
    }

  }

}

