package com.Kureikode.sqlite.DB;

import android.provider.BaseColumns;

public class MovimientosContract{
    public static abstract class MovimientosEntry implements BaseColumns {

        public static final String TABLE_NAME ="productos";
        public static final String ID_PRODUCTO = "id_producto";
        public static final String ID_USUARIO = "id_usuario";
        public static final String ACCION = "accion";
        public static final String CANTIDAD = "cantidad";
    }
}
