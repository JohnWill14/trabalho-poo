package br.com.uem.poo.clinica.util.io.relatorios;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.medico.AtestadoMedico;
import br.com.uem.poo.clinica.relatorio.medico.DeclaracaoDeAcompanhamento;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

public class DeclaracaoDeAcompanhanteUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static DeclaracaoDeAcompanhamento inseriDadosDeclaracaoDeAcompanhamento(Paciente  paciente){
    LocalDate localDateConvertido;
    String nomeAcompanhante;

    saidaTexto.print("Insira o nome do acompanhante: ");
    nomeAcompanhante = leitor.nextLine();

    saidaTexto.print("Digite a data do acompanhamento(\"dd/MM/yyyy\"): ");
    try {
       localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
    }catch (Exception e){
      throw new RuntimeException("Nao foi possivel converter data");
    }

    return new DeclaracaoDeAcompanhamento(paciente, nomeAcompanhante, localDateConvertido);
  }

  public static void mostraDeclaracaoDeAcompanhamento(DeclaracaoDeAcompanhamento declaracaoDeAcompanhamento){
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println(declaracaoDeAcompanhamento.geraRelatorio());
  }

}
