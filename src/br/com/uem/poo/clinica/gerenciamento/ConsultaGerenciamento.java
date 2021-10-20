package br.com.uem.poo.clinica.gerenciamento;

import br.com.uem.poo.clinica.entidade.Consulta;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaGerenciamento {
  private static final List<Consulta> consultas = new ArrayList<>();

  public void adicionaConsulta(Consulta consulta){
    consultas.add(consulta);
  }

  public List<Consulta> listaConsulta(){
    return consultas;
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
