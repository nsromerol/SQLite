package com.Kureikode.sqlite.DB;


import android.content.ContentValues;
import android.database.Cursor;
import com.Kureikode.sqlite.DB.productosContract.ProductosEntry;
public class Productos {
    private int id;
    private String nombre_prod;
    private String descripcion;
    private int stock;
    private float valor;
    private int salidas;

    public Productos(int id, String nombre_prod, String descripcion, int stock, float valor, int salidas) {
        this.id = id;
        this.nombre_prod = nombre_prod;
        this.descripcion = descripcion;
        this.stock = stock;
        this.valor = valor;
        this.salidas = salidas;
    }

    public Productos(Cursor cursor){
        id= cursor.getInt(cursor.getColumnIndexOrThrow(ProductosEntry.ID_PRODUCTO));
        nombre_prod=cursor.getString(cursor.getColumnIndexOrThrow(ProductosEntry.NOMBRE));
        descripcion= cursor.getString(cursor.getColumnIndexOrThrow(ProductosEntry.DESCRIPCION));
        stock =cursor.getInt(cursor.getColumnIndexOrThrow(ProductosEntry.STOCK));
        valor =cursor.getFloat(cursor.getColumnIndexOrThrow(ProductosEntry.PRECIO));
        salidas = cursor.getInt(cursor.getColumnIndexOrThrow(ProductosEntry.SALIDAS));
    }

    public ContentValues toContentValues() {
        ContentValues Values =new ContentValues();
        Values.put(ProductosEntry.ID_PRODUCTO,id);
        Values.put(ProductosEntry.NOMBRE,nombre_prod);
        Values.put(ProductosEntry.DESCRIPCION,descripcion);
        Values.put(ProductosEntry.STOCK, stock);
        Values.put(ProductosEntry.PRECIO, valor);
        Values.put(ProductosEntry.SALIDAS, salidas);
        return Values;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getStock() {
        return stock;
    }

    public float getValor() {
        return valor;
    }

    public int getSalidas() {
        return salidas;
    }
}

