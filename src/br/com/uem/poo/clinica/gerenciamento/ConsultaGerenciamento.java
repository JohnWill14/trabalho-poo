package br.com.uem.poo.clinica.gerenciamento;

import br.com.uem.poo.clinica.entidade.Consulta;
import br.com.uem.poo.clinica.entidade.Paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaGerenciamento {
  private static final List<Consulta> consultas = new ArrayList<>();

  public void adicionaConsulta(Consulta consulta){
    consulta.setId(Consulta.getNumeroConsulta()+1L);

    Consulta.setNumeroConsulta(Consulta.getNumeroConsulta()+1L);

    consultas.add(consulta);
  }

  public List<Consulta> listaConsulta(){
    return consultas;
  }

  public List<Consulta> listaConsultaPelaData(LocalDateTime ldt){
    return consultas.stream()
            .filter(c -> c.getDiaHorario().equals(ldt))
            .collect(Collectors.toList());
  }

  public List<Consulta> listaConsultaPelaData(LocalDate ldt){
    return consultas.stream()
            .filter(c -> c.getDiaHorario().toLocalDate().equals(ldt))
            .collect(Collectors.toList());
  }


  public List<Consulta> listaConsultaPeloEmail(String email){
    return consultas.stream()
            .filter(c -> c.getPaciente().getContato().getEmail().equals(email))
            .sorted(Comparator.comparing(Consulta::getDiaHorario).reversed())
            .collect(Collectors.toList());
  }

  public List<Consulta> listaConsultaPeloMesAno(Integer numeroMes, Integer ano){
    return consultas.stream()
            .filter(c->c.getDiaHorario().getMonthValue()==numeroMes)
            .filter(c->c.getDiaHorario().getYear()==ano)
            .sorted(Comparator.comparing(Consulta::getDiaHorario).reversed())
            .collect(Collectors.toList());
  }

  public List<Consulta> listaConsultaPeloMedicoEPeloMesAno(String nomeMedico, Integer numeroMes, Integer ano){
    return consultas.stream()
            .filter(c -> c.getNomeMedico().equals(nomeMedico))
            .filter(c->c.getDiaHorario().getMonthValue()==numeroMes)
            .filter(c->c.getDiaHorario().getYear()==ano)
            .sorted(Comparator.comparing(Consulta::getDiaHorario).reversed())
            .collect(Collectors.toList());
  }

  public List<Paciente> listaPacientesPeloMedicoEPeloMesAno(String nomeMedico, Integer numeroMes, Integer ano){
    return consultas.stream()
            .filter(c -> c.getNomeMedico().equals(nomeMedico))
            .filter(c->c.getDiaHorario().getMonthValue()==numeroMes)
            .filter(c->c.getDiaHorario().getYear()==ano)
            .sorted(Comparator.comparing(Consulta::getDiaHorario).reversed())
            .map(Consulta::getPaciente)
            .distinct()
            .collect(Collectors.toList());
  }


  public List<Consulta> listaConsultaPeloTelefone(String telefone){
    return consultas.stream()
            .filter(c -> c.getPaciente().getContato().getTelefone().equals(telefone))
            .sorted(Comparator.comparing(Consulta::getDiaHorario).reversed())
            .collect(Collectors.toList());
  }

  public Consulta buscaConsultaPeloId(Long id){
    Consulta consulta;
    int indexOf;

    indexOf = buscaIndexConsultaPeloId(id);

    if(indexOf==-1){
      consulta = null;
    }else{
      consulta = consultas.get(indexOf);
    }

    return consulta;
  }

  public boolean existeConsultaComId(Long id){
    int indexOf;

    indexOf = buscaIndexConsultaPeloId(id);

    return indexOf!=-1;
  }

  public void atualizaConsulta(Consulta consulta){
    int indexOf;

    indexOf = buscaIndexConsultaPeloId(consulta.getId());

    if(indexOf==-1){
      throw new RuntimeException("Id não encontrado");
    }else{
      consultas.set(indexOf, consulta);
    }

  }

  public void removeConsulta(Long id){
    int indexOf;

    indexOf = buscaIndexConsultaPeloId(id);

    if(indexOf==-1){
      throw new RuntimeException("Id não encontrado");
    }else{
      consultas.remove(indexOf);
    }

  }

  private int buscaIndexConsultaPeloId(Long id){

    List<Long> idList = consultas.stream()
            .map(Consulta::getId)
            .collect(Collectors.toList());

    return idList.indexOf(id);
  }


}
