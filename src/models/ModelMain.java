package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Briceyda Angeles Perez
 */

public class ModelMain {
    private Connection sql_connection;
    private Statement sql_statement;
    private PreparedStatement sql_prepared_statement;
    private ResultSet sql_result_set;
    private String sql;
    
    private MessageDigest md5;
    private StringBuilder string_builder;
    
    public void Connect(){
        try {
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/gymolympus","root","1234");
            sql_statement = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e);
        }
    }
    
    public void Ejecutar_Consulta() {
        try {
            Connect();
            sql_result_set = sql_statement.executeQuery(sql);
//            sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta: " + e);
        }
    }
    
    public void Ejecutar_Consulta_PS() {
        try {
            sql_result_set = sql_prepared_statement.executeQuery();
            //sql_connection.close();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta: " + e);
        }
    }

    public void Ejecutar_Actualizacion() {
        try {
            sql_prepared_statement.executeUpdate();
            //sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar actualización: " + e);
        }
    }

    public void Ejecutar_Sentencia() {
        try {
            Connect();
            sql_statement.execute(sql);
            //sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
    }

    public void Preparar_Statement() {
        try {
            Connect();
            sql_prepared_statement = sql_connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al preparar statement: " + e);
        }
    }
    
    public String Cifrar(String texto, String tipo_cifrado){
        try{
            md5 = MessageDigest.getInstance(tipo_cifrado);
            byte[] auxiliar_cifrado = md5.digest(texto.getBytes());
            string_builder = new StringBuilder();
            for(int x = 0; x < auxiliar_cifrado.length; x ++){
                string_builder.append(Integer.toHexString((auxiliar_cifrado[x] & 0xFF) | 0x100).substring(1,3));
            }
            return string_builder.toString();
        }
        catch(NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, "Error al cifrar la información" + e);
        }
        return "";
    }

    public Connection getSql_connection() {
        return sql_connection;
    }

    public void setSql_connection(Connection sql_connection) {
        this.sql_connection = sql_connection;
    }

    public Statement getSql_statement() {
        return sql_statement;
    }

    public void setSql_statement(Statement sql_statement) {
        this.sql_statement = sql_statement;
    }

    public PreparedStatement getSql_prepared_statement() {
        return sql_prepared_statement;
    }

    public void setSql_prepared_statement(PreparedStatement sql_prepared_statement) {
        this.sql_prepared_statement = sql_prepared_statement;
    }

    public ResultSet getSql_result_set() {
        return sql_result_set;
    }

    public void setSql_result_set(ResultSet sql_result_set) {
        this.sql_result_set = sql_result_set;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
    
    
}
   