package controle;

import ModeloDao.ContaDao;
import ModeloDao.PessoaDao;
import Modelo.Pessoa;
import Modelo.Conta;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Harrison
 */
public class Banco {

    public final String caminho =" ";
    PessoaDao pessoaDao = new PessoaDao();
    ContaDao contaDao = new ContaDao();

    ArrayList<Conta> lista = new ArrayList<>();
    ArrayList<Pessoa> lista1 = new ArrayList<>();

    
    public void cadastrar() throws IOException {
        pessoaDao.adiciona(lista1);
    }

    public void criarConta() {
       // contaDao.adicionarConta(lista, lista1,pessoaDao);
       contaDao.setConta(lista, lista1, pessoaDao);
    }

    public void dadosBancarios() {
        pessoaDao.verificaDadosBanco(lista1);
    }

    public void visualizarSaldo() {
        contaDao.verificaSaldoBanco(lista);
    }

    public void depositar() {
        contaDao.depositaBanco(lista);
    }

    public void sacar() {
        contaDao.sacaBanco(lista);
    }

    public void transferir() {
        contaDao.verificaSaldoBanco(lista);
    }

    public void removerConta() {
        contaDao.remover(lista);
    }

    public void salvarTxt() throws IOException, Exception{
        
        
        
        pessoaDao.deserializar(lista1);
        contaDao.deserializar(lista);
       
    }
    
    public void mostrarPessoa() throws FileNotFoundException{
        
     pessoaDao.mostrarpessoas(lista1);
     
    }
    
    
}
