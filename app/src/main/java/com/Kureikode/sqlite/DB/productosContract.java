package com.Kureikode.sqlite.DB;

import android.provider.BaseColumns;

public class productosContract {

    public static abstract class ProductosEntry implements BaseColumns {
        public static final String TABLE_NAME ="productos";
        public static final String ID_PRODUCTO = "id_producto";
        public static final String NOMBRE = "nombre_producto";
        public static final String DESCRIPCION = "descripcion_producto";
        public static final String STOCK = "stock";
        public static final String PRECIO = "precio_producto";
        public static final String SALIDAS = "salidas_producto";
    }

}
