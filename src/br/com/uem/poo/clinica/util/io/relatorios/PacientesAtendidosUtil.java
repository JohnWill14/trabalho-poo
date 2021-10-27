package br.com.uem.poo.clinica.util.io.relatorios;

import br.com.uem.poo.clinica.relatorio.medico.ConsultasRealizadas;
import br.com.uem.poo.clinica.relatorio.medico.PacientesAtendidos;

import java.io.PrintStream;
import java.util.Scanner;

public class PacientesAtendidosUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static void mostraCPacientesAtendidos(PacientesAtendidos pacientesAtendidos){
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println(pacientesAtendidos.geraRelatorio());
  }

}
