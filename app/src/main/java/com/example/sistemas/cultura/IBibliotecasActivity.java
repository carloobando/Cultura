package com.example.sistemas.cultura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.sistemas.cultura.R;
import com.example.sistemas.cultura.api.ApiService;
import com.example.sistemas.cultura.models.Bibliotecas;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IBibliotecasActivity extends AppCompatActivity {



    private static final String TAG = "BIBLIOTECAS";

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    //private int offset;

    private boolean aptoParaCargar;

    private ListaBibliotecasAdapter listaBibliotecasAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibibliotecas);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listaBibliotecasAdapter = new ListaBibliotecasAdapter(this);
        recyclerView.setAdapter(listaBibliotecasAdapter);
        recyclerView.setHasFixedSize(true);
        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //quitar esta wea
                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (aptoParaCargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Log.i(TAG, " Llegamos al final.");

                            aptoParaCargar = false;
                            // offset += 20;
                            procesarDatos();
                        }
                    }
                }
            }
        });


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        aptoParaCargar = false;
        //offset = 0;
        procesarDatos();
    }

    private void procesarDatos() {
        ApiService service = retrofit.create(ApiService.class);

        //Call<ArrayList<ZonaRespuesta>> zonaRespuestaCall= service.obtenerZona();
        Call<ArrayList<Bibliotecas>> zonaRespuestaCall= service.obtenerBibliotecas();
        zonaRespuestaCall.enqueue(new Callback<ArrayList<Bibliotecas>>() {
            @Override
            public void onResponse(Call<ArrayList<Bibliotecas>> call, Response<ArrayList<Bibliotecas>> response) {
                if(response.isSuccessful()) {

                    ArrayList<Bibliotecas> nuevo = response.body();
                    Log.i("Bibliotecas", "Bibliotecas,");
                    for(int i = 0; i<nuevo.size();i++){

                        Bibliotecas miBiblioteca = nuevo.get(i);
                        // Log.i("Direccion", miZona.getDireccion());
                        // Log.i("Nombre", miZona.getPuntoWifi());


                    }
                    listaBibliotecasAdapter.adicionarListaBibliotecas(nuevo);

                }else {
                    Log.e(TAG, "onFailure: ");
                }

            }



            @Override
            public void onFailure(Call<ArrayList<Bibliotecas>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });

    }
    public void volver(View view)
    {
        Intent obj = new Intent(IBibliotecasActivity.this,MainActivity.class);
        startActivity(obj);
    }
}
