package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.View_RentaLocker;
import models.ModelRenta;
import models.ModelMain;

/**
 *
 * @author Briceyda Angeles
 */


public final class ControllerRenta implements FocusListener {

    private final ModelRenta model_renta;
    private final View_RentaLocker view_renta;
    private final ModelMain model_main;

    public ControllerRenta(Object[] models, Object[] views, Object[] controllers) {
        this.model_renta = (ModelRenta) models[4];
        this.view_renta = (View_RentaLocker) views[4];
        this.model_main = (ModelMain) models[0];
        initView();
    }

    public void initView() {
        view_renta.addFocusListener(this);
        view_renta.jbtn_primero.addActionListener(e -> jbtn_primero_click());
        view_renta.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
        view_renta.jbtn_agregar.addActionListener(e -> jbtn_agregar_click());
        view_renta.jbtn_editar.addActionListener(e -> jbtn_editar_click());
        view_renta.jbtn_eliminar.addActionListener(e -> jbtn_eliminar_click());
        view_renta.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        view_renta.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
        view_renta.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
        view_renta.jbtn_agregar.setEnabled(false);
        view_renta.jtf_id_renta.setEditable(false);

    }
    
    public void getValores() {
        view_renta.jtf_id_renta.setText("" + model_renta.getId_locker());
        view_renta.jcb_id_cliente.setSelectedItem(model_renta.getId_cliente());
        view_renta.jtf_nombre.setText(model_renta.getNombre());
        view_renta.jtf_inicio.setText(model_renta.getFechaIn());
        view_renta.jtf_final.setText(model_renta.getFechaFin());
        view_renta.jtf_monto.setText(model_renta.getMonto());
    }
    
    public void setValores() {
        model_renta.setId_locker(view_renta.jtf_id_renta.getText());
        model_renta.setId_cliente("" + view_renta.jcb_id_cliente.getSelectedItem());
        model_renta.setMonto(view_renta.jtf_nombre.getText());
        model_renta.setMonto(view_renta.jtf_monto.getText());
        model_renta.setFechaFin(view_renta.jtf_final.getText());
        model_renta.setFechaIn(view_renta.jtf_inicio.getText());
        model_renta.setMonto(view_renta.jtf_monto.getText());
    }   
    
    public void ActualizarInterfaz(){
        view_renta.jcb_id_cliente.removeActionListener(a -> jcb_id_cliente_click());
        model_renta.ActuliazarComboClientes(view_renta.jcb_id_cliente);
        model_renta.ObtenerLocker();
        view_renta.jtb_renta.setModel(model_renta.getTabla_locker());
        getValores();
        view_renta.jcb_id_cliente.addActionListener(a -> jcb_id_cliente_click());
    }
    
    public void jbtn_nuevo_click(){
        view_renta.jtf_id_renta.setText("0");
        view_renta.jcb_id_cliente.setSelectedIndex(0);
        view_renta.jtf_inicio.setText("");
        view_renta.jtf_final.setText("");
        view_renta.jtf_monto.setText("");
        view_renta.jtf_monto.setText("");
        view_renta.jbtn_agregar.setEnabled(true); 
    }
    
    public void jbtn_agregar_click(){
        setValores();
        model_renta.insertar();
        ActualizarInterfaz();
    }
     
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_renta.modificar();
        ActualizarInterfaz();
    }
    public void jcb_id_cliente_click(){
        model_renta.ObtenerTipoCliente("" + view_renta.jcb_id_cliente.getSelectedItem());
    }
    
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_renta.borrar();
        ActualizarInterfaz();
    }
    

      /*   
    public void jcb_tipo_mem_click() {
        String tipo_mem = "" + view_membresia.jcb_tipo_mem.getSelectedItem();
        String tipo_cli = "" + view_membresia.jtf_tipoc.getText();
        
        if (tipo_mem.equals("VISITA")) {
            model_membresia.setMonto("30");
            view_membresia.jtf_monto.setText(model_membresia.getMonto());
        } 
        else if (tipo_mem.equals("SEMANA")) {
            model_membresia.setMonto("90");
            view_membresia.jtf_monto.setText(model_membresia.getMonto());

        } 
        else if (tipo_mem.equals("MES")) {
            if (tipo_cli.equals("E")) {
                model_membresia.setMonto("180");
                view_membresia.jtf_monto.setText(model_membresia.getMonto());
            } 
            else {
                model_membresia.setMonto("200");
                view_membresia.jtf_monto.setText(model_membresia.getMonto());
            }
        } 
        else if (tipo_mem.equals("AÑO")) {
            model_membresia.setMonto("1200");
            view_membresia.jtf_monto.setText(model_membresia.getMonto());
        }
    }
    /*
     /******************************BOTONES NAVEGACION****************************/

    public void jbtn_primero_click(){
        model_main.Mover_Primero();
        model_renta.AsignarDatos();
        getValores();
    }
    
    public void jbtn_ultimo_click(){
        model_main.Mover_Ultimo();
        model_renta.AsignarDatos();
        getValores();     
    }
    
    public void jbtn_anterior_click(){
        model_main.Mover_Anterior();
        model_renta.AsignarDatos();
        getValores();
    }
    public void jbtn_siguiente_click(){
        model_main.Mover_Siguiente();
        model_renta.AsignarDatos();
        getValores();
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        ActualizarInterfaz();
        model_renta.ObtenerLocker();
    }

    @Override
    public void focusLost(FocusEvent e) {
        view_renta.jbtn_agregar.setEnabled(false);
    }
    
}