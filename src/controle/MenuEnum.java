package controle;

import static controle.OpcaoMenu.menuEscolhido;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuEnum implements Serializable {

    Scanner scan = new Scanner(System.in);

    Banco banco = new Banco();

    public void usandoMenu() throws IOException, Exception {

        while (true) {
            try {
                menu1();
                int opcao = scan.nextInt();
                scan.nextLine();

                switch (menuEscolhido(opcao)) {
                    case CADASTRAR:
                        banco.cadastrar();
                        break;
                    case CRIAR_CONTA:
                        banco.criarConta();

                        break;

                    case DADOS_BANCARIOS:
                        banco.dadosBancarios();
                        break;

                    case VISUALIZAR_SALDO:
                        banco.visualizarSaldo();
                        break;

                    case DEPOSITO:
                        banco.depositar();
                        break;
                    case SACAR:
                        banco.sacar();
                        break;
                    case TRANSFERIR:
                        banco.transferir();
                        break;
                    case Excluir_Conta:
                        banco.removerConta();
                        break;
                    case DESEREALIZAR:
                        banco.salvarTxt();
                        break;
                    case Mostrar_Pessoas:
                    banco.mostrarPessoa();
                    break;
                    //case DESEREALIZAR:
                      //    banco.deserelializar();
                        //    break;
                    case SAIR:
                        System.exit(0);
                        break;

                }
            } catch (NullPointerException e) {
                System.err.println(e);
            }catch (InputMismatchException e){
                scan.nextLine();
                System.err.println(e);
            }
        }
    }



    public void menu1() {
        System.out.println("\n******MENU*******");
        System.out.println("1 Cadastrar");
        System.out.println("2 Criar Conta");
        System.out.println("3 Dados Bancarios");
        System.out.println("4 Visualizar Saldo");
        System.out.println("5 Depositar");
        System.out.println("6 Sacar");
        System.out.println("7 Transferencia");
        System.out.println("8 Excluir Conta");
        System.out.println("0 Sair.");
        System.out.print("Opcao: ");

    }

}
