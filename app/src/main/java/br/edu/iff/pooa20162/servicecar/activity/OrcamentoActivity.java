package br.edu.iff.pooa20162.servicecar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.edu.iff.pooa20162.servicecar.R;

public class OrcamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);

        ListView itens = (ListView) findViewById(R.id.lservicos);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.servicos, android.R.layout.simple_list_item_1);
        itens.setAdapter(adapter);
    }
}
