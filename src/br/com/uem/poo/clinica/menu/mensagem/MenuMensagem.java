package br.com.uem.poo.clinica.menu.mensagem;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.entidade.Contato;
import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.ConsultaGerenciamento;
import br.com.uem.poo.clinica.mensagem.email.EmailMensagem;
import br.com.uem.poo.clinica.mensagem.sms.SmsMensagem;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuMensagem implements Menu {

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- CONSULTA");
      saidaTexto.print(topicosMensagem());
      saidaTexto.print("Digite a opção: ");

      op = Integer.parseInt(leitor.nextLine());

      try {
        executaOperacao(op);
      }catch (RuntimeException e){
        saidaTexto.println(e.getMessage());
      }
    }while (op!=2);

  }

  private String topicosMensagem(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Avisa paciente sobre consulta\n");
    sb.append("   2- Sair\n");

    return sb.toString();
  }

  private void executaOperacao( int op ){
    if(op==1){
      LocalDate localDate;
      int opEnvio;

      saidaTexto.println("Escolha a forma de envio:");
      saidaTexto.println("    [1] - Email");
      saidaTexto.println("    [2] - SMS");
      opEnvio = Integer.parseInt(leitor.nextLine());
      saidaTexto.println("Insira a data para a consulta(dd/MM/yyyy):");

      try{
        localDate = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
      }catch (Exception e){
        throw new RuntimeException("Nao foi possivel converter data");
      }
      ConsultaGerenciamento consultaGerenciamento = new ConsultaGerenciamento();

      List<Consulta> consultas = consultaGerenciamento.listaConsultaPelaData(localDate);

      if(opEnvio==1) {
        notificaPacientePorEmail(consultas);
      }else if(opEnvio==2){
        notificaPacientePorTelefone(consultas);
      }

    }
  }

  public void notificaPacientePorEmail(List<Consulta> consultas){
    saidaTexto.println("Insira o e-mail do remetente:");
    String remetente = leitor.nextLine();

    String assunto = "Lembrete da consulta";
    EmailMensagem emailMensagem = new EmailMensagem();

    for (Consulta c : consultas) {
      Paciente paciente = c.getPaciente();
      Contato contato = paciente.getContato();

      emailMensagem.setEmailDestinatario(contato.getEmail());
      emailMensagem.setAssunto(assunto);
      emailMensagem.setCorpoDoTexto(geraMensagemPaciente(c));
      emailMensagem.setEmailRemetente(remetente);

      emailMensagem.enviaMensagem();
      System.out.println();
    }
  }

  public void notificaPacientePorTelefone(List<Consulta> consultas){
    saidaTexto.println("Insira o telefone do remetente:");
    String remetente = leitor.nextLine();

    SmsMensagem smsMensagem = new SmsMensagem();

    for (Consulta c : consultas) {
      Paciente paciente = c.getPaciente();
      Contato contato = paciente.getContato();

      smsMensagem.setTelefoneDestinatario(contato.getTelefone());
      smsMensagem.setMensagem(geraMensagemPaciente(c));
      smsMensagem.setTelefoneDestinatario(remetente);

      smsMensagem.enviaMensagem();
      System.out.println("\n");
    }
  }

  public String geraMensagemPaciente(Consulta consulta){
    StringBuilder sb = new StringBuilder();
    LocalDateTime diaHorario = consulta.getDiaHorario();

    sb.append("Vim aqui para lembrar da sua consulta ;)\n");
    sb.append("Sua consulta ficou marcada para as "+diaHorario.getHour()+":"+diaHorario.getMinute());
    sb.append(" com o medico "+ consulta.getNomeMedico());
    sb.append(" a consulta irá demorar em torno de  "+ consulta.getDuracao()+" min.\n");

    return sb.toString();
  }


}
