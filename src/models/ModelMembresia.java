
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Briceyda Angeles
 */
public class ModelMembresia {
     private final ModelMain model_main;        

    public ModelMembresia(ModelMain model_main){
        this.model_main = model_main;
    }
    
private String sql; 
    
    private String id_membresia;
    private String id_cliente;
    private String fechafin;
    private String fechaini;
    private String monto;
    private String tipom;
    private String tipoc;
    private TableModel tabla_membresia;
 
    private Connection conexion;
   public TableModel getTabla_membresia(){
       return tabla_membresia;
    }
    
 
     public String getFechaIn() {
        return fechaini;
    }

    public String getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(String id_membresia) {
        this.id_membresia = id_membresia;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setTipom(String tipom) {
        this.tipom = tipom;
    }

    public void setTipoc(String tipoc) {
        this.tipoc = tipoc;
    }
    
    

    public String getId_cliente() {
        return id_cliente;
    }

    public String getTipoc() {
        return tipoc;
    }

    public String getTipom() {
        return tipom;
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
  
    public void ObtenerMembresias(){
        try{
        model_main.setSql("SELECT * FROM Membrecia;");
        model_main.Preparar_Statement();
        model_main.Ejecutar_Consulta_PS();
        model_main.getRs().first();
        AsignarDatos();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener membresias: " + e);
        }
    }
    public void ActualizarTabla(){
        model_main.setSql("SELECT * FROM Membrecia;");
        model_main.Preparar_Statement();
        model_main.Ejecutar_Consulta();
        tabla_membresia = DbUtils.resultSetToTableModel(model_main.getRs());
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
       public void ObtenerTipoCliente(String id_cliente){ 
        try{
            model_main.setSql("select TIPOC from CLIENTE where ID_CLIENTE =?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_cliente);
            model_main.Ejecutar_Consulta_PS();
            model_main.getRs().first();
            tipoc=model_main.getRs().getString("TIPOC");
        }catch(SQLException e){
        //JOptionPane.showMessageDialog(null, "error 180" + e);
    }
       }
        
        
      
   public void AsignarDatos(){
        try{
            id_membresia = model_main.getRs().getString("id_membrecia");
            id_cliente = model_main.getRs().getString("id_cliente");
            tipom = model_main.getRs().getString("tipo_de_membrecia");
            tipoc = model_main.getRs().getString("tipoc");
            fechaini = model_main.getRs().getString("fecha_inicial");
            fechafin = model_main.getRs().getString("fecha_final");
            monto=model_main.getRs().getString("monto");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "error 102.2" + e);
        }
    }    
   
    public void insertar(){
        try{
            model_main.setSql("INSERT INTO membrecia(id_cliente,  tipoc, fecha_inicial, fecha_final,  tipo_de_membrecia, monto ) VALUES (?,?,?,?,?,?);");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_cliente);
            model_main.getPs().setString(2, tipoc);
            model_main.getPs().setString(3, fechaini);
            model_main.getPs().setString(4, fechafin);
            model_main.getPs().setString(5, tipom);
            model_main.getPs().setString(6, monto);
            
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 108" + e);
        }
    }
    public void borrar(){
        try{
            model_main.setSql("DELETE FROM membrecia WHERE id_membresia = ?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(1, id_membresia);
            model_main.Ejecutar_Actualizacion();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 109" + e);
        }
    }
    public void modificar(){
        try{
            model_main.setSql("UPDATE membrecia SET id_cliente=?, tipom=? , tipoc=? , monto=?, fecha_inicial=?,fecha_final=?,  WHERE id_membresia=?;");
            model_main.Preparar_Statement();
            model_main.getPs().setString(5, id_cliente);
            model_main.getPs().setString(1, tipom);
            model_main.getPs().setString(2, tipoc);
            model_main.getPs().setString(4, monto);
            model_main.getPs().setString(5, fechaini);
            model_main.getPs().setString(6, fechafin);
            model_main.Ejecutar_Actualizacion();

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"error 110" + e);
        }
    }
}
/**********************************BOTONES NAVEGACION **********************************************/    


    
    
    
    
    

