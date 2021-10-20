package br.com.uem.poo.clinica.menu.secretaria;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.gerenciamento.ConsultaGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.DateTimeUtil;
import br.com.uem.poo.clinica.util.camposentidade.CamposConsultaUtil;

import java.io.PrintStream;
import java.text.ParseException;
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

      executaOperacao(op);
    }while (op!=5);

  }

  private String topicosConsulta(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Cadastrar consulta\n");
    sb.append("   2- Relátorio busca consulta pela data\n");
    sb.append("   3- Atualizar consulta\n");
    sb.append("   4- Remove consulta\n");
    sb.append("   5- Sair\n");

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
    }

    saidaTexto.println("\n---------------------\n");

  }

  private void adicionaConsulta(){

    try {
      Consulta consulta = CamposConsultaUtil.inseriCamposConsulta();

      consultaGerenciamento.adicionaConsulta(consulta);

      saidaTexto.println("Sucesso ao cadastar consulta !!!!");

    } catch (Exception e) {
      saidaTexto.print(e);
      saidaTexto.println(" - Erro ao cadastar a consulta");
    }

  }

  private void atualizaConsulta(){

    listaConsulta();

    if(consultaGerenciamento.listaConsulta().isEmpty()){
      return;
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());

    try {
      Consulta consulta = CamposConsultaUtil.inseriCamposConsulta();
      consulta.setId(id);

      consultaGerenciamento.atualizaConsulta(consulta);

      saidaTexto.println("Sucesso ao atualizar a consulta !!!!");
    } catch (Exception e) {
      saidaTexto.print(e);
      saidaTexto.println("- Erro ao atualizar a consulta");
    }

  }

  private void removeConsulta(){
    listaConsulta();

    if(consultaGerenciamento.listaConsulta().isEmpty()){
      return;
    }

    saidaTexto.println("-------");
    saidaTexto.print("Escolha um id: ");

    Long id = Long.parseLong(leitor.nextLine());

    try {
      consultaGerenciamento.removeConsulta(id);
      saidaTexto.println("Sucesso ao remover consulta !!!!");
    } catch (Exception e) {
      saidaTexto.print(e);
      saidaTexto.println("- Erro ao atualizar a consulta");
    }
  }

  private void listaConsulta(){
    List<Consulta> consultas = consultaGerenciamento.listaConsulta();

    try {
      if(consultas.size()==0){
        saidaTexto.println("  Lista vazia !!!!");
      }else{
        saidaTexto.print("Digie o dia das consultas no seguinte formato \"dd/MM/yyyy\": ");
        LocalDate localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
        CamposConsultaUtil.listaConsultasPeloDia(consultas, localDateConvertido);
      }
    } catch (Exception e) {
      saidaTexto.print(e);
      saidaTexto.println("- Erro");
    }

  }

}
