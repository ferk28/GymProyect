package main;
import views.*;
import controllers.*;
import models.*;
/**
 *
 * @author Briceyda Angeles
 */
public class Main {

    
    private static View_Clientes view_clientes;
    private static ModelClientes model_clientes;
    private static ControllerClientes controller_clientes;
    private static ModelMain model_main;
    private static ControllerMain controller_main;
    
    

       public static void main (String bapgp[]){
       view_clientes = new View_Clientes();
       model_clientes = new ModelClientes();
       controller_clientes = new ControllerClientes(model_clientes, view_clientes);
       
       model_main= new ModelMain();
       controller_main = new ControllerMain(view_clientes, model_main);
       
 
    }
}
