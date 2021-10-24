package br.com.uem.poo.clinica.util.entidades;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.entidade.Prontuario;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProntuarioUtil {
    private static final PrintStream saidaTexto = System.out;
    private static final Scanner leitor = new Scanner(System.in);

    public static Prontuario inseriCamposProntuario(Paciente paciente)  {
      Prontuario.ProntuarioBuilder pb = new Prontuario.ProntuarioBuilder();

        pb.paciente(paciente);

        saidaTexto.print("Insira o nome do medico: ");
        pb.nomeMedico(leitor.nextLine());

        saidaTexto.print("Inseri a data da consulta no formato \"dia/mes/ano\": ");
        try{
            LocalDate dataConsulta = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
            pb.data(dataConsulta);
        }catch (Exception e){
            throw new RuntimeException("Nao foi possivel converter data");
        }

        saidaTexto.print("Insira os sintomas: ");
        pb.sintomas(leitor.nextLine());

        saidaTexto.print("Insira o diagnostico da doenca: ");
        pb.diagnosticoDoenca(leitor.nextLine());

        saidaTexto.print("Insira o tratamento da doenca: ");
        pb.tratamento(leitor.nextLine());

        return pb.build();
    }


  public static void listaProntuarios(List<Prontuario> prontuarios){
    saidaTexto.println("Lista Prontuarios:");

    if(prontuarios.size()==0){
      saidaTexto.println("* lista vazia");
    }
    else {
      for (Prontuario p : prontuarios) {
          mostraProntuarioSimples(p);
      }
    }
  }

    public static void mostraProntuarioSimples(Prontuario prontuario){
        String dataString;
        try{
            dataString = DateTimeUtil.converteLocalDateParaString(prontuario.getData(), "dd/MM/yyyy");
        }catch (Exception e){
            throw new RuntimeException("Nao foi possivel converter data");
        }
        saidaTexto.printf("[%03d] - paciente: %s, medico: %s, Data/Horario: %s\n",
                prontuario.getId(),
                prontuario.getPaciente().getNome(),
                prontuario.getNomeMedico(),
                dataString
        );
    }

  public static void mostraProntuarioCompleto(Prontuario prontuario){
    String dataString;
    try{
      dataString = DateTimeUtil.converteLocalDateParaString(prontuario.getData(), "dd/MM/yyyy");
    }catch (Exception e){
      throw new RuntimeException("Nao foi possivel converter data");
    }

    saidaTexto.printf("   Codigo: %03d\n", prontuario.getId());
    saidaTexto.printf("   Paciente: %s\n", prontuario.getPaciente().getNome());
    saidaTexto.printf("   Paciente ID: %03d\n", prontuario.getPaciente().getId());
    saidaTexto.printf("   Data: %s\n", dataString);
    saidaTexto.printf("   Sintomas: %s\n", prontuario.getSintomas());
    saidaTexto.printf("   Diagnosticos: %s\n", prontuario.getDiagnosticoDoenca());
    saidaTexto.printf("   Tratamento: %s\n", prontuario.getTratamento());
  }

}
