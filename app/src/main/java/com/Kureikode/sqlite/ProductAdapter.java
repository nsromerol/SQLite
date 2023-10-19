package com.Kureikode.sqlite;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import com.Kureikode.sqlite.DB.Productos;

public class ProductAdapter extends ArrayAdapter<Productos> {

    public ProductAdapter(Context context, List<Productos> objects){
        super(context,0,objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        if (null == convertView){
            convertView = inflater.inflate(
                    R.layout.fragment_producto,
                    parent,
                    false
            );
        }

        TextView nameList = (TextView) convertView.findViewById( R.id.nombre_lista );
        TextView stockList = (TextView) convertView.findViewById( R.id.stock_lista );
        TextView valueList = (TextView) convertView.findViewById( R.id.valor_lista );

        Productos productoActual = getItem( position );

        nameList.setText(productoActual.getNombre_prod());
        stockList.setText(Integer.toString(productoActual.getStock()));
        valueList.setText(Float.toString(productoActual.getValor()) );


        return convertView;
    }

}