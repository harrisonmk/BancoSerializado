package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Pessoa implements Serializable {

    public String nome;
    private String date;
    private char sexo;
    private String cpf;
    ArrayList<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }


    public String obterInfo() {
        String info = "\nNome: " + nome;
        info += "\nData de Nascimento: " + date;
        //info+="\nSexo: " + sexo ;
        info += "\nCpf: " + cpf + "\n";
        
        if (contas != null) {
            for (Conta c : contas) {
                info += c.toString() + "\n";
            }
        }

        return info;
    }

    @Override
    public String toString() {
        return "Nome: " + nome+
                "\nData de Nascimento: "+date+
                 "\n: " + contas;

    }
    


}
