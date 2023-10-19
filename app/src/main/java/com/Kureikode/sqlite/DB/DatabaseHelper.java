package com.Kureikode.sqlite.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.Kureikode.sqlite.DB.productosContract.ProductosEntry;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Sqlite.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + ProductosEntry.TABLE_NAME + " ("+
                ProductosEntry.ID_PRODUCTO + " INTEGER PRIMARY KEY," +
                ProductosEntry.NOMBRE+ " TEXT NOT NULL," +
                ProductosEntry.DESCRIPCION+ " INTEGER NOT NULL," +
                ProductosEntry.STOCK+ " INTEGER NOT NULL,"+
                ProductosEntry.PRECIO + " INTEGER NOT NULL,"+
                ProductosEntry.SALIDAS + " INTEGER NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveProducto(Productos producto) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(
                ProductosEntry.TABLE_NAME,
                null,
                producto.toContentValues());
    }

    public Cursor getAllProductos() {
        return getReadableDatabase()
                .query(
                        ProductosEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null);
    }

    public Cursor getProductoById(String productoId) {
        Cursor dan = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.ID_PRODUCTO + " = ?",
                new String[]{productoId},
                null,
                null,
                null);
        return dan;
    }

    public Cursor getProductoByName(String productoName) {
        Cursor dan = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.NOMBRE + " = ?",
                new String[]{productoName},
                null,
                null,
                null);
        return dan;
    }

    public Cursor getProductoByStock(String productoStock) {
        Cursor dan = getReadableDatabase().query(
                ProductosEntry.TABLE_NAME,
                null,
                ProductosEntry.STOCK + " = ?",
                new String[]{productoStock},
                null,
                null,
                null);
        return dan;
    }

    public int deleteProducto(String productoId) {
        return getWritableDatabase().delete(
                ProductosEntry.TABLE_NAME,
                ProductosEntry.ID_PRODUCTO+ " = ?",
                new String[]{productoId});
    }

    public int updateProducto(Productos productoModificar, String productoId) {
        return getWritableDatabase().update(
                ProductosEntry.TABLE_NAME,
                productoModificar.toContentValues(),
                ProductosEntry.ID_PRODUCTO + " = ?",
                new String[]{productoId}
        );
    }

    public int updateProductoNAMESTOCKVALUE(Productos productoModificar, String productoStock) {
        return getWritableDatabase().update(
                ProductosEntry.TABLE_NAME,
                productoModificar.toContentValues(),
                ProductosEntry.NOMBRE + " = ?",
                new String[]{productoStock}
        );
    }
}
