package com.iwalnexus.tsn.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    adaptadorTexto adaptadorTexto;
    RecyclerView.LayoutManager manager;
    List<String> lista;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        lista = new ArrayList<>();
        lista.add("1");
        lista.add("2");
        lista.add("3");
        lista.add("4");
        lista.add("5");
        lista.add("6");
        lista.add("7");

        manager = new LinearLayoutManager(this);

        //manager = new GridLayoutManager(this, 2);


        adaptadorTexto = new adaptadorTexto(lista, R.layout.rv_lista, this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adaptadorTexto);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_rv, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.añadir:
                lista.add("Nuevo" + ++contador);
                adaptadorTexto.notifyDataSetChanged();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }


    }
}
