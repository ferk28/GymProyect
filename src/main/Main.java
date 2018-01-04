package main;

import models.*;
import controllers.*;
import views.*;

/**
 *
 * @author Briceyda  Angeles
 */

public class Main {
    
    public static void main (String bap[]){
        ModelMain model_main = new ModelMain();
        ModelVerificacionUsuario model_verificacion_usuario = new ModelVerificacionUsuario(model_main);
        ModelClientes model_clientes = new ModelClientes(model_main);
        ModelMembresia model_membrecia = new ModelMembresia(model_main);
        ModelRenta model_renta =new ModelRenta (model_main);
        
        ViewMain view_main = new ViewMain();
        ViewVerificacionUsuario view_verificacion_usuario = new ViewVerificacionUsuario();
        View_Clientes view_clientes = new View_Clientes();
        View_Membresia view_membrecia = new View_Membresia();
        View_RentaLocker view_renta = new View_RentaLocker();
        View_Asistencia view_asistencia = new View_Asistencia();

        Object[] models = new Object[10];
        Object[] views = new Object[10];
        Object[] controllers = new Object[10];
        
        models[0] = model_main;
        models[1] = model_verificacion_usuario;
        models[2] = model_clientes;
        models[3] = model_membrecia; 
        models[4] = model_renta;
        
        views[0] = view_main;
        views[1] = view_verificacion_usuario;
        views[2] = view_clientes;
        views[3] = view_membrecia;
        views[4] = view_renta;
        views[5] =view_asistencia;
        
        ControllerMain controller_main = new ControllerMain(models, views, controllers);
        controllers[0] = controller_main;
        
        ControllerVerificacionUsuario controller_verificacion_usuario = new ControllerVerificacionUsuario(models, views, controllers);
        controllers[1] = controller_verificacion_usuario;
        
        ControllerClientes controller_clientes = new ControllerClientes(models, views, controllers);
        controllers[2] = controller_clientes;
       
        ControllerMembresia controller_membrecia = new ControllerMembresia(models, views, controllers);
        controllers[3] = controller_membrecia;
        
        ControllerRenta controller_renta = new ControllerRenta(models, views, controllers);
        controllers[4] = controller_renta;
    }
    
    
    
}
