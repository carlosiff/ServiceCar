package br.edu.iff.pooa20162.servicecar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.model.Cadastro;

public class EsqueciActivity extends AppCompatActivity {
    long id;
    EditText etemail, etdica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci);
        Intent intent = getIntent();
        id = (Long) intent.getSerializableExtra("id");
    }

    public void mostrasenha() {
        String email = etemail.getText().toString();
        String dica = etdica.getText().toString();
        if (email.isEmpty() || dica.isEmpty()){
            Toast.makeText(getApplicationContext(), "Informe o email e a dica!", Toast.LENGTH_SHORT).show();
        }
        else {
            List<Cadastro> query = Cadastro.find(Cadastro.class, "email = ?", email);
            Boolean login=false;
            for (int i=0; i<query.size(); i++){
                if (query.get(i).getDica().equals(dica)){
                    Intent it = new Intent(EsqueciActivity.this, PrincipalActivity.class);
                    it.putExtra("id", query.get(i).getId().toString());
                    login=true;
                    startActivity(it);
                    finish();
                }
            }
            if (!login){
                Toast.makeText(getApplicationContext(), "Dados inválidos!", Toast.LENGTH_SHORT).show();
            }
        }
        Cadastro cadastro = Cadastro.findById(Cadastro.class, id);
        Toast.makeText(this,"Senha: "+cadastro.getSenha().toString(),Toast.LENGTH_LONG).show();
    }

}