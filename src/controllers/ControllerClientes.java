package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import views.View_Clientes;
import models.ModelClientes;
import models.ModelMain;

/**
 *
 * @author Briceyda Angeles
 */


public final class ControllerClientes implements FocusListener {
    private final ModelClientes model_clientes;
    private final View_Clientes view_clientes;  
    private final ModelMain model_main;
    
public ControllerClientes(Object models[], Object views[], Object controllers[]){
        this.model_clientes = (ModelClientes)models[2];
        this.view_clientes = (View_Clientes)views[2];
        this.model_main = (ModelMain)models[0];

        initView();
        }

public void initView(){
        view_clientes.addFocusListener(this);
        
        view_clientes.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_clientes.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_clientes.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_clientes.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_clientes.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_clientes.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());         
        view_clientes.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_clientes.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_clientes.jbtn_buscar.addActionListener(e-> jbtn_buscar_click());
        
           
    }
  public void getValores(){
        view_clientes.jtf_id_cliente.setText("" + model_clientes.getId_cliente());
        view_clientes.jtf_nombre_cliente.setText(model_clientes.getNombre());
        view_clientes.jtf_apellido1.setText(model_clientes.getApellido1()); 
        view_clientes.jtf_apellido2.setText(model_clientes.getApellido2());
        view_clientes.jcb_tipo_cliente.setSelectedItem(model_clientes.getTipo());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_monto.setText(model_clientes.getMonto());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
        view_clientes.jtf_fecha_in.setText(model_clientes.getFecha());
       
  }
   public void setValores(){
        model_clientes.setId_cliente(Integer.parseInt(view_clientes.jtf_id_cliente.getText()));
        model_clientes.setNombre(view_clientes.jtf_nombre_cliente.getText());
        model_clientes.setApellido1(view_clientes.jtf_apellido1.getText());
        model_clientes.setApellido2(view_clientes.jtf_apellido2.getText());
        model_clientes.setTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.setDireccion(view_clientes.jtf_direccion.getText());
        model_clientes.setMonto(view_clientes.jtf_monto.getText());
        model_clientes.setFecha(view_clientes.jtf_fecha_in.getText());
        model_clientes.setBuscar(view_clientes.jtf_buscar.getText());        
    }    
    public void ActualizarInterfaz(){
        model_clientes.llenarActualizarDatos();
        view_clientes.jtb_cliente.setModel(model_clientes.getTabla_clientes());
        getValores();
    }
     public void jbtn_nuevo_click(){
     
        view_clientes.jtf_id_cliente.setText("0");
        view_clientes.jtf_nombre_cliente.setText("");
        view_clientes.jtf_apellido1.setText("");
        view_clientes.jtf_apellido2.setText("");
        view_clientes.jtf_telefono.setText("");
        view_clientes.jtf_direccion.setText("");
        view_clientes.jtf_monto.setText("");
        view_clientes.jtf_fecha_in.setText("");
       
    }
     public void jbtn_agregar_click(){
        
        if(view_clientes.jtf_nombre_cliente.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese texto");
        }else{
        setValores();
        model_clientes.insertar();
        ActualizarInterfaz();
        
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_clientes.modificar();
        ActualizarInterfaz();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_clientes.borrar();
        ActualizarInterfaz();
    }
         
    /*****************************BUSCAR**********************************************/
    public void jbtn_buscar_click(){
        model_clientes.setBuscar(view_clientes.jtf_buscar.getText());
        model_clientes.buscar_jtable();
        view_clientes.jtb_cliente.setModel(model_clientes.getTabla_clientes());
    }
     /******************************BOTONES NAVEGACION****************************/
    public void jbtn_primero_click(){
        model_main.Mover_Primero();
        model_clientes.AsignarDatos();
        getValores();
    
    }
    public void jbtn_ultimo_click(){
        model_main.Mover_Ultimo();
        model_clientes.AsignarDatos();
        getValores();
             
    }
    public void jbtn_anterior_click(){
        model_main.Mover_Anterior();
        model_clientes.AsignarDatos();
        getValores();
        
    }
    public void jbtn_siguiente_click(){
        model_main.Mover_Siguiente();
        model_clientes.AsignarDatos();
        getValores();
      
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        model_clientes.llenarActualizarDatos();
        view_clientes.jtb_cliente.setModel(model_clientes.getTabla_clientes());
        model_clientes.ObtenerClientes();
        getValores();
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
    
    
    
}
    