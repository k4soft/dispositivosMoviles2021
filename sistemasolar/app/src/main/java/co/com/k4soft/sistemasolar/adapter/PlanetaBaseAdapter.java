package co.com.k4soft.sistemasolar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import co.com.k4soft.sistemasolar.R;
import co.com.k4soft.sistemasolar.entities.Planeta;

public class PlanetaBaseAdapter extends BaseAdapter implements Filterable {

    private List<Planeta> listaPlanetasIn;
    private List<Planeta> listaPlanetasOut;
    private final LayoutInflater inflater;

    public PlanetaBaseAdapter(Context context, List<Planeta> listaPlanetas) {
        this.listaPlanetasOut = listaPlanetas;
        this.listaPlanetasIn = listaPlanetas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listaPlanetasOut.size();
    }

    @Override
    public Planeta getItem(int position) {
        return listaPlanetasOut.get(position);
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
        holder.imagen.setImageResource(listaPlanetasOut.get(position).getImagen());
        holder.titulo.setText(listaPlanetasOut.get(position).getTitulo());
        holder.descripcion.setText(listaPlanetasOut.get(position).getDescripcion());
        return convertView;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listaPlanetasOut = (List<Planeta>) results.values;
                notifyDataSetChanged();
            }

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<Planeta> FilteredArrList = new ArrayList<>();
                if (listaPlanetasIn == null) {
                    listaPlanetasIn = new ArrayList<>(listaPlanetasOut);
                }
                if (constraint == null || constraint.length() == 0) {
                    results.count = listaPlanetasIn.size();
                    results.values = listaPlanetasIn;
                } else {

                    constraint = constraint.toString().toLowerCase();
                    for (int i = 0; i < listaPlanetasIn.size(); i++) {
                        String data = listaPlanetasIn.get(i).getTitulo();
                        if (data.toLowerCase().contains(constraint.toString())) {
                            FilteredArrList.add(listaPlanetasIn.get(i));
                        }
                    }
                    results.count = FilteredArrList.size();
                    results.values = FilteredArrList;
                }
                return results;
            }
        };
        return filter;
    }

    class ViewHolder {
        ImageView imagen;
        TextView titulo;
        TextView descripcion;
    }
}
