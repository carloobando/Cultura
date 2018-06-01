package com.example.sistemas.cultura;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sistemas.cultura.models.Musicas;

import java.util.ArrayList;

public class ListaMusicasAdapter extends RecyclerView.Adapter<ListaMusicasAdapter.ViewHolder> {

    private ArrayList<Musicas> dataset;
    private Context context;
    public int variable;

    public ListaMusicasAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ListaMusicasAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_musica, parent, false);
        return new ListaMusicasAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaMusicasAdapter.ViewHolder holder, int position) {
        Musicas p = dataset.get(position);
        //holder.nombreTextView.setText("Barrio: "+p.getBarrio()+"\n"+ "Departamento: "+p.getDepartamento());

       /* holder.nombreTextView.setText("Departamento: "+p.getDepartamento()+"\n"
                + "Municipio: "+p.getMunicipio()+"\n"
                + "Direccion: "+p.getDirecciNEscuela()+"\n"
                + "Nombre: "+p.getNombreEscuela()+"\n"
                + "Tipo: "+p.getTipoEscuela()+"\n"
                + "Naturaleza: "+p.getNaturaleza()+"\n"
                + "Email: "+p.getCorreoElectrNicoEscuela()+"\n"
                + "Telefono: "+p.getTelFonoEscuela()
        );*/
        holder.tv1.setText(p.getDepartamento());
        holder.tv2.setText(p.getMunicipio());
        holder.tv3.setText(p.getDirecciNEscuela());
        holder.tv4.setText(p.getNombreEscuela());
        holder.tv5.setText(p.getTipoEscuela());
        holder.tv6.setText(p.getNaturaleza());
        holder.tv7.setText(p.getCorreoElectrNicoEscuela());
        holder.tv8.setText(p.getTelFonoEscuela());




        //variable= Integer.parseInt( p.getDireccion()+p.getCoordenadasPuntosWifi().getCoordinates());
        //variable= p.getCoordenadasPuntosWifi();

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaMusicas(ArrayList<Musicas> listaMusicas) {
        dataset.addAll(listaMusicas);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7,tv8;

        public ViewHolder(View itemView) {
            super(itemView);

            tv1=(TextView) itemView.findViewById(R.id.tv1);
            tv2=(TextView) itemView.findViewById(R.id.tv2);
            tv3=(TextView) itemView.findViewById(R.id.tv3);
            tv4=(TextView) itemView.findViewById(R.id.tv4);
            tv5=(TextView) itemView.findViewById(R.id.tv5);
            tv6=(TextView) itemView.findViewById(R.id.tv6);
            tv7=(TextView) itemView.findViewById(R.id.tv7);
            tv8=(TextView) itemView.findViewById(R.id.tv8);


        }
    }
}
