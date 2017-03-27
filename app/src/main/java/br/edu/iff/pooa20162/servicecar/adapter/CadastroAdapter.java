package br.edu.iff.pooa20162.servicecar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.model.Cadastro;

/**
 * Created by carlos on 26/03/17.
 */

public class CadastroAdapter extends ArrayAdapter<Cadastro> {

    private Context context = null;
    private ArrayList<Cadastro> cadastro= null;


    public CadastroAdapter(Context context, ArrayList<Cadastro> cadastro) {
        super(context, R.layout.linhacadastro,cadastro);
        this.context = context;
        this.cadastro = cadastro;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhacadastro, parent, false);
        final Cadastro item = getItem(position);

        TextView nome = (TextView) rowView.findViewById(R.id.tvllvNome);
        TextView cpf = (TextView) rowView.findViewById(R.id.tvllvCpf);
        TextView email = (TextView) rowView.findViewById(R.id.tvllvEmail);
        TextView dataNasc = (TextView) rowView.findViewById(R.id.tvllvDataNasc);
        TextView telefone = (TextView) rowView.findViewById(R.id.tvllvTelefone);
        TextView senha = (TextView) rowView.findViewById(R.id.tvllvSenha);
        TextView dica = (TextView) rowView.findViewById(R.id.tvllvDica);
        TextView sexo = (TextView) rowView.findViewById(R.id.tvllvSexo);

        nome.setText(cadastro.get(position).getNome());
        cpf.setText(cadastro.get(position).getCpf());
        email.setText(cadastro.get(position).getEmail());
        dataNasc.setText(cadastro.get(position).getDataNasc());
        telefone.setText(cadastro.get(position).getTelefone());
        senha.setText(cadastro.get(position).getSenha());
        dica.setText(cadastro.get(position).getDica());
        sexo.setText(cadastro.get(position).getSexo());

        return rowView;
    }

}













