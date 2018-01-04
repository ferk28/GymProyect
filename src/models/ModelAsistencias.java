/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.TableModel;

/**
 *
 * @author Briceyda Angeles
 */
public class ModelAsistencias {
    private final ModelMain model_main;
    
    public ModelAsistencias(ModelMain model_main){
        this.model_main = model_main;
    }

    private int id_cliente;
    private TableModel jtabla;
    private String fecha_actual;
    private String fecha_vencimiento;
    
    
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public TableModel getJtabla() {
        return jtabla;
    }

    public void setJtabla(TableModel jtabla) {
        this.jtabla = jtabla;
    }

    public String getFecha_actual() {
        return fecha_actual;
    }

    public void setFecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    
}
