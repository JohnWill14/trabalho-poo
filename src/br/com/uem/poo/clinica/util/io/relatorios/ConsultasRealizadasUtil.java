package br.com.uem.poo.clinica.util.io.relatorios;

import br.com.uem.poo.clinica.relatorio.medico.ConsultasRealizadas;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsultasRealizadasUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static void mostraPacientesAtendidos(ConsultasRealizadas clientesAtendidos){
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println(clientesAtendidos.geraRelatorio());
  }

}
