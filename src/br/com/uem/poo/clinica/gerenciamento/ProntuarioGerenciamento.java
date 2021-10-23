package br.com.uem.poo.clinica.gerenciamento;

import br.com.uem.poo.clinica.entidade.Prontuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProntuarioGerenciamento {
  private static final List<Prontuario> consultas = new ArrayList<>();

  public void adicionaProntuario(Prontuario consulta){
    consulta.setId(Prontuario.getNumeroDeProntuarios()+1L);

    Prontuario.setNumeroDeProntuarios(Prontuario.getNumeroDeProntuarios()+1L);

    consultas.add(consulta);
  }

  public List<Prontuario> listaProntuario(){
    return consultas;
  }
  public List<Prontuario> listaProntuarioPeloNomeDoMedico(String nomeDoMedico){
    return consultas.stream()
            .filter(p -> p.getNomeMedico().equals(nomeDoMedico))
            .collect(Collectors.toList());
  }

  public Prontuario buscaProntuarioPeloId(Long id){
    Prontuario consulta;
    int indexOf;

    indexOf = buscaIndexProntuarioPeloId(id);

    if(indexOf==-1){
      consulta = null;
    }else{
      consulta = consultas.get(indexOf);
    }

    return consulta;
  }

  public boolean existeProntuarioComId(Long id){
    int indexOf;

    indexOf = buscaIndexProntuarioPeloId(id);

    return indexOf!=-1;
  }

  public void atualizaProntuario(Prontuario consulta){
    int indexOf;

    indexOf = buscaIndexProntuarioPeloId(consulta.getId());

    if(indexOf==-1){
      throw new RuntimeException("Id não encontrado");
    }else{
      consultas.set(indexOf, consulta);
    }

  }

  public void removeProntuario(Long id){
    int indexOf;

    indexOf = buscaIndexProntuarioPeloId(id);

    if(indexOf==-1){
      throw new RuntimeException("Id não encontrado");
    }else{
      consultas.remove(indexOf);
    }

  }

  private int buscaIndexProntuarioPeloId(Long id){

    List<Long> idList = consultas.stream()
            .map(Prontuario::getId)
            .collect(Collectors.toList());

    return idList.indexOf(id);
  }

}
