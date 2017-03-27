package br.edu.iff.pooa20162.servicecar.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import br.edu.iff.pooa20162.servicecar.R;
/**
 * Created by carlos on 27/03/17.
 */

public class LVOrcamentoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvorcamento);
        Intent intent = getIntent();
        String parametro = (String) intent.getSerializableExtra("nome");
        TextView nome = (TextView) findViewById(R.id.tvNome);
        nome.setText(parametro);
    }


}
