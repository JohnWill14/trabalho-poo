package br.com.uem.poo.clinica.menu.secretaria;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.camposentidade.CamposPacienteUtil;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class SubMenuPaciente implements Menu {
  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  private PacienteGerenciamento pacienteGerenciamento = new PacienteGerenciamento();

  public SubMenuPaciente() {
    super();
  }

  @Override
  public void showMenu() {
    int op = 0;

    do {
        saidaTexto.println("- PACIENTE");
        saidaTexto.print(topicoPaciente());
        saidaTexto.print("Digite a opção: ");

        op = Integer.parseInt(leitor.nextLine());
        try {
          executaOperacao(op);
        }catch (RuntimeException e){
          saidaTexto.println(e.getMessage());
        }
      }while (op!=5);
  }

  private String topicoPaciente(){
    int op = 0;
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Cadastrar paciente\n");
    sb.append("   2- Lista paciente\n");
    sb.append("   3- Atualiza paciente\n");
    sb.append("   4- Remove paciente\n");
    sb.append("   5- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){
    saidaTexto.println("---------------------\n");

    switch (op){
      case 1:
        adicionaPaciente();
        break;
      case 2:
        listaPaciente();
        break;
      case 3:
        atualizaPaciente();
        break;
      case 4:
        removePaciente();
        break;
    }

    saidaTexto.println("\n---------------------\n");

  }

  private void adicionaPaciente(){

    try {
      Paciente paciente = CamposPacienteUtil.inseriCamposPaciente();

      pacienteGerenciamento.adicionaPaciente(paciente);

      saidaTexto.println("Sucesso ao cadastar usuário !!!!");
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }

  }

  private void atualizaPaciente(){

    listaPaciente();

    if(pacienteGerenciamento.listaPacientes().isEmpty()){
      throw new RuntimeException("Lista vazia nao e possivel continuar a atualizacao");
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());


    Paciente paciente = null;
    try {
      if(!pacienteGerenciamento.existePacienteComId(id)){
        throw new RuntimeException("Id inexistente");
      }

      paciente = CamposPacienteUtil.inseriCamposPaciente();
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }

    paciente.setId(id);

    pacienteGerenciamento.atualizaPaciente(paciente);

    saidaTexto.println("Sucesso ao atualizar o usuário !!!!");
  }

  private void removePaciente(){
    listaPaciente();

    if(pacienteGerenciamento.listaPacientes().isEmpty()){
      throw new RuntimeException("Lista vazia nao e possivel continuar a remocao");
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());
    try {
      if (!pacienteGerenciamento.existePacienteComId(id)) {
        throw new RuntimeException("Id inexistente");
      }

      pacienteGerenciamento.removePaciente(id);
      saidaTexto.println("Sucesso ao remover usuário !!!!");
    }catch (RuntimeException e){
      throw new RuntimeException("Erro "+e.getMessage());
    }
  }

  private void listaPaciente(){
    List<Paciente> pacientes = pacienteGerenciamento.listaPacientes();

    if(pacientes.size()==0){
      saidaTexto.println("*  Lista vazia");
    }else{
      CamposPacienteUtil.listaPacientes(pacientes);
    }

  }
  }
