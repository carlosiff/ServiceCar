package br.edu.iff.pooa20162.servicecar.model;

import com.orm.SugarRecord;

/**
 * Created by carlos on 26/03/17.
 */

public class Cadastro extends SugarRecord{
    private String nome;
    private String cpf;
    private String email;
    private String dataNasc;
    private String telefone;
    private String senha;
    private String dica;
    private String sexo;

    public Cadastro(String nome, String cpf, String email, String dataNasc,
                     String telefone, String senha, String dica, String sexo) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataNasc = dataNasc;
        this.telefone = telefone;
        this.senha = senha;
        this.dica = dica;
        this.sexo = sexo;
    }

    public Cadastro(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
