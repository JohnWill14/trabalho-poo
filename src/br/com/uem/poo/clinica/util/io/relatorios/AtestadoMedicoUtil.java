package br.com.uem.poo.clinica.util.io.relatorios;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.medico.AtestadoMedico;
import br.com.uem.poo.clinica.relatorio.medico.ReceitaMedica;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

public class AtestadoMedicoUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static AtestadoMedico inseriDadosAtestadoMedico(Paciente  paciente){
    LocalDate localDateConvertido;

    saidaTexto.print("Digite a data do atestado(\"dd/MM/yyyy\"): ");
    try {
       localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
    }catch (Exception e){
      throw new RuntimeException("Nao foi possivel converter data");
    }

    return new AtestadoMedico(paciente, localDateConvertido);
  }

  public static void mostraAtestadoMedico(AtestadoMedico atestadoMedico){
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println(atestadoMedico.geraRelatorio());
  }

}
