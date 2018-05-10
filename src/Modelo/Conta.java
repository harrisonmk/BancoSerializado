
package Modelo;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Conta implements Serializable {
    
    private double saldo;
    private String senha;
    private int numero;
    private int agencia;
    static int quantContas = 0;
    
    DecimalFormat deci = new DecimalFormat("0.00");
    
    public Conta() {
        
        this.agencia = 15;
        quantContas++;
        this.numero=quantContas;
        this.saldo = 0.0;

    }
    


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public static int getQuantContas() {
        return quantContas;
    }

    public static void setQuantContas(int quantContas) {
        Conta.quantContas = quantContas;
    }

   
    
    

    @Override
    public String toString() {
        return "\nNumero: " + numero + 
                
                "\nAgencia: " + agencia + 
                "\nSaldo: " + deci.format(saldo)+"\n"; 
                 
                
    }

    
    
    public void depositar(double valor) {

        this.saldo += valor;

    }

    public void sacar(double valor) {

        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insulficinente");
        }

    }

    public void visualizarSaldo() {

        System.out.println("\nSaldo: " + deci.format(this.saldo));
    }

    public void transferir(Conta trans, double valor) {

        if (valor <= this.saldo) {
            this.saldo -= valor;
            trans.saldo+=valor;
        } else {
            System.out.println("Saldo insulficinente");
        }

}
    
}
