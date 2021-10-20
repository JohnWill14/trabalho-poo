package br.com.uem.poo.clinica.util.camposentidade;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CamposPacienteUtil {
    private static final PrintStream saidaTexto = System.out;
    private static final Scanner leitor = new Scanner(System.in);

    public static Paciente inseriCamposPaciente() throws ParseException {
        Paciente.PacienteBuilder pb = new Paciente.PacienteBuilder();

        saidaTexto.print("Digite o nome: ");
        pb.nome(leitor.nextLine());

        pb.contato(CamposContatoUtil.inseriCamposContato());

        saidaTexto.print("Digite o tipo do convenio:  \n\t[1] - Particular\n\t[2] - Publico  \n");
        int convenioSelecionado = Integer.parseInt(leitor.nextLine());
        String convenio;
        if(convenioSelecionado==1){
            convenio = "Particular";
        }else{
            convenio = "Publico";
        }
        pb.tipoConvenio(convenio);

        saidaTexto.print("Digite o sexo:  \n\t[1] - Masculino\n\t[2] - Feminino \n");
        int sexoSelecionado = Integer.parseInt(leitor.nextLine());
        char sexo;
        if(sexoSelecionado==1){
            sexo = 'M';
        }else{
            sexo = 'F';
        }
        pb.sexo(sexo);

        saidaTexto.print("Digite o estado civil:  \n\t[1] - Casado\n\t[2] - Solteiro \n");
        int estadoCivilSelecionado = Integer.parseInt(leitor.nextLine());
        String estadoCivil;
        if(estadoCivilSelecionado==1){
            estadoCivil = "Casado";
        }else{
            estadoCivil = "Solteiro";
        }
        pb.estadoCivil(estadoCivil);

        saidaTexto.print("Digite a data de nascimento neste formato dia/mes/ano: ");
        try {
            LocalDate localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.nextLine(), "dd/MM/yyyy");
            pb.dataNascimento(localDateConvertido);
        }catch (Exception e){
            throw new RuntimeException("Nao foi possivel converter data");
        }

        return pb.build();
    }

    public static void listaPacientes(List<Paciente> listaPaciente){
        saidaTexto.println("Lista Pacientes:");
        for(Paciente p: listaPaciente){
            mostraPaciente(p);
        }
    }

    public static void mostraPaciente(Paciente paciente){

        try{
            String dataString = DateTimeUtil.converteLocalDateParaString(paciente.getDataNascimento(), "dd/MM/yyyy");
            saidaTexto.printf("[%d] - %s, email: %s, telefone: %s, Data nascimento: %s\n",
                    paciente.getId(),
                    paciente.getNome(),
                    paciente.getContato().getEmail(),
                    paciente.getContato().getTelefone(),
                    dataString
            );
        }catch (Exception e){
            throw new RuntimeException("Nao foi possivel converter data");
        }

    }
}
