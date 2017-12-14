package models;

import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Briceyda Angeles
 */

public class ModelVerificacionUsuario {
    private final ModelMain model_main;
    
    private String usuario;
    private char[] contraseña_usuario;
    private String contraseña_usuario_s;
    private String tipo_usuario;
    
    public ModelVerificacionUsuario(ModelMain model_main){
        this.model_main = model_main;
    }
    
    public void Verificar_Usuario(){
        try{
            contraseña_usuario_s = model_main.Cifrar(contraseña_usuario_s, "MD5");
            model_main.setSql("SELECT COUNT(Usuario)AS Verificado FROM Usuarios WHERE Usuario = ? AND PASSWORD = ?;");
            model_main.Preparar_Statement();
            model_main.getSql_prepared_statement().setString(1, usuario);
            model_main.getSql_prepared_statement().setString(2, contraseña_usuario_s);
            model_main.Ejecutar_Consulta_PS();
            model_main.getSql_result_set().first();
            if(model_main.getSql_result_set().getString("Verificado").equals("1")){
                JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
            }
            else{
                throw new SQLException();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos | Acceso Denegado");
        }
    }
    
    public void Verificar_Tipo_Usuario(){
        try{
            model_main.setSql("SELECT Rol FROM Usuarios WHERE Usuario = ?;");
            model_main.Preparar_Statement();
            model_main.getSql_prepared_statement().setString(1, usuario);
            model_main.Ejecutar_Consulta_PS();
            model_main.getSql_result_set().first();
            if (model_main.getSql_result_set().getString("Rol").equals("00")) {
                tipo_usuario = "Admin";
            } 
            else {
                tipo_usuario = "Recepcionista";
            }
            System.out.println(tipo_usuario);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al verificar el tipo de usuario: " + e);
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getContraseña_Usuario() {
        return contraseña_usuario;
    }

    public void setContraseña_Usuario(char[] contraseña_usuario) {
        try{
            this.contraseña_usuario = contraseña_usuario;
            contraseña_usuario_s = "";
            
            for (int x = 0; this.contraseña_usuario[x] != '\0'; x++) {
                contraseña_usuario_s += this.contraseña_usuario[x];
            }  
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            //
        }
    }

    public String getTipo_Usuario() {
        return tipo_usuario;
    }

    public void setTipo_Usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
}