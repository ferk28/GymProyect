
package models;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Briceyda Angeles
 */
public class ModelClientes {
/*    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql; 
    
    private int id_cliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String direccion;
    private String monto;
    private String fechain;
    
    public void SetId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
    public void SetApellido1(String apellido1){
        this.apellido1 = apellido1;
    }
    public void SetApellido2(String apellido2){
        this.apellido2 = apellido2;
    }
    public void SetTelefono(String telefono){
        this.telefono = telefono;
    }
    public void SetDireccion(String apellido2){
        this.apellido2 = apellido2;
    }
    public void SetMonto(String monto){
        this.monto = monto;
    }
     public void SetFechaIn(String fechain){
        this.fechain = fechain;
     }
    public int getId_cliente(){
        return id_cliente;
    }
    public String getNombre(){
        return nombre;
    }
     public String getApellido1(){
        return nombre;
    }
      public String getApellido2(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getMonto(){
        return monto;
    }
    public String getFechaIn(){
        return fechain;
    }
    
    public void Conectar(){
    try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/GYMOLYMPUS","root","1234");
        st = conexion.createStatement();
        }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error 101" + e);
        }    
    }
   public void llenarValores(){
        try{
            SetId_cliente(rs.getInt("id_cliente"));
            SetNombre(rs.getString("Nombre"));
            SetApellido1(rs.getString("apellido_pa"));
            SetApellido2(rs.getString("apellido_ma"));
            SetTelefono(rs.getString("telefono"));
            SetDireccion(rs.getString("direccion"));
            SetApellido2(rs.getString("apellido_ma"));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102" + e);
        }
    }    
    public void moverPrimero(){
        try{
            rs.first();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 103" + e);
        }
    }
    public void moverUltimo(){
        try{
            rs.last();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 104" + e);
        }
    }
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false)
            rs.next();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 105" + e);
        }
    }
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false)
            rs.previous();
            llenarValores();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 106" + e);
        }
    }    

    public void seleccionarTodos(){
        try{
            sql="SELECT * FROM CLIENTE;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 107" + e);
        }
    }
    public void insertar(){
        try{
            sql= "INSERT INTO CLIENTE(nombre, telefono,apellido_pa, apellido_ma,telefono,direccion,monto,fecha_de_ingreso) VALUES (?,?,?,?,?,?);";
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, monto);
            ps.setString(7, fechain);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            sql="DELETE FROM CLIENTE WHERE id_cliente = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.executeQuery();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }
    public void actualizar(){
        try{
            sql= "UPDATE CLIENTE SET nombre=? , apellido1=? ,apellido2=?, telefono=?, direccion=?, monto=?, fecha_de_ingreso=?,WHERE id_cliente=?;";
            ps = conexion.prepareStatement(sql);
           
            ps.setString(1, nombre);
            ps.setString(2, apellido1);
            ps.setString(3, apellido2);
            ps.setString(4, telefono);
            ps.setString(5, direccion);
            ps.setString(6, monto);
            ps.setString(7, fechain);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    }
*/
}

