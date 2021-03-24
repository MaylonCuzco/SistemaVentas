/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;



/**
 *
 * @author DELL
 */
public class Movimiento {
    /**
     * ATRIBUTOS
     */
    private String codigo;
    private String producto;
    private int cantidad;
    private Date fecha;

    /**
     * CONSTRUCTORES
     * @param codigo
     * @param producto
     * @param cantidad
     * @param fecha 
     */
    public Movimiento(String codigo, String producto, int cantidad, Date fecha) {
        this.codigo = codigo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    
    public Movimiento() {
        this.codigo = "";
        this.producto = "";
        this.cantidad = 0;
        this.fecha = null;
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

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
}
