package main;
import views.*;
import controllers.*;
import models.*;
/**
 *
 * @author Briceyda Angeles
 */
public class Main {   

    public static void main (String bap[]){
        ModelMain model_main = new ModelMain();
        ModelVerificacionUsuario model_login = new ModelVerificacionUsuario(model_main);
        /*ModelClientes model_clientes = new ModelClientes(model_main);
        ModelInventario model_inventario = new ModelInventario(model_main);
        ModelEmpleados model_empleados = new ModelEmpleados(model_main);
        
        ViewMain view_main = new ViewMain();
        ViewLogin view_login = new ViewLogin();
       /* ViewClientes view_clientes = new ViewClientes();
        ViewInventario view_inventario = new ViewInventario();
        ViewEmpleados view_empleados = new ViewEmpleados();
        */
        Object[] models = new Object[20];
        Object[] views = new Object[20];
        Object[] controllers = new Object[20];
        
        models[0] = model_main;
        models[1] = model_login;
        /*models[2] = model_clientes;
        models[3] = model_inventario;
        models[4] = model_empleados;
        
        views[0] = view_main;
        views[1] = view_login;
        views[2] = view_clientes;
        views[3] = view_inventario;
        views[4] = view_empleados;*/
        
        ControllerMain controller_main = new ControllerMain(models, views, controllers);
        controllers[0] = controller_main;     
        
        ControllerVerificacionUsuario controller_login = new ControllerVerificacionUsuario(models, views, controllers);
        controllers[1] = controller_login;
        
        /*ControllerClientes controller_clientes = new ControllerClientes(models, views, controllers);
        controllers[2] = controller_clientes;
        
        ControllerInventario controller_inventario = new ControllerInventario(models, views, controllers);
        controllers[3] = controller_inventario;
        
        ControllerEmpleados controller_empleados = new ControllerEmpleados(models, views, controllers);
        controllers[4] = controller_empleados;
   */
      }
}


    

