package br.com.uem.poo.clinica.menu.secretaria;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.ConsultaGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.leitor.CapturaPacienteUtil;

import java.io.PrintStream;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class SubMenuConsulta implements Menu {
  @Override
  public void showMenu() {

  }
//
//  private static final PrintStream saidaTexto = System.out;
//  private static final Scanner leitor = new Scanner(System.in);
//
//  private ConsultaGerenciamento consultaGerenciamento = new ConsultaGerenciamento();
//
//  @Override
//  public void showMenu() {
//    int op = 0;
//
//    do {
//      saidaTexto.println("- CONSULTA");
//      saidaTexto.print(topicosConsulta());
//      saidaTexto.print("Digite a opção: ");
//
//      op = leitor.nextInt();
//
//      executaOperacao(op);
//    }while (op!=4);
//
//  }
//
//  private String topicosConsulta(){
//    StringBuffer sb = new StringBuffer();
//
//    sb.append("   1- Cadastrar consulta\n");
//    sb.append("   2- Atualizar consulta\n");
//    sb.append("   3- Remove consulta\n");
//    sb.append("   4- Sair\n");
//
//    return sb.toString();
//  }
//
//  private void executaOperacao(int op){
//    saidaTexto.println("---------------------\n");
//
//    switch (op){
//      case 1:
//        adicionaConsulta();
//        break;
//      case 2:
//        listaConsulta();
//        break;
//      case 3:
//        atualizaConsulta();
//        break;
//      case 4:
//        removeConsulta();
//        break;
//    }
//
//    saidaTexto.println("\n---------------------\n");
//
//  }
//
//  private void adicionaConsulta(){
//
//    try {
//      Paciente paciente = CapturaPacienteUtil.inseriCamposPaciente();
//
//      consultaGerenciamento.adicionaConsulta(paciente);
//
//      saidaTexto.println("Sucesso ao cadastar usuário !!!!");
//    } catch (ParseException e) {
//      saidaTexto.print(e);
//      saidaTexto.println(" - Erro ao cadastar o usuário :(");
//    }
//
//  }
//
//  private void atualizaConsulta(){
//
//    listaConsulta();
//
//    if(consultaGerenciamento.listaPacientes().isEmpty()){
//      return;
//    }
//
//    saidaTexto.println("-------");
//    saidaTexto.print("Escolha um id: ");
//
//    Long id = leitor.nextLong();
//
//    try {
//      Paciente paciente = CapturaPacienteUtil.inseriCamposPaciente();
//      paciente.setId(id);
//
//      consultaGerenciamento.atualizaPaciente(paciente);
//
//      saidaTexto.println("Sucesso ao atualizar o usuário !!!!");
//    } catch (ParseException e) {
//      saidaTexto.print(e);
//      saidaTexto.println("- Erro ao atualizar usuário :(");
//    }
//
//  }
//
//  private void removeConsulta(){
//    listaConsulta();
//
//    if(consultaGerenciamento.listaPacientes().isEmpty()){
//      return;
//    }
//
//    saidaTexto.println("-------");
//    saidaTexto.print("Escolha um id: ");
//
//    Long id = leitor.nextLong();
//
//    consultaGerenciamento.removePaciente(id);
//    saidaTexto.println("Sucesso ao remover usuário !!!!");
//  }
//
//  private void listaConsulta(){
//    List<Paciente> pacientes = consultaGerenciamento.listaPacientes();
//
//    if(pacientes.size()==0){
//      saidaTexto.println("  Lista vazia !!!!");
//    }else{
//      CapturaPacienteUtil.listaPacientes(pacientes);
//    }
//
//  }

}
