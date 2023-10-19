package com.Kureikode.sqlite.DB;

import android.content.ContentValues;
import android.database.Cursor;
import com.Kureikode.sqlite.DB.MovimientosContract.MovimientosEntry;


public class Movimientos {

    private int idUsuario;
    private int idProducto;
    private int accion;
    private int cantidad;

    public Movimientos(int id, int idProd, int accion, int cantidadProd) {
        this.idUsuario = id;
        this.idProducto = idProd;
        this.accion = accion;
        this.cantidad = cantidadProd;
    }

    public Movimientos(Cursor cursor) {
        this.idUsuario = cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ID_USUARIO));
        this.idProducto = cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ID_PRODUCTO));
        this.accion = cursor.getInt(cursor.getColumnIndex(MovimientosEntry.ACCION));
        this.cantidad = cursor.getInt(cursor.getColumnIndex(MovimientosEntry.CANTIDAD));
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(MovimientosEntry.ID_USUARIO, idUsuario);
        values.put(MovimientosEntry.ID_PRODUCTO, idProducto);
        values.put(MovimientosEntry.ACCION, accion);
        values.put(MovimientosEntry.CANTIDAD, cantidad);
        return values;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public int getAccion() {
        return accion;
    }

    public int getCantidad() {
        return cantidad;
    }
}
