package br.edu.iff.pooa20162.servicecar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.model.Orcamento;

import java.util.ArrayList;


/**
 * Created by carlos on 27/03/17.
 */

public class OrcamentoAdapter extends ArrayAdapter<Orcamento>{
    private final Context context;
    private final ArrayList<Orcamento> elementos;

    public OrcamentoAdapter(Context context, ArrayList<Orcamento> elementos) {
        super(context, R.layout.linhaorcamento, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.linhaorcamento, parent, false);
        TextView nome = (TextView) rowView.findViewById(R.id.nome);
        TextView preco = (TextView) rowView.findViewById(R.id.preco);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imagem);
        nome.setText(elementos.get(position).getNome());
        preco.setText(elementos.get(position).getPreco());
        imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }


}
