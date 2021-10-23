package br.com.uem.poo.clinica.gerenciamento;

import br.com.uem.poo.clinica.entidade.Contato;
import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PacienteGerenciamento {
  private static final List<Paciente> pacientes = new ArrayList<>();

  static{
    Contato.ContatoBuilder cb = new Contato.ContatoBuilder();
    Paciente.PacienteBuilder pb = new Paciente.PacienteBuilder();

    cb.cidade("juruaia");
    cb.telefone("(77) 4544-7854");
    cb.bairro("bairro");
    cb.email("contato@gmail.com");

    pb.id(1L);
    pb.nome("John William");
    pb.sexo('M');
    pb.estadoCivil("Solteiro");
    pb.dataNascimento(DateTimeUtil.converteStringParaLocalDate("07/07/1957", "dd/MM/yyyy"));
    pb.tipoConvenio("Particular");
    pb.contato(cb.build());

    pacientes.add(pb.build());
    Paciente.setNumeroPaciente(Paciente.getNumeroPaciente()+1l);

  }

  public void adicionaPaciente(Paciente paciente){
    paciente.setId(Paciente.getNumeroPaciente()+1l);
    Paciente.setNumeroPaciente(Paciente.getNumeroPaciente()+1l);
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
      Paciente pacienteOriginal = pacientes.get(indexOf);
      paciente.setDadosAdicionais(pacienteOriginal.getDadosAdicionais());
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
