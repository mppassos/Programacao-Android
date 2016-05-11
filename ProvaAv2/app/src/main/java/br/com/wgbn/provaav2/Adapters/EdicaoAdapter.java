package br.com.wgbn.provaav2.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.wgbn.provaav2.Models.EdicaoModel;
import br.com.wgbn.provaav2.Pojo.EdicaoPojo;
import br.com.wgbn.provaav2.R;

public class EdicaoAdapter extends RecyclerView.Adapter<EdicaoAdapter.EdicaoViewHolder> {

    private List<EdicaoModel> lista;
    private Context contexto;

    public EdicaoAdapter(Context ctx, List<EdicaoModel> lista) {
        this.contexto = ctx;
        this.lista = lista;
    }

    @Override
    public EdicaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexto).inflate(R.layout.card_edicao, parent, false);
        EdicaoViewHolder vh = new EdicaoViewHolder(v);
        v.setTag(vh);
        return vh;
    }

    @Override
    public void onBindViewHolder(EdicaoViewHolder holder, int position) {
        EdicaoModel edicao = lista.get(position);
        Picasso.with(contexto).load(edicao.getCapa()).into(holder.imgCapa);
        holder.lblTitulo.setText(edicao.getTitulo());
        holder.lblNumero.setText("#"+String.valueOf(edicao.getNumero()));
        holder.lblSubTitulo.setText(edicao.getSubtitulo());
        holder.lblAno.setText(String.valueOf(edicao.getAno()));
    }

    @Override
    public int getItemCount() {
        return lista != null ? lista.size() : 0;
    }

    public static class EdicaoViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgCapa;
        public TextView lblTitulo;
        public TextView lblNumero;
        public TextView lblSubTitulo;
        public TextView lblAno;

        public EdicaoViewHolder(View itemView) {
            super(itemView);

            imgCapa = (ImageView)itemView.findViewById(R.id.imgCapa);
            lblTitulo = (TextView)itemView.findViewById(R.id.lblTitulo);
            lblNumero = (TextView)itemView.findViewById(R.id.lblNumero);
            lblSubTitulo = (TextView)itemView.findViewById(R.id.lblSubTitulo);
            lblAno = (TextView)itemView.findViewById(R.id.lblAno);
        }
    }
}
