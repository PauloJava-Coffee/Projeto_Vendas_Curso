/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.model;

import java.awt.Component;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author barbo
 */
public class Utilitarios {

    //Método limpar campos de texto 
    public void limparCampos(JPanel container) {
        Component componentes[] = container.getComponents();
        for (Component componente : componentes) {
            if (componente instanceof JTextField camposDeTexto) {
                camposDeTexto.setText(null);
            }

            /*
              if(componente instanceof JTextField){
                ((JTextField)componente).setText(null);
            }*/
        }
    }

    //Método de busca de endereço por cep
    public Clientes buscarEndereco(String cep) {

        Clientes suporte = new Clientes();
        try {
            URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");

            SAXReader xml = new SAXReader();
            Document doc = xml.read(url);
            Element elemento = doc.getRootElement();

            for (Iterator<Element> it = elemento.elementIterator(); it.hasNext();) {
                Element result = it.next();

                switch (result.getQualifiedName()) {
                    case "uf" ->
                        suporte.setEstado(result.getText());
                    case "cidade" ->
                        suporte.setCidade(result.getText());
                    case "bairro" ->
                        suporte.setBairro(result.getText());
                    case "tipo_logradouro" ->
                        suporte.setEndereco(result.getText());
                    case "logradouro" ->
                        suporte.setEndereco(suporte.getEndereco() + " " + result.getText());

                }

            }
            return suporte;

        } catch (MalformedURLException | DocumentException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }

    }

}
