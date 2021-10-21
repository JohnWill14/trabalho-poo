package br.com.uem.poo.clinica.util.camposentidade;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class CamposConsultaUtil {
    private static final PrintStream saidaTexto = System.out;
    private static final Scanner leitor = new Scanner(System.in);

    private static PacienteGerenciamento pacienteGerenciamento = new PacienteGerenciamento();

    public static Consulta inseriCamposConsulta(Paciente paciente)  {
        Consulta.ConsultaBuild cb = new Consulta.ConsultaBuild();

        cb.paciente(paciente);

        saidaTexto.print("Inseri o nome do medico: ");
        cb.nomeMedico(leitor.nextLine());

        saidaTexto.print("Inseri o dia e o horario da consulta no formato \"dia-mes-ano hora:minutos\": ");
        try{
            LocalDateTime localDateTime = DateTimeUtil.converteStringParaLocalDateTime(leitor.nextLine(), "dd-MM-yyyy HH:mm");
            cb.diaHorario(localDateTime);
        }catch (Exception e){
            throw new RuntimeException("Nao foi possivel converter data");
        }

        saidaTexto.print("Inseri a duracao da consulta:  \n\t[1] - Longa\n\t[2] - Curta \n");
        int duracaoSelecionada = Integer.parseInt(leitor.nextLine());
        int duracao;
        if(duracaoSelecionada==1){
            duracao = 60;
        }else{
            duracao = 30;
        }
        cb.duracao(duracao);

        return cb.build();

    }

    public static void listaConsultasPeloDia(List<Consulta> listaConsulta, LocalDate data){
        saidaTexto.println("Lista Consultas:");

        if(listaConsulta.size()==0){
            saidaTexto.println("* lista vazia");
        }
        else {
            for (Consulta c : listaConsulta) {
                LocalDate localDate = c.getDiaHorario().toLocalDate();

                if (localDate.equals(data)) {
                    mostraConsulta(c);
                }
            }
        }
    }

    public static void mostraConsulta(Consulta consulta){
       String dataString;
       try{
            dataString = DateTimeUtil.converteLocalDateTimeParaString(consulta.getDiaHorario(), "dd/MM/yyyy - HH:mm");
        }catch (Exception e){
            throw new RuntimeException("Nao foi possivel converter data");
        }
        saidaTexto.printf("[%d] - paciente: %s, medico: %s, duração: %d, Data/Horario: %s\n",
                consulta.getId(),
                consulta.getPaciente().getNome(),
                consulta.getNomeMedico(),
                consulta.getDuracao(),
                dataString
                );
    }
}
