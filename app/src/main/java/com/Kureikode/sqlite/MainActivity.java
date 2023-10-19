package com.Kureikode.sqlite;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.Kureikode.sqlite.DB.DatabaseHelper;
import com.Kureikode.sqlite.DB.Productos;

public class MainActivity extends AppCompatActivity implements productoRecyclerAdaptator.OnItemClickListener {
    private DatabaseHelper dbAyudante;
    private productoRecyclerAdaptator productoAdaptador;
    private LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGuardar = (Button) findViewById( R.id.agregar );
        EditText nombreTxt = (EditText) findViewById( R.id.nombre_prod );
        EditText cantidad = (EditText) findViewById( R.id.stock_prod);
        EditText valor = (EditText) findViewById( R.id.valor_prod);
        RecyclerView milista = (RecyclerView) findViewById( R.id.recyclerListaProductos );
        dbAyudante = new DatabaseHelper(this);
        milista.setHasFixedSize( true );
        linearLayoutManager = new LinearLayoutManager( this );
        milista.setLayoutManager( linearLayoutManager );
        productoAdaptador = new productoRecyclerAdaptator( this );
        milista.setAdapter( productoAdaptador );

        btnGuardar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int random = (int) (Math.random() * 100) + 1;
                Cursor productoConsultado = dbAyudante.getProductoByName( nombreTxt.getText().toString());
                Productos productoNuevo = new Productos(random,nombreTxt.getText().toString(),"placeholder",Integer.parseInt(cantidad.getText().toString()),Integer.parseInt(valor.getText().toString()),10 );
                dbAyudante.saveProducto( productoNuevo );
                loadPersonas();

            }
        } );
        loadPersonas();
    }



    private void loadPersonas() {
        new PersonaLoaderTask().execute( );
    }

    @Override
    public void onClick(productoRecyclerAdaptator.ViewHolder view, Productos productoActualizado) {
        dbAyudante.updateProductoNAMESTOCKVALUE(productoActualizado,productoActualizado.getNombre_prod());
        loadPersonas();
    }

    private class PersonaLoaderTask extends AsyncTask<Void, Void, Cursor> {

        @Override
        protected Cursor doInBackground(Void... voids) {
            return dbAyudante.getAllProductos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if (cursor != null && cursor.getCount() > 0) {
                productoAdaptador.swapCursor( cursor );
            }
        }
    }
}