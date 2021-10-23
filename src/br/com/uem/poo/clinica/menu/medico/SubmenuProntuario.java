package br.com.uem.poo.clinica.menu.medico;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.entidade.Prontuario;
import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.gerenciamento.ProntuarioGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.entidades.PacienteUtil;
import br.com.uem.poo.clinica.util.entidades.ProntuarioUtil;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class SubmenuProntuario implements Menu {

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  private ProntuarioGerenciamento prontuarioGerenciamento = new ProntuarioGerenciamento();

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- PRONTUARIO PACIENTE");
      saidaTexto.print(topicosProntuarioMedico());
      saidaTexto.print("Digite a opção: ");

      op = Integer.parseInt(leitor.nextLine());

      try {
        executaOperacao(op);
      }catch (RuntimeException e){
        saidaTexto.println(e.getMessage());
      }
    }while (op!=5);

  }

  private String topicosProntuarioMedico(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Cadastrar prontuario\n");
    sb.append("   2- Lista prontuario\n");
    sb.append("   3- Atualiza prontuario\n");
    sb.append("   4- Remove prontuario\n");
    sb.append("   5- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){
    Paciente paciente = null;
    if(op!=5){
      paciente = selecionaPaciente();
    }

    saidaTexto.println("---------------------\n");

    switch (op){
      case 1:
        adicionaProntuario(paciente);
        break;
      case 2:
        listaProntuario(paciente);
        break;
      case 3:
        atualizaProntuario(paciente);
        break;
      case 4:
        removeProntuario(paciente);
        break;
    }

    saidaTexto.println("\n---------------------\n");
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

  public void adicionaProntuario(Paciente paciente){
    Prontuario prontuario = ProntuarioUtil.inseriCamposProntuario(paciente);

    prontuarioGerenciamento.adicionaProntuario(prontuario);

    saidaTexto.println("Sucesso ao inserir dado");
  }

  public void listaProntuario(Paciente paciente){
    ProntuarioUtil.listaProntuariosPeloPaciente(paciente, prontuarioGerenciamento.listaProntuario());
  }

  public void atualizaProntuario(Paciente paciente){
    listaProntuario(paciente);

    if(prontuarioGerenciamento.listaProntuario().isEmpty()){
      throw new RuntimeException("Lista vazia nao e possivel continuar a atualizacao");
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());

    Prontuario prontuario = null;
    try {
      if(!prontuarioGerenciamento.existeProntuarioComId(id)){
        throw new RuntimeException("Id inexistente");
      }

      prontuario = ProntuarioUtil.inseriCamposProntuario(paciente);
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }

    prontuario.setId(id);

    prontuarioGerenciamento.atualizaProntuario(prontuario);

    saidaTexto.println("Sucesso ao atualizar !!!");
  }

  public void removeProntuario(Paciente paciente){
    listaProntuario(paciente);

    if(prontuarioGerenciamento.listaProntuario().isEmpty()){
      throw new RuntimeException("Lista vazia nao e possivel continuar a remocao");
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());
    try {
      if (!prontuarioGerenciamento.existeProntuarioComId(id)) {
        throw new RuntimeException("Id inexistente");
      }

      prontuarioGerenciamento.removeProntuario(id);
      saidaTexto.println("Sucesso ao remover prontuario !!!!");
    }catch (RuntimeException e){
      throw new RuntimeException("Erro "+e.getMessage());
    }
  }

}
