package controle;

public enum OpcaoMenu {

    CADASTRAR(1),CRIAR_CONTA(2),DADOS_BANCARIOS(3),VISUALIZAR_SALDO(4),DEPOSITO(5), SACAR(6), TRANSFERIR(7),Excluir_Conta(8),DESEREALIZAR(9),Mostrar_Pessoas(10),SAIR(0);

    private int aux;
    
    OpcaoMenu(int aux) {
     this.aux = aux;
    }

    public static OpcaoMenu menuEscolhido(int op) {
        if (op == 1) {
            return OpcaoMenu.CADASTRAR;
        }
        if (op == 2) {
            return OpcaoMenu.CRIAR_CONTA;
        }
        if (op == 3) {
            return OpcaoMenu.DADOS_BANCARIOS;
        }
        if (op == 4) {
            return OpcaoMenu.VISUALIZAR_SALDO;
        }
        if (op == 5) {
            return OpcaoMenu.DEPOSITO;
        }
        if (op == 6) {
            return OpcaoMenu.SACAR;
        }
        if (op ==7){
            return OpcaoMenu.TRANSFERIR;
        }
        if (op ==8){
            return OpcaoMenu.Excluir_Conta;
        }
        if (op==9){
            return OpcaoMenu.DESEREALIZAR;
        }
        if (op==10){
            return OpcaoMenu.Mostrar_Pessoas;
        }
        
        if (op == 0) {
            return OpcaoMenu.SAIR;
        }

        return null;
    }

    public int getAux() {
        return aux;
    }
    
    

}
