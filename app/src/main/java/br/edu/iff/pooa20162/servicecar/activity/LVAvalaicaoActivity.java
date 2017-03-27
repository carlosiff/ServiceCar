package br.edu.iff.pooa20162.servicecar.activity;


import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.model.Avaliacao;
import br.edu.iff.pooa20162.servicecar.activity.*;
import br.edu.iff.pooa20162.servicecar.adapter.AvaliacaoAdapter;



public class LVAvalaicaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvavalaicao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LVAvalaicaoActivity.this,AvaliacaoActivity.class);
                intent.putExtra("id",Long.valueOf(0));
                intent.putExtra("classificacao","");
                intent.putExtra("comentario","");
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lvavaliacao, menu);
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
        final ArrayList<Avaliacao>  avaliacao  = (ArrayList) Avaliacao.listAll(Avaliacao.class);

        ListView lista = (ListView) findViewById(R.id.lvAvaliacao);
        ArrayAdapter adapter = new AvaliacaoAdapter(this,avaliacao);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(LVAvalaicaoActivity.this,AvaliacaoActivity.class);

                intent.putExtra("id",avaliacao.get(i).getId());
                intent.putExtra("classificacao",avaliacao.get(i).getClassificacao());
                intent.putExtra("comentario",avaliacao.get(i).getComentarios());

                startActivity(intent);

            }
        });
    }
}
