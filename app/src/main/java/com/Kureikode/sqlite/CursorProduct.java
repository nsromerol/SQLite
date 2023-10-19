package com.Kureikode.sqlite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.Kureikode.sqlite.DB.productosContract;

public class CursorProduct extends CursorAdapter {

    public CursorProduct(Context context, Cursor objects){
        super(context,objects,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.fragment_producto, parent, false);
    }



    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameList = (TextView) view.findViewById( R.id.nombre_lista );
        TextView stockList = (TextView) view.findViewById( R.id.stock_lista );
        TextView valueList = (TextView) view.findViewById( R.id.valor_lista );

        @SuppressLint("Range") String name_prod = cursor.getString(cursor.getColumnIndex(productosContract.ProductosEntry.NOMBRE));
        @SuppressLint("Range") Integer stock_prod = cursor.getInt(cursor.getColumnIndex( productosContract.ProductosEntry.STOCK ) );
        @SuppressLint("Range") Integer value_prod = cursor.getInt(cursor.getColumnIndex( productosContract.ProductosEntry.PRECIO) );
        nameList.setText(name_prod );
        stockList.setText( stock_prod.toString());
        valueList.setText(value_prod.toString());

    }
}