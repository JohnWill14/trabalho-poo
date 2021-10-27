package br.com.uem.poo.clinica.menu.secretaria;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.ConsultaGerenciamento;
import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.DateTimeUtil;
import br.com.uem.poo.clinica.util.io.entidades.ConsultaUtil;
import br.com.uem.poo.clinica.util.io.entidades.PacienteUtil;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SubMenuConsulta implements Menu{

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);

  private ConsultaGerenciamento consultaGerenciamento = new ConsultaGerenciamento();

  @Override
  public void showMenu() {
    int op = 0;

    do {
      saidaTexto.println("- CONSULTA");
      saidaTexto.print(topicosConsulta());
      saidaTexto.print("Digite a opção: ");

      op = Integer.parseInt(leitor.nextLine());

      try {
        executaOperacao(op);
      }catch (RuntimeException e){
        saidaTexto.println(e.getMessage());
      }
    }while (op!=7);

  }

  private String topicosConsulta(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Cadastrar consulta\n");
    sb.append("   2- Relátorio busca consulta pela data\n");
    sb.append("   3- Atualizar consulta\n");
    sb.append("   4- Remove consulta\n");
    sb.append("   5- Exibe Consulta pelo ID\n");
    sb.append("   6- Relátorio busca consulta pelo email/telefone\n");
    sb.append("   7- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){

    saidaTexto.println("---------------------\n");

    switch (op){
      case 1:
        adicionaConsulta();
        break;
      case 2:
        listaConsulta();
        break;
      case 3:
        atualizaConsulta();
        break;
      case 4:
        removeConsulta();
        break;
      case 5:
        exibeConsulta();
        break;
      case 6:
        buscaConsultaPeloEmailOuTelefone();
        break;
    }

    saidaTexto.println("\n---------------------\n");

  }

  private void adicionaConsulta(){

    try {
      Paciente paciente = selecionaPaciente();

      Consulta consulta = ConsultaUtil.inseriCamposConsulta(paciente);

      consultaGerenciamento.adicionaConsulta(consulta);

      saidaTexto.println("Sucesso ao cadastar consulta !!!!");

    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }

  }

  private void atualizaConsulta(){

    listaConsulta();

    if(consultaGerenciamento.listaConsulta().isEmpty()){
      throw new RuntimeException("Lista vazia nao e possivel continuar a atualizacao");
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());

    try {

      Paciente paciente = selecionaPaciente();

      Consulta consulta = ConsultaUtil.inseriCamposConsulta(paciente);
      consulta.setId(id);

      consultaGerenciamento.atualizaConsulta(consulta);

      saidaTexto.println("Sucesso ao atualizar a consulta !!!!");
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }

  }

  private Paciente selecionaPaciente(){
    PacienteGerenciamento pacienteGerenciamento = new PacienteGerenciamento();
    List<Paciente> pacientes = pacienteGerenciamento.listaPacientes();

    if (pacientes.size()==0){
      throw new RuntimeException("Lista pacientes vazia nao e possivel continuar");
    }

    PacienteUtil.listaPacientes(pacientes);

    saidaTexto.print("Insira um id válido do paciente: ");
    Long id = Long.parseLong(leitor.nextLine());

    if(!pacienteGerenciamento.existePacienteComId(id)){
      throw new RuntimeException("Id inexistente");
    }

    return pacienteGerenciamento.buscaPacientePeloId(id);
  }

  private void removeConsulta(){
    listaConsulta();

    if(consultaGerenciamento.listaConsulta().isEmpty()){
      throw new RuntimeException("Lista vazia nao e possivel continuar a remocao");
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());

    try {
      consultaGerenciamento.removeConsulta(id);
      saidaTexto.println("Sucesso ao remover consulta !!!!");
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }
  }

  public void exibeConsulta(){
    saidaTexto.println("-------");
    saidaTexto.print("Insira um id: ");
    Long id = Long.parseLong(leitor.nextLine());

    try {
      Consulta consulta = consultaGerenciamento.buscaConsultaPeloId(id);

      ConsultaUtil.mostraConsultaCompleta(consulta);
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }
  }

  public void buscaConsultaPeloEmailOuTelefone(){
    saidaTexto.println("\t[1] - email \n\t[2] - telefone");
    int op = Integer.parseInt(leitor.nextLine());

    if(op!=1&&op!=2){
      throw new RuntimeException("opcao errada");
    }

    String busca;
    saidaTexto.println("Insira a chave de busca:");
    busca = leitor.nextLine();

    try {

      List<Consulta> consultas;

      if(op==1){
        consultas = consultaGerenciamento.listaConsultaPeloEmail(busca);
      }else{
        consultas = consultaGerenciamento.listaConsultaPeloTelefone(busca);
      }

      ConsultaUtil.listaConsultas(consultas);
    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }
  }

  private void listaConsulta(){
    List<Consulta> consultas = consultaGerenciamento.listaConsulta();

    try {

      saidaTexto.print("Digie o dia das consultas no seguinte formato \"dd/MM/yyyy\": ");
      LocalDate localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
      ConsultaUtil.listaConsultas(consultaGerenciamento.listaConsultaPelaData(localDateConvertido));

    } catch (Exception e) {
      throw new RuntimeException("Erro "+e.getMessage());
    }

  }

}
