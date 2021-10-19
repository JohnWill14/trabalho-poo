package br.com.uem.poo.clinica.menu.secretaria;

import br.com.uem.poo.clinica.menu.Menu;

import java.io.PrintStream;
import java.util.Scanner;

public class SubMenuRelatorioConsulta implements Menu {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- RELATORIO CONSULTA");
      saidaTexto.print(topicosRelatorioConsulta());

      op = leitor.nextInt();

    }while(op!=2);

  }

  private String topicosRelatorioConsulta(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- gera relatorio consulta\n");
    sb.append("   2-Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){

  }

  }
