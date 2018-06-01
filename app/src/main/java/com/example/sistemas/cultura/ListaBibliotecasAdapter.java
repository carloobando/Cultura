package com.example.sistemas.cultura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;

import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;


import com.example.sistemas.cultura.models.Bibliotecas;

import java.util.ArrayList;


public class ListaBibliotecasAdapter extends RecyclerView.Adapter<ListaBibliotecasAdapter.ViewHolder>  {

    private ArrayList<Bibliotecas> dataset;

    private Context context;
    public int variable;

    public ListaBibliotecasAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bibliotecas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {



        final Bibliotecas p = dataset.get(position);
        //holder.nombreTextView.setText("Barrio: "+p.getBarrio()+"\n"+ "Departamento: "+p.getDepartamento());

       /* holder.nombreTextView.setText("Departamento: "+p.getDepartamento()+"\n"
                + "Municipio: "+p.getMunicipio()+"\n"
                + "Barrio: "+p.getBarrio()+"\n"
                + "Direccion: "+p.getDirecciNDeLaBiblioteca()+"\n"
                + "Georeferencia: "+p.getGeoreferencia()+"\n"
                + "Nombre: "+p.getNombreDeLaBiblioteca()+"\n"
                + "Tipo: "+p.getTipoDeBiblioteca()+"\n"
                + "Naturaleza: "+p.getNaturalezaDeLaBiblioteca()+"\n"
                + "Cod.Dane: "+p.getCDigoDane()
        );*/
        holder.tv1.setText(p.getDepartamento());
        holder.tv2.setText(p.getMunicipio());
        holder.tv3.setText(p.getBarrio());
        holder.tv4.setText(p.getDirecciNDeLaBiblioteca());
        holder.tv5.setText(p.getNombreDeLaBiblioteca());
        holder.tv6.setText(p.getTipoDeBiblioteca());
        holder.tv7.setText(p.getNaturalezaDeLaBiblioteca());

        holder.ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj = new Intent(holder.context,MBibliotecasActivity.class);
                obj.putExtra("Latitud",p.getGeoreferencia());
                obj.putExtra("Nombre",p.getNombreDeLaBiblioteca());
                obj.putExtra("Direccion",p.getDirecciNDeLaBiblioteca());



                Log.d("asd",p.getGeoreferencia());
                holder.context.startActivity(obj);
            }
        });




        //variable= Integer.parseInt( p.getDireccion()+p.getCoordenadasPuntosWifi().getCoordinates());
        //variable= p.getCoordenadasPuntosWifi();

    }

    @Override
    public int getItemCount() {
        return dataset.size();

    }

    public void adicionarListaBibliotecas(ArrayList<Bibliotecas> listaBibliotecas) {
        dataset.addAll(listaBibliotecas);
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        private Button ver;

        private TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);

            context= itemView.getContext();

            //nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
            tv1=(TextView) itemView.findViewById(R.id.tv1);
            tv2=(TextView) itemView.findViewById(R.id.tv2);
            tv3=(TextView) itemView.findViewById(R.id.tv3);
            tv4=(TextView) itemView.findViewById(R.id.tv4);
            tv5=(TextView) itemView.findViewById(R.id.tv5);
            tv6=(TextView) itemView.findViewById(R.id.tv6);
            tv7=(TextView) itemView.findViewById(R.id.tv7);
            ver = (Button) itemView.findViewById(R.id.ubi);

        }
    }





}
