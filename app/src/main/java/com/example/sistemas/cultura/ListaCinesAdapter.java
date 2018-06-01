package com.example.sistemas.cultura;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.sistemas.cultura.models.Cines;

import java.util.ArrayList;

public class ListaCinesAdapter extends RecyclerView.Adapter<ListaCinesAdapter.ViewHolder> {

    private ArrayList<Cines> dataset;
    private Context context;
    public int variable;

    public ListaCinesAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ListaCinesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cines, parent, false);
        return new ListaCinesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaCinesAdapter.ViewHolder holder, int position) {
        Cines p = dataset.get(position);
        //holder.nombreTextView.setText("Barrio: "+p.getBarrio()+"\n"+ "Departamento: "+p.getDepartamento());

        /*holder.nombreTextView.setText("Departamento: "+p.getDepartamento()+"\n"
                + "Ciudad: "+p.getCiudad()+"\n"
                + "Direccion: "+p.getDireccionDeLaSala()+"\n"
                + "Nombre: "+p.getNombreDelComplejo()+"\n"
                + "N. de salas: "+p.getTotalSalas()
        );*/

        holder.tv1.setText(p.getDepartamento());
        holder.tv2.setText(p.getCiudad());
        holder.tv3.setText(p.getDireccionDeLaSala());
        holder.tv4.setText(p.getNombreDelComplejo());
        holder.tv5.setText(p.getTotalSalas());



        //variable= Integer.parseInt( p.getDireccion()+p.getCoordenadasPuntosWifi().getCoordinates());
        //variable= p.getCoordenadasPuntosWifi();

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaCines(ArrayList<Cines> listaCines) {
        dataset.addAll(listaCines);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tv1,tv2,tv3,tv4,tv5;

        public ViewHolder(View itemView) {
            super(itemView);


            tv1=(TextView) itemView.findViewById(R.id.tv1);
            tv2=(TextView) itemView.findViewById(R.id.tv2);
            tv3=(TextView) itemView.findViewById(R.id.tv3);
            tv4=(TextView) itemView.findViewById(R.id.tv4);
            tv5=(TextView) itemView.findViewById(R.id.tv5);
        }
    }
}
