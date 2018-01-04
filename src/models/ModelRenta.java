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
public class ModelRenta{
     private final ModelMain model_main;        

    public ModelRenta(ModelMain model_main){
        this.model_main = model_main;
    }
    
private String sql; 
    
    private String id_locker;
    private String id_cliente;
    private String nombre;
    private String fechafin;
    private String fechaini;
    private String monto;
    
    private TableModel tabla_locker;
 
    private Connection conexion;
   public TableModel getTabla_locker(){
       return tabla_locker;
    }
    public String getId_locker() {
        return id_locker;
    }

    public void setId_locker(String id_locker) {
        this.id_locker = id_locker;
    }
 
     public String getFechaIn() {
        return fechaini;
    }
     

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public String getId_cliente() {
        return id_cliente;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setFechaIn(String fechaini) {
        this.fechaini = fechaini;
    }
    
    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getMonto() {
        return monto;
    }
    public void setMonto(String monto ) {
        this.monto = monto;
    }
    public String getFechaFin() {
        return fechafin;
    }
    public void setFechaFin(String fechafin) {
        this.fechafin = fechafin;
    }
  
    public void ObtenerLocker(){
        try{
        model_main.setSql("SELECT * FROM LOCKER;");
        model_main.Preparar_Statement();
        model_main.Ejecutar_Consulta_PS();
        tabla_locker = DbUtils.resultSetToTableModel(model_main.getRs());
        model_main.getRs().first();
        AsignarDatos();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener locker: " + e);
        }
    }
    
    
    public void ActuliazarComboClientes(javax.swing.JComboBox ComboCliente){
        try{
            model_main.setSql("select ID_CLIENTE from cliente order by id_cliente asc;");
            model_main.Preparar_Statement();
            model_main.Ejecutar_Consulta_PS();
            ComboCliente.removeAllItems();
            while(model_main.getRs().next()){
                ComboCliente.addItem(model_main.getRs().getString("ID_CLIENTE"));
            }
            ComboCliente.setSelectedIndex(0);
        }
            catch(SQLException e){
                //
        }
    }
      
         public void ObtenerTipoCliente(String id_cliente) {
        try {
            model_main.setSql("select ID_CLIENTE from CLIENTE where ID_CLIENTE =?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_cliente);
            model_main.Ejecutar_Consulta_PS2();
            model_main.getRs2().first();
            id_cliente = model_main.getRs2().getString("ID_CLIENTE");
        } 
        catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "error 180" + e);
        }
    }
         public void ObtenerNombreCliente(String id_cliente) {
        try {
            model_main.setSql("select NOMBRE from CLIENTE where ID_CLIENTE =?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_cliente);
            model_main.Ejecutar_Consulta_PS2();
            model_main.getRs2().first();
            nombre = model_main.getRs2().getString("NOMBRE");
        } 
        catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "error 180" + e);
        }
    }
       
   public void AsignarDatos(){
        try{
            id_locker = model_main.getRs().getString("id_locker");
            id_cliente = model_main.getRs().getString("id_cliente");
            nombre = model_main.getRs().getString("nombre");
            fechaini = model_main.getRs().getString("fecha_de_inicio");
            fechafin = model_main.getRs().getString("fecha_final");
            monto=model_main.getRs().getString("monto");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "No Encuentra datos" + e);
        }
    }    
   
    public void insertar(){
        try{
            model_main.setSql("INSERT INTO LOCKER(id_cliente, nombre fecha_de_inicio, fecha_final,  monto ) VALUES (?,?,?,?,?);");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_cliente);
            model_main.getPs().setString(2, nombre);
            model_main.getPs().setString(3, fechaini);
            model_main.getPs().setString(4, fechafin);
            model_main.getPs().setString(5, monto);
            
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            model_main.setSql("DELETE FROM LOCKER WHERE id_locker = ?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_locker);
            model_main.Ejecutar_Actualizacion();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }
    public void modificar(){
        try{
            model_main.setSql("UPDATE LOCKER SET id_cliente=?, fecha_de_inicio=?,fecha_final=?,monto=?,  WHERE ID_LOCKER=?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_cliente);
            model_main.getPs().setString(2, fechaini);
            model_main.getPs().setString(3, fechafin);
            model_main.getPs().setString(4, monto);
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    }
}