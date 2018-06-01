package com.example.sistemas.cultura;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sistemas.cultura.api.ApiService;
import com.example.sistemas.cultura.models.Bibliotecas;

import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MBibliotecasActivity extends AppCompatActivity {
    private MapView myOpenMapView;
    private MapController myMapController;
    private ListaBibliotecasAdapter listaBiblioteca;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbibliotecas);

        Bundle bundle = getIntent().getExtras();

        String string = bundle.getString("Latitud");

        String[] parts = string.split(",");
        String part1 = parts[0];
        String part2 = parts[1];

        String cadena1=part1.substring(1,part1.length()-1);
        String cadena2=part2.substring(0,part2.length()-2);

        double x = Double.parseDouble(cadena1);
        double y = Double.parseDouble(cadena2);



        GeoPoint pasto= new GeoPoint(x, y);
        GeoPoint centro= new GeoPoint(4.091542, -72.957226);


        myOpenMapView=(MapView)findViewById(R.id.openmapview);
        myOpenMapView.setBuiltInZoomControls(true);

        myMapController= (MapController) myOpenMapView.getController();
        myMapController.setCenter(pasto);
        myMapController.setZoom(15);
        myOpenMapView.setMultiTouchControls(true);


        final ArrayList<OverlayItem> puntos = new ArrayList<OverlayItem>();


         bundle.getString("Latitud");

        puntos.add(new OverlayItem(bundle.getString("Nombre"), bundle.getString("Direccion"), pasto));


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

/*

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


                        String string = miBiblioteca.getGeoreferencia();
                        String[] parts = string.split(",");
                        String part1 = parts[0];
                        String part2 = parts[1];

                        String cadena1=part1.substring(1,part1.length()-1);
                        String cadena2=part2.substring(0,part2.length()-2);

                        double x = Double.parseDouble(cadena1);
                        double y = Double.parseDouble(cadena2);

                        Log.e("BIBLIOTECA", x+"");
                        Log.e("BIBLIOTECA", y+"");

                        GeoPoint punto= new GeoPoint(x,y);

                        //puntos.add(new OverlayItem(miBiblioteca.getNombreDeLaBiblioteca(), miBiblioteca.getBarrio(), punto));

                        puntos.add(new OverlayItem(miBiblioteca.getNombreDeLaBiblioteca(), miBiblioteca.getBarrio(), punto));


                        // Log.i("Direccion", miZona.getDireccion());
                        // Log.i("Nombre", miZona.getPuntoWifi());


                    }

                    Log.e("BIBLIOTECA", puntos.size()+"");
                }else {
                    Log.e("BIBLIOTECA", "onFailure: ");
                }

            }



            @Override
            public void onFailure(Call<ArrayList<Bibliotecas>> call, Throwable t) {
                Log.e("BIBLIOTECA", "onFailure: "+t.getMessage());
            }
        });

*/


        /*
        final MyLocationNewOverlay myLocationoverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(getApplicationContext()), myOpenMapView);
        myOpenMapView.getOverlays().add(myLocationoverlay); //No añadir si no quieres una marca
        myLocationoverlay.enableMyLocation();
        myLocationoverlay.runOnFirstFix(new Runnable() {
            public void run() {
                myMapController.animateTo(myLocationoverlay.getMyLocation());

            }
        });
        */



        //puntos.add(new OverlayItem("Pasto", "Ciudad de Pasto", pasto));




        ItemizedIconOverlay.OnItemGestureListener<OverlayItem> tap = new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
            @Override
            public boolean onItemLongPress(int arg0, OverlayItem arg1) {
                return false;
            }
            @Override
            public boolean onItemSingleTapUp(int index, OverlayItem item) {
                return true;
            }
        };

        ItemizedOverlayWithFocus<OverlayItem> capa = new ItemizedOverlayWithFocus<OverlayItem>(this, puntos, tap);
        capa.setFocusItemsOnTap(true);
        myOpenMapView.getOverlays().add(capa);




    }

}
