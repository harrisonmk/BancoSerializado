
package controle;


import java.io.IOException;


public class Main {

  
    public static void main(String[] args) throws IOException, Exception {
           
        Banco b = new Banco();
        b.salvarTxt();
        MenuEnum opcao = new MenuEnum(); 
   
        opcao.usandoMenu();
       
    }
    
}
