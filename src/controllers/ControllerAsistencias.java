/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import views.View_Asistencia;
import models.ModelAsistencias;
import models.ModelMain;


/**
 *
 * @author Briceyda Angeles
 */
public final class ControllerAsistencias  implements FocusListener {
    private final ModelAsistencias model_asistencia;
    private final View_Asistencia view_asistencia;
    private final ModelMain model_main;
    
     public ControllerAsistencias(Object models[], Object views[], Object controllers[]) {
        this.model_asistencia = (ModelAsistencias) models[3];
        this.view_asistencia = (View_Asistencia) views[3];
        this.model_main = (ModelMain) models[0];
        initView();
    
    }
     public void initView(){
         view_asistencia.addFocusListener(this);
         //botones 
     }
     public void getValores(){
         
     }
     public void setValores(){
         //jtf 
     }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {
    }

}
