package br.edu.iff.pooa20162.servicecar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.edu.iff.pooa20162.servicecar.R;
import br.edu.iff.pooa20162.servicecar.model.Avaliacao;


/**
 * Created by carlos on 26/03/17.
 */

public class AvaliacaoAdapter extends ArrayAdapter<Avaliacao>{

    private Context context = null;
    private ArrayList<Avaliacao> avaliacao= null;


    public AvaliacaoAdapter(Context context, ArrayList<Avaliacao> avaliacao) {
        super(context, R.layout.linhaavaliacao,avaliacao);
        this.context = context;
        this.avaliacao = avaliacao;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.linhaavaliacao, parent, false);
        final Avaliacao item = getItem(position);

        TextView classificacao = (TextView) rowView.findViewById(R.id.tvllvClassificacao);
        TextView comentario = (TextView) rowView.findViewById(R.id.tvllvComentario);

        classificacao.setText(avaliacao.get(position).getClassificacao());
        comentario.setText(avaliacao.get(position).getComentarios());

        return rowView;
    }

}
