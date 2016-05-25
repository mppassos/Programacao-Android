package br.ba.senai.mapeamento;

import java.util.List;

import br.ba.senai.atividades.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ClienteAdapter extends BaseAdapter {

	Context ctx;
	List<Cliente> clientes;
	
	public ClienteAdapter(Context ctx, List<Cliente> clientes) {
		this.ctx = ctx;
		this.clientes = clientes;
	}
	@Override
	public int getCount() {
		
		return clientes.size();
	}
	@Override
	public Object getItem(int position) {
		return clientes.get(position);
	}
	@Override
	public long getItemId(int position) {
		return position;
	}
	
	static class ViewHolder{
		TextView txtnome;
		TextView txtendereco;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Cliente cliente = clientes.get(position);
		ViewHolder holder=null;
		if (convertView==null){
		  convertView = LayoutInflater.from(ctx).inflate(R.layout.layout_primeiro_nivel_fragment, null);
		  holder = new ViewHolder();
		  holder.txtnome = (TextView) convertView.findViewById(R.id.textnome);
		  holder.txtendereco = (TextView) convertView.findViewById(R.id.textendereco);
		  
		  convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.txtnome.setText(cliente.getNome());
		holder.txtendereco.setText(cliente.getEndereco());
		
		return convertView;
	}
	
	
}
