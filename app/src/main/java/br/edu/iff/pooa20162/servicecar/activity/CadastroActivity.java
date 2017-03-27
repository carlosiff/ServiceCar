package br.edu.iff.pooa20162.servicecar.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.model.Cadastro;

public class CadastroActivity extends Activity {

    EditText nome, cpf, email, dataNasc, telefone, senha, dica, sexo;
    Button btsalvar, btalterar;
    long id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        Intent intent    = getIntent();
        id = (Long) intent.getSerializableExtra("id");


        String nomec = (String) intent.getSerializableExtra("nome");
        String cpfc = (String) intent.getSerializableExtra("cpf");
        String emailc = (String) intent.getSerializableExtra("email");
        String dataNascc = (String) intent.getSerializableExtra("dataNasc");
        String telefonec = (String) intent.getSerializableExtra("telefone");
        String senhac = (String) intent.getSerializableExtra("senha");
        String dicac = (String) intent.getSerializableExtra("dica");
        String sexoc = (String) intent.getSerializableExtra("sexo");

        EditText nome = (EditText) findViewById(R.id.salvaNome);
        nome.setText(nomec);

        EditText cpf = (EditText) findViewById(R.id.salvaCpf);
        cpf.setText(cpfc);

        EditText email = (EditText) findViewById(R.id.salvaEmail);
        email.setText(emailc);

        EditText dataNasc = (EditText) findViewById(R.id.salvaNascimento);
        dataNasc.setText(dataNascc);

        EditText telefone = (EditText) findViewById(R.id.salvaTelefone);
        telefone.setText(telefonec);

        EditText senha = (EditText) findViewById(R.id.salvaSenha);
        senha.setText(senhac);

        EditText dica = (EditText) findViewById(R.id.salvaDica);
        dica.setText(dicac);

        EditText sexo = (EditText) findViewById(R.id.salvaSexo);
        sexo.setText(sexoc);


        btsalvar = (Button) findViewById(R.id.idSalvarDados);
        btalterar = (Button) findViewById(R.id.idAlterarDados);


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
        }else {
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
        }
    }

    public void salvar() {

        nome = (EditText) findViewById(R.id.salvaNome);
        cpf = (EditText) findViewById(R.id.salvaCpf);
        email = (EditText) findViewById(R.id.salvaEmail);
        dataNasc = (EditText) findViewById(R.id.salvaNascimento);
        telefone = (EditText) findViewById(R.id.salvaTelefone);
        senha = (EditText) findViewById(R.id.salvaSenha);
        dica = (EditText) findViewById(R.id.salvaDica);
        sexo = (EditText) findViewById(R.id.salvaSexo);


        Cadastro cadastro = new Cadastro(nome.getText().toString(),cpf.getText().toString(),
                email.getText().toString(),dataNasc.getText().toString(),
                telefone.getText().toString(),senha.getText().toString(),
                dica.getText().toString(), sexo.getText().toString());

        cadastro.save();

        Toast.makeText(this,"Cadastro Realizado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void alterar() {

        nome = (EditText) findViewById(R.id.salvaNome);
        cpf = (EditText) findViewById(R.id.salvaCpf);
        email = (EditText) findViewById(R.id.salvaEmail);
        dataNasc = (EditText) findViewById(R.id.salvaNascimento);
        telefone = (EditText) findViewById(R.id.salvaTelefone);
        senha = (EditText) findViewById(R.id.salvaSenha);
        dica = (EditText) findViewById(R.id.salvaDica);
        sexo = (EditText) findViewById(R.id.salvaSexo);


        Cadastro cadastro = Cadastro.findById(Cadastro.class, id);

        cadastro.setNome(nome.getText().toString());
        cadastro.setCpf(cpf.getText().toString());
        cadastro.setEmail(dataNasc.getText().toString());
        cadastro.setDataNasc(dataNasc.getText().toString());
        cadastro.setTelefone(telefone.getText().toString());
        cadastro.setSenha(senha.getText().toString());
        cadastro.setDica(dica.getText().toString());
        cadastro.setSexo(sexo.getText().toString());


        cadastro.save();

        Toast.makeText(this,"Cadastro Alterado",Toast.LENGTH_LONG).show();
        this.finish();
    }
}
