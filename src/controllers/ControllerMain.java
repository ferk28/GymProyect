
package controllers;
import views.*;
import models.*;
/**
 *
 * @author Briceyda Angeles
 */
public class ControllerMain {
    
    View_Clientes view_clientes;
    
    
    ModelMain model_main;
    ModelClientes model_clientes;
    
    
    public ControllerMain( View_Clientes view_clientes,ModelMain model_main){
      
        this.view_clientes = view_clientes;
      
        this.model_main = model_main;
        
        
    }
}
