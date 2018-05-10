package ModeloDao;

import Modelo.Pessoa;
import Modelo.Conta;
import controle.Deserealizar;
import controle.Serelizalizar;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ContaDao implements Serializable {

    Scanner scan = new Scanner(System.in);
    Serelizalizar s = new Serelizalizar();
    Deserealizar d = new Deserealizar();
    String msg;

    public ArrayList<Conta> adicionar(ArrayList<Conta> contas) {

        //System.out.print("Digite o numero da conta: ");
        //int numconta = scan.nextInt();
        //scan.nextLine(); //limpa o buffer
        System.out.print("Digite uma senha: ");
        String senha = scan.next();
        scan.nextLine(); //limpa o buffer
        Conta c = new Conta();

        //c.setNumero(numconta);
        c.setSenha(senha);

        contas.add(c);

        return contas;
    }

    public Pessoa setConta(ArrayList<Conta> contas, ArrayList<Pessoa> pessoas, PessoaDao pe) {
        Pessoa p = pe.buscarPessoa(pessoas);

        p.setContas(this.adicionar(contas));

        try {
            s.serializar("contas.dat", contas);

        } catch (Exception ex) {
            System.err.println("Falha ao serializar ! - " + ex.toString());
        }

        return p;
    }

    public void depositaBanco(ArrayList<Conta> contas) {
        System.out.println("\nDigite o numero da conta:");
        int numero = scan.nextInt();
        Conta t = null;

        for (int i = 0; i < contas.size(); i++) {
            Conta la = contas.get(i);

            if (numero == la.getNumero()) {
                t = la;
                System.out.print("Digite o valor do deposito: ");
                double dinheiro = scan.nextDouble();
                t.depositar(dinheiro);

                break;
            } else {
                t = null;

            }
        }
        msg = (t != null) ? "Deposito Realizado Com Sucesso\n" : "Conta nao cadastrada";
        System.out.println("\n" + msg);
    }

    public void verificaSaldoBanco(ArrayList<Conta> contas) {
        System.out.println("\nDigite o numero da conta:");
        int numeto = scan.nextInt();
        scan.nextLine();

        Conta j = null;

        for (int i = 0; i < contas.size(); i++) {
            Conta pu = contas.get(i);

            if (numeto == pu.getNumero()) {
                j = pu;
                j.visualizarSaldo();
                break;
            } else {
                j = null;

            }
        }

        msg = (j != null) ? "Transação realizada\n" : "Conta nao cadastrada";
        System.out.println("\n" + msg);
    }

    public void sacaBanco(ArrayList<Conta> contas) {

        System.out.println("\nDigite o numero da conta:");
        int numero1 = scan.nextInt();
        Conta ta = null;

        for (int i = 0; i < contas.size(); i++) {
            Conta pu = contas.get(i);

            if (numero1 == pu.getNumero()) {
                ta = pu;
                System.out.print("Digite o valor do saque: ");
                double dinheiro1 = scan.nextDouble();

                ta.sacar(dinheiro1);

                break;
            } else {
                ta = null;

            }
        }

        msg = (ta != null) ? "Saque Realizado Com Sucesso\n" : "Conta nao cadastrada";
        System.out.println("\n" + msg);

    }

    public void transferirContas(ArrayList<Conta> contas) {

        System.out.println("\nDigite o numero da conta de origem: ");
        int numero2 = scan.nextInt();

        Conta j = null;

        for (int i = 0; i < contas.size(); i++) {
            Conta pu = contas.get(i);

            if (numero2 == pu.getNumero()) {
                j = pu;

                break;
            } else {
                j = null;

            }
        }

        System.out.println("\nDigite o numero da conta de Destino: ");
        int numero3 = scan.nextInt();

        Conta w = null;

        for (int i = 0; i < contas.size(); i++) {
            Conta pu = contas.get(i);

            if (numero3 == pu.getNumero()) {
                w = pu;
                System.out.println("\nDigite o valor da Transferencia:");
                double valorMoney = scan.nextDouble();

                j.transferir(w, valorMoney);
                break;
            } else {
                w = null;

            }
        }
        msg = (j != null && w != null) ? "Transferencia Realizada com Sucesso\n" : "Conta nao cadastrada";
        System.out.println("\n" + msg);
    }

    public void remover(ArrayList<Conta> contas) {

        System.out.print("\nDigite o numero da Conta: ");
        int k = scan.nextInt();

        Conta removerConta = null;

        for (int i = 0; i < contas.size(); i++) {

            Conta p = contas.get(i);

            if (p.getNumero() == k) {

                removerConta = p;

            }

        }
        String msg = contas.remove(removerConta) ? "Conta Removida" : "Conta nao existe";
        System.out.println("\n" + msg);

    }

    public void deserializar(ArrayList<Conta> contas) throws FileNotFoundException {

        try {
            contas = (ArrayList<Conta>) d.deserializar("contas.dat");
            //for (Conta f : contas) {
              //  System.out.println(f + "\n");
            //}
        } catch (Exception ex) {
            System.err.println("Falha ou deserializar! - " + ex.toString());
        }

    }

}
