package br.edu.iff.pooa20162.servicecar.activity;

import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import android.content.Intent;
import br.edu.iff.pooa20162.servicecar.model.Orcamento;
import br.edu.iff.pooa20162.servicecar.adapter.OrcamentoAdapter;
import android.widget.Toast;

import br.edu.iff.pooa20162.servicecar.R;

public class OrcamentoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);

        ListView itens = (ListView) findViewById(R.id.lservicos);
        final ArrayList<Orcamento> orcamentos = adicionarOrcamentos();
        ArrayAdapter adapter = new OrcamentoAdapter(this, orcamentos);
        itens.setAdapter(adapter);



        itens.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                Toast.makeText(getBaseContext(), "Orçamento: "+orcamentos.get(i).getNome(),
                        Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(OrcamentoActivity.this, LVOrcamentoActivity.class);
                intent.putExtra("nome", orcamentos.get(i).getNome());
                startActivity(intent);
            }
        });
    }

    private ArrayList<Orcamento> adicionarOrcamentos() {
        ArrayList<Orcamento> orcamentos = new ArrayList<Orcamento>();
        Orcamento e = new Orcamento("Troca de Óleo e Lubrificantes",
                "R$100,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Alinhamento e Balanceamento",
                "R$200,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Regulamento de Motores",
                "R$250,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Sistemas de Freios",
                "R$150,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Mecânica Geral",
                "R$220,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento ("Suspensão",
                "R$230,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Ar-Condicionado",
                "R$260,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Escapamento",
                "R$190,00", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Direção Hidráulica",
                "R$167,50", R.drawable.bg);
        orcamentos.add(e);
        e = new Orcamento("Sistemas de Injeção",
                "R$155,00", R.drawable.bg);
        orcamentos.add(e);

        return orcamentos;
    }
}
