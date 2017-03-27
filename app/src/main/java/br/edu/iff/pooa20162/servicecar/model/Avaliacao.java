package br.edu.iff.pooa20162.servicecar.model;

import com.orm.SugarRecord;

/**
 * Created by carlos on 26/03/17.
 */

public class Avaliacao extends SugarRecord{
    private String classificacao;
    private String comentarios;

    public Avaliacao(String classificacao, String comentarios) {
        this.classificacao = classificacao;
        this.comentarios = comentarios;
    }

    public Avaliacao(){

    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
