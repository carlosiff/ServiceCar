package br.edu.iff.pooa20162.servicecar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.adapter.CadastroAdapter;
import br.edu.iff.pooa20162.servicecar.model.Cadastro;

public class LVCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvcadastro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LVCadastroActivity.this,CadastroActivity.class);
                intent.putExtra("id",Long.valueOf(0));
                intent.putExtra("nome","");
                intent.putExtra("cpf","");
                intent.putExtra("email","");
                intent.putExtra("dataNasc","");
                intent.putExtra("telefone","");
                intent.putExtra("senha","");
                intent.putExtra("dica","");
                intent.putExtra("sexo","");
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lvcadastro, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onResume() {
        super.onResume();
        final ArrayList<Cadastro> cadastro  = (ArrayList) Cadastro.listAll(Cadastro.class);

        ListView lista = (ListView) findViewById(R.id.lvCadastro);
        ArrayAdapter adapter = new CadastroAdapter(this,cadastro);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LVCadastroActivity.this,CadastroActivity.class);

                intent.putExtra("id",cadastro.get(i).getId());
                intent.putExtra("nome",cadastro.get(i).getNome());
                intent.putExtra("cpf",cadastro.get(i).getCpf());
                intent.putExtra("email",cadastro.get(i).getEmail());
                intent.putExtra("dataNasc",cadastro.get(i).getDataNasc());
                intent.putExtra("telefone",cadastro.get(i).getTelefone());
                intent.putExtra("senha",cadastro.get(i).getSenha());
                intent.putExtra("dica",cadastro.get(i).getDica());
                intent.putExtra("sexo",cadastro.get(i).getSexo());

                startActivity(intent);

            }
        });
    }

}
