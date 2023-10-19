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
        id= cursor.getInt(cursor.getColumnIndex(ProductosEntry.ID));
        nombre_prod=cursor.getString(cursor.getColumnIndex(ProductosEntry.NAME));
        descripcion= cursor.getString(cursor.getColumnIndex(ProductosEntry.DESCRIPTION));
        stock =cursor.getInt(cursor.getColumnIndex(ProductosEntry.QUANTITY));
        valor =cursor.getFloat(cursor.getColumnIndex(ProductosEntry.PRICE));
        salidas = cursor.getInt(cursor.getColumnIndex(ProductosEntry.OUT));
    }

    public ContentValues toContentValues() {
        ContentValues Values =new ContentValues();
        Values.put(ProductosEntry.ID,id);
        Values.put(ProductosEntry.NAME,nombre_prod);
        Values.put(ProductosEntry.DESCRIPTION,descripcion);
        Values.put(ProductosEntry.QUANTITY, stock);
        Values.put(ProductosEntry.PRICE, valor);
        Values.put(ProductosEntry.OUT, salidas);
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

