package br.ba.organizacao.projeto_android_recicleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andre on 25/04/16.
 */
public class BebidaListAdapter extends RecyclerView.Adapter<BebidaListAdapter.ViewHolder> {

    private List<Bebida> bebidas;
    private Context context;
    private OnDataSelected  onDataSelected;

    public BebidaListAdapter(Context context, OnDataSelected onDataSelected, List<Bebida> bebidas) {
        this.context = context;
        this.onDataSelected = onDataSelected;
        this.bebidas = bebidas;
    }

    @Override
    public BebidaListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_bebida, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bebida be = bebidas.get(position);
        holder.textViewModelo.setText(be.getModelo());
        holder.textViewMarca.setText(be.getMarca());
    }

    @Override
    public int getItemCount() {
        return bebidas.size();
    }

    public static interface OnDataSelected {

        public void onDataSelected(View view, int position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewMarca;
        public TextView textViewModelo;

        public ViewHolder(View view) {
            super(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    treatOnDataSelectedIfNecessary(v, getAdapterPosition());
                }
            });

            textViewModelo = (TextView)view.findViewById(R.id.modelo);
            textViewMarca = (TextView)view.findViewById(R.id.marca);
        }
    }

    private void treatOnDataSelectedIfNecessary(View view, int position) {
        if(onDataSelected != null) {
            onDataSelected.onDataSelected(view, position);
        }
    }
}