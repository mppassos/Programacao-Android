package br.com.wgbn.provaav2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.wgbn.provaav2.Pojo.EdicaoPojo;
import br.com.wgbn.provaav2.R;

public class EdicaoAdapter extends RecyclerView.Adapter<EdicaoAdapter.EdicaoViewHolder> {

    private Context contexto;
    private List<EdicaoPojo> lista;

    public EdicaoAdapter(Context contexto, List<EdicaoPojo> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @Override
    public EdicaoAdapter.EdicaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexto).inflate(R.layout.card_edicao, parent, false);
        EdicaoViewHolder vh = new EdicaoViewHolder(v);
        v.setTag(vh);
        return vh;
    }

    @Override
    public void onBindViewHolder(EdicaoAdapter.EdicaoViewHolder holder, int position) {
        EdicaoPojo edicao = lista.get(position);
        Picasso.with(contexto).load(edicao.getCapa()).into(holder.imgCapa);
        holder.lblTitulo.setText(edicao.getTitulo());
        holder.lblSubTitulo.setText(edicao.getSubtitulo());
        holder.lblAno.setText(String.valueOf(edicao.getAno()));
    }

    @Override
    public int getItemCount() {
        return lista == null ? lista.size() : 0;
    }

    public static class EdicaoViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgCapa;
        public TextView lblTitulo;
        public TextView lblSubTitulo;
        public TextView lblAno;

        public EdicaoViewHolder(View itemView) {
            super(itemView);

            imgCapa = (ImageView)itemView.findViewById(R.id.imgCapa);
            lblTitulo = (TextView)itemView.findViewById(R.id.lblTitulo);
            lblSubTitulo = (TextView)itemView.findViewById(R.id.lblSubTitulo);
            lblAno = (TextView)itemView.findViewById(R.id.lblAno);
        }
    }
}
