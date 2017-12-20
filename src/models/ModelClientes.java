
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Briceyda Angeles
 */


public class ModelClientes {
    private final ModelMain model_main;        

    public ModelClientes(ModelMain model_main){
        this.model_main = model_main;
    }
    
private String sql; 
    
    private int id_cliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String direccion;
    private String monto;
    private String fecha;
    private TableModel tabla_clientes;
    private String buscar;
    private String tipo;
 
 
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
    public TableModel getTabla_clientes(){
       return tabla_clientes;
    }
    
    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    
     public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion ) {
        this.direccion = direccion;
    }
    public String getMonto() {
        return monto;
    }
    public void setMonto(String monto ) {
        this.monto = monto;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
   public void AsignarDatos(){
        try{
            id_cliente = model_main.getRs().getInt("id_cliente");
            nombre = model_main.getRs().getString("nombre");
            apellido1 = model_main.getRs().getString("apellido_pa");
            apellido2 = model_main.getRs().getString("apellido_ma");
            telefono = model_main.getRs().getString("telefono");
            direccion = model_main.getRs().getString("direccion");
            monto=model_main.getRs().getString("monto");
            tipo=model_main.getRs().getString("tipoc");
            fecha =model_main.getRs().getString("fecha_de_ingreso");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    
   
   public void ObtenerClientes (){
       try{
        model_main.setSql("SELECT * FROM CLIENTE;");
        model_main.Preparar_Statement();
        model_main.Ejecutar_Consulta_PS();
        model_main.getRs().first();
        AsignarDatos();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener Clientes: " + e);
        }
    }
   
    public void llenarActualizarDatos(){
        model_main.setSql("SELECT * FROM cliente;");
        model_main.Ejecutar_Consulta();
        tabla_clientes = DbUtils.resultSetToTableModel(model_main.getRs());

    }
    public void buscar_jtable(){

        model_main.setSql("SELECT * FROM cliente WHERE nombre LIKE ('%"+buscar+"%') OR apellido_pa LIKE ('%"+buscar+"%');");       
        model_main.Ejecutar_Consulta();
        tabla_clientes = DbUtils.resultSetToTableModel(model_main.getRs());
        model_main.Mover_Primero();
        AsignarDatos();
        System.out.println("buscar jtable");
    }    

    public void insertar(){
        try{
            model_main.setSql("INSERT INTO cliente(nombre,apellido_pa,apellido_ma, telefono, direccion, monto,fecha_de_ingreso,tipoc) VALUES (?,?,?,?,?,?,?,?);");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, nombre);
            model_main.getPs().setString(2, apellido1);
            model_main.getPs().setString(3, apellido2);
            model_main.getPs().setString(4, telefono);
            model_main.getPs().setString(5, direccion);
            model_main.getPs().setString(6, monto);
            model_main.getPs().setString(7, fecha);
            model_main.getPs().setString(8, tipo);
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            model_main.setSql("DELETE FROM cliente WHERE id_cliente = ?;");
            model_main.Preparar_Statement();
            model_main.getPs().setInt(1, id_cliente);
            model_main.Ejecutar_Actualizacion();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }
    public void modificar(){
        try{
            model_main.setSql("UPDATE cliente SET nombre=? , apellido_pa=? , apellido_ma=? , telefono=?, direccion=?,monto=?, fecha_de_ingreso=?, tipoc=? WHERE id_cliente=?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, nombre);
            model_main.getPs().setString(2, apellido1);
            model_main.getPs().setString(3, apellido2);
            model_main.getPs().setString(4, telefono );
            model_main.getPs().setString(5, direccion);
            model_main.getPs().setString(6, monto);
            model_main.getPs().setString(7, fecha);
            model_main.getPs().setString(8, tipo);
            model_main.getPs().setInt(9, id_cliente);
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    }
        public void buscar(){
        try {
            model_main.setSql("SELECT * FROM cliente WHERE nombre LIKE CONCAT('%',? '%') OR apellido_pa LIKE CONCAT('%',? '%');");            
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, buscar);
            model_main.getPs().setString(2, buscar);
            model_main.Ejecutar_Consulta_PS();
            System.out.println(sql);
            tabla_clientes = DbUtils.resultSetToTableModel(model_main.getRs());
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "error al buscar" + e);
        }
        

    }
}