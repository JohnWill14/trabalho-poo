package br.com.uem.poo.clinica.util.io.relatorios;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.relatorio.medico.ReceitaMedica;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Scanner;

public class ReceitaMedicaUtil {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  public static ReceitaMedica inseriDadosReceitaMedica(Paciente  paciente){
    LocalDate localDateConvertido;
    String nomeMedico;
    String medicamento;
    String detalhesMedicacao;

    saidaTexto.print("Insira o nome do medico: ");
    nomeMedico = leitor.nextLine();

    saidaTexto.print("Digite a data da receita(\"dd/MM/yyyy\"): ");
    try {
       localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
    }catch (Exception e){
      throw new RuntimeException("Nao foi possivel converter data");
    }

    saidaTexto.print("Insira o medicamento: ");
    medicamento = leitor.nextLine();

    saidaTexto.print("Insira os detalhes da medicacao: ");
    detalhesMedicacao = leitor.nextLine();

    return new ReceitaMedica(paciente, medicamento, detalhesMedicacao, nomeMedico, localDateConvertido);

  }

  public static void mostraReceita(ReceitaMedica receitaMedica){
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println();
    saidaTexto.println(receitaMedica.geraRelatorio());
  }

}
