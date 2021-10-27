package br.com.uem.poo.clinica.menu.medico;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.ConsultaGerenciamento;
import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.relatorio.medico.*;
import br.com.uem.poo.clinica.util.io.entidades.PacienteUtil;
import br.com.uem.poo.clinica.util.io.relatorios.*;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class SubMenuRelatorio implements Menu {

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- RELATORIO");
      saidaTexto.print(topicosRelatorio());
      saidaTexto.print("Digite a opção: ");

      op = Integer.parseInt(leitor.nextLine());

      try {
        executaOperacao(op);
      }catch (RuntimeException e){
        saidaTexto.println(e.getMessage());
      }
    }while (op!=6);

  }

  private String topicosRelatorio(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Receita Medica \n");
    sb.append("   2- Atestado \n");
    sb.append("   3- Declaração de acompanhamento\n");
    sb.append("   4- Consultas feitas por mês\n");
    sb.append("   5- Clientes atendidos por mês\n");
    sb.append("   6- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){
    saidaTexto.println("---------------------\n");

    switch (op){
      case 1:
        geraReceita();
        break;
      case 2:
        geraAtestado();
        break;
      case 3:
        geraDeclarcaoDeAcompanhamento();
        break;
      case 4:
        gerarRelatorioDeConsultas();
        break;
      case 5:
        gerarRelatorioDePacientesConsultados();
        break;
    }

    saidaTexto.println("\n---------------------\n");
  }

  public void geraReceita(){
    Paciente paciente = selecionaPaciente();

    ReceitaMedica receitaMedica = ReceitaMedicaUtil.inseriDadosReceitaMedica(paciente);

    ReceitaMedicaUtil.mostraReceita(receitaMedica);

  }

  public void geraAtestado(){
    Paciente paciente = selecionaPaciente();

    AtestadoMedico atestadoMedico = AtestadoMedicoUtil.inseriDadosAtestadoMedico(paciente);

    AtestadoMedicoUtil.mostraAtestadoMedico(atestadoMedico);

  }


  public void geraDeclarcaoDeAcompanhamento(){
    Paciente paciente = selecionaPaciente();

    DeclaracaoDeAcompanhamento declaracaoDeAcompanhamento = DeclaracaoDeAcompanhanteUtil.inseriDadosDeclaracaoDeAcompanhamento(paciente);

    DeclaracaoDeAcompanhanteUtil.mostraDeclaracaoDeAcompanhamento(declaracaoDeAcompanhamento);

  }

  public void gerarRelatorioDeConsultas(){

    System.out.println("Insira o número do mes: ");
    int mes = Integer.parseInt(leitor.nextLine());

    System.out.println("Insira o ano(yyyy): ");
    int ano = Integer.parseInt(leitor.nextLine());

    ConsultaGerenciamento consultaGerenciamento = new ConsultaGerenciamento();
    List<Consulta> consultas = consultaGerenciamento.listaConsultaPeloMesAno(mes, ano);

    ConsultasRealizadas consultasRealizadas = new ConsultasRealizadas(consultas);

    ConsultasRealizadasUtil.mostraPacientesAtendidos(consultasRealizadas);
  }

  public void gerarRelatorioDePacientesConsultados(){
    System.out.println("Insira o nome do medico: ");
    String nomeMedico = leitor.nextLine();

    System.out.println("Insira o número do mes: ");
    int mes = Integer.parseInt(leitor.nextLine());


    System.out.println("Insira o ano(yyyy): ");
    int ano = Integer.parseInt(leitor.nextLine());

    ConsultaGerenciamento consultaGerenciamento = new ConsultaGerenciamento();
    List<Paciente> pacientes = consultaGerenciamento.listaPacientesPeloMedicoEPeloMesAno(nomeMedico, mes, ano);

    PacientesAtendidos pacientesAtendidos = new PacientesAtendidos(nomeMedico, pacientes);

    PacientesAtendidosUtil.mostraCPacientesAtendidos(pacientesAtendidos);
  }


  private Paciente selecionaPaciente(){
    PacienteGerenciamento pacienteGerenciamento = new PacienteGerenciamento();
    List<Paciente> pacientes = pacienteGerenciamento.listaPacientes();

    if (pacientes.size()==0){
      throw new RuntimeException("Lista prontuarios está vazia nao e possivel continuar");
    }

    PacienteUtil.listaPacientes(pacientes);

    saidaTexto.print("Insira um id válido do paciente: ");
    Long id = Long.parseLong(leitor.nextLine());

    if(!pacienteGerenciamento.existePacienteComId(id)){
      throw new RuntimeException("Id inexistente");
    }

    return pacienteGerenciamento.buscaPacientePeloId(id);
  }

}