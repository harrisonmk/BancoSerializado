package ModeloDao;

import Modelo.Pessoa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import controle.Deserealizar;
import controle.Serelizalizar;
import java.io.Serializable;

/**
 *
 * @author Harrison
 */
public class PessoaDao implements Serializable {

    Scanner scan = new Scanner(System.in);
    Serelizalizar s = new Serelizalizar();
    Deserealizar d = new Deserealizar();
    String msg;
    Pessoa buscaPessoa;

    public void adiciona(ArrayList<Pessoa> pessoas) throws IOException, Exception {

        System.out.print("\nDigite seu nome: ");
        String nome = scan.nextLine();
        System.out.print("Digite sua data de nascimento: ");
        String data = scan.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = scan.nextLine();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setDate(data);
        pessoa.setCpf(cpf);
        pessoas.add(pessoa);
        
        try {
            s.serializar("pessoas.dat", pessoas);

        } catch (Exception ex) {
            System.err.println("Falha ao serializar ! - " + ex.toString());
        }

    }

    public void verificaDadosBanco(ArrayList<Pessoa> pessoas) {
        System.out.println("\nDigite seu CPF:");
        String number = scan.nextLine();
        //scan.nextLine();

        Pessoa k = null;

        for (int i = 0; i < pessoas.size(); i++) {
            Pessoa pu = pessoas.get(i);

            if (pu.getCpf().equals(number)) {
                k = pu;
                System.out.println(k.obterInfo());

                break;
            } else {
                k = null;

            }
        }

        msg = (k != null) ? "Transação realizada\n" : "Conta nao cadastrada";
        System.out.println("\n" + msg);
    }

    public void removePessoa(ArrayList<Pessoa> pessoas) {

        System.out.print("\nDigite seu cpf: ");
        String k = scan.nextLine();

        Pessoa RemoverPessoa = null;

        for (Pessoa ca : pessoas) {

            if (ca.getCpf().equals(k)) {

                RemoverPessoa = ca;

            }

        }
        String msg = pessoas.remove(RemoverPessoa) ? "Usuario Removido" : "Usuario nao existe";
        System.out.println("\n" + msg);

    }

    public Pessoa buscarPessoa(ArrayList<Pessoa> pessoas) {
        System.out.println("\nDigite o CPF para buscar: ");
        String busca = scan.nextLine();

        for (Pessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(busca)) {
                buscaPessoa = pessoa;
                break;
            } else {
                buscaPessoa = null;

            }
        }
        if (buscaPessoa == null) {

            return null;
        } else {
            return buscaPessoa;
        }
    }

public void deserializar(ArrayList<Pessoa> pessoas) throws FileNotFoundException, Exception {

        try {
            pessoas = (ArrayList<Pessoa>) d.deserializar("pessoas.dat");
           // for (Pessoa f : pessoas) {
             //   System.out.println("\n" + f.obterInfo() + "\n");
            //}
        } catch (Exception ex) {
            System.err.println("Falha ou deserializar! - " + ex.toString());
        }
             
}    

    public void mostrarpessoas(ArrayList<Pessoa> pessoas) throws FileNotFoundException, Exception {

        if (pessoas.isEmpty()) {

            System.out.println("\nLista Vazia");
        } else {

            for (Pessoa p : pessoas) {
                System.out.println(p);
            }

        }
    }

}
