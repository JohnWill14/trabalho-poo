package br.com.uem.poo.clinica;

import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.menu.MenuPrincipal;

public class IniciaAplicacao {
  public static void main(String[] args) {
    Menu menuCentral = new MenuPrincipal();

    menuCentral.showMenu();
  }
}
