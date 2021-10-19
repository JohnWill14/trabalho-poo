package br.com.uem.poo.clinica.util.leitor;

import br.com.uem.poo.clinica.entidade.Paciente;
import br.com.uem.poo.clinica.util.DateTimeUtil;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CapturaPacienteUtil {
    private static final PrintStream saidaTexto = System.out;
    private static final Scanner leitor = new Scanner(System.in);

    public static Paciente inseriCamposPaciente() throws ParseException {
        Paciente.PacienteBuilder pb = new Paciente.PacienteBuilder();

        saidaTexto.print("Digie o nome: ");
        pb.nome(leitor.next());

        pb.contato(CapturaContatoUtil.inseriCamposContato());

        saidaTexto.print("Digie o tipo do convenio: ");
        pb.tipoConvenio(leitor.next());

        saidaTexto.print("Digie o sexo: ");
        pb.sexo(leitor.next().charAt(0));

        saidaTexto.print("Digie o estado civil(solteiro ou casado): ");
        pb.estadoCivil(leitor.next());

        saidaTexto.print("Digie a data de nascimento(dd/MM/yyyy): ");
        LocalDate localDateConvertido = DateTimeUtil.converteStringParaLocalDate(leitor.next(), "dd/MM/yyyy");
        pb.dataNascimento(localDateConvertido);

        return pb.build();
    }

    public static void listaPacientes(List<Paciente> listaPaciente){
        saidaTexto.println("Lista Pacientes:");
        for(Paciente p: listaPaciente){
            mostraPaciente(p);
        }
    }

    public static void mostraPaciente(Paciente paciente){

        saidaTexto.printf("[%d] - %s, email: %s, telefone: %s, Data nascimento: %s\n",
                paciente.getId(),
                paciente.getNome(),
                paciente.getContato().getEmail(),
                paciente.getContato().getTelefone(),
                DateTimeUtil.converteLocalDateParaString(paciente.getDataNascimento(), "dd/MM/yyyy")
                );
    }
}
