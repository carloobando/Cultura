package com.example.sistemas.cultura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }
    public void atras(View view)
    {
        Intent obj = new Intent(AcercaDe.this,MainActivity.class);
        startActivity(obj);


//asd









    }
}
