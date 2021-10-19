package br.com.uem.poo.clinica.gerenciamento;

import br.com.uem.poo.clinica.entidade.Paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteGerenciamento {
  private static final List<Paciente> pacientes = new ArrayList<>();

  public void adicionaPaciente(Paciente paciente){
    pacientes.add(paciente);
  }

  public List<Paciente> listaPacientes(){
    return pacientes;
  }

  public Paciente buscaPacientePeloId(Long id){
    Paciente paciente;
    int indexOf;

    indexOf = buscaIndexPacientePeloId(id);

    if(indexOf==-1){
      paciente = null;
    }else{
      paciente = pacientes.get(indexOf);
    }

    return paciente;
  }

  public boolean existePacienteComId(Long id){
    int indexOf;

    indexOf = buscaIndexPacientePeloId(id);

    return indexOf!=-1;
  }

  public void atualizaPaciente(Paciente paciente){
    int indexOf;

    indexOf = buscaIndexPacientePeloId(paciente.getId());

    if(indexOf==-1){
      throw new RuntimeException("Id não encontrado");
    }else{
      pacientes.set(indexOf, paciente);
    }

  }

  public void removePaciente(Long id){
    int indexOf;

    indexOf = buscaIndexPacientePeloId(id);

    if(indexOf==-1){
      throw new RuntimeException("Id não encontrado");
    }else{
      pacientes.remove(indexOf);
    }

  }

  private int buscaIndexPacientePeloId(Long id){

    List<Long> idList = pacientes.stream()
            .map(Paciente::getId)
            .collect(Collectors.toList());

    return idList.indexOf(id);
  }

}
