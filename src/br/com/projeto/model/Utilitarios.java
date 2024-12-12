/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.model;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author barbo
 */
public class Utilitarios {
    
    public void limparCampos(JPanel container){
        Component componentes[] = container.getComponents();
        for(Component componente: componentes){
            if(componente instanceof JTextField camposDeTexto){
                camposDeTexto.setText(null);
            }
            
            /*
              if(componente instanceof JTextField){
                ((JTextField)componente).setText(null);
            }*/
            
        }
    }
}
