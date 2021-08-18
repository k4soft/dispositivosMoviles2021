package co.com.k4soft.sistemasolar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import co.com.k4soft.sistemasolar.R;
import co.com.k4soft.sistemasolar.entities.Planeta;

public class PlanetaBaseAdapter extends BaseAdapter {

    private List<Planeta> listaPlanetas;
    private final LayoutInflater inflater;

    public PlanetaBaseAdapter(Context context, List<Planeta> listaPlanetas) {
        this.listaPlanetas = listaPlanetas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaPlanetas.size();
    }

    @Override
    public Planeta getItem(int position) {
        return listaPlanetas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.planeta_item, null);
            holder.imagen = convertView.findViewById(R.id.imagen);
            holder.titulo = convertView.findViewById(R.id.titulo);
            holder.descripcion = convertView.findViewById(R.id.descripcion);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.imagen.setImageResource(listaPlanetas.get(position).getImagen());
        holder.titulo.setText(listaPlanetas.get(position).getTitulo());
        holder.descripcion.setText(listaPlanetas.get(position).getDescripcion());
        return convertView;
    }

    class ViewHolder {
        ImageView imagen;
        TextView titulo;
        TextView descripcion;
    }
}
