package br.edu.iff.pooa20162.servicecar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        ImageButton imageDispo = (ImageButton) findViewById(R.id.imageDispo);
        imageDispo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                Intent intent = new Intent(PrincipalActivity.this,DisponobilidadeActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageOrca = (ImageButton) findViewById(R.id.imageOrca);
        imageOrca.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                Intent intent = new Intent(PrincipalActivity.this,OrcamentoActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageAvali = (ImageButton) findViewById(R.id.imageAvali);
        imageAvali.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                Intent intent = new Intent(PrincipalActivity.this,AvaliacaoActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageSair = (ImageButton) findViewById(R.id.imageSair);
        imageSair.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view){
                Intent intent = new Intent(PrincipalActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
