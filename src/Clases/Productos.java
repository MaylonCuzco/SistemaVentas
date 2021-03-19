/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author DELL
 */
public class Productos {
    
    /**
     * ATRIBUTOS
     */
    
    private String codigo;
    private String nombre;
    private String detalle;
    private Double precio;
    private int stockMinimo;
    private int stockActual;
    
    /**
     * CONSTRUCTOR
     * @param codigo
     * @param nombre
     * @param detalle
     * @param precio
     * @param stockMinimo
     * @param stockActual
     */
    public Productos(String codigo, String nombre, String detalle, Double precio, int stockMinimo, int stockActual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.detalle = detalle;
        this.precio = precio;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
    }
    
    public Productos() {
        this.codigo ="";
        this.nombre = "";
        this.detalle = "";
        this.precio = 0.0;
        this.stockMinimo = 0;
        this.stockActual = 0;
    }

    /**
     * METODOS SETTERS Y GETTERS
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }
    
    /**
     * REGISTAR PRODUCTO
     */
    
    
    
}
