package br.com.uem.poo.clinica.util.entidades;

import br.com.uem.poo.clinica.entidade.Paciente;

import java.io.PrintStream;
import java.util.Scanner;

public class DadosPacienteUtil {
    private static final PrintStream saidaTexto = System.out;
    private static final Scanner leitor = new Scanner(System.in);

    public static String inseriCamposDadosPaciente()  {
        saidaTexto.print("Digite o o item a ser inserido: ");

        return leitor.nextLine();
    }

    public static void listaDadosPaciente(Paciente paciente){
        saidaTexto.println("Lista dados do paciente "+paciente.getNome()+" :");
        if(paciente.getDadosAdicionais().size()==0){
            saidaTexto.println("* Lista Vazia");
        }else{
            int cont = 0;
            for(String dado: paciente.getDadosAdicionais()){
                saidaTexto.printf("[%d] - %s\n", cont, dado);
                cont+=1;
            }
        }
    }

}
