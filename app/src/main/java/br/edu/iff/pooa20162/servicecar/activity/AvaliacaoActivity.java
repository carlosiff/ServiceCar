package br.edu.iff.pooa20162.servicecar.activity;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import br.edu.iff.pooa20162.servicecar.R;

import br.edu.iff.pooa20162.servicecar.model.Avaliacao;

public class AvaliacaoActivity extends Activity {

    EditText classificacao,comentario;
    Button btsalvar,btalterar;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);
        Intent intent    = getIntent();
        id = (Long) intent.getSerializableExtra("id");


        String classificacaoa = (String) intent.getSerializableExtra("classificacao");
        String comentarioa = (String) intent.getSerializableExtra("comentario");

        EditText classificacao = (EditText) findViewById(R.id.idAvaliacao);
        classificacao.setText(classificacaoa);

        EditText comentario = (EditText) findViewById(R.id.idComentarios);
        comentario.setText(comentarioa);


        btsalvar = (Button) findViewById(R.id.idSalvarAvaliacao);
        btalterar = (Button) findViewById(R.id.idAlterarAvaliacao);


        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);
        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);

        }


    }

    public void salvar() {

        classificacao = (EditText) findViewById(R.id.idAvaliacao);
        comentario = (EditText) findViewById(R.id.idComentarios);


        Avaliacao avaliacao = new Avaliacao(classificacao.getText().toString(),comentario.getText().toString());

        avaliacao.save();

        Toast.makeText(this,"Avaliação Realizada",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        classificacao = (EditText) findViewById(R.id.idAvaliacao);
        comentario = (EditText) findViewById(R.id.idComentarios);


        Avaliacao avaliacao = Avaliacao.findById(Avaliacao.class, id);

        avaliacao.setClassificacao(classificacao.getText().toString());
        avaliacao.setComentarios(comentario.getText().toString());

        avaliacao.save();

        Toast.makeText(this,"Avaliação Alterada",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
