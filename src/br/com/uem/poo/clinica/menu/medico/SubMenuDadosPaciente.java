package br.com.uem.poo.clinica.menu.medico;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.gerenciamento.PacienteGerenciamento;
import br.com.uem.poo.clinica.menu.Menu;
import br.com.uem.poo.clinica.util.io.entidades.DadosPacienteUtil;
import br.com.uem.poo.clinica.util.io.entidades.PacienteUtil;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class SubMenuDadosPaciente implements Menu {

  private static final PrintStream saidaTexto = System.out;
  private static final Scanner leitor = new Scanner(System.in);


  @Override
  public void showMenu() {
    int op = 0;

      do {
        saidaTexto.println("- DADOS ADICIONAIS PACIENTE");
        saidaTexto.print(topicoDadosAdicionaisSobrePaciente());
        saidaTexto.print("Digite a opção: ");

        op = Integer.parseInt(leitor.nextLine());

        try {
          executaOperacao(op);
        }catch (RuntimeException e){
          saidaTexto.println(e.getMessage());
        }
      } while (op != 5);

  }

  private String topicoDadosAdicionaisSobrePaciente(){
    StringBuffer sb = new StringBuffer();

    sb.append("   1- Cadastrar dados\n");
    sb.append("   2- Lista dados\n");
    sb.append("   3- Atualiza dados\n");
    sb.append("   4- Remove dados\n");
    sb.append("   5- Sair\n");

    return sb.toString();
  }

  private void executaOperacao(int op){
    saidaTexto.println("---------------------\n");
    Paciente paciente;

    switch (op){
      case 1:
        paciente = selecionaPaciente();
        adicionaDadosPaciente(paciente);
        break;
      case 2:
        paciente = selecionaPaciente();
        listaDadosPaciente(paciente);
        break;
      case 3:
        paciente = selecionaPaciente();
        atualizaDadosPaciente(paciente);
        break;
      case 4:
        paciente = selecionaPaciente();
        removeDadosPaciente(paciente);
        break;
    }

    saidaTexto.println("\n---------------------\n");
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

  public void adicionaDadosPaciente(Paciente paciente){
    String dados = DadosPacienteUtil.inseriCamposDadosPaciente();
    paciente.getDadosAdicionais().add(dados);
    saidaTexto.println("Sucesso ao inserir dado");
  }

  public void listaDadosPaciente(Paciente paciente){
    DadosPacienteUtil.listaDadosPaciente(paciente);
  }

  public void atualizaDadosPaciente(Paciente paciente){
    DadosPacienteUtil.listaDadosPaciente(paciente);
    saidaTexto.println("Selecione um id: ");

    int id = Integer.parseInt(leitor.nextLine());

    String dado = DadosPacienteUtil.inseriCamposDadosPaciente();

    paciente.getDadosAdicionais().set(id, dado);

    saidaTexto.println("Sucesso ao atualizar !!!");
  }

  public void removeDadosPaciente(Paciente paciente){
    DadosPacienteUtil.listaDadosPaciente(paciente);
    saidaTexto.println("Selecione um id: ");

    int id = Integer.parseInt(leitor.nextLine());

    paciente.getDadosAdicionais().remove(id);

    saidaTexto.println("Sucesso ao remover !!!");
  }

}
