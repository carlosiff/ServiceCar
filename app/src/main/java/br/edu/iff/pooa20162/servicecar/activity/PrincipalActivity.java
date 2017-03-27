package br.edu.iff.pooa20162.servicecar.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import br.edu.iff.pooa20162.servicecar.R;

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
                Intent intent = new Intent(PrincipalActivity.this,LVAvalaicaoActivity.class);
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
    public void link(View view){
        Intent linkIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ServiceCar2016"));
        startActivity(linkIntent);

    }

}




