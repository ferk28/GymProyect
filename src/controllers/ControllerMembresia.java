package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.View_Membresia;
import models.ModelMembresia;
import models.ModelMain;

/**
 *
 * @author Briceyda Angeles
 */


public final class ControllerMembresia implements FocusListener {
    private final ModelMembresia model_membresia;
    private final View_Membresia view_membresia;  
    private final ModelMain model_main;
    
public ControllerMembresia(Object models[],Object views[], Object controllers[]){
        this.model_membresia = (ModelMembresia)models[3];
        this.view_membresia = (View_Membresia)views[3];
        this.model_main = (ModelMain)models[0];

        initView();
        }

public void initView(){
        view_membresia.addFocusListener(this);
        view_membresia.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_membresia.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_membresia.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_membresia.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_membresia.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_membresia.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());         
        view_membresia.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_membresia.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_membresia.jcb_tipo_mem.addActionListener(e-> jcb_tipo_mem_click());
        view_membresia.jbtn_agregar.setEnabled(false);
        view_membresia.jtf_id_membresia.setEditable(false);
           
    }
  public void getValores(){
        view_membresia.jtf_id_membresia.setText("" + model_membresia.getId_membresia());
        view_membresia.jtf_tipoc.setText(model_membresia.getTipoc());
        view_membresia.jtf_monto.setText(model_membresia.getMonto());
        view_membresia.jcb_tipo_mem.setSelectedItem(model_membresia.getTipom());
        view_membresia.jtf_inicio.setText(model_membresia.getFechaIn());
        view_membresia.jtf_final.setText(model_membresia.getFechaFin());
  }
   public void setValores(){
        model_membresia.setId_membresia(view_membresia.jtf_id_membresia.getText());
        model_membresia.setTipom("" + view_membresia.jcb_tipo_mem.getSelectedItem());
        model_membresia.setId_cliente("" + view_membresia.jcb_id_cliente.getSelectedItem());
        model_membresia.setMonto(view_membresia.jtf_monto.getText());
        model_membresia.setFechaFin(view_membresia.jtf_final.getText());
        model_membresia.setFechaIn(view_membresia.jtf_inicio.getText());
        model_membresia.setMonto(view_membresia.jtf_monto.getText());
        
                
    }    
    public void ActualizarInterfaz(){
        model_membresia.ActualizarTabla();
        getValores();
        view_membresia.jtb_membrecia.setModel(model_membresia.getTabla_membresia());
    }
     public void jbtn_nuevo_click(){
     
        view_membresia.jtf_id_membresia.setText("0");
        view_membresia.jtf_inicio.setText("");
        view_membresia.jtf_final.setText("");
        view_membresia.jtf_monto.setText("");
        view_membresia.jcb_tipo_mem.setSelectedIndex(0);
        view_membresia.jtf_tipoc.setText("");
        view_membresia.jtf_monto.setText("");
        
       
    }
     public void jbtn_agregar_click(){
        setValores();
        model_membresia.insertar();
        ActualizarInterfaz();
    }
     
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_membresia.modificar();
        ActualizarInterfaz();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_membresia.borrar();
        ActualizarInterfaz();
    }
 
            
         
    
     /******************************BOTONES NAVEGACION****************************/
    public void jbtn_primero_click(){
        model_main.Mover_Primero();
        model_membresia.AsignarDatos();
        getValores();
    
    }
    public void jbtn_ultimo_click(){
        model_main.Mover_Ultimo();
        model_membresia.AsignarDatos();
        getValores();
             
    }
    public void jbtn_anterior_click(){
        model_main.Mover_Anterior();
        model_membresia.AsignarDatos();
        getValores();
        
    }
    public void jbtn_siguiente_click(){
        model_main.Mover_Siguiente();
        model_membresia.AsignarDatos();
        getValores();
      
    }
    public void jcb_tipo_mem_click(){
        String tipo_mem = view_membresia.jtf_tipoc.getText();
        String tipo_cli = "";
        tipo_mem = "" + view_membresia.jcb_tipo_mem.getSelectedItem();
        if (tipo_mem.equals("VISITA")){
            model_membresia.setMonto("30");
            view_membresia.jtf_monto.setText(model_membresia.getMonto());
        }
        
        else if(tipo_mem.equals("SEMANA")){
            model_membresia.setMonto("90");
            view_membresia.jtf_monto.setText(model_membresia.getMonto());
        
        }
        else if(tipo_mem.equals("MES")){
            if(tipo_cli.equals("E")){
                model_membresia.setMonto("180");
            }
            else{
                model_membresia.setMonto("200");
                view_membresia.jtf_monto.setText(model_membresia.getMonto());
            }
        }
        else if(tipo_mem.equals("AÑO")){
            model_membresia.setMonto("1200");
            view_membresia.jtf_monto.setText(model_membresia.getMonto());
        }
    }
    public void jbtn_tipo_de_cliente(){
         model_membresia.ObtenerTipoCliente(view_membresia.jcb_id_cliente.getSelectedItem() + "");
         view_membresia.jtf_tipoc.setText(model_membresia.getTipoc());
         view_membresia.jbtn_agregar.setEnabled(true);
    }
    
    @Override
    public void focusGained(FocusEvent e) {
        model_membresia.ActualizarTabla();
        view_membresia.jtb_membrecia.setModel(model_membresia.getTabla_membresia());
        model_membresia.ActuliazarComboClientes(view_membresia.jcb_id_cliente);
        view_membresia.jcb_id_cliente.addActionListener(a-> jbtn_tipo_de_cliente());
        model_membresia.ObtenerMembresias();
        getValores();
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
}
