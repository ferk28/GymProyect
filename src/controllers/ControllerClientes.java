package controllers;
import javax.swing.JOptionPane;
import views.View_Clientes;
import models.ModelClientes;
/**
 *
 * @author Briceyda Angeles
 */
public class ControllerClientes {
    private final ModelClientes model_clientes;
    private final View_Clientes view_clientes;
    
    public ControllerClientes(ModelClientes model_clientes, View_Clientes view_clientes){
        this.model_clientes = model_clientes;
        this.view_clientes = view_clientes;
        
        view_clientes.jbtn_primero.addActionListener(e-> jbtn_primero_click());
        view_clientes.jbtn_ultimo.addActionListener(e-> jbtn_ultimo_click());
        view_clientes.jbtn_siguiente.addActionListener(e-> jbtn_siguiente_click());
        view_clientes.jbtn_anterior.addActionListener(e-> jbtn_anterior_click());
        view_clientes.jbtn_agregar.addActionListener(e-> jbtn_agregar_click());
        view_clientes.jbtn_editar.addActionListener(e-> jbtn_editar_click());
        view_clientes.jbtn_eliminar.addActionListener(e-> jbtn_eliminar_click());
        view_clientes.jbtn_nuevo.addActionListener(e-> jbtn_nuevo_click());
        initView();
        }
    public void initView(){
        model_clientes.Conectar();
        model_clientes.seleccionarTodos();
        model_clientes.moverPrimero();
            
        view_clientes.jbtn_agregar.setEnabled(false);
        view_clientes.jtf_id_cliente.setEditable(false);
        view_clientes.jtf_nombre_cliente.setEditable(false);
        view_clientes.jtf_apellido1.setEditable(false);
        view_clientes.jtf_telefono.setEditable(false);
        view_clientes.jtf_direccion.setEditable(false);
        view_clientes.jtf_monto.setEditable(false);
        view_clientes.jtf_fecha_in.setEditable(false);
        getValores();
    }
    public void getValores(){
        view_clientes.jtf_id_cliente.setText("" + model_clientes.getId_cliente());
        view_clientes.jtf_nombre_cliente.setText(model_clientes.getNombre());
        view_clientes.jtf_apellido1.setText(model_clientes.getApellido1());
        view_clientes.jtf_apellido2.setText(model_clientes.getApellido2());
        view_clientes.jtf_telefono.setText(model_clientes.getTelefono());
        view_clientes.jtf_direccion.setText(model_clientes.getDireccion());
        view_clientes.jtf_monto.setText(model_clientes.getMonto());
        view_clientes.jtf_fecha_in.setText(model_clientes.getFechaIn());
        
    }
    public void setValores(){
        model_clientes.SetId_cliente(Integer.parseInt(view_clientes.jtf_id_cliente.getText()));
        model_clientes.SetNombre(view_clientes.jtf_nombre_cliente.getText());
        model_clientes.SetApellido1(view_clientes.jtf_apellido1.getText());
        model_clientes.SetApellido2(view_clientes.jtf_apellido2.getText());
        model_clientes.SetTelefono(view_clientes.jtf_telefono.getText());
        model_clientes.SetDireccion(view_clientes.jtf_direccion.getText());
        model_clientes.SetMonto(view_clientes.jtf_monto.getText());
        model_clientes.SetFechaIn(view_clientes.jtf_fecha_in.getText());
        
    }
    public void jbtn_nuevo_click(){
        agregar_true();
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
        JOptionPane.showMessageDialog(null, "Añade");
        }else{
        setValores();
        model_clientes.insertar();
        getValores();
        agregar_falso();
        }
    }
    public void jbtn_editar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se modificará el registro ¿Desea continuar?",
        "Modificar registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_clientes.actualizar();
        getValores();
    }
    public void jbtn_eliminar_click(){
        setValores();
        if (JOptionPane.showConfirmDialog(null, "Se eliminará el registro, ¿Desea continuar?",
        "Eliminar Registro", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        model_clientes.borrar();
        getValores();
    }
    public void jbtn_primero_click(){
        model_clientes.moverPrimero();
        getValores();
        agregar_falso();
    }
    public void jbtn_ultimo_click(){
        model_clientes.moverUltimo();
        getValores();
        agregar_falso();        
    }
    public void jbtn_anterior_click(){
        model_clientes.moverAnterior();
        getValores();
        agregar_falso();
    }
    public void jbtn_siguiente_click(){
        model_clientes.moverSiguiente();
        getValores();
        agregar_falso();
    }
    
    public void agregar_falso(){
        view_clientes.jbtn_agregar.setEnabled(false);
        view_clientes.jbtn_editar.setEnabled(true);
        view_clientes.jbtn_eliminar.setEnabled(true);          
    }
    public void agregar_true(){
        view_clientes.jbtn_agregar.setEnabled(true);
        view_clientes.jbtn_eliminar.setEnabled(false);
        view_clientes.jbtn_editar.setEnabled(false);        
    }
}
