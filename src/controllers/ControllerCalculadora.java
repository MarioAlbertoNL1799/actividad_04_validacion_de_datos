/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import views.ViewCalculadora;
import models.ModelCalculadora;
import extras.DataValidation;


/**
 *
 * @author manl_
 */
public class ControllerCalculadora {
    ModelCalculadora modelCalculadora;
    ViewCalculadora viewCalculadora;
    DataValidation dataValidation = new DataValidation();
    private float operacion;
    private float n2;
    private float n1;
    
    MouseListener nl = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
           if(e.getSource()== viewCalculadora.jb_suma){
               jb_suma_mouse_clicked();
           }
           else if(e.getSource()== viewCalculadora.jb_resta){
               jb_resta_mouse_clicked();
           }
           else if(e.getSource()== viewCalculadora.jb_multiplicar){
               jb_multiplicar_mouse_clicked();
           }
           else if(e.getSource()== viewCalculadora.jb_dividir){
               jb_dividir_mouse_clicked();
           }
           else if(e.getSource()== viewCalculadora.jb_modulo){
               jb_modulo_mouse_clicked();
           }
        }

        @Override
        public void mousePressed(MouseEvent e) {
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           
        }

        @Override
        public void mouseExited(MouseEvent e) {
            
        }
    };
    
    public ControllerCalculadora(ModelCalculadora modelCalculadora, ViewCalculadora viewCalculadora) {
        this.modelCalculadora = modelCalculadora;
        this.viewCalculadora = viewCalculadora;
        this.viewCalculadora.jb_suma.addMouseListener(nl);
        this.viewCalculadora.jb_resta.addMouseListener(nl);
        this.viewCalculadora.jb_dividir.addMouseListener(nl);
        this.viewCalculadora.jb_multiplicar.addMouseListener(nl);
        this.viewCalculadora.jb_modulo.addMouseListener(nl);
        initComponents();
    }
    public void operar(){
         if((viewCalculadora.jtf_numero1.getText().isEmpty())||(viewCalculadora.jtf_numero2.getText().isEmpty())){
                 JOptionPane.showMessageDialog(viewCalculadora,"Falta un valor, verifique nuevamente","Error",JOptionPane.ERROR_MESSAGE);
             }
         else{
             n1 = dataValidation.string2Float(viewCalculadora.jtf_numero1.getText());
             modelCalculadora.setNum1(n1);
             n2 = dataValidation.string2Float(viewCalculadora.jtf_numero2.getText());
             modelCalculadora.setNum2(n2);
         }
    }
    
    public void jb_suma_mouse_clicked(){
        operar();
         operacion = n1 + n2;
         viewCalculadora.jl_resultado.setText("Resultado = " + operacion);
    }
    public void jb_resta_mouse_clicked(){
         operar();
         operacion = n1 - n2;
         viewCalculadora.jl_resultado.setText("Resultado = " + operacion);
    }
    public void jb_multiplicar_mouse_clicked(){
         operar();
         operacion = n1 * n2;
         viewCalculadora.jl_resultado.setText("Resultado = " + operacion);
    }
    public void jb_dividir_mouse_clicked(){
         operar();
         operacion = n1 / n2;
         if(n2 == 0){
            JOptionPane.showMessageDialog(viewCalculadora,"Divisor es 0, ingrese otro valor", "Error", JOptionPane.ERROR_MESSAGE);
            viewCalculadora.jl_resultado.setText("Resultado ");
         }
         else{
             viewCalculadora.jl_resultado.setText("Resultado = " + operacion);
         }
    }
    public void jb_modulo_mouse_clicked(){
         operar();
         operacion = n1 % n2;
         if(n2 == 0){
            JOptionPane.showMessageDialog(viewCalculadora,"Divisor es 0, ingrese otro valor", "Error", JOptionPane.ERROR_MESSAGE);
            viewCalculadora.jl_resultado.setText("Resultado ");
         }
         else{
             viewCalculadora.jl_resultado.setText("Resultado = " + operacion);
         }
    }
     public void initComponents(){
         viewCalculadora.setVisible(true);
     }   
}




